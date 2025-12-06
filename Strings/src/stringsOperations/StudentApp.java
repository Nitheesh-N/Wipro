package stringsOperations;
import java.util.*;
public class StudentApp {
	public static void main(String[] args) {
		Student s = new Student("Mukesh",30);
		s.displayInfo();
	}
}
class Person {
	String name;
	public Person(String name) {
		this.name = name;
	}
	void displayInfo() {
		System.out.println("Name: " + name);
	}
}
class Student extends Person {
	int rollNum;
	public Student(String name,int rollNum) {
		super(name);
		this.rollNum = rollNum;
	}
	void displayInfo() {
		super.displayInfo();
		System.out.println("Name: " + name);
		System.out.println("Roll Number: " + rollNum);
	}
	
}