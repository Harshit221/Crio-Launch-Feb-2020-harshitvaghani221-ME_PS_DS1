import java.io.*;
import java.util.*;

public class ValidParenthesis {
    // Implement your solution by completing the below function
    public boolean isValid(String s) {
      Map<Character, Character> map = new HashMap<>();
      
      map.put('(',')');
      map.put('{','}');
      map.put('[',']');
      int length = s.length();
      if(length%2==1)
        return false;
      for(int i=0;i<length/2;i++) {
        if(map.get(s.charAt(i)) != s.charAt(length-i-1))
          return false;
      }
      return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String parenthesis = in.readLine();
        boolean result = new ValidParenthesis().isValid(parenthesis);
        System.out.print(String.valueOf(result));
    }
}
