package baekjoon;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class B1935 {
	/**
	 * 백준 1935 후위 표기식2
	 * 후위 표기식을 계산하는 문제이다.
	 * 피연산자를 스택에 넣고 연산자를 만나면 2개씩 꺼내서 계산 해주고 다시 넣는 과정을 반복하면 된다.
	 * 그런데 A는 0번째 인덱스 피연산자에 매칭되고 B는 1번째 ~~ 를 주의해야 하는 문제다.
	 * HashMap을 이용하여 쌍을 저장해서 해결했다.
	 * putIfAbsent 메소드 활용.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		String str = scan.next();
		
		double[] arr = new double[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextDouble();
		}
		
		scan.close();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c <= 'Z' && c >= 'A') {
				map.putIfAbsent(c, c - 'A');
			}
		}
		
		Stack<Double> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '*' || c == '+' || c == '-' || c == '/') {
				double b = stack.pop();
				double a = stack.pop();
				
				double result = cal(a, b, c);
				stack.push(result);
			}
			else {
				stack.push(arr[map.get(c)]);
			}
		}
		
		System.out.println(String.format("%.2f", stack.pop()));
		
	}
	
	private static double cal(double a, double b, char c) {
		if(c == '+')
			return a + b;
		if(c == '-')
			return a - b;
		if(c == '/')
			return a / b;
		if(c == '*')
			return a * b;
		
		return 0.0;
	}

}
