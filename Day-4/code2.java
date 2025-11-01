public class Main {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        Scooter s = new Scooter();
        Car c = new Car();
        v.noOfWheels();
        s.noOfWheels();
        c.noOfWheels();
    }
}
class Vehicle {
    void noOfWheels() {
        System.out.println("No of wheels undefined");
    }
}
class Scooter extends Vehicle {
    void noOfWheels() {
        System.out.println("No of wheels 2");
    }
}
class Car extends Vehicle {
    void noOfWheels() {
        System.out.println("No of wheels 4");
    }
}