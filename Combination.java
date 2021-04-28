package code;

import java.util.ArrayList;

public class solve{
	static ArrayList<int[]> list;
	static int[] arr;
	static int[] select;
	static int r_value;
	public static void main(String[] args) throws Exception{
		
		arr = new int[4];
		select = new int[4];
		r_value = 2;
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		
		list = new ArrayList<>();
		combination(0, 2); // 4C2를 구해보자
		
		for(int[] com : list) {
			for(int i : com) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
				
	}
	
	public static void combination(int start, int r) {
		if(r == 0) {
			ArrayList<Integer> l = new ArrayList<>();
			int[] result = new int[r_value];
			for(int i = 0; i < select.length; i++) {
				if(select[i] == 0)
					continue;
				l.add(select[i]);
			}
			for(int i = 0; i < result.length; i++) {
				result[i] = l.get(i);
			}
			
			list.add(result);
		}
		
		for(int i = start; i < arr.length; i++) {
			select[i] = arr[i]; 
			combination(i + 1, r - 1);
			select[i] = 0;
		}
	
	}
}
