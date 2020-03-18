import java.io.*;
import java.util.*;
class TrappingRainWater {

    // complete the below function implementation
    public int start(int[] a) {
        for(int i=0;i<a.length;i++)
            if(a[i]>0)
                return i;
        return -1;
    }
    public int end(int[] a) {
        for(int i=a.length;i>=0;i--)
            if(a[i]>0)
                return i;
        return -1;
    }
    public int trap(int[] height) {
        int count;
        int left=0,right,length;
        while( (left = start(a)) != -1 ){
            right = end(a);
            for(int i=left;i<right;i++) {
                if(a[i]==0)
                    count++;
                else
                    a[i]--;
            }
            

        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int height[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            height[i] = scanner.nextInt();
        }
        scanner.close();
        int result = new TrappingRainWater().trap(height);
        System.out.println(result);
    }
}