import java.util.*;
import java.io.*;

public class Main{
    static void binary_search(int[] arr, int target, int start, int end){
        if(start > end){
            System.out.println("0");
            return;
        }
            
        int middle = (start + end) / 2;
        
        if(arr[middle] == target)
            System.out.println("1");
        else if(arr[middle] < target){
            binary_search(arr, target, middle + 1, end);
        }
        else{
            binary_search(arr, target, start, middle - 1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int x = Integer.parseInt(st.nextToken());
            binary_search(arr, x, 0, n - 1);
        }
    }
}
