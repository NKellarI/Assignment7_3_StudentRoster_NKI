/**
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * @author Noah Isaac
 * @apiNote This class builds a command system and manages drawing to the screen
 */
public class MenuManager {
	
	private Menu makeStudentMenu;
	private Menu homeMenu;
	private Menu findStudentMenu;
	public MenuManager()
	{	
	
	}	
	/**
	 * 
	 * @param Command A String that moves through a switch for menu access
	 */
	public void Command(String cmd) 
	{
		Scanner scnr = new Scanner(System.in);
		switch(cmd) {
		  case "make_students":
			 //Make a Menu with the name Make Student
			 makeStudentMenu = new Menu("Make Student");
			 // Makes a list of objects as the parameters to make a student have different types
			 Object[] studentValues = new Object[6];
			 // A loop to make params for every student 
			 for(int i = 0; i < 5; i++ ) 
			 {
			  makeStudentMenu.setToDraw(new String[] {"Enter The Following Information For Student " + (i+1) + "/5", "FIRST NAME:",
						 "LAST NAME", "GPA:","CURRENT ADDRESS:","HOME ADDRESS:","PHONE NUMBER:", "STUDENT CREATION COMPLETE"});
			  // Print instructions and student count out of first toDraw Index
			  makeStudentMenu.drawElement(true, 0);
			  //For every Student ask these questions and fill out the values
			  for(int j = 0; j < studentValues.length; j++) 
			  {
				  //Prints the instructions for the current params of the student
				  makeStudentMenu.drawElement(true, j+1);
				  // We do this for the fact that GPA is a double we dont want wonky tonky here
				  if(j == 2) 
				  {
					  studentValues[j] = Double.valueOf(scnr.nextLine());  
				  }else {studentValues[j] = scnr.nextLine();}
			  } 
			  	Application.roster.createStudent((String)studentValues[0],(String) studentValues[1], (double)studentValues[2], (String)studentValues[3], (String)studentValues[4], (String)studentValues[5]);
			 }
			 //Waits for next command 
			 System.out.print("All Student Creation Complete!");
			 System.out.print("TYPE |home|:");
			 String io = scnr.next();
			 Command(io);
		    break;
		  case "home":
			  //Makes a Menu with the home name
			  homeMenu = new Menu("Home");
			  //Stores a list of things meant to be drawn to the menu instance of homeMenu
			  homeMenu.setToDraw(new String[] {"TYPE THE COMMANDS TO ENTER MENU!","Typing |home| will return you here",
				" |make_students| -> Makes students at the first available index",
				" |print_roster| -> prints roster",
				" |find_student| -> enter a first and last to find a student",
				" |save_roster| -> Saves roster to disk",
				" |load_roster| -> Loads roster from disk",
				" |exit| -> Erm Its kills program"
			  });
			  //Draws the menu elements with the boolean true meaning newline
			  homeMenu.drawElements(true);
			  System.out.print("TYPE CMD:");
			  String input = scnr.next();
			  Command(input);
		    break;
		  case "print_roster":
			  homeMenu = new Menu("Home");
			  System.out.print(Application.roster.toString());
			  System.out.print("TYPE CMD:");
			  String pi = scnr.next();
			  Command(pi);
			  break;
		  case "find_student":
			  findStudentMenu = new Menu("Find Student");
			  findStudentMenu.setToDraw(new String[] {"Enter A Studnet Name:","Enter First And Last Name:"});
			  String name = "";
			  for(int i =0; i < 2; i++) 
			  {
				 name = name + scnr.next().toLowerCase();
			  }
			  for(int i = 0; i < Application.roster.getStudentRosterCount(); i++) 
			  {
				  if((Application.roster.getStudentFromRosterIndex(i).getFirstName().toLowerCase() + Application.roster.getStudentFromRosterIndex(i).getLastName().toLowerCase()).equals(name)) 
				  {
					  System.out.print(Application.roster.getStudentFromRosterIndex(i).toString());
				  }else {System.out.println("Student Not Found Try Consulting the Roster!");}
			  }
			  System.out.println("TYPE CMD:");
			  String zi = scnr.next();
			  Command(zi);
			  break;
		  case"save_roster":
			  findStudentMenu = new Menu("Saving Student Roster!");
			  File file = new File("studentRoster.data"); 
			  try {
		            FileOutputStream fs = new FileOutputStream(file);
		            ObjectOutputStream os = new ObjectOutputStream(fs);
		            os.writeObject(Application.roster); // 3
		            os.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			  	System.out.println("Saving Complete!");
			  	Command("home");
			  break;
		  case"load_roster":
			  File ReadFile =  new File("studentRoster.data");    
		        try {
		            FileInputStream fis = new FileInputStream(ReadFile);
		            ObjectInputStream ois = new ObjectInputStream(fis);
		            StudentRoster loadedRoster  = (StudentRoster) ois.readObject();
		            Application.roster = loadedRoster;
		            ois.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        Command("home");
			  break;
		  case"exit":
			  System.exit(0);
			  break;
		  default:
		   System.out.println("Not a proper input:");
		   Command("home");
		}
	}
}