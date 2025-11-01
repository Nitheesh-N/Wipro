import java.util.*;

public class DataAnalyzer<T extends Number & Comparable<T>> {
    private T[] data;
    public DataAnalyzer(T[] data) {
        this.data = data;
    }

    public double calculateAverage() {
        double sum = 0.0;
        for (T element : data) {
            sum += element.doubleValue();         }
        return sum / data.length;
    }

    public T findMaximum() {
        T max = data[0];
        for (T element : data) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public void dataSummary() {
        System.out.println("Data Summary:");
        System.out.println("Average: " + calculateAverage());
        System.out.println("Maximum: " + findMaximum());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        int size = sc.nextInt();

        if (ch == 1) {
            Integer[] integerData = new Integer[size];
            for (int i = 0; i < size; i++)
                integerData[i] = sc.nextInt();
            DataAnalyzer<Integer> analyzer = new DataAnalyzer<>(integerData);
            analyzer.dataSummary();
        } else if (ch == 2) {
            Double[] doubleData = new Double[size];
            for (int i = 0; i < size; i++)
                doubleData[i] = sc.nextDouble();
            DataAnalyzer<Double> analyzer = new DataAnalyzer<>(doubleData);
            analyzer.dataSummary();
        } else if (ch == 3) {
            Short[] shortData = new Short[size];
            for (int i = 0; i < size; i++)
                shortData[i] = sc.nextShort();
            DataAnalyzer<Short> analyzer = new DataAnalyzer<>(shortData);
            analyzer.dataSummary();
        } else if (ch == 4) {
            Float[] floatData = new Float[size];
            for (int i = 0; i < size; i++)
                floatData[i] = sc.nextFloat();
            DataAnalyzer<Float> analyzer = new DataAnalyzer<>(floatData);
            analyzer.dataSummary();
        }
    }
}