package code;

import java.util.ArrayList;

public class solve{
	static ArrayList<int[]> list;
	static int[] arr;
	static int[] select;
	static boolean[] visited;
	static int r_value;
	public static void main(String[] args) throws Exception{
		
		arr = new int[4];
		select = new int[2];
		visited = new boolean[4];
		r_value = 2;
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		
		list = new ArrayList<>();
		permutation(0, 2); // 4P2를 구해보자
		
		for(int[] com : list) {
			for(int i : com) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
				
	}
	
	public static void permutation(int start, int r) {
		if(start == r) {
			int[] copy = new int[r];
			copy = select.clone();
			
			list.add(copy);
			
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				select[start] = arr[i]; 
				permutation(start + 1, r);
				visited[i] = false;
			}
		}
	
	}
}
