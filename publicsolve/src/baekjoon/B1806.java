import java.util.*;
import java.io.*;

public class Main{
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(slide());
    }
    
    static int slide(){
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while(start < N){
            if(sum >= S || end == N){
                sum -= arr[start++];
            }
            else{
                sum += arr[end++];
            }
            if(sum >= S){
                min = Math.min(min, end - start);
            }
            
        }
        
        if(min == Integer.MAX_VALUE){
            min = 0;
        }
        return min;
    }
}
