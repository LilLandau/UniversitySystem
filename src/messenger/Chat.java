package messenger;

import Users.Employee;
import database.DataBase;

import java.io.Serializable;
import java.util.Vector;

public class Chat implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1138645952737596214L;
	private Vector<Employee> members = new Vector<Employee>();
    private Vector<Message> messages = new Vector<Message>();
    private String name;
    private Employee owner;
    public Chat(Employee other, String name, Employee owner) {
        this.members.add(other);
        this.name = name;

    }


    public void sendMessage(Message message) {
        messages.add(message);
    }

    public void showMessages() {
        for(Message message: messages) {
            System.out.println(message);
        }
    }

    public boolean add(Employee other) {
        if(members.contains(other)) {
            System.out.println("Он уже в чате");
            return false;
        }
        System.out.println("!@#!#");
        members.add(other);
        return true;
    }

    public boolean delete(Employee other) {
        return members.remove(other);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + "\n" + members;
    }


    public Employee getOwner() {
        return owner;
    }


    public void setOwner(Employee owner) {
        this.owner = owner;
    }


    public Vector<Employee> getMembers() {
        return members;
    }


    public void setMembers(Vector<Employee> members) {
        this.members = members;
    }


    public Vector<Message> getMessages() {
        return messages;
    }


    public void setMessages(Vector<Message> messages) {
        this.messages = messages;
    }


    public void setName(String name) {
        this.name = name;
    }



}
