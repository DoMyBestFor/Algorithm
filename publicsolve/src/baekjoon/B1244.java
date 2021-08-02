package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
	static int n, student;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 스위치 개수
		arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		student = Integer.parseInt(st.nextToken()); // 학생 수
		
		// 남학생은 1, 여학생은 2
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 성별
			int number = Integer.parseInt(st.nextToken()); // 받은 번호
			
			transform(s, number);
			
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) {
				// 한 줄에 20개만 출력
				System.out.println();
			}
		}
	
	}
	public static void transform(int s, int number) {
		if(s == 1) {
			// 남자라면
			int m = 1;
			while(m * number <= n) {
				// number의 배수 번호에 위치한 애들 스위치 상태를 모두 변경
				arr[m * number] = 1 - arr[m * number];
				m++;
			}
		}
		else if(s == 2) {
			// 여자라면
			int p1;
			int p2;
			
			arr[number] = 1 - arr[number];

			// number가 양 끝 인덱스이면 종료
			if(number == 1) {
				return;
			}
			if(number == n) {
				return;
			}
			
			p1 = number - 1;
			p2 = number + 1;
			while(p1 >= 1 && p2 <= n && arr[p1] == arr[p2]) {
				// 인덱스 안 벗어나고 양 대칭 값이 같을때까지 계속 투포인터로 탐색
				arr[p1] = 1 - arr[p1];
				arr[p2] = 1 - arr[p2];
				p1--;
				p2++;
			}
			
		}
	}
}
