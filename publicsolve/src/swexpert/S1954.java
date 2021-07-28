package swexpert;

import java.util.Scanner;

public class S1954 {
	/*
	 * 배열의 크기를 일부러 더 크게해서 조건문에 이용하는 스킬은
	 * 실제 코딩테스트에서 많이 활용 되는 스킬이었다.
	 * 이 문제에서 역시 일부러 +2칸 넓게 잡아서 
	 * 벽에 부딪힐때마다 방향을 전환시켜 숫자를 넣어주는 식으로 해결한다.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int[] dx = {0, +1, 0, -1};
		int[] dy = {+1, 0, -1, 0};
		int t = scan.nextInt();
		for(int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			int[][] map = new int[n+2][n+2];
			int count = 1;
			int x = 1, y = 1;
			int idx = 0;
			for(int a = 1; a <= n; a++) {
				for(int b = 1; b <= n; b++) {
					map[a][b] = -1;
				}
			}
			
			map[1][1] = 1;
			while(count < n * n) {
				if(map[x + dx[idx]][y + dy[idx]] != -1) {
					idx++;
					if(idx == 4) {
						idx = 0;
					}
					x += dx[idx];
					y += dy[idx];
					map[x][y] = ++count;
				}
				else {
					x += dx[idx];
					y += dy[idx];
					map[x][y] = ++count;					
				}
			}
			
			System.out.println("#" + i);
			
			
			for(int a = 1; a <= n; a++) {
				for(int b = 1; b <= n; b++) {
					System.out.print(map[a][b] + " ");
				}
				System.out.println();
			}
			
		}
	}

}
