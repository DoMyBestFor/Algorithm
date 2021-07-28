package code;

import java.util.*;
import java.io.*;

class solve{
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		int t = Integer.parseInt(st.nextToken()); // 테스트 케이스 수
		
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			HashMap<Integer, Integer> map = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int value = Integer.parseInt(st.nextToken());
				map.put(j, value - j);
			}
			
			Iterator<Integer> it = map.keySet().iterator();
			int count = 0;
			while(it.hasNext()) {
				int key = it.next();
				int value = map.get(key); // 고정 비교값
				
				for(int k = 0; k < n; k++) {
					if(key < k) {
						if(map.get(k) == value) {
							count++;
						}
					}
				}
			}
			list.add(count);
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			
		}
		
	}
}
