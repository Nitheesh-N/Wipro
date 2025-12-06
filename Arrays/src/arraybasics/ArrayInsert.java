package arraybasics;
import java.util.*;
public class ArrayInsert {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];	
		for(int i=0;i<arr.length;i++) {
			arr[i] = scan.nextInt();
		}
		System.out.print("[");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			if(i!=arr.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		System.out.println(arr[0]);
		System.out.println(arr[n-1]);
	}
}
