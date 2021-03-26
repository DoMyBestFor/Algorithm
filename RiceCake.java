import java.util.*;
import java.io.*;

public class HelloWorld{

    static int binary_search(int[] arr, int target, int start, int end){
        int result;
        
        while(start <= end){
            int total = 0;
            int mid = (start + end) / 2;
            
            for(int num : arr){
                if(num - mid > 0)
                    total = total + (num - mid);
            }
            
            if(total < target){
                end = mid - 1;
            }
            else{
                result = mid;
                start = mid + 1;
            }
        }
        
        return result;
        
    }


     public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        int max;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        max = arr[n - 1];
        
        System.out.println(binary_search(arr, m, 0, max));
        
        
     }
}
