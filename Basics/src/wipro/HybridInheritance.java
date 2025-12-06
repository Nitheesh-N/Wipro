package wipro;

public class HybridInheritance {
	public static void main(String[] args) {
		child2 c2  = new child2();
		c2.display();
		c2.display1();
		c2.display2();
		child3 c3 = new child3();
		child4 c4 = new child4();
		child5 c5 = new child5();
		c3.display();
		c3.display1();
		c3.display2();
		c4.display();
		c4.display1();
		c4.display2();
		c5.display();
		c5.display1();
		c5.display2();
	}
}
class Hybrid {
	void display() {
		System.out.println("Hi im Parent class");
	}
}
class child1 extends Hybrid {
	void display1() {
		System.out.println("Hi im child1 class");
	}
}
class child2 extends child1 {
	void display2() {
		System.out.println("Hi im child2 class");
	}
}
class child3 extends child2 {
	
}
class child4 extends child2 {
	
}
class child5 extends child2 {
	
}
