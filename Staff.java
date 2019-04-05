
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Staff extends User{

	public Staff (String myname, int myID, int myPassword) {
		super(myname, myID, myPassword);
	}
	
	public void show_Workshop(final JFrame frame11, final Administrator[] PU, final Staff[] SU, final Workshop[] WS, final String[]WS_List) { 	//Display what workshop which can be chosen.
		final JFrame show_WS = new JFrame("Work Shop List");
		show_WS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show_WS.setLocationRelativeTo(null);
		show_WS.setSize(900, 600);
		JButton [] List = new JButton[10];
		JButton previous = new JButton("Previous page");
		
		
		show_WS.setLayout(new GridLayout(2,5));
		for(int i=0; i<10; i++) {
			List[i] = new JButton(WS_List[i]);
			show_WS.add(List[i]);
		}
		show_WS.add(previous);
		
		List[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
				int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));

				if(checkname(Student_name)&&checkID(ID)) {//Check if it is correct. We need to connect to database here.
					WS[0].chick_in(Student_name,ID);
				}
			}
		});
		
		List[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
				int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));

				if(checkname(Student_name)&&checkID(ID)) {//Check if it is correct. We need to connect to database here.
					WS[1].chick_in(Student_name,ID);
				}
			}
		});
		
		List[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
				int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));

				if(checkname(Student_name)&&checkID(ID)) {//Check if it is correct. We need to connect to database here.
					WS[2].chick_in(Student_name,ID);
				}
			}
		});
		
		List[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
				int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));

				if(checkname(Student_name)&&checkID(ID)) {//Check if it is correct. We need to connect to database here.
					WS[3].chick_in(Student_name,ID);
				}
			}
		});
		
		List[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
				int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));

				if(checkname(Student_name)&&checkID(ID)) {//Check if it is correct. We need to connect to database here.
					WS[4].chick_in(Student_name,ID);
				}
			}
		});
		
		List[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
				int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));

				if(checkname(Student_name)&&checkID(ID)) {//Check if it is correct. We need to connect to database here.
					WS[5].chick_in(Student_name,ID);
				}
			}
		});
		
		List[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
				int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));

				if(checkname(Student_name)&&checkID(ID)) {//Check if it is correct. We need to connect to database here.
					WS[6].chick_in(Student_name,ID);
				}
			}
		});
		
		List[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
				int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));

				if(checkname(Student_name)&&checkID(ID)) {//Check if it is correct. We need to connect to database here.
					WS[7].chick_in(Student_name,ID);
				}
			}
		});
		
		List[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
				int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));

				if(checkname(Student_name)&&checkID(ID)) {//Check if it is correct. We need to connect to database here.
					WS[8].chick_in(Student_name,ID);
				}
			}
		});
		
		List[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
				int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));

				if(checkname(Student_name)&&checkID(ID)) {//Check if it is correct. We need to connect to database here.
					WS[9].chick_in(Student_name,ID);
				}
			}
		});


		show_WS.setVisible(true);
		
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Staff(true, frame11, PU, SU, WS, WS_List);
			}
		});
		
		
	}
	


	/*public void select_WS_and_Swipe(String Student_Name, int ID) {		//Input information and ask if it is correct.
		JOptionPane.showMessageDialog(null," Name: "+Student_Name+" ID:"+ID);
		int chick = Integer.valueOf(JOptionPane.showInputDialog("Is this information correct? If yes, please enter 1. If no, please enter 0."));
		
		if(chick==1) {
			Name_of_WS.chick_in(Student_Name,ID);
		}
		
	}*/
}
