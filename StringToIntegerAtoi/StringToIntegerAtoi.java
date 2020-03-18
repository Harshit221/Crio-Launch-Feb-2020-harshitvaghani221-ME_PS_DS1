import java.io.*;
import java.util.*;

class StringToIntegerAtoi {
    // Implement your solution by completing the below function
    public int myAtoi(String str) {

        return Integer.parseInt(str.trim());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        int result = new StringToIntegerAtoi().myAtoi(str);
        System.out.println(result);
    }
}
