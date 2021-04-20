import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] card = new int[n];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			pq.offer(card[i]);
		}
		
		if(pq.size() == 1) {
			System.out.println(0);
			return;
		}
		
		int sum = 0;
		
		while(pq.size() != 1) {
		int a = pq.poll();
		int b = pq.poll();
		sum += (a + b);
		pq.offer(a + b);
		}
		
		System.out.println(sum);
		
	
	}
	
	
}
