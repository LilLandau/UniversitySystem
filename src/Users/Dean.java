package Users;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import database.Complaint;
import database.DataBase;
import messenger.Message;

public class Dean extends Employee{
	private Faculties deanOf;

	
	public Dean(String firstname, String secondname, String ID, Date birthdate, String phoneNumber, String login,
			String password, String email, Gender gender, Address address, Language language, double salary, Faculties fac) {
		super(firstname, secondname, ID, birthdate, phoneNumber, login, password, email, gender, address, language, salary);
		this.deanOf = fac;
	}

	public void mainPage() throws IOException {
		while(true) {
			System.out.println("https://wsp.kbtu.kz/" + this.getLogin());
			System.out.println("LNG: " + this.getLanguage());
			int chooseOfDean;
			System.out.println("BaseFuctionality           (1)");
			System.out.println("Dean's Functionality       (2)");
			System.out.println("Go Back                    (3)");
			
			chooseOfDean = reader.read();
			if(chooseOfDean == 1) {
				super.mainPage();
			}else if (chooseOfDean == 2) {
				System.out.println("https://wsp.kbtu.kz/" + this.getLogin());
				System.out.println("LNG: " + this.getLanguage());
				this.checkComplaints();
			}	
			reader.readLine();
		}
	}
	
	public void checkComplaints() throws IOException {
		Vector<Complaint> compls = DataBase.getComplaintsByFaculty(this.deanOf);
		for(Complaint compl : compls) {
			String solution;
			System.out.println(compl);
			System.out.println("What will you make?");
			solution = reader.readLine();
			compl.getSender().sendNotification(new Message(solution, this));
			DataBase.deleteComplaints(compl);
		}
	}
	
	public Faculties getDeanOf() {
		return deanOf;
	}


	public void setDeanOf(Faculties deanOf) {
		this.deanOf = deanOf;
	}
	
}
