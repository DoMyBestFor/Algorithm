import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = 10000000;
	private static int n;
	private static int e;
	private static int x;
	private static int y;
	private static int result;
	private static int[][] graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		graph = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++)
			Arrays.fill(graph[i], INF);
		for(int i = 1; i <= n; i++)
			graph[i][i] = 0;
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[start][end] = weight;
			graph[end][start] = weight;
		}
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++)
			for(int a = 1; a <= n; a++)
				for(int b = 1; b <= n; b++)
					graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
		
		if(graph[1][x] + graph[x][y] + graph[y][n] >= INF || graph[1][y] + graph[y][x] + graph[x][n] >= INF)
			result = -1;
		else 
            result = Math.min(graph[1][x] + graph[x][y] + graph[y][n], graph[1][y] + graph[y][x] + graph[x][n]);
		
		System.out.println(result);
	}
}
