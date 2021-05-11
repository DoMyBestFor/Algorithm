
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static String[] strs;
	static boolean[] visited;
	static ArrayList<String> result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		result = new ArrayList<>();
		strs = new String[C];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < C; i++) {
			strs[i] = st.nextToken();
		}
		
		dfs(0, C, L);
		Collections.sort(result);
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	static public boolean verify(String str) {
		int ja = 0;
		int mo = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
				mo++;
			}
			else {
				ja++;
			}
		}
		
		if(mo >= 1 && ja >= 2) {
			return true;
		}
		return false;
	}
	
	static public void dfs(int start, int C, int L) {
		if(L == 0) {
			ArrayList<String> res = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					res.add(strs[i]);
				}
			}
			Collections.sort(res);
			
			for(int i = 0; i < res.size(); i++) {
				sb.append(res.get(i));
			}
			String str = sb.toString();
			if(verify(str)) {
				result.add(str);
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
				visited[i] = true;
				dfs(i + 1, C, L - 1);
				visited[i] = false;
		}
	}
}
