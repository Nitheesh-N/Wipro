package arraybasics;
import java.util.*;
public class Student {
	String name;
	int salary;
	String department;
	public Student(String name,int salary,String department) {
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	public Student(String name) {
		this.salary = 53000;
		this.department = "Testing";
		this.name = name;
	}
	public Student(String name,int salary) {
		this.department = "Cloud";
		this.name = name;
		this.salary = salary;
	}
	public Student() {
		name = "Unknown";
		salary = 0;
		department = "Unknown";
	}
	void display() {
		System.out.println("The name of the employee is: " + name);
		System.out.println("The salary of the employee is: " + salary);
		System.out.println("The department of the employee is: " + department);
	}
}
class Main {
	public static void main(String[] args) {
		Student employee = new Student();
		Student employee1 = new Student("John doe",45000,"Oracle");
		Student employee2 = new Student("Sunny",95000);
		Student employee3 = new Student("Max");
		employee.display();
		System.out.println("Constructor default is executed----------");
		System.out.println();
		employee1.display();
		System.out.println("Constructor 3 executed--------------");
		System.out.println();
		employee2.display();
		System.out.println("Constructor 2 executed---------------");
		System.out.println();
		employee3.display();
		System.out.println("Constructor 1 executed---------------");
	}
}
