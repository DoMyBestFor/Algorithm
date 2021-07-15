import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int t; // 테스트 케이스 개수
	private static int v, e; // 각 테스트 케이스의 정점과 간선 개수
	
	private static ArrayList<Integer>[] list;
	private static int[] verify;
	
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		t = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		while(t > 0) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			list = new ArrayList[v+1];
			for(int i = 1; i <= v; i++) {
				list[i] = new ArrayList<>();
			}
			verify = new int[v+1];
			
			
			for(int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				list[b].add(a);
			}
			bfs();
			
			t--;
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= v; i++) {
			if(verify[i] == 0) {
				// 방문 안했으면
				queue.offer(i);
				verify[i] = 1;
			}
			
			while(!queue.isEmpty()) {
				int ver = queue.poll();
				
				for(int j : list[ver]) {
					if(verify[j] == verify[ver]) {
						// 연결되어 있는데 색깔이 같으면
						sb.append("NO\n");
						return;
					}
					// i 노드와 연결된 애들은 다른 색을 칠해줘야 겠다.
					if(verify[j] == 0 && verify[ver] == 1) {
						verify[j] = 2;
						queue.offer(j);
					}
					else if(verify[j] == 0 && verify[ver] == 2) {
						verify[j] = 1;
						queue.offer(j);
					}
				}
			}
		}
		sb.append("YES\n");
	}

	

}
