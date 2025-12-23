import java.util.concurrent.locks.ReentrantLock;
// Shared resource class
class Counter {
    int count = 0;

    // Creating a ReentrantLock object
    ReentrantLock lock = new ReentrantLock();

    // Method to increment count safely
    void increment() {
        lock.lock();   // Acquire the lock
        try {
            count++;   // Critical section
        } finally {
            lock.unlock(); // Release the lock (mandatory)
        }
    }
}

// Thread class
class MyThread extends Thread {
    Counter counter;

    MyThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

// Main class
public class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        // Creating two threads that share the same Counter object
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        // Start threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Final output
        System.out.println("Final Count: " + counter.count);
    }
}
