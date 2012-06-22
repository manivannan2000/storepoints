package demo.order.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.cxf.frontend.ClientProxy;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import org.apache.cxf.endpoint.Client;

import demo.order.Order;
import demo.order.OrderProcess;

public class Client2 {
	private static final QName SERVICE_NAME = new QName("http://order.demo/",
			"OrderProcessImplService");
	private static final QName PORT_NAME = new QName("http://order.demo/",
			"OrderProcessImplPort");
	
	
	private static final String WSDL_LOCATION = "http://localhost:8080/orderapp/OrderProcess?wsdl";

	public static void main(String args[]) throws Exception {
		URL wsdlURL = new URL(WSDL_LOCATION);
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		OrderProcess port = service.getPort(PORT_NAME, OrderProcess.class);
		
		
		 Client client = (Client) ClientProxy.getClient(port);
		 client.getInInterceptors().add(new LoggingInInterceptor());
	     client.getOutInterceptors().add(new LoggingOutInterceptor()); 
		
		
		Order order = new Order();
		order.setCustomerID("C001");
		order.setItemID("I001");
		order.setQty(100);
		order.setPrice(200.00);
		String orderID = 		port.processOrder(order);
		String message = (orderID == null) ? "Order not approved"
				: "Order approved; order ID is " + orderID;
		System.out.println(message);
		System.exit(0);

		

		
		
		
	}

}
