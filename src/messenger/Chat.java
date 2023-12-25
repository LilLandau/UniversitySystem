package messenger;

import Users.User;

import java.io.Serializable;
import java.util.Vector;

public class Chat implements Serializable{
    private Vector<User> members = new Vector<User>();
    private Vector<Message> messages = new Vector<Message>();
    private String name;
    private User owner;
    public Chat(User other, String name, User owner) {
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

    public boolean add(User other) {
        if(members.contains(other)) {
            System.out.println("Он уже в чате");
            return false;
        }
        System.out.println("!@#!#");
        members.add(other);
        return true;
    }

    public boolean delete(User other) {
        return members.remove(other);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + "\n" + members;
    }


    public User getOwner() {
        return owner;
    }


    public void setOwner(User owner) {
        this.owner = owner;
    }


    public Vector<User> getMembers() {
        return members;
    }


    public void setMembers(Vector<User> members) {
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
