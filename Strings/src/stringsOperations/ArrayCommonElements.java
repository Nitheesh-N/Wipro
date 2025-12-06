package stringsOperations;
import java.util.*;
public class ArrayCommonElements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>al = new ArrayList<>();
		ArrayList<Integer>al1 = new ArrayList<>();
		ArrayList<Integer>al2 = new ArrayList<>();
		for(int i=0;i<n;i++) {
			al.add(sc.nextInt());
		}
		for(int i=0;i<m;i++) {
			al1.add(sc.nextInt());
		}
		for(int i: al) {
			if(al1.contains(i)) {
				al2.add(i);
			}
		}
		System.out.println(al2);
	}
}
