// 프로그래머스에서 실행 가능

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int j;
        StringBuilder sb;
        // i + 1 단위 부터 자르기 확인
        for(int i = 0; i < s.length() / 2; i++){
            sb = new StringBuilder();
            String prev = s.substring(0, i+1);
            int count = 1;
            for(j = i + 1; j+i+1 <= s.length(); j += i + 1){
                if(prev.equals(s.substring(j, j+i+1))){
                    count++;
                }
                else{
                    if(count > 1){
                        sb.append(count);
                        sb.append(prev);
                    }
                    else{
                        sb.append(prev);
                    }
                    prev = s.substring(j, j+i+1);
                    count = 1;
                }
            }
            
        
            if(count > 1){
                sb.append(count);
                sb.append(prev);
            }
            else{
                sb.append(prev);
            }
            
            if(j != s.length()){
                sb.append(s.substring(j, s.length()));
            }
            
            //System.out.println(sb.toString());
            answer = Math.min(answer, sb.toString().length());
        } 
        return answer;
    }
}
