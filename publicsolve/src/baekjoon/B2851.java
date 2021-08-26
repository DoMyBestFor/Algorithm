package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2851 {
	/**
	 * 10개의 버섯이 일렬로 놓아져 있다.
	 * 점수 합을 최대한 100에 가깝게 하려고 한다.
	 * 순차적으로 버섯을 먹을 수 있다가 끊을 수 있다.
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < 10; i++) {
			queue.offer(scan.nextInt());
		}
		
		int min = Integer.MAX_VALUE;
		
		int sum = 0;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			sum += temp;
			if(Math.abs(100 - sum) <= min) {
				min = Math.abs(100 - sum);
			}
			else {
				sum -= temp;
				break;
			}
		}
		
		System.out.println(sum);
	}

}
