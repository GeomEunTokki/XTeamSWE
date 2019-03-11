package X_Project.A3;
import java.util.*;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App 
{
	static int pu_counter=0;
	static int su_counter=0;
	static int ws_counter=0;
	
	public static void main(String [] args) {
		JOptionPane.showMessageDialog(null, "This is X'project of EXLAB Workshop Attention System(WAS).");
		
		int user_type_control_loop = 1;
		int user_login_signup = 0;
		
		Primary_User[] PU = new Primary_User[3];				//Set the max user and workshop.
		Secondary_User[] SU = new Secondary_User[10];
		Workshop[] WS = new Workshop[30];
		String[] WS_List = new String[30];

		PU[0] = new Primary_User("Fan", 002430436, 1234);		//The initial user account.

		SU[0] = new Secondary_User("Daniel", 002430322, 1234);
		
		WS[0] = new Workshop("Tntroduce to EXLAB", 0000, 0000, "Armel");
		WS_List[0] = WS[0].getName();
		
		//This while loop is to decide if you want to log in to use WAS.
		while(user_type_control_loop == 1) {	
			
			user_login_signup = Integer.valueOf(JOptionPane.showInputDialog("If you are primary user, please enter 1 and secondary user please enter 2." ));
			
			/*The main structure here:
			 * if(You are a primary user.){
			 * 		while(For entering user ID and name.){
			 * 			for loop to match the ID and name.
			 * 			{if(If not correct, User can choose if they want to continue.)
			 * 				
			 * 			}
			 * 		}
			 * 		if(The user logins successfully.){
			 * 			while(){
			 * 				Do the things they need.
			 * 			}
			 * 		}
			 * }
			 * else if(You are a Secondary user){
			 * 		while(For entering user ID and name.){
			 * 			for loop to match the ID and name.
			 * 			{if(If not correct, User can choose if they want to continue.)
			 * 				
			 * 			}
			 * 		}
			 * 		if(The user logins successfully.){
			 * 			while(){
			 * 				Do the things they need.
			 * 			}
			 * 		}
			 * }
			 * */
			if(user_login_signup == 1) {

				JOptionPane.showMessageDialog(null, "Welcome Primary User.");
				
				int enterloop=0;int login=0;int i=0;
				
				while(enterloop==0) {
					String verified_name = JOptionPane.showInputDialog("Please enter your name.");
					int verified_password = Integer.valueOf(JOptionPane.showInputDialog("Please enter your user password." ));
					
					for(i=0; i<=pu_counter; i++) {				//To match the input with the data.
						if(PU[i].getName().equals(verified_name)&&PU[i].getPassword() == verified_password) {
							login=1;
							break;
						}
					}
					
					if(login!=1) {
						JOptionPane.showMessageDialog(null,"The name or password is not correct. ");
						enterloop = Integer.valueOf(JOptionPane.showInputDialog("Do you want to try one more time? If yes, please enter a number not 0." ));
					}
					else {
						break;
					}
					
				}
				
				if(login==1) {					//If your user information is correct, you can do next operation here.
					JOptionPane.showMessageDialog(null, "Log in successed.");
					
					int opt=0;
					while(opt!=4) {
						JOptionPane.showMessageDialog(null,"Please select one opertion.");
					
						opt = Integer.valueOf(JOptionPane.showInputDialog("Add Primary User:1, Add Secondary User:2, Add Workshop:3, Exit:4" ));
							switch(opt){
								case 1:
									PU[pu_counter+1] = PU[i].add_Primary_User();
									pu_counter++;
									break;
							
								case 2:
									SU[su_counter+1] = PU[i].add_Secondary_User();
									su_counter++;
									break;
								
								case 3:
									WS[ws_counter+1] = PU[i].add_Workshop();
									WS_List[ws_counter+1] = WS[ws_counter+1].getName();
									ws_counter++;
									break;
						}
					
					}
					i=0;//For checking which index of PU, that User are matched with. After finishing, his session, it will reset to 0.
				}
				
			}
			
			else if(user_login_signup == 2) {				
				JOptionPane.showMessageDialog(null, "Welcome Secondary User.");
				
				int enterloop=0;int login=0;int i=0;
				while(enterloop==0) {
					String verified_name = JOptionPane.showInputDialog("Please enter your name.");
					int verified_password = Integer.valueOf(JOptionPane.showInputDialog("Please enter your user password." ));
				
					for(i=0; i<=su_counter; i++) {				//To match the input with the data.
						if(SU[i].getName().equals(verified_name)&&SU[i].getPassword() == verified_password) {
							login=1;
							break;
						}
					}
					
					if(login!=1) {
						JOptionPane.showMessageDialog(null,"The name or password is not correct. ");
						enterloop = Integer.valueOf(JOptionPane.showInputDialog("Do you want to try one more time? If yes, please enter a number not 0." ));
					}
					else {
						break;
					}
					
				}
				
				if(login==1) {					//If your user information is correct, you can do next operation here.
					JOptionPane.showMessageDialog(null, "Log in successed.");
					
					int opt=0;
					while(opt!=4) {
						
					JOptionPane.showMessageDialog(null,"Please select one opertion.");
					
					opt = Integer.valueOf(JOptionPane.showInputDialog("Show Workshop:1,  select_WS_and_Swipe ID:2, Exit:4" ));
					
						switch(opt){
							case 1:
								//We can add introduction of each workshop.
								SU[i].show_Workshop(WS_List);
								break;
								
							case 2:
								//We can change this to GUI list. When SU click it, it will ask if he wants to add students.
								int choose = Integer.valueOf(JOptionPane.showInputDialog("Please enter which workshop you want."));
								String Student_name = JOptionPane.showInputDialog("Please input the name of student.");
								int ID = Integer.valueOf(JOptionPane.showInputDialog("Please enter student ID."));
								SU[i].select_WS_and_Swipe(WS[choose],Student_name,ID);
								break;
			
						}
						
					}
					i=0;//For checking which index of SU, that User are matched with. After finishing, his session, it will reset to 0.
					
				}
				
			}
				
			else {
				JOptionPane.showMessageDialog(null,"There is something wrong.");
			}
			
			JOptionPane.showMessageDialog(null,"Exit WAS, please enter the other not one number.");
			user_type_control_loop = Integer.valueOf(JOptionPane.showInputDialog("Continue WAS, please enter the number one." ));
		}
	}
}
