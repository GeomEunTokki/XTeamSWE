


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Administrator extends User{
	
	
	public Administrator(String myname, int myID, int myPassword) {
		super(myname, myID, myPassword);
	}

	public Administrator add_Administrator() {
		
		String myName = JOptionPane.showInputDialog("Please enter the name of Primary User.");
		
		int myID = Integer.valueOf(JOptionPane.showInputDialog("Please enter the ID of Primary User."));
		
		int myPassword = Integer.valueOf(JOptionPane.showInputDialog("Please enter the Password of Primary User."));
		
		boolean name = checkname(myName);
		boolean ID = checkID(myID);
		boolean Password = checkpassword(myPassword);
		if(name&&ID&&Password) {
			Administrator a = new Administrator(myName, myID, myPassword);

			ConnectDB mongo = new ConnectDB();
			mongo.addAdmin(myName, myID, myPassword);
			return a;
		}
			return null;
	}
	
	
	public Staff add_Staff() {
		
		String myName = JOptionPane.showInputDialog("Please enter the name of Secondary User.");
		
		int myID = Integer.valueOf(JOptionPane.showInputDialog("Please enter the ID of Secondary User."));
		
		int myPassword = Integer.valueOf(JOptionPane.showInputDialog("Please enter the Password of Secondary User."));

		boolean name = checkname(myName);
		boolean ID = checkID(myID);
		boolean Password = checkpassword(myPassword);
		if(name&&ID&&Password) {
			Staff a = new Staff(myName, myID, myPassword);
			return a;
		}
			return null;
	}
	
	public void add_Workshop(final JFrame frame11, final Administrator[] PU, final Staff[] SU, final Workshop[] WS, final String[]WS_List)  {
		
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
		
		List[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				WS[1] = a;
				WS_List[1] = WS[1].getName();
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is added successfully.");
			}
		});
		
		List[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				WS[2] = a;
				WS_List[2] = WS[2].getName();
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is added successfully.");
			}
		});
		
		List[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				WS[3] = a;
				WS_List[3] = WS[3].getName();
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is added successfully.");
			}
		});
		
		List[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				WS[4] = a;
				WS_List[4] = WS[4].getName();
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is added successfully.");
			}
		});
		
		List[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				WS[5] = a;
				WS_List[5] = WS[5].getName();
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is added successfully.");
			}
		});
		
		List[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				WS[6] = a;
				WS_List[6] = WS[6].getName();
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is added successfully.");
			}
		});
		
		List[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				WS[7] = a;
				WS_List[7] = WS[7].getName();
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is added successfully.");
			}
		});
		
		List[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				WS[8] = a;
				WS_List[8] = WS[8].getName();
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is added successfully.");
			}
		});
		
		List[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				WS[9] = a;
				WS_List[9] = WS[9].getName();
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is added successfully.");
			}
		});
		
		show_WS.setVisible(true);
		
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_WS.setVisible(!true);

				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
			}
		});
	
	}
	
	public void remove_Workshop(final JFrame frame11, final Administrator[] PU, final Staff[] SU, final Workshop[] WS, final String[]WS_List) {
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
				WS[0] = null;
				WS_List[0] = null;
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is removed successfully.");
			}
		});
		
		List[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WS[1] = null;
				WS_List[1] = null;
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is removed successfully.");
			}
		});
		
		List[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WS[2] = null;
				WS_List[2] = null;
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is removed successfully.");
			}
		});
		
		List[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WS[3] = null;
				WS_List[3] = null;
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is removed successfully.");
			}
		});
		
		List[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WS[4] = null;
				WS_List[4] = null;
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is removed successfully.");
			}
		});
		
		List[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WS[5] = null;
				WS_List[5] = null;
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is removed successfully.");
			}
		});
		
		List[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WS[6] = null;
				WS_List[6] = null;
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is removed successfully.");
			}
		});
		
		List[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WS[7] = null;
				WS_List[7] = null;
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is removed successfully.");
			}
		});
		
		List[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WS[8] = null;
				WS_List[8] = null;
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is removed successfully.");
			}
		});
		
		List[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WS[9] = null;
				WS_List[9] = null;
				show_WS.setVisible(!true);
				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
				JOptionPane.showMessageDialog(null, "The workshop is removed successfully.");
			}
		});
		show_WS.setVisible(true);
		
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_WS.setVisible(!true);

				ProjectA3_main.login_for_Admin(true, frame11, PU, SU, WS, WS_List);
			}
		});
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
