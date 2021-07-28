import java.io.*;
import java.util.*;

// 다른 방식 해결

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
        
        int sum = 0;
        int prev = 0;
        for(int i = 0; i < n; i++){
            sum += prev + list[i]; // 1, 1 + 1+2, 1 + 1+2 + 1+2+3 등 총 시간을 저장
            prev += list[i]; // 1, 1+2, 1+2+3 등 각 원소별 대기 시간을 저장
        }
        
        System.out.println(sum);
    }
}
