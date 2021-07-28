import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int infinity = 10000000;
	static int v;
	static int e;
	static int[][] graph;
	
	public static void floydWarshall() {
		for(int i = 1; i <= v; i++) { // 거쳐 가는 노드
			for(int j = 1; j <= v; j++) { // 출발 노드
				for(int k = 1; k <= v; k++) { // 도착 노드
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken()); // 도시의 개수 즉, 노드의 개수
		st = new StringTokenizer(br.readLine());
		
		e = Integer.parseInt(st.nextToken()); // 버스의 개수 즉, 간선의 개수
		graph = new int[v+1][v+1];
		for(int i = 1; i <= v; i++)
			Arrays.fill(graph[i], infinity);
		for(int i = 1; i <= v; i++)
			graph[i][i] = 0;
		
		for(int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[x][y] = Math.min(graph[x][y], weight); // 한 노드에서 다른 노드로 가는 경우의 수가 하나가 아닐 수도 있기 때문
		}
		
		floydWarshall();
		
		for(int i = 1; i <= v; i++) {
			for(int j = 1; j <= v; j++) {
				if(graph[i][j] == infinity)
					System.out.print(0 + " ");
				else
					System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
