import java.io.*;
import java.util.*;

class MergeIntervals {
    // Implement your solution by completing the below function
    public int[][] merge(int[][] intervals, int max) {
        int range[] = new int[max+2];
        for(int i = 0; i<intervals.length; i++) {
            range[intervals[i][0]]++;
            range[intervals[i][1] + 1]--;
        }
        for(int i = 1; i < range.length; i++) {
            range[i] += range[i-1];
        }
        int flag = 0, start = 0, end = 0;
        List<Pair<Integer, Integer> > pairList = new ArrayList(); 
        for(int i = 1; i<range.length; i++) {
            if(flag ==0) {
                if(range[i] != 0 && range[i-1] == 0) {
                    start = i;
                    flag = 1;
                }                    
            } else {
                if(range[i] != 0 && range[i+1] == 0) {
                    end = i;
                    flag = 0;
                    pairList.add(new Pair(start, end));
                }
            }

        }
        int[][] result = new int[pairList.size()][2];
        for(int i = 0; i < pairList.size(); i++) {
            result[i][0] = pairList.get(i).getKey();
            result[i][1] = pairList.get(i).getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        int max = -1;
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
            if(max < nums[i][1]) {
                max = nums[i][1];
            }
        }
        scanner.close();

        int[][] results = new MergeIntervals().merge(nums, max);
        for (int i = 0; i < results.length; ++i)
            System.out.println(String.valueOf(results[i][0]) + " " + String.valueOf(results[i][1]));
    }
    
    private class Pair<T, U> {
        private T key;
        private U value;

        Pair(T key, U value) {
            this.key = key;
            this.value = value;
        }

        T getKey() {
            return this.key;
        }

        U getValue() {
            return this.value;
        }
    }
}
