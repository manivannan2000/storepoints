package com.storepoints.service.client;

import java.io.InputStream;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;


public abstract class AbstractSPServiceClient {

	
	// set up static reusable JAXBContext
	private static JAXBContext jaxbContext = null;
	
	private MessageFactory msgFactory = null;


	protected abstract String getStoreType();

	protected abstract void inflateResponse( Object responseObj);
	
	protected abstract Object getSPServiceRequest();
	
	
	/**
	 * Use this static accessor method to access the JAXBContext, rather than referencing 
	 * the static variable jaxbContext, which may be null initially
	 * @return jaxbContext
	 * @throws JAXBException
	 */
	protected static JAXBContext getJaxbContext() throws JAXBException
	{
		if (jaxbContext == null) 
			try {
				jaxbContext = JAXBContext.newInstance("com.storepoints.service");
			} catch (JAXBException e){
				throw e; // consider throwing a custom exception here, rather than JAXBException
			}
		return jaxbContext;
	}

	public void makeServiceCall(){
		try {
			msgFactory = MessageFactory.newInstance();

			getJaxbContext();

			StringBuffer buffer = new StringBuffer()
					.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body>");

			Marshaller marshaller = jaxbContext.createMarshaller();
			Unmarshaller unmarshaller = getJaxbContext().createUnmarshaller();

			java.io.StringWriter sw = new StringWriter();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//			marshaller.setProperty("com.sun.xml.bind.xmlDeclaration",
//					Boolean.FALSE);
			
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

			marshaller.marshal(getSPServiceRequest(), sw);
			buffer.append(sw.toString());

			buffer.append("<soap:Body>");

			String body = new String(buffer);

			HttpClient client = new HttpClient();

			PostMethod post = new PostMethod(
					"http://localhost:8080/storepoints-services/StorePointsService");

			post.setRequestEntity(new ByteArrayRequestEntity(body.getBytes()));
			// set any request headers
			post.setRequestHeader("Content-type", "text/xml");
			post.setRequestHeader("SOAPAction", "");

			// Make the call
			int status = client.executeMethod(post);

			InputStream in = null;
			switch (status) {
			case 200:
				in = post.getResponseBodyAsStream();

				break;
			case 500:
				in = post.getResponseBodyAsStream();
				break;
			case 404:

				break;
			default:
				// possibly return?
				break;
			}
			if (in == null) {
				return;
			}

			/*
			 * if (status == 200) { in = post.getResponseBodyAsStream(); } else
			 * if (status == 500) { in = post.getResponseBodyAsStream(); }
			 */
			
			
			if (status == 200) {
				in = post.getResponseBodyAsStream();
			} else if (status == 500) { 
				// Axis/Soap fault comes back with error 500
				// get the response body in this case as well, in order to parse for GBML error MB-6201
				in = post.getResponseBodyAsStream();
			}

			// still using saaj for the response for some crazy reason
			SOAPMessage outMessage = msgFactory.createMessage(null, in);
			
			
			// process the response
			SOAPBody responseBody = outMessage.getSOAPBody();
			if (!responseBody.hasFault()) {
	 			Node cNode = (Node) responseBody.getFirstChild();
					System.out.println("node name " + cNode.getNodeName());				
				inflateResponse( unmarshaller.unmarshal(cNode));
			} else {
				SOAPFault fault = responseBody.getFault();
				System.out.println("Received SOAP Fault");
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
