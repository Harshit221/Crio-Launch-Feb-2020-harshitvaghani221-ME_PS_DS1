import java.io.*;
import java.util.*;

class MessagePassing {

  // Complete the below function implementation
  // Print "Yes" for success and "No" for Failure

  public List<Integer> spiralOrder(int[][] a) {
    int i, k = 0, l = 0, m = a.length, n = a[0].length;
    List<Integer> list = new ArrayList<>();
    while (k < m && l < n) {
      for (i = l; i < n; ++i) {
        list.add(a[k][i]);
      }
      k++;
      for (i = k; i < m; ++i) {
        list.add(a[i][n - 1]);
      }
      n--;
      if (k < m) {
        for (i = n - 1; i >= l; --i) {
          list.add(a[m - 1][i]);
        }
        m--;
      }
      if (l < n) {
        for (i = m - 1; i >= k; --i) {
          list.add(a[i][l]);
        }
        l++;
      }
    }
    return list;
  }

  public void messagePassTest(int s, int o, int[][] matrix) {

    if(n == 1 && s >= 1) {
      System.out.println("Yes");
      return;
    }
    if(s == 0) {
      System.out.println("No");
      return;
    }
    int flag = 0;
    List<Integer> list = spiralOrder(matrix);
    for(int i = 1;i<list.size();i++) {
      list.set(i, Math.max(list.get(i-1)-1, list.get(i)));     
    }

    if (list.get(list.size()-1) >= 0)
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
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] > 0)
          matrix[i][j]++;
        else
          matrix[i][j] = -1;
      }
    }
    scanner.close();

    new MessagePassing().messagePassTest(s, m, matrix);
  }
}
