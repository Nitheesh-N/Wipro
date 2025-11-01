import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            map.put(i, s.next());
        }
        System.out.print("Mappings of HashMap are : ");
        System.out.println(map);
        int removeKey = s.nextInt();
        map.remove(removeKey);
        System.out.print("Mappings after removal are : ");
        System.out.println(map);
        s.close();
    }
}
Comment:

