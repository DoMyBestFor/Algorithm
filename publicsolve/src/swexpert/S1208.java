package swexpert;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class S1208 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		for(int i = 1; i <= 10; i++) {
			int n = scan.nextInt(); // 덤프 횟수
			PriorityQueue<Integer> q1 = new PriorityQueue<>(); // 최소 힙
			PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
			for(int j = 0; j < 100; j++) {
				int e = scan.nextInt();
				q1.offer(e);
				q2.offer(e);
			}
			
			for(int j = 0; j < n; j++) {
				q2.offer(q2.poll() - 1);
				q1.offer(q1.poll() + 1);
			}
			
			System.out.print("#" + i + " ");
			System.out.println(q2.poll() - q1.poll());
		}
		
	}

}
