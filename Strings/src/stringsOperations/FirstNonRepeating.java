package stringsOperations;
import java.util.*;
public class FirstNonRepeating {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	String a = sc.nextLine();
	Set<Character> s = new LinkedHashSet<>();
	Set<Character> s1 = new HashSet<>();
	for(char x: a.toCharArray()) {
		if(!s1.contains(x)) {
			if(s.contains(x)) {
				s.remove(x);
				s1.add(x);
			} else {
				s.add(x);
			}
		}
	}
	if(!s.isEmpty()) {
		System.out.println("First non repeating character: " + s.iterator().next());
	} else {
		System.out.println("All characters repeat");
	}
	}
}
