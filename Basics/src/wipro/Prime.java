package wipro;
import java.util.*;
public class Prime {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		switch(n) {
		case 80 -> System.out.println("good");
		case 60 -> System.out.println("Ok");
		case 40 -> System.out.println("not bad");
		case 30 -> System.out.println("Poor");
		}
		if(n<30) {
			System.out.println("Fail");
		}
	}
}
