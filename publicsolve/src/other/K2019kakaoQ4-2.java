// union-find 풀이

import java.util.*;

class Solution {
    HashMap<Long, Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            long a = room_number[i];
 
            answer[i] = get_parent(a);
        }
        
        return answer;
    
    }
    
    public long get_parent(long a){
        if(!map.containsKey(a)){
            map.put(a, a+1);
            return a;
        }
        map.put(a, get_parent(map.get(a)));
        return map.get(a);
    }
    
    
}
