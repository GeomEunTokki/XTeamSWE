package X_Project.A3.newname;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Staff extends User{

	public Staff (String myname, int myID, int myPassword) {
		super(myname, myID, myPassword);
	}
	
	public void show_Workshop(String[] ws_index) { 	//Display what workshop which can be chosen.
		JFrame show_WS = new JFrame("Work Shop List");
		show_WS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show_WS.setLocationRelativeTo(null);
		show_WS.setSize(900, 600);
		JButton [] WS_List = new JButton[10];
		//ImageIcon [] image = new ImageIcon [10];
		String str[] = ws_index;
		
		show_WS.setLayout(new GridLayout(2,5));
		for(int i=0; i<10; i++) {
			WS_List[i] = new JButton(str[i]);
			show_WS.add(WS_List[i]);
		}

		show_WS.setVisible(true);
	}
	


	public void select_WS_and_Swipe(Workshop Name_of_WS, String Student_Name, int ID) {		//Input information and ask if it is correct.
		JOptionPane.showMessageDialog(null,"Workshop: "+Name_of_WS.getName()+" Name: "+Student_Name+" ID:"+ID);
		int chick = Integer.valueOf(JOptionPane.showInputDialog("Is this information correct? If yes, please enter 1. If no, please enter 0."));
		
		if(chick==1) {
			Name_of_WS.chick_in(Student_Name,ID);
		}
		
	}
}
