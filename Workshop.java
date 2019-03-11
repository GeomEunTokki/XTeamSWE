package X_Project.A3;
import javax.swing.JOptionPane;

class Workshop {
	
	private String Name;
	private int Time;
	private int Data;
	private String Instructor;
	private String[] Student_name = new String [10]; 
	private int[] Student_ID = new int [10]; 
	
	public Workshop(String myName, int myTime, int myData, String myInstructor) {
		Name = myName;
		Time = myTime;
		Data = myData;
		Instructor = myInstructor;
	}
	
	public void setName(String newName) {
		Name = newName;
	}
	public String getName() {
		return Name;
	}
	
	public void setTime(int newTime) {
		Time = newTime;
	}
	
	public int getTime() {
		return Time;
	}
	
	public void setData(int newData) {
		Data = newData;
	}
	
	public int getData() {
		return Data;
	}
	
	public void setInstructor(String newInstructor) {
		Instructor = newInstructor;
	}
	
	public String getInstructor() {
		return Instructor;
	}
	public void chick_in(String Name, int ID) {
		int counter = 0;
		if(counter>10) {
			JOptionPane.showMessageDialog(null,"This workshop is full.");
		}
		else {
			Student_name[counter]=Name;
			Student_ID[counter]=ID;
			counter++;
		}
	}
	
	public void showWorkshop() {
		JOptionPane.showMessageDialog(null,"Name: "+Name+"Time: "+Time+"Data: "+Data+"Instructor: "+Instructor);
		JOptionPane.showMessageDialog(null,"The list of students who sign the workshop."+Student_name.toString());
	}
	
}
