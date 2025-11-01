import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int maxCount = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        int minMoves = s.length() - maxCount;
        System.out.println(minMoves);
        sc.close();
    }
}