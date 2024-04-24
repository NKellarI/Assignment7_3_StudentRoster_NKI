/**
 * 
 */

import java.io.Serializable;

/**
 * @author Noah Isaac
 * A StudentRoster class that contains the array of student objects and other functionality you deem necessary such
 *  as adding an instance of a Student to the roster, returning the array,
 *  reading from disk and writing to disk. Name the class StudentRoster.
 * The StudentRoster class should have methods to print one student and to print the roster of students.
 */
public class StudentRoster  implements Serializable{
	private Student[] students;
	private int studentRosterIndex = 0; 
	public StudentRoster() 
	{
		students = new Student[5];
	}
	
	public void setStudents(Student[] list) 
	{
		this.students = list;
	}
	
	public void createStudent(String fn, String ln, double gpa, String currentad, String homead, String phnum) 
	{
			if(!(students[studentRosterIndex] instanceof Student)) 
			{
				students[studentRosterIndex] = new Student(fn,ln,gpa,currentad,homead,phnum);
				if(studentRosterIndex < 5) {studentRosterIndex++;}
			}
			
	}
	
	public Student getStudentFromRosterIndex(int studentIndex) 
	{
		if(students[studentIndex] instanceof Student) 
		{
			return students[studentIndex];
		}else 
		{
			System.out.println("No Student Found At that Index!!!");
		}
		return null;
	}
	
	public String toString()
	{
		String toReturn = "";
		for(int i = 0; i < students.length; i++) 
		{
			if(students[i] instanceof Student) 
			{
				toReturn = toReturn+"\n" + students[i].toString();
			}
		}
		return toReturn + "----------------------------";
	}
	
	public void saveToDisk() 
	{
		System.out.print("Saving WORK IN PROGRESS");
	}
	
	public void loadFromDisk() {
		System.out.print("Loading WORK IN PROGRESS");
	}

	public int getStudentRosterCount() {
		return studentRosterIndex;
	}

	public void setStudentRosterCount(int studentRosterCount) {
		this.studentRosterIndex = studentRosterCount;
	}

}
