package constructor;
import java.util.*;
public class Demo {
	String author;
	String bookName;
	int price;
	public Demo(String author,String bookName,int price) {
		this.author = author;
		this.bookName = bookName;
		this.price= price;
	}
	void displayInfo() {
		System.out.println("The author name is: " + author);
		System.out.println("The bookName is: " + bookName);
		System.out.println("The price is: " + price);
	}
}
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String authorName = sc.nextLine();
		String bookname = sc.nextLine();
		int bookprice = sc.nextInt();
		Demo d = new Demo(authorName,bookname,bookprice);
		d.displayInfo();
	}
}
