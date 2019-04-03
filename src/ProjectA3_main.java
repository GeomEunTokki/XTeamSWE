
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ProjectA3_main extends JApplet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int pu_counter=0;
	static int su_counter=0;
	static int ws_counter=0;
	static int who_login;
	static int enterloop_counter=0;

	
	public static void main(String [] args) {
		
		//The first frame when you initial this application.
		final JFrame frame11 = new JFrame("Workshop Attention System(WAS)");
		//When you close the frame, it will not show you the error.
		frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame11.setLocationRelativeTo(null);
		frame11.setSize(450, 300);
		
        JLabel label = new JLabel("This is X'project of EXLAB Workshop Attention System(WAS).",SwingConstants.CENTER);	
        label.setPreferredSize(new Dimension(120,24));
		frame11.add(label,BorderLayout.CENTER);
		
		
		final Administrator[] PU = new Administrator[3];				//Set the max user and workshop.
		final Staff[] SU = new Staff[10];
		final Workshop[] WS = new Workshop[10];
		final String[] WS_List = new String[10];

		PU[0] = new Administrator("Fan", 2430436, 1234);		//The initial user account, and The Name is less than 15 char.
		SU[0] = new Staff("Daniel", 2430322, 1234);		//The ID will be less than 7 digits, and the first digit must be bigger than 1.
		WS[0] = new Workshop("Introduce to EXLAB", 00000000, 0000, "Armel");		//The password will be 4 digits, and the first digit must be bigger than 1.
		WS_List[0] = WS[0].getName();
		
		main_interface(frame11, PU, SU, WS, WS_List);
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

	//To valid if the user input is same as to the one stored data.
	public static boolean passwordcheck(User [] U,int user_counter, String verified_name, int verified_password) {
		int i=0;
		for(i=0; i<=user_counter; i++) {				//To match the input with the data.
			if(U[i].getName().equals(verified_name)&&U[i].getPassword() == verified_password) {
				who_login = i;
				return true;
			}
		}
		return false;
	}

	public static void main_interface(final JFrame frame11,final Administrator[] PU, final Staff[] SU, final Workshop[] WS, final String[]WS_List) {
		//When closing the window, it will not show any error, and also it will ask you if you want to close.
				frame11.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				frame11.addWindowListener(   
						new WindowAdapter() {
							public void windowClosing(WindowEvent e) {
								int result=JOptionPane.showConfirmDialog(frame11,"Are you sure that you want to close?","Exit Message!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.WARNING_MESSAGE);
								if (result==JOptionPane.YES_OPTION) {System.exit(0);}
							}    
						}
				);
				//The button for Administrator to login.
				JButton Admin = new JButton("Admin login.");
				Admin.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {	
				        frame11.setVisible(false);
				        before_login_to_PU(frame11, PU, SU, WS, WS_List);
				        }
				}); 
				     
				JButton Staff = new JButton("Staff login.");
				Staff.addActionListener(new java.awt.event.ActionListener() {
				    public void actionPerformed(java.awt.event.ActionEvent e) {	
				        	frame11.setVisible(false);
				        	before_login_to_SU(frame11, PU, SU, WS, WS_List);
				        	}
				}); 
				    
				JPanel login = new JPanel();
				login.add(Admin);login.add(Staff);
				frame11.add(login, BorderLayout.SOUTH);
				frame11.setVisible(true);
	}

	public static void before_login_to_PU(final JFrame frame11, final Administrator[] PU, final Staff[] SU, final Workshop[] WS, final String[]WS_List) {
		final JFrame Ad = new JFrame("Administrator Page");
		Ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ad.setLocationRelativeTo(null);
		Ad.setSize(725, 500);
		Ad.setVisible(true);
		
		final JLabel WA = new JLabel("Welcome Administrator.",SwingConstants.CENTER);
		WA.setFont(new Font("",1,30));
		WA.setPreferredSize(new Dimension(240, 48));

		Ad.add(WA,BorderLayout.CENTER);
		
		JLabel UN = new JLabel("User name:");
		final JTextField verified_name = new JTextField();
		verified_name.setPreferredSize(new Dimension(120,24));
		JLabel PW = new JLabel("Password:");
		final JTextField verified_password = new JTextField();
		verified_password.setPreferredSize(new Dimension(120,24));
		
		JButton login = new JButton("login");
		login.setPreferredSize(new Dimension(90,24));
		JButton forget_user_or_password = new JButton("forget_user_or_password.");
		forget_user_or_password.setPreferredSize(new Dimension(90,24));
		JButton Go_back = new JButton("Previous page");
		Go_back.setPreferredSize(new Dimension(120,24));

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean login = false;
					
					login = passwordcheck(PU ,pu_counter, verified_name.getText(), Integer.valueOf(verified_password.getText()));

					if(login==false) {
						JOptionPane.showMessageDialog(null,"The name or password is not correct. ");
						enterloop_counter++;
						if(enterloop_counter==4) {
							JOptionPane.showMessageDialog(null,"You has been tried too many times. Please contact Administrator. ");
						}
					}
					else {
						enterloop_counter=0;
					}
				
				verified_name.setText(" ");
				verified_password.setText(" ");
				
				if(login==true) {					//If your user information is correct, you can do next operation here.
					WA.setText("Log in successed.");
					
					login_for_Admin(login, frame11, PU, SU, WS, WS_List);
					Ad.setVisible(false);
					login=false;//For checking which index of PU, that User are matched with. After finishing, his session, it will reset to 0.
				}
			}});
		forget_user_or_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"User name: Fan. Password: 1234.");
			}
		});
		Go_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ad.setVisible(!true);
				main_interface(frame11, PU, SU, WS, WS_List);
			}
		});
		
		JPanel Adinput = new JPanel();
		Adinput.add(UN);Adinput.add(verified_name);Adinput.add(PW);Adinput.add(verified_password);
		Adinput.add(login);Adinput.add(forget_user_or_password);Adinput.add(Go_back);
		Ad.add(Adinput, BorderLayout.SOUTH);
	}
	
	public static void before_login_to_SU(final JFrame frame11, final Administrator[] PU, final Staff[] SU, final Workshop[] WS, final String[]WS_List) {
		
		final JFrame St = new JFrame("Staff Page");
		St.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		St.setLocationRelativeTo(null);
		St.setSize(725, 500);
		St.setVisible(true);
		
		JLabel WSt = new JLabel("Welcome Staff.",SwingConstants.CENTER);
		WSt.setFont(new Font("",1,30));
		WSt.setPreferredSize(new Dimension(120,24));
		St.add(WSt,BorderLayout.CENTER);
		
		JLabel UN = new JLabel("User name:");
		final JTextField verified_name = new JTextField();
		verified_name.setPreferredSize(new Dimension(120,24));
		JLabel PW = new JLabel("Password:");
		final JTextField verified_password = new JTextField();
		verified_password.setPreferredSize(new Dimension(120,24));
		
		JButton login = new JButton("login");
		login.setPreferredSize(new Dimension(90,24));
		JButton forget_user_or_password = new JButton("forget_user_or_password.");
		forget_user_or_password.setPreferredSize(new Dimension(90,24));
		JButton Go_back = new JButton("Previous page");
		Go_back.setPreferredSize(new Dimension(120,24));
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean login = false;
		
				login = passwordcheck(SU, su_counter, verified_name.getText(), Integer.valueOf(verified_password.getText()));
			
				if(login==false) {
					JOptionPane.showMessageDialog(null,"The name or password is not correct. ");
					enterloop_counter++;
					if(enterloop_counter==4) {
						JOptionPane.showMessageDialog(null,"You has been tried too many times. Please contact Administrator. ");
					}
				}
				else {
						enterloop_counter=0;
				}

				if(login==true) {//If your user information is correct, you can do next operation here.
					login_for_Staff(login, frame11, PU, SU, WS, WS_List);
					St.setVisible(false);
					login=false;//For checking which index of SU, that User are matched with. After finishing, his session, it will reset to 0.
				}
			}
		});
		forget_user_or_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"User name: Daniel. Password: 1234.");
			}
		});
		Go_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				St.setVisible(!true);
				main_interface(frame11, PU, SU, WS, WS_List);
			}
		});
		
		JPanel Stinput = new JPanel();
		Stinput.add(UN);Stinput.add(verified_name);Stinput.add(PW);Stinput.add(verified_password);
		Stinput.add(login);Stinput.add(forget_user_or_password);Stinput.add(Go_back);
		St.add(Stinput, BorderLayout.SOUTH);
	}
	
	
	
	public static void login_for_Admin(boolean login, final JFrame frame11, final Administrator[] PU, final Staff[] SU, final Workshop[] WS, final String[]WS_List) {
		//If your user information is correct, you can do next operation here.

		final JFrame Ad_option = new JFrame("Administrator Option Page");
		Ad_option.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ad_option.setLocationRelativeTo(null);
		Ad_option.setSize(600, 400);

		
		JButton [] Ad_opt = new JButton[5];
		Ad_opt[0] = new JButton("Add Administrator");
		Ad_opt[0].setPreferredSize(new Dimension(90,24));
		Ad_opt[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PU[pu_counter+1] = PU[who_login].add_Administrator();
				pu_counter++;
				pu_counter=pu_counter%3;
			}
		});
		
		Ad_opt[1] = new JButton("Add Staff");
		Ad_opt[1].setPreferredSize(new Dimension(90,24));
		Ad_opt[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SU[su_counter+1] = PU[who_login].add_Staff();
				su_counter++;
				su_counter=su_counter%10;
			}
		});
		
		Ad_opt[2] = new JButton("Add Workshop");
		Ad_opt[2].setPreferredSize(new Dimension(90,24));
		Ad_opt[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PU[who_login].add_Workshop(frame11, PU, SU, WS, WS_List);
				ws_counter++;
				WS_List[ws_counter+1] = WS[ws_counter+1].getName();
				ws_counter++;
				ws_counter=ws_counter%10;
			}
		});
		
		Ad_opt[3] = new JButton("Remove Workshop");
		Ad_opt[3].setPreferredSize(new Dimension(120,24));
		Ad_opt[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ad_option.setVisible(!true);
				PU[who_login].remove_Workshop(frame11, PU, SU, WS, WS_List);
			}
		});
		
		Ad_opt[4] = new JButton("Previous page");
		Ad_opt[4].setPreferredSize(new Dimension(120,24));
		Ad_opt[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ad_option.setVisible(!true);
				before_login_to_PU(frame11, PU, SU, WS, WS_List);
			}
		});
		
		Ad_option.setLayout(new GridLayout(2,2));
		Ad_option.add(Ad_opt[0]);Ad_option.add(Ad_opt[1]);Ad_option.add(Ad_opt[2]);Ad_option.add(Ad_opt[3]);Ad_option.add(Ad_opt[4]);
			
		Ad_option.setVisible(true);
		
	}

	public static void login_for_Staff(boolean login, final JFrame frame11, final Administrator [] PU, final Staff[] SU, final Workshop[] WS, final String[]WS_List) {
		
		final JFrame St_option = new JFrame("Staff Option Page");
		St_option.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		St_option.setLocationRelativeTo(null);
		St_option.setSize(600, 400);
		JButton [] St_opt = new JButton[2];
		
		St_opt[0] = new JButton("Show and Select a Workshop");
		St_opt[0].setPreferredSize(new Dimension(90,24));
		St_opt[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SU[who_login].show_Workshop(frame11, PU, SU, WS, WS_List);
			}
		});
		
		St_opt[1] = new JButton("Previous page");
		St_opt[1].setPreferredSize(new Dimension(120,24));
		St_opt[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				St_option.setVisible(!true);
				before_login_to_SU(frame11, PU, SU, WS, WS_List);
			}
		});
		
		St_option.setLayout(new GridLayout(1,3));
		St_option.add(St_opt[0]);St_option.add(St_opt[1]);
		
		St_option.setVisible(true);
		

	}
}
