import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main{
	private static int n, k;
	private static int[] line;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// n 수빈이는 X-1, X+1, 2X로 갈 수 있음
		line = new int[100001];
		line[n] = 1;
		
		bfs();
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		
		int temp;
		while(!queue.isEmpty()) {
			temp = queue.poll();
			if(temp == k) {
				break;
			}
			
			if(temp+1 < 100001 && line[temp+1] == 0) {
				queue.offer(temp+1);
				line[temp+1] = line[temp] + 1;
			}
			if(temp-1 >= 0 && line[temp-1] == 0) {
				queue.offer(temp-1);
				line[temp-1] = line[temp] + 1;
			}
			if(2*temp < 100001 && line[2*temp] == 0) {
				queue.offer(2*temp);
				line[2*temp] = line[temp] + 1;
			}
		}
		System.out.println(line[k] - 1);
	}
	
}
