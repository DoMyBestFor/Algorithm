import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int MAX = Integer.MIN_VALUE;
	private static int MIN = Integer.MAX_VALUE;
	private static int[] list;
	private static int[] operator;
	
	
	// 완전 탐색이고 하나의 경우를 끝까지 본 후 다음 경우를 봐야하니까 dfs
	static void dfs(int idx, int sum) {
		if(idx == n) {
			MAX = Math.max(MAX, sum);
			MIN = Math.min(MIN, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				
				switch(i) {
				 case 0:
					 dfs(idx + 1, sum + list[idx]);
					 break;
				 case 1:
					 dfs(idx + 1, sum - list[idx]);
					 break;
				 case 2:
					 dfs(idx + 1, sum * list[idx]);
					 break;
				 case 3:
					 dfs(idx + 1, sum / list[idx]);
					 break;
				}
				
				operator[i]++;
			}
			
			
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		list = new int[n];
		// 0 - 덧셈 개수, 1 - 뺄셈 개수, 2 - 곱셈 개수, 3 - 나눗셈 개수
		operator = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			list[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());
		
		dfs(1, list[0]);
		System.out.println(MAX);
		System.out.println(MIN);
		
	}
}
