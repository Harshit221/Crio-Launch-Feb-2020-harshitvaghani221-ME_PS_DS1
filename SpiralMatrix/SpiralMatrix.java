import java.io.*;
import java.util.*;

class SpiralMatrix {
    // Implement your solution by completing the below function
    public List<Integer> spiral(int[][] matrix, int s) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length - s;
        int m = matrix[0].length - s;
        for(int i=s;i<m;i++)
            list.add(matrix[s][i]);
        for(int i=s+1;i<n;i++)
            list.add(matrix[i][n-1]);
        for(int i=m-2;i>=s;i--)
            list.add(matrix[n-1][i]);
        for(int i=n-2;i>s;i--)
            list.add(matrix[i][s]);
        return list;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<Integer>();
        int n = Math.min(matrix.length, matrix[0].length);
        int lc=(n/2.0 == n/2)?0:1;
        lc += n/2;
        
        for(int s=0;s<lc;s++) {
            lst.addAll(spiral(matrix,s));
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
