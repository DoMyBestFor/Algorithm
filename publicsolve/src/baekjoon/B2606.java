import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main{
	static int n;
	static int l;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		System.out.println(bfs() - 1);
		
	}
	
	static int bfs() {
		int count = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			
			if(!visited[q]) {
				visited[q] = true;
				count++;
				for(int g : graph[q]) {
					queue.offer(g);
				}
			}
		}
		return count;
	}
}
