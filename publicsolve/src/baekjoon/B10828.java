/*package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Stack{
	int tp;
	List<Integer> list;
	
	Stack(){
		tp = -1;
		list = new ArrayList<>();
	}
	
	public void push(int e) {
		tp++;
		list.add(e);
	}
	
	public int pop() {
		if(tp == -1) {
			return -1;
		}
		int res = list.get(tp);
		list.remove(tp);
		tp--;
		return res;
	}
	
	public int size() {
		return list.size();
	}
	
	public int empty() {
		if(tp == -1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int top() {
		if(tp == -1) {
			return -1;
		}
		else {
			return (int)list.get(tp);
		}
	}
}

public class B10828 {

	static Stack stack = new Stack();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String cmd = br.readLine();
			command(cmd);
		}
	}
	
	public static void command(String cmd) {
		if(cmd.startsWith("push")) {
			int data = Integer.parseInt(cmd.split(" ")[1]);
			stack.push(data);
		}
		else if(cmd.equals("top")) {
			System.out.println(stack.top());
		}
		else if(cmd.equals("size")) {
			System.out.println(stack.size());
		}
		else if(cmd.equals("empty")) {
			System.out.println(stack.empty());
		}
		else if(cmd.equals("pop")) {
			System.out.println(stack.pop());
		}
	}

}
*/