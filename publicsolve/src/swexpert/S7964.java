package swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S7964 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int cnt, answer, N, D;
	static int[] capital;
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			cnt =0; answer =0;
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			capital = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i< N; i++) {
				capital[i] = Integer.parseInt(st.nextToken());
			}
			
            // 처음 문과 끝 문이 0 이면 무조건 1로 바꿔주고 answer 1 UP
			if(capital[0] == 0) {
				answer++;
				capital[0] =1;
			}
			if(capital[N-1] == 0) {
				answer++;
				capital[N-1] =1;
			}
			
			for(int i=0; i< N; i++) {
				if(capital[i] == 1) { // 관문이 있으면
					cnt =0; // 현재 이동 거리 제한 0 으로 만들기
				} else {
					cnt++;
					if(cnt >= D) { // 이동 거리 제한에 걸리면 
						answer++; // 관문을 재건하고 
						cnt =0; // 현재 이동 거리 제한 0으로 만들기 
					}
				}
			}
			bw.append("#"+t+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
	}
}