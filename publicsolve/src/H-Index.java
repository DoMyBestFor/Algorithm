import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int prev = 0;
        for(int i = 1; i < citations[citations.length - 1]; i++){
            int index = 0;
            while(citations[index] < i){
                index++;
            }
            if(citations.length - index >= i){
                prev = i;
                continue;
            }
            break;
        }
        
        return prev;
    }
}
