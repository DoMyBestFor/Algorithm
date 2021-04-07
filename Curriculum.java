package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class solve {
	private static int v;
	private static int[] indegree;
	private static int[] time;
	private static int[] result;
	private static ArrayList<Integer>[] graph;
	
	private static void topologySort() {
		Queue<Integer> queue = new LinkedList<>();
		result = time.clone();
		
		// 진입차수가 0인 노드를 모두 넣음
		for(int i = 1; i <= v; i++) {
			if(indegree[i] == 0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int elm = queue.poll(); // 큐에서 하나를 빼냄
			for(int i : graph[elm]) { // 그 빼낸 것이 선수 과목인 것들을 하나하나 살펴봄
				// 현재 result[i] 값과 선수과목을 들은 후 time[i] 값을 더한 것중 더 큰 것을 선택
				result[i] = Math.max(result[i], result[elm] + time[i]);
				indegree[i]--;
				if(indegree[i] == 0)
					queue.offer(i);
			}
		}
		
		for(int i = 1; i <= v; i++)
			System.out.println(result[i]);
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		v = scan.nextInt();
		indegree = new int[v + 1];
		time = new int[v + 1];
		graph = new ArrayList[v + 1];
		for(int i = 1; i <= v; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 1; i <= v; i++) {
			int weight = scan.nextInt();
			time[i] = weight; // 해당 노드 인강만을 수강하는데 걸린 시간
		    while(true) {
		    	int preq = scan.nextInt(); // 선수 과목 노드
		    	if(preq == - 1)
		    		break;
		    	graph[preq].add(i); // preq -> i의 과목 관계
		    	indegree[i]++; // i의 진입차수는 1 증가
		    }
		}
		
		topologySort();
		
	}
}
