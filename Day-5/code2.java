import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try {
            int n = Integer.parseInt(input); // could throw NumberFormatException
            if (99 % n == 0) {
                System.out.println(n + " is a factor of 99");
            } else {
                System.out.println(n + " is a not a factor of 99");
            }
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception " + e); // For division by zero
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception " + e);
        }
    }
}