package wipro;

public class HierarchialInheritance {
	public static void main(String[] args) {
		Inherited1 i1 = new Inherited1();
		Inherited2 i2 = new Inherited2();
		Inherited3 i3 = new Inherited3();
		i1.display();
		i2.display();
		i3.display();
	}
}
class Hierarchy {
	void display() {
		System.out.println("im the parent class");
	}
}
class Inherited1 extends Hierarchy {
	
}
class Inherited2 extends Hierarchy {
	
}
class Inherited3 extends Hierarchy {
	
}
