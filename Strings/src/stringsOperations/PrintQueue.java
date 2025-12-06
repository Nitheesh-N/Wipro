package stringsOperations;
import java.util.*;
public class PrintQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			q.add(sc.nextInt());
		}
		Iterator <Integer> iterator = q.iterator();
		System.out.print("[");
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
			if(iterator.hasNext()) {
				System.out.print(" ");
			}
		}
		System.out.println("]");
	}
}
