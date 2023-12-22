package Users;
import java.util.*;

public class TechSupportSpecialist extends Employee {
	private Vector <Order> orders;
	
	public TechSupportSpecialist(String firstname, String secondname, String ID, Date birthdate, String phoneNumber,
			String login, String password, String email, Gender gender, Address address, Language language, double salary) {
		
		super(firstname, secondname, ID, birthdate, phoneNumber,
				login, password, email, gender, address, language, salary);
		this.orders = new Vector <Order>();
	}
	
	public void viewOrders() {
		for (Order o: orders) {
			System.out.println(o.toString());
		}
	}
	
	public void viewNewOrders() {
		for (Order o: orders) {
			if (o.getOrderStatus() == Status.NEW) {
				System.out.println(o.toString());
			}
		}
	}
	
	public void viewAcceptedOrders() {
		for (Order o: orders) {
			if (o.getOrderStatus() == Status.ACCEPTED) {
				System.out.println(o.toString());
			}
		}
	}
	
	public void viewRejectedOrders() {
		for (Order o: orders) {
			if (o.getOrderStatus() == Status.REJECTED) {
				System.out.println(o.toString());
			}
		}
	}
	
	public void viewDoneOrders() {
		for (Order o: orders) {
			if (o.getOrderStatus() == Status.DONE) {
				System.out.println(o.toString());
			}
		}
	}
	
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
