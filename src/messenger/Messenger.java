package messenger;

import Users.Employee;
import database.DataBase;

import java.io.Serializable;
import java.util.Vector;

public class Messenger implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8060060516448946152L;
	private Vector<Chat> chats;
    private Employee owner;

    public Messenger(Employee owner) {
        this.chats = new Vector<Chat>();
        this.owner = owner;
        DataBase.addMessenger(this);

    }

    public void showChats() {
        for(Chat chat:chats) {
            System.out.println(chat);
        }
    }

    public void sendMessageTo(String name, Message message) {
        for(Chat chat:chats) {
            if(chat.getName() == name) {
                chat.sendMessage(message);
            }
        }
    }

    public void createChat(Employee other, String name) {
        if(chats.add(new Chat(other, name, this.owner))) {
            chats.lastElement().add(owner);
            other.getMyMessenger().addChat(chats.lastElement());
            System.out.println(other.getMyMessenger().getChats());
        };
    }

    public void addChat(Chat chat) {
        chats.add(chat);
    }
    
    public void deleteChat(Chat chat) {
        chats.remove(chat);
    }

    public void addUserTo(String name, Employee other) {
        for(Chat chat:chats) {
            if(chat.getName() == name) {
                if(chat.getMembers().contains(other)) { // checking that is ownher
                    break;
                }
                chat.add(other);
            }
        }
    }

    public void deleteUserTo(String name, Employee other) {
        for(Chat chat:chats) {
            if(chat.getName() == name) {
                if(owner == other) {
                    System.out.println();
                    return;
                }
                if(chat.delete(other)) {
                    other.getMyMessenger().deleteChat(chat);
                    System.out.println("DELETED");
                }else {
                    System.out.println("There was not that person");
                }
            }
        }
    }
    public void showChat(String name) {
        for(Chat chat:chats) {
            if(chat.getName().equals(name)) {
                System.out.println("\t\t" + chat.getName());
                chat.showMessages();
                return;
            }
        }
        System.out.println("There is not chat with that name");
    }
    public Vector<Chat> getChats() {
        return chats;
    }

}
