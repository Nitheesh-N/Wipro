package stringsOperations;
import java.util.*;
public class QueueReverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			q.add(sc.nextInt());
		}
		System.out.println("Original Queue: " + q);
		Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
		System.out.println("Reversed Queue: " + q);
	}
}
