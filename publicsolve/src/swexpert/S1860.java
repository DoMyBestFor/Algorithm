package swexpert;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1860 {
	// n 명의 사람이 붕어빵 먹을 자격을 얻었습니다.
	// 0초부터 만들기 시작해서 M초의 시간을 들이면 K개의 붕어빵을 만들 수 있다.
	// 손님들이 언제 도착하는지 주어지면 모든 손님들이 기다리는 시간 없이 붕어빵을 제공할 수 있는지 판별
	static int n, m, k;
	static int[] arrive;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			arrive = new int[n];
			for(int i = 0; i < n; i++) {
				arrive[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arrive);
			
			System.out.print("#" + tc + " ");
			if(solve()) {
				System.out.println("Possible");
			}
			else {
				System.out.println("Impossible");
			}
			
		}
	}
	
	public static boolean solve() {
		int now = 0; // 붕어빵 만들어진 수
		int yet = 0; // 받아간 사람의 수
		
		for(int i : arrive) {
			// 지금 만들어진 붕어빵 수
			now = (i / m) * k;
			if(now - yet <= 0) 
				return false;
			yet += 1; // 받아간 사람 수 count
		}
		return true;
	}

}