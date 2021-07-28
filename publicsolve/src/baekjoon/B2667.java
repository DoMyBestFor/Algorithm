import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int count = 0;
	static int n;
	static boolean DFS(int[][] map, int i, int j) {
		if(i < 0 || i >= n || j < 0 || j >= n)
			return false;
		if(map[i][j] == 1) {
			map[i][j] = 0;
			count++;
			DFS(map, i - 1, j);
			DFS(map, i + 1, j);
			DFS(map, i, j - 1);
			DFS(map, i, j + 1);
			return true;
		}
		return false;
			
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];
		int complex = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		// 1은 집이 있는 곳을 0은 집이 없는 곳을!
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(DFS(map, i, j) == true) {
					complex += 1;
					list.add(count);
					count = 0;
				}
			}
		}
		System.out.println(complex);
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
