package demo.order;

public class OrderProcessImpl implements OrderProcess {

	@Override
	public String processOrder(Order order) {
		String orderID = validate(order);
		return orderID;
	}
	
	/**
	 * * Validates the order and returns the order ID
	 **/
	private String validate(Order order) {
		String custID = order.getCustomerID();
		String itemID = order.getItemID();
		int qty = order.getQty();
		double price = order.getPrice();
		if (custID != null && itemID != null && !custID.equals("")
				&& !itemID.equals("") && qty > 0 && price > 0.0) {
			
			System.out.println("Service providing the response:ORD12345");
			return "ORD12345";
		}
		return null;

	}

}
