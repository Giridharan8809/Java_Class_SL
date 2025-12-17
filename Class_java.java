// Class definition
class Car {           

    // Attributes (Data Members)
    String brand;
    int speed;

    // Method (Behavior)
    void drive() {
        System.out.println(brand + " is moving at " + speed + " km/h");
    }
}

public class Class_java {
    public static void main(String[] args) {
        
        // Creating an object
        Car myCar = new Car();

        
        
        // Assigning values
        myCar.brand = "Honda";
        myCar.speed = 120;
        
        // Calling method
        myCar.drive();
    }
}
