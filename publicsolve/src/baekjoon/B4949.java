package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class B4949 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		outer : while(true) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			if(str.equals("."))
				break;
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(' || str.charAt(i) == '[') {
					stack.push(str.charAt(i));
				}
				else if(str.charAt(i) == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						System.out.println("no");
						continue outer;
					}
					else {
						stack.pop();
					}
				}
				else if(str.charAt(i) == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						System.out.println("no");
						continue outer;
					}
					else {
						stack.pop();
					}
				}
			}
			if(stack.isEmpty()) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
			
		}
	}

}
