import java.io.*;
import java.util.*;

class SpiralMatrix {
    // Implement your solution by completing the below function
    public List<Integer> spiral(int[][] matrix, int n, int s) {
        List<Integer> lst = new ArrayList<>();
        for(int i=s;i<n;i++)
            list.add([s][i]);
        for(int i=s+1;i<n;i++)
            list.add(a[i][n-1]);
        for(int i=n-2;i>=s;i--)
            list.add(a[n-1][i]);
        for(int i=n-2;i>s;i--)
            list.add(a[i][s]);
        return lst;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<Integer>();
        int n = Math.min(matrix.length, matrix[0].length);
        int lc=(n/2.0 == n/2)?0:1;
        lc += n/2;
        for(int i=0;i<lc;i++) {
            lst.addAll(spiral(matrix,n-i,i));
        }
        return lst;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                matrix[i][j] = scanner.nextInt();
        scanner.close();

        List<Integer> result = new SpiralMatrix().spiralOrder(matrix);
        for (int i = 0; i < result.size(); ++i)
            System.out.printf("%d ", result.get(i));
    }
}
