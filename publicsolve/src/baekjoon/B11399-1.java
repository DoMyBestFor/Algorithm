import java.io.*;
import java.util.*;

// 11399번 수학적 식 해결

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(list); // O(nlogn)
        
        int multiplier = list.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += list[i] * multiplier;
            multiplier--;
        }
        
        System.out.println(sum);
    }
}
