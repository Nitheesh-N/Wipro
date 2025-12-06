package arraybasics;
import java.util.*;
public class ArraySum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		System.out.print("[");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			if(i!=arr.length-1) {
				System.out.print(", ");
			}
			sum+=arr[i];
		}
		System.out.println("]");
		System.out.println("Sum: " + sum);
	}
}
