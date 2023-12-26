package messenger;
import Users.Employee;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{




    /**
	 * 
	 */
	private static final long serialVersionUID = -8781537565241582897L;
	private String text;
    private Date date;
    private Employee sender;

    public Message(String text, Employee sender) {
        this.text = text;
        this.date = new Date();
        this.sender = sender;
    }

    public Employee getUser() {
        return this.sender;
    }


    public String toString() {
        return "\nSender:  " + this.sender + "\nMessage: " + this.text + "\t" + this.date;
    }
}
