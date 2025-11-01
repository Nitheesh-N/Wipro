import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cube cuboid1 = new Cube();
        System.out.println("Constructor without parameter");
        cuboid1.display();
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int w = s.nextInt();
        int h = s.nextInt();
        Cube cuboid2 = new Cube(l, w, h);
        System.out.println("Constructor with parameter");
        cuboid2.display();
    }
    static class Cube {
        double length, width, height;
        public Cube() {
            length = width = height = 10.0; 
        }
        public Cube(int l, int w, int h) {
            length = l;
            width = w;
            height = h;
        }
        public void display() {
            double volume = length * width * height;
            System.out.println("Volume is " + volume);
        }
    }
}