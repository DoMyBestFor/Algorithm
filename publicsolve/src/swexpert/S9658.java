package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class S9658 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			int len = num.length() - 1;
			num = num.substring(0, 3);
			double n = Math.round(Integer.parseInt(num) / 100.0);
			if((int) n == 10) {
				n /= 10;
				len++;
			}
			System.out.printf("#%d %.1f*10^%d\n", i, n, len);
			
		}
		
	}
//	 for(int t = 1; t <= T; t++) {
//         String n = br.readLine();
//          
//         int s = n.length() - 1;
//          
//         String sub = n.substring(0, 3);
//          
//         double r = Math.round(Integer.parseInt(sub) / 10.0);
//          
//         if(r == 100.0) {
//             r /= 10;
//             s++;
//         }
//         System.out.printf("#%d %.1f*10^%d\n", t, r / 10, s);
//     }
}
