import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
		private static int n;
		private static int m;
		private static int k;
		private static int x;
		private static ArrayList<Integer>[] list;
		private static ArrayList<Integer> result;
		private static int[] distance;
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
    // 거리 정보 저장
		distance = new int[n + 1];
		Arrays.fill(distance, -1);
		distance[x] = 0;
		
		list = new ArrayList[n + 1];
		result = new ArrayList<>();
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b); // a -> b
		}
		
		bfs();
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		
		while(!queue.isEmpty()) {
			int data = queue.poll();
			
      // data 노드로부터 갈 수 있는 노드를 모두 탐색
			for(int i : list[data]) {
        // 아직 방문하지 않은 곳이라면
				if(distance[i] == -1) { 
          // 최단 거리를 갱신한다.
					distance[i] = distance[data] + 1;
					queue.offer(i);
				}
			}
			
		}
		
		for(int i = 1; i <= n; i++) {
			if(distance[i] == k) {
				result.add(i);
			}
		}

		if(result.isEmpty())
			System.out.println(-1);
		else {
			Collections.sort(result);
			for(int i = 0; i < result.size(); i++)
				System.out.println(result.get(i));
		}
		
	}
	
}
