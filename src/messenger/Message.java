package messenger;
import Users.User;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{




    private String text;
    private Date date;
    private User sender;

    public Message(String text, User sender) {
        this.text = text;
        this.date = new Date();
        this.sender = sender;
    }

    public User getUser() {
        return this.sender;
    }


    public String toString() {
        return "\nSender:  " + this.sender + "\nMessage: " + this.text + "\t" + this.date;
    }
}
