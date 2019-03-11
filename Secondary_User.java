package X_Project.A3;
import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

public class Secondary_User extends User {
	
	private JLabel lb;
	private JList lst;
	private JScrollPane sp;
	
	public Secondary_User (String myname, int myID, int myPassword) {
		super(myname, myID, myPassword);
	}
	
	public void show_Workshop(String[] ws_counter) {
		JOptionPane.showMessageDialog(null, Arrays.toString(ws_counter));
		
		/*lb = new JLabel("The list of WorkShop.");
		lst = new JList(ws_counter);
		sp = new JScrollPane(lst);
		
		add(lb, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		
		lst.addListSelectionListener(new SampleListSelectionListener());*/
	}
	
	public void select_WS_and_Swipe(Workshop Name_of_WS, String Name, int ID) {
		JOptionPane.showMessageDialog(null,"Workshop: "+Name_of_WS.getName()+" Name: "+Name+" ID:"+ID);
		int chick = Integer.valueOf(JOptionPane.showInputDialog("Is this information correct? If yes, please enter 1. If no, please enter 0."));
		
		if(chick==1) {
			Name_of_WS.chick_in(Name,ID);
		}
		
	}

}
