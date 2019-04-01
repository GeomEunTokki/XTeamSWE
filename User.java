import javax.swing.JOptionPane;

public class User {
	private  String Name;
	private int ID;
	private int Password;
	public User(String myname, int myID, int myPassword) {
		Name = myname;
		ID = myID;
		Password = myPassword;
	}
	
	public void setName(String newName) {
		Name = newName;
	}
	
	public void setID(int newID) {
		ID = newID;
	}
	
	public void setPassword(int newPassword) {
		Password = newPassword;
	}
	
	public String getName() {
		return Name;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getPassword() {
		return Password;
	}
	
	public static boolean checkname(String name) {
		if(name==" "||name=="  "||name=="   "||name=="    "||name=="     ") {
			return false;
		}
		else if(name=="      "||name=="       "||name=="        "||name=="         "||name=="          ") {
			return false;
		}
		else if(name=="           "||name=="            "||name=="             "||name=="              "||name=="               ") {
			return false;
		}
		
		if(name.length()<=15&&name.length()>=1) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null,"There is something wrong. It must be less than 15 letters and bigger than 1 letter.");
			return false;
		}
	}
	
	public static boolean checkID(int ID) {
		int IDcounter=0;
		while(ID!=0) {
			ID=ID/10;
			IDcounter++;
		}
		
		if(IDcounter<=7) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null,"There is something wrong. It must be less than 7 digits, and the first digit must be bigger than 1.");
			return false;
		}
	}

	public static boolean checkpassword(int passward) {
		int passwardcounter=0;
		while(passward!=0) {
			passward = passward/10;
			passwardcounter++;
		}
		
		if(passwardcounter==4) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null,"There is something wrong. It must be 4 digits.");
			return false;
		}
	}
}
