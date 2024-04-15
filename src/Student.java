
/**
 * @author Noah Isaac
 */

import java.io.Serializable;

/**
 * Your program must be able to store and manipulate the first name and last name,
 * the GPA,
 * the student’s current address,
 * home address and phone number.
 */

public class Student implements Serializable{
	private double GPA;
	private String lastName;
	private String firstName;
	private String currentAddress;
	private String homeAddress;
	private String phoneNumber;
	
	public Student(String fn, String ln, double gpa, String currentad, String homead, String phnum) 
	{
		 GPA = gpa;
		 lastName = ln;
		 firstName = fn;
		 currentAddress = currentad;
		 homeAddress = homead;
		 phoneNumber = phnum;
	}
	
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gPA) {
		GPA = gPA;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() 
	{
		String toReturn = "NAME: " + firstName +" "+ lastName + ", " + "\n"
		+ "GPA: " + GPA + "\n" + "CURRENT ADDRESS: " + currentAddress+ "\n"
		+ "HOME ADDRESS: " + homeAddress + "\n" + "PHONE NUMBER: " + phoneNumber;
		return toReturn;
	}
	
}
