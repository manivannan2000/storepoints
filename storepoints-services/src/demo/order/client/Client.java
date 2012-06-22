package demo.order.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.order.Order;
import demo.order.OrderProcess;

public class Client {
	
	public Client() { }

	public static void main(String args[]) throws Exception { // START SNIPPET:
																// client
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "demo/order/client/client-beans.xml" });
		OrderProcess client = (OrderProcess) context.getBean("orderClient");
		// Populate the Order bean 
		Order order = new Order();
		order.setCustomerID("C001");
		order.setItemID("I001");
		order.setQty(100);
		order.setPrice(200.00);
		String orderID = client.processOrder(order);
		String message = (orderID == null) ? "Order not approved"
				: "Order approved; order ID is " + orderID;
		System.out.println(message);
		System.exit(0);
	}

}
