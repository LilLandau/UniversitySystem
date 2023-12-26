package Users;
import java.util.*;
/**
 * This class represents Technical support in university system
 * @author Danial
*/
public class TechSupportSpecialist extends Employee {
	/**
	 * Fields are formed only by 1 parameter.
	 * This parameter is vector of orders to complete
	*/
	private Vector <Order> orders;
	
	public TechSupportSpecialist(String firstname, String secondname, String ID, Date birthdate, String phoneNumber,
			String login, String password, String email, Gender gender, Address address, Language language, double salary) {
		
		super(firstname, secondname, ID, birthdate, phoneNumber,
				login, password, email, gender, address, language, salary);
		this.orders = new Vector <Order>();
	}
	
	/**
	 * This method prints all orders
	*/
	public void viewOrders() {
		for (Order o: orders) {
			System.out.println(o.toString());
		}
	}
	/**
	 * This method prints only new orders
	*/
	public void viewNewOrders() {
		for (Order o: orders) {
			if (o.getOrderStatus() == Status.NEW) {
				System.out.println(o.toString());
			}
		}
	}
	
	/**
	 * This method prints only accepted orders
	*/
	public void viewAcceptedOrders() {
		for (Order o: orders) {
			if (o.getOrderStatus() == Status.ACCEPTED) {
				System.out.println(o.toString());
			}
		}
	}
	
	/**
	 * This method prints only rejected orders
	*/
	public void viewRejectedOrders() {
		for (Order o: orders) {
			if (o.getOrderStatus() == Status.REJECTED) {
				System.out.println(o.toString());
			}
		}
	}
	
	/**
	 * This method prints only done orders
	*/
	public void viewDoneOrders() {
		for (Order o: orders) {
			if (o.getOrderStatus() == Status.DONE) {
				System.out.println(o.toString());
			}
		}
	}
	
	/**
	 * This method accepts order to completing
	 * @param order ID
	 * @throws OrderStatusImmutableException if order's status isn't new
	*/
	public void acceptOrder(int orderID) throws OrderStatusImmutableException{
		for (Order o: orders) {
			if (o.getOrderID() == orderID) {
				if (o.getOrderStatus() == Status.NEW) {
					o.setOrderStatus(Status.ACCEPTED);
				}
				else {
					throw new OrderStatusImmutableException("Order's status isn't new");
				}
			}
		}
	}
	
	/**
	 * This method rejects order to completing
	 * @param order ID
	 * @throws OrderStatusImmutableException if order's status isn't new or accepted
	*/
	public void rejectOrder(int orderID) throws OrderStatusImmutableException{
		for (Order o: orders) {
			if (o.getOrderID() == orderID) {
				if (o.getOrderStatus() == Status.NEW || o.getOrderStatus() == Status.ACCEPTED) {
					o.setOrderStatus(Status.REJECTED);
				}
				else {
					throw new OrderStatusImmutableException("Order's status isn't new or accepted");
				}
			}
		}
	}
	
	/**
	 * This method finishes order
	 * @param order ID
	 * @throws OrderStatusImmutableException if order's status isn't accepted
	*/
	public void finishOrder(int orderID) throws OrderStatusImmutableException{
		for (Order o: orders) {
			if (o.getOrderID() == orderID) {
				if (o.getOrderStatus() == Status.ACCEPTED) {
					o.setOrderStatus(Status.DONE);
				} 
				else {
					throw new OrderStatusImmutableException("Order's status isn't accepted");
				}
			}
		}
	}

}
