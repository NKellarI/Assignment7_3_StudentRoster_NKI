/**
 * 
 */

/**
 * @author Noah Isaac
 */
public class Application {
	public static StudentRoster roster = new StudentRoster();
	public static void main(String[] args) {
		/** TODO  
		 * Application class that drives the program instantiating other classes and including the main method, prints the user interface etc. Name this class Application.
		 * HINT: The general work flow will be as follows.
		*/
		MenuManager MM = new MenuManager();
		MM.Command("home");
	}

}
