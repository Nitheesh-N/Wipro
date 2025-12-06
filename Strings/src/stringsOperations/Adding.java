package stringsOperations;
import java.util.*;
public class Adding {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		Queue<Integer> a = new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			a.add(sc.nextInt());
		}
		System.out.println(a);
		System.out.println("Enter the number of elements to be added extra");
		int m = sc.nextInt();
		for(int i=0;i<m;i++) {
			a.add(sc.nextInt());
		}
		System.out.println("Enter the element to be removed: ");
		int b = sc.nextInt();
		a.remove(b);
		System.out.println("After removing " + b + " from Queue: " + a);
		System.out.println("First element in the queue is: " + a.peek());
		System.out.println("Queue:" + a);
	}
}
