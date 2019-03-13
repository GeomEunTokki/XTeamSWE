import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Staff extends User{
	private JLabel lb;
	private JList lst;
	private JScrollPane sp;
	
	public Staff (String myname, int myID, int myPassword) {
		super(myname, myID, myPassword);
	}
	
	public void show_Workshop(String[] ws_index) { 	//Display what workshop which can be chosen.
		JOptionPane.showMessageDialog(null, Arrays.toString(ws_index));
		
		/*lb = new JLabel("The list of WorkShop.");
		lst = new JList(ws_counter);
		sp = new JScrollPane(lst);
		
		add(lb, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		
		lst.addListSelectionListener(new SampleListSelectionListener());*/
	}
	
	public void select_WS_and_Swipe(Workshop Name_of_WS, String Student_Name, int ID) {		//Input information and ask if it is correct.
		JOptionPane.showMessageDialog(null,"Workshop: "+Name_of_WS.getName()+" Name: "+Student_Name+" ID:"+ID);
		int chick = Integer.valueOf(JOptionPane.showInputDialog("Is this information correct? If yes, please enter 1. If no, please enter 0."));
		
		if(chick==1) {
			Name_of_WS.chick_in(Student_Name,ID);
		}
		
	}
}
