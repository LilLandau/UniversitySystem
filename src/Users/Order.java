package Users;
import java.util.Objects;
/**
 * @author Danial
 * This class is used to create orders to TechSupportSpecialist
*/

public class Order {
	/**
	 * These fields are used to describe order
	*/
	private int orderID;
	private String description;
	private Status orderStatus;
	
	public Order(int orderID, String description) {
		this.orderID = orderID;
		this.description = description;
		this.orderStatus = Status.NEW;
	}
	
	public Status getOrderStatus() {
		return orderStatus;
	}
	
	public String getOrderDescription() {
		return description;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public void setOrderStatus(Status s) {
		this.orderStatus = s;
	}
	
	public int hashCode() {
		return Objects.hash(orderID, description, orderStatus);
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        
        return orderID == order.orderID &&
               Objects.equals(description, order.description) &&
               orderStatus == order.orderStatus;
    }
	
	public String toString() {
		return orderID + " " + description + " " + orderStatus;
	}
}
