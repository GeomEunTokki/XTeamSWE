package X_Project.A3.newname;

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
}
