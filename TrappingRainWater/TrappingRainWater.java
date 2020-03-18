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
    public int trap(int[] arr) {
        int n = arr.length;
        int res = 0; 
      
        // For every element of the array 
        for (int i = 1; i < n-1; i++) { 
              
            // Find the maximum element on its left 
            int left = arr[i]; 
            for (int j=0; j<i; j++) 
               left = max(left, arr[j]); 
              
            // Find the maximum element on its right    
            int right = arr[i]; 
            for (int j=i+1; j<n; j++) 
               right = max(right, arr[j]);  
             
           // Update the maximum water     
           res = res + (min(left, right) - arr[i]);    
        } 
      
        return res;  
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
