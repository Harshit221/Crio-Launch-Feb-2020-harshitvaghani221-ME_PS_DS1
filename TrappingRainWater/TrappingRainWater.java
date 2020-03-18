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
        for(int i=a.length-1;i>=0;i--)
            if(a[i]>0)
                return i;
        return -1;
    }
    public int trap(int[] height) {
        int count=0;
        int left,right;
        if(height.length<3)
            return 0;
        while( true ){
            left = start(height);
            if(left == -1)
                break;
            right = end(height);
            for(int i=left;i<right;i++) {
                if(height[i]==0)
                    count++;
                else
                    height[i]--;
               
            
            }
            height[right]--;
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
