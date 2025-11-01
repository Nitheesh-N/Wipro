import java.util.InputMismatchException;
import java.util.Scanner;

class Test {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0;
        boolean validInput = false;

        // Prompt for first number until valid integer entered
        while (!validInput) {
            try {
                num1 = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // clear invalid input
            }
        }

        // Prompt for second number until valid and not zero
        validInput = false;
        while (!validInput) {
            try {
                num2 = sc.nextInt();
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero. Please enter a valid divisor.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // clear invalid input
            }
        }

        int result = num1 / num2;
        System.out.println("Result: " + result);
    }
}