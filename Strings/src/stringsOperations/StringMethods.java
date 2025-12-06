package stringsOperations;
import java.util.*;
public class StringMethods {
	public static void main(String[] args) {
		String a = "hello world";
		String b = "How are you!";
		String c = a + b;
		System.out.println(c);
		String d = a.concat(" ").concat(b);
		System.out.println(d);
		char e = d.charAt(2);
		System.out.println(e);
		if(d.contains("world")) {
			System.out.println("Exists");
		}
		else {
			System.out.println("Not exists");
		}
		String f = d.substring(2,6);
		System.out.println(f);
		String g = d.toUpperCase();
		System.out.println(g);
		System.out.println("The length of string in d is: " + d.length());
	}
}
