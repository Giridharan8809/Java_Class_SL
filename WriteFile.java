import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("data.txt");
            fw.write("Welcome to Java File Handling new line.");
            fw.close();
            System.out.println("Data written successfully");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}
 
