package stringsOperations;
import java.util.*;
public class Unique {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input  = sc.nextLine();
		String[] words = input.split(" ");
		Set<String> uw = new HashSet<>();
		for(String a: words) {
			uw.add(a);
		}
		System.out.println(uw.size());
	}
}
