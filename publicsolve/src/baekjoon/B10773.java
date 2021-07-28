package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B10773 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		
		int k = scan.nextInt();
		for(int i = 0; i < k; i++) {
			int num = scan.nextInt();
			if(num != 0) {
				stack.push(num);
			}
			else {
				stack.pop();
			}
		}
		scan.close();
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);

	}

}
