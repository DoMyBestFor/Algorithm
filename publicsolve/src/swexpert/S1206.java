package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class S1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 4];
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 2; i < N + 2; i++)
                arr[i] = Integer.parseInt(st.nextToken());
 
            int sum = 0;
 
            for (int i = 2; i < N; i++) {
 
                int max = 0;
                // 테크닉
                // 왼쪽 두 칸과 오른쪽 두칸을 살펴서 가장 큰 높이를 구함
                for (int j = i - 2; j < i + 3; j++) {
                    if (i == j) continue;
 
                    max = Math.max(max, arr[j]);
                }
 
                // 가장 큰 높이가 arr[i]보다 작다면 그 차이만큼 개수를 더함
                if (arr[i] > max) sum += arr[i] - max;
 
            }
 
            sb.append("#" + t + " " + sum + "\n");
        }
 
        System.out.println(sb);
    }
}