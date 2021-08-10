package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1215 {
	static int n;
	static char[][] arr;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new char[8][8];
			count = 0;
			for(int a = 0; a < 8; a++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for(int b = 0; b < 8; b++) {
					arr[a][b] = str.charAt(b);
				}
			}
			
			down();
			right();
			System.out.println("#" + i + " " + count);
		}
	}
	
	public static void down() {
		for(int j = 0; j < 8; j++) {
			outer : for(int i = 0; i + n <= 8; i++) {
				int p1 = i;
				int p2 = i + n - 1;
				while(p1 <= p2) {
					if(arr[p1][j] == arr[p2][j]) {
						p1++;
						p2--;
						continue;
					}
					continue outer;
				}
				count++;
			}
		}
	}
	
	public static void right() {
		for(int i = 0; i < 8; i++) {
			outer : for(int j = 0; j + n <= 8; j++) {
				int p1 = j;
				int p2 = j + n - 1;
				while(p1 <= p2) {
					if(arr[i][p1] == arr[i][p2]) {
						p1++;
						p2--;
						continue;
					}
					continue outer;
				}
				count++;
			}
		}
	}

}
