import java.io.*;
import java.util.*;

class MatrixTraversal  {

  // complete the below function implementation
  public List<Integer> valueAtNewPosition(int[][] matrix, int currX, int currY, int dir, int steps) {
    
    try {
      List<Integer> lst = new ArrayList<Integer>();
      if(dir == 1) {
        int count = 0;
        for(int i = currY+1; count < dir; count++)
          lst.add(matrix[currX][i++]);
      } else if(dir == 2) {
        for(int i = currX+1; count < dir; count++)
          lst.add(matrix[i++][currY]);
  
      } else if (dir == 3) {
        for(int i = currY-1; count < dir; count++)
          lst.add(matrix[currX][i--]);
  
      } else if (dir == 4) {
        for(int i = currX-1; count < dir; count++)
          lst.add(matrix[i--][currY]);
      }
      return lst;
    } catch(ArrayIndexOutOfBoundsException e) {
      List<Integer> lst = new ArrayList<Integer>();
      lst.add(-1);
      return lst;

    }
  }
    

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] matrix = new int[n][m];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    int currPosX = scanner.nextInt();
    int currPosY = scanner.nextInt();
    int dirToMove = scanner.nextInt();
    int stepsToMove = scanner.nextInt();

    scanner.close();
     List<Integer> result = new MatrixTraversal().valueAtNewPosition(matrix, currPosX, currPosY, dirToMove, stepsToMove);

    for (int i = 0; i < result.size(); ++i) {
      System.out.printf("%d ", result.get(i));
    }
  }
}

