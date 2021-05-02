import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int count = 0;
        
        int[] copy = stones.clone();
        Arrays.sort(copy);
        
        int min = copy[0];
        int max = copy[copy.length - 1];
        
        answer = binary_search(stones, min, max, k);
        
        return answer;
        
    }
    
    public int binary_search(int[] stones, int min, int max, int k){
        int result = 0;
        
        while(min <= max){
        int[] copy = stones.clone();
        int middle = (min + max) / 2;
        
        for(int i = 0; i < copy.length; i++){
            copy[i] = copy[i] - middle;
        }
        
        if(verify(copy, k)){
            // k 이상의 거리가 벌려진다면 숫자를 줄여서 확인해보자.
            result = middle;
            max = middle - 1;
        }
        else{
            // k 이상의 거리가 벌려지지 않는다면 숫자를 늘려서 확인해보자.
            min = middle + 1;
        }
            
        }
        
        return result;
    }
    
    public boolean verify(int[] stones, int k){
        int count = 0;
        int max_count = Integer.MIN_VALUE;
        
        for(int i = 0; i < stones.length; i++){
            if(count >= k){
                return true;
            }
            
            if(stones[i] <= 0){
                count++;
            }
            else{
                max_count = Math.max(max_count, count);
                count = 0;
            }
        }
        
        if(k <= max_count){
            return true;
        }
        
        return false;
    }
}
