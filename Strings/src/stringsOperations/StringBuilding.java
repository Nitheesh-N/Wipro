package stringsOperations;
import java.util.*;
public class StringBuilding {
	public static void main(String[] args) {
		String a = "Hello";
		StringBuilder sb = new StringBuilder(a);
		sb.append(" world!");
		System.out.println(sb);
		sb.replace(5,7,"");
		System.out.println(sb);
		sb.insert(1, "hey");
		System.out.println(sb);
		sb.delete(4, 6);
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
	}
}

