import java.util.Scanner;

public class MultidimensionalArrayExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[][] = new int[scanner.nextInt()][scanner.nextInt()];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                   System.out.print(arr[i][j] + " ");
            }
             System.out.println();
        }
        scanner.close();
    }
}