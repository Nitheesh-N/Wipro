package stringsOperations;
import java.util.*;
public class ArrayCommon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Integer> al1 = new ArrayList<>();
		for(int i=0;i<n;i++) {
			al.add(sc.nextInt());
		}
		for(int i=0;i<m;i++) {
			al1.add(sc.nextInt());
		}
		boolean found = false;
		for(int i: al) {
			if(al1.contains(i)) {
				found = true;
				System.out.println("true");
			}
		}
		if(!found) {
			System.out.println("false");
		}
		
	}
}
