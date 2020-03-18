import java.io.*;
import java.util.*;

class MessagePassing {

  // Complete the below function implementation
  // Print "Yes" for success and "No" for Failure
  
  int spiral(int n,int s, int[][] a) {
    int x = s,y = s;
    
    for(int i=s+1;i<n;i++) {
      if(a[x][y] > 0) {
        a[s][i] = Math.max(a[x][y] - 1, a[s][i]);
        x = s;
        y = i;
      }
      else
        return -1;
    }
      
    for(int i=s+1;i<n;i++) {
      if(a[x][y] > 0) {
        a[i][n-1] = Math.max(a[x][y] - 1, a[i][n-1]);
        x = s;
        y = i;
      }
      else
        return -1;
    }
    for(int i=n-2;i>=s;i--) {
      if(a[x][y] > 0) {
        a[n-1][i] = Math.max(a[x][y] - 1, a[n-1][i]);
        x = s;
        y = i;
      }
      else
        return -1;
      
    }
    for(int i=n-2;i>s;i--) {
      if(a[x][y] > 0) {
        a[i][s] = Math.max(a[x][y] - 1, a[i][s]);
        x = s;
        y = i;
      }
      else
        return -1;
      
    }
      

    return 1;
  }

  public void messagePassTest(int s, int o, int[][] matrix) {
    int n = matrix.length;
    int lc=(n/2.0 == n/2)?0:1;
    lc += n/2;
    int flag = 1;
    for(int i=0;i<lc && flag==1;i++) {
      flag = spiral(n-i,i, matrix);
    }
    if(flag == 0)
      System.out.println("Yes");
    else
      System.out.println("No");
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int s = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] matrix = new int[n][n];
    matrix[0][0] = s;
    for (int i = 0; i < m; ++i) {
      int x, y, p;
      x = scanner.nextInt();
      y = scanner.nextInt();
      p = scanner.nextInt();
      matrix[x][y] = Math.max(p, matrix[x][y]);
    }
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(matrix[i][j] > 0)
          matrix[i][j]++;
        else
          matrix[i][j] = -1;
      }
    }
    scanner.close();
    
    new MessagePassing().messagePassTest(s, m, matrix);
  }
}
