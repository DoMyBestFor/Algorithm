import java.util.*;
import java.io.*;

class Main{
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        System.out.println(min);
    }
    
    public static void dfs(int start, int count){
        if(count == N/2){
            // 차를 계산해서 min 값 업데이트
        	
        	
            min = Math.min(min, minus());
            return;
        }
        
        for(int i = start; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
        
    }
    
    public static int minus(){
        int[] start = new int[N / 2];
        int[] link = new int[N / 2];
        int index_start = 0;
        int index_link = 0;
        int sum_start = 0;
        int sum_link = 0;
        
        for(int i = 0; i < visited.length; i++){
            if(visited[i]){
                start[index_start++] = i;
            }
            else{
                link[index_link++] = i;
            }
        }
        for(int i = 0; i < start.length-1; i++){
            for(int j = i + 1; j < start.length; j++){
                sum_start += arr[start[i]][start[j]];
                sum_start += arr[start[j]][start[i]];
            }
        }
        for(int i = 0; i < link.length-1; i++){
            for(int j = i + 1; j < link.length; j++){
                sum_link += arr[link[i]][link[j]];
                sum_link += arr[link[j]][link[i]];
            }
        }
        
        return Math.abs(sum_start - sum_link);
        
    }
}
