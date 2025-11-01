import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                Test<Integer> t1 = new Test<>();
                t1.add(30, 20);
                break;
            case 2: 
                Test<Double> t2 = new Test<>();
                t2.add(10.0, 20.0);
                break;
            case 3: 
                Test<Float> t3 = new Test<>();
                t3.add(20.0f, 20.0f);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}

class Test<T extends Number> {
    void add(T a, T b) {
        if (a instanceof Integer) {
			double result = a.doubleValue() + b.doubleValue();
            System.out.println("the sum is = " + result);
        } else if (a instanceof Double) {
            System.out.println("the sum is = " + (a.doubleValue() + b.doubleValue()));
        } else if (a instanceof Float) {
            System.out.println("the sum is = " + (a.floatValue() + b.floatValue()));
        } else if (a instanceof Long) {
            System.out.println("the sum is = " + (a.longValue() + b.longValue()));
        } else {
            System.out.println("Unsupported type");
        }
    }
}