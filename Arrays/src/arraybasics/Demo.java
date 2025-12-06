package arraybasics;
import java.util.*;
public class Demo {
	static int book_count;
	String name;
	String publisher;
	int year;
	
	public Demo(String n, String p,int y)
	{
		name=n;
		publisher=p;
		year=y;
		book_count++; 
	}
	
	void displayInfo()
	{
		System.out.println("Name: "+name);
		System.out.println("Publisher: "+publisher);
		System.out.println("Year: "+year);
	}
	
	static void showBookCount()
	{
		System.out.println("Total car count: "+book_count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo b1=new Demo("Java","Micro",1992);
		Demo b2=new Demo("Java and python","penguin",1997);
		
		b1.displayInfo();
		b2.displayInfo();
		
		Demo.showBookCount();
		
		

	}

}
