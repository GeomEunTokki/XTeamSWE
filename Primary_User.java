package X_Project.A3;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Primary_User extends User {
	public Primary_User (String myname, int myID, int myPassword) {
		super(myname, myID, myPassword);
	}

	public Primary_User add_Primary_User() {
		
		String myName = JOptionPane.showInputDialog("Please enter the name of Primary User.");
		
		int myID = Integer.valueOf(JOptionPane.showInputDialog("Please enter the ID of Primary User."));
		
		int myPassword = Integer.valueOf(JOptionPane.showInputDialog("Please enter the Password of Primary User."));

		Primary_User a = new Primary_User(myName, myID, myPassword);
		return a;
	}
	
	
	public Secondary_User add_Secondary_User() {
		
		String myName = JOptionPane.showInputDialog("Please enter the name of Secondary User.");
		
		int myID = Integer.valueOf(JOptionPane.showInputDialog("Please enter the ID of Secondary User."));
		
		int myPassword = Integer.valueOf(JOptionPane.showInputDialog("Please enter the Password of Secondary User."));

		Secondary_User a = new Secondary_User(myName, myID, myPassword);
		return a;
	}
	
	public Workshop add_Workshop() {

		String myName = JOptionPane.showInputDialog("Please enter the name of Workshop User.");
		
		int myTime = Integer.valueOf(JOptionPane.showInputDialog("Please enter the time of Workshop."));
		
		int myData = Integer.valueOf(JOptionPane.showInputDialog("Please enter the Data of Workshop."));
		
		String myInstructor = JOptionPane.showInputDialog("Please enter the instructor of Workshop.");
		
		Workshop a = new Workshop(myName, myTime, myData, myInstructor);
	    return a;
	}
	
	public void remove_Workshop() {
		
	}
	
	public void view_Data() {
		//one from workshop class.
		//one from database.
	}
}
