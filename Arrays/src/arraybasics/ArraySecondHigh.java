package arraybasics;
import java.util.*;
public class ArraySecondHigh {
	public static void main(String[] args) {
		int[] arr = {12, 35, 1, 10, 35, 1};
		Arrays.sort(arr);
		int n = arr.length;
		int largest = arr[n-1];
		for (int i = n-2; i >= 0; i--) {
		    if (arr[i] != largest) {
		        System.out.println("Second largest: " + arr[i]);
		        break;
		    }
		}

	}
}
