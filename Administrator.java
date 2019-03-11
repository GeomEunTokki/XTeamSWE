package X_Project.A3.newname;

import javax.swing.JOptionPane;

public class Administrator extends User{
	
	public Administrator(String myname, int myID, int myPassword) {
		super(myname, myID, myPassword);
	}

	public Administrator add_Administrator() {
		
		String myName = JOptionPane.showInputDialog("Please enter the name of Primary User.");
		
		int myID = Integer.valueOf(JOptionPane.showInputDialog("Please enter the ID of Primary User."));
		
		int myPassword = Integer.valueOf(JOptionPane.showInputDialog("Please enter the Password of Primary User."));

		Administrator a = new Administrator(myName, myID, myPassword);
		return a;
	}
	
	
	public Staff add_Staff() {
		
		String myName = JOptionPane.showInputDialog("Please enter the name of Secondary User.");
		
		int myID = Integer.valueOf(JOptionPane.showInputDialog("Please enter the ID of Secondary User."));
		
		int myPassword = Integer.valueOf(JOptionPane.showInputDialog("Please enter the Password of Secondary User."));

		Staff a = new Staff(myName, myID, myPassword);
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
