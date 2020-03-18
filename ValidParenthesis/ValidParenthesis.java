import java.io.*;
import java.util.*;

public class ValidParenthesis {
    // Implement your solution by completing the below function
    public boolean isOpening(char c) {
      if(c == '(' || c == '{' || c == '[')
        return true;
      else
        return false;
      
    }
    public boolean isValid(String s) {
      Map<Character, Character> map = new HashMap<>();
      
      map.put('(',')');
      map.put('{','}');
      map.put('[',']');
      Stack<Character> stack = new Stack<>();
      int length = s.length();
      if(length%2==1)
        return false;
      for(int i=0;i<length;i++) {
        char c = s.charAt(i);
        if(isOpening(c)){
          stack.push(map.get(c));
        } else {
          if(stack.pop() != c)
            return false;            
        }
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
