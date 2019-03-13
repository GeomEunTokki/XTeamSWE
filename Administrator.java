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
		
		int myDate = Integer.valueOf(JOptionPane.showInputDialog("Please enter the Date of Workshop.(Four digitals, month first.)"));
		
		boolean datecheck = false;
		while(!datecheck) {
			datecheck = checkdate(myDate);
			if (datecheck==false) {
				myDate = Integer.valueOf(JOptionPane.showInputDialog("Please enter the Date of Workshop again.(Four digitals, month first.)"));
			}
		}
		
		String myInstructor = JOptionPane.showInputDialog("Please enter the instructor of Workshop.");
		
		Workshop a = new Workshop(myName, myTime, myDate, myInstructor);
	    return a;
	}
	
	public void remove_Workshop() {
		
	}
	
	public void view_Data() {
		//one from workshop class.
		//one from database.
	}
	
	public static boolean checkdate(int date) {
		int month;
		int day;
		
		if(date>10000) {
			JOptionPane.showInputDialog("Please enter four digitals.");
			return false;
		}
		else if(date<101) {
			JOptionPane.showInputDialog("Please enter four digitals.");
			return false;
		}
		
		day = date%100;
		date = date/100;
		month = date%100;
		
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			if(day >31 || day < 1) {
				JOptionPane.showInputDialog("This date does not exist.");
				return false;
			}
		}
		else if(month==4||month==6||month==9||month==11){
			if(day >30 || day < 1) {
				JOptionPane.showInputDialog("This date does not exist.");
				return false;
			}
		}
		else if(month==2) {
			if(day >28 || day < 1) {
				JOptionPane.showInputDialog("This date does not exist.");
				return false;
			}
		}
		
		return true;
		
	}
}
