package wipro;

public class MultiLevelInheritance {
	public static void main(String[] args) {
		Inheritance2 i2 = new Inheritance2();
		i2.display();
		i2.display1();
	}
}
class MultiLevel {
	void display() {
		System.out.println("Hi im parent class");
	}
}
class Inheritance1 extends MultiLevel {
	void display1 () {
		System.out.println("Hi im 1st Inherited class");
	}
}
class Inheritance2 extends Inheritance1 {
	
}

