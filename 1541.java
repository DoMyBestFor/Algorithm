import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // -를 기준으로 문자열 분리
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
        int result = 999999999;
        
        while(sub.hasMoreTokens()){
            int minus = 0;
            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
            
            while(add.hasMoreTokens()){
                minus += Integer.parseInt(add.nextToken());
            }
            
            if(result == 999999999){
                result = minus;
            }
            else{
                result -= minus;
            }
        }
        System.out.println(result);
        
    }
}
