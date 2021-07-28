package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2007 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			for(int j = 1; j <= str.length(); j++) {
				String a = str.substring(0, j); // 0 ~ i-1
				String b = str.substring(j, j+j); // i ~ i + i -1
				if(a.equals(b)) {
					sb.append("#" + i + " " + j + "\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
