import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int dp[]= new int[31];
        
        dp[1]=1;
        dp[2]=3;
        for(int i = 3; i <= n; i++)
            dp[i] = dp[i-1] + 2 * dp[i-2];
            
            if(n == 1)
                System.out.println(dp[n]);
            else if(n == 2)
                System.out.println(dp[n]);
            else if(n % 2 == 0)
                System.out.println((dp[n] + dp[n / 2] + 2 * dp[n / 2 - 1]) / 2);
            else
                System.out.println((dp[n] + dp[n / 2]) / 2);
        
    }
}
