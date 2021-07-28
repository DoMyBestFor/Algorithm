import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static void DFS(LinkedList<Integer>[] lists, int init_node, boolean[] visited) {
		visited[init_node] = true;
		System.out.print(init_node + " ");
			for(int node : lists[init_node]) {
				if(visited[node] != true) {
					DFS(lists, node, visited);
				}
			}
		
	}
	static void BFS(LinkedList<Integer>[] lists, int init_node, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		visited[init_node] = true;
		queue.offer(init_node);
		while(queue.size() != 0) {
			System.out.print(queue.peek() + " ");
			for(int node : lists[queue.poll()]) {
				if(visited[node] != true) {
				visited[node] = true;
				queue.offer(node);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v_count = Integer.parseInt(st.nextToken());
		int l_count = Integer.parseInt(st.nextToken());
		int init_node = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[v_count + 1];
		int start, end;
		
		LinkedList<Integer>[] lists = new LinkedList[v_count + 1];
		for(int i = 0; i <= v_count; i++) {
			lists[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < l_count; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
	        end = Integer.parseInt(st.nextToken());
	        lists[start].add(end);
	        lists[end].add(start);
		}
		
		for(int i = 1; i <= v_count; i++) {
			Collections.sort(lists[i]);
		}
		
		DFS(lists, init_node, visited);
		System.out.println();
		Arrays.fill(visited, false);
		BFS(lists, init_node, visited);
		
	}
}
