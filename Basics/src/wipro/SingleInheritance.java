package wipro;
import java.util.*;
public class SingleInheritance {
	void display() {
		System.out.println("Hi im single Inheritance");
	}
}
class Inheritance extends SingleInheritance {
	
}
class Main {
	public static void main(String[] args) {
		Inheritance i = new Inheritance();
		i.display();
	}
}
