package wipro;

public class UsingSuper {
	public static void main(String[] args) {
        c1 i1 = new c1();
        c2 i2 = new c2();
        c3 i3 = new c3();
        i1.display();
        i2.display();
        i3.display();
    }
}

class Parent {
    void display() {
        System.out.println("I'm the parent class");
    }
}

class c1 extends Parent {
    void display() {
        super.display();  
        System.out.println("I'm Inheritance1 class");
    }
}

class c2 extends Parent {
    void display() {
        super.display();  
        System.out.println("I'm Inheritance2 class");
    }
}

class c3 extends Parent {
    void display() {
        super.display();  
        System.out.println("I'm Inheritance3 class");
    }
}

