package com.storepoints.couchdb.rs.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PutMethod;

public  abstract class AbstractRESTServiceClient {

	
	protected abstract String getSPRESTServiceRequest();
	
	protected abstract String getSPRESTPostData();
	
	protected abstract String getRESTUrl();
	
	
	protected abstract void inflateResponse( Object responseObj);
	
	
	public void makePutServiceCall(){

		try {
			HttpClient client = new HttpClient();

			PutMethod putMethod = new PutMethod(
					getRESTUrl()+"/"
							+ getSPRESTServiceRequest());

			putMethod.setRequestHeader("Content-type", "application/json");
			
			putMethod.setRequestBody(getSPRESTPostData());
			
			// Make the call
			int status = client.executeMethod(putMethod);

			System.out.println("Status value:" + status);

			InputStream in = null;
			switch (status) {
			case 200:
			case 201:
				
				in = putMethod.getResponseBodyAsStream();

				break;
			case 500:
				in = putMethod.getResponseBodyAsStream();
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
			
			parseResponse(in);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	}

	public void makeGetServiceCall(){
		try {
			HttpClient client = new HttpClient();

			GetMethod getMethod = new GetMethod(
					getRESTUrl()+"/"
							+ getSPRESTServiceRequest());

			getMethod.setRequestHeader("Content-type", "application/json");

			// Make the call
			int status = client.executeMethod(getMethod);

			System.out.println("Status value:" + status);

			InputStream in = null;
			switch (status) {
			case 200:
				in = getMethod.getResponseBodyAsStream();

				break;
			case 500:
				in = getMethod.getResponseBodyAsStream();
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
			
			parseResponse(in);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void parseResponse(InputStream in) throws Exception{
		StringBuffer buffer = new StringBuffer();
		
		BufferedReader readerOut = null;
		try {
			readerOut = new BufferedReader(new InputStreamReader(in));
			String line = readerOut.readLine();
			while( line != null ){
				
				buffer.append(line);
				line = readerOut.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				readerOut.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		inflateResponse(buffer.toString());
	}
}
