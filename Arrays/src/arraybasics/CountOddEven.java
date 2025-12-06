package arraybasics;
import java.util.*;
public class CountOddEven {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		int evenCount = 0;
		int oddCount = 0;
		System.out.print("[");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			if(i!=arr.length-1) {
				System.out.print(", ");
			}
			if(arr[i]%2==0) {
				evenCount++;
			}
			else {
				oddCount++;
			}
		}
		System.out.println("]");
		System.out.println("EvenCount: " + evenCount);
		System.out.println("OddCount: " + oddCount);
	}
}
