package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class S1859 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
         
        int t = Integer.parseInt(st.nextToken());
         
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
             
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
             
            long answer = calculate(arr);
            sb.append("#");
            sb.append(i+1 + " ");
            sb.append(answer + "\n");
             
        }
 
        System.out.print(sb.toString());
    }
     
    public static long calculate(int[] arr) {
        long sum = 0;
        // 거꾸로 탐색해 나간다
        // 오름차순 유지 될 때까지는 계속 더해준다.
        // 끊기면 max를 arr[i]로 갱신해서 반복
        int max = arr[arr.length - 1];
        for(int i = arr.length - 2 ; i >= 0; i--) {
            if(max > arr[i]){
                sum += max - arr[i];   
            }
            else{
                max = arr[i];   
            }
        }
         
        return sum;
    }
 
}