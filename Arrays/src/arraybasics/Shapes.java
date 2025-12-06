package arraybasics;
import java.util.*;
//polymorphism
public class Shapes {
	public static void main(String[] args) {
		System.out.println("Cube volume: " + VolumeCalculator.volume(12));
		System.out.println("Sphere volume: " + VolumeCalculator.volume(3.24));
		System.out.println("Cylinder volume: " + VolumeCalculator.volume(2.45, 5.7));
	}
}
class VolumeCalculator {
	static int volume(int length) {
		return length*length*length;
	}
	static double volume(double radius, double height) {
		return Math.PI*radius*radius*height;
	}
	static double volume(double radius) {
		return(4.0/3.0) * Math.PI*radius*radius*radius;
	}
}
