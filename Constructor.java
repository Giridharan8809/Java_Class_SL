class Student {

    String name;
    int age;

    // Constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println(name + " is " + age + " years old");
    }
}

public class Constructor {
    public static void main(String[] args) {
        
        Student s1 = new Student("Giri", 18); // constructor call
        s1.display();
        System.out.println(s1.name);
    }
}
