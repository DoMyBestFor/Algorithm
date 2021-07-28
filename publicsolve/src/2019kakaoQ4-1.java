// 효율성 미통과

import java.util.*;

class Solution {
    HashMap<Long, Integer> room_state;
    
    public long[] solution(long k, long[] room_number) {
        Queue<HashMap<Integer, Long>> queue = new LinkedList<>();
        long[] result = new long[room_number.length];
        
        for(int i = 0; i < room_number.length; i++){
            HashMap<Integer, Long> map = new HashMap<>();
            map.put(i, room_number[i]); // 사람 번호와 희망 방 번호 저장
            queue.offer(map);
        }
        
        int index = 0;
        room_state = new HashMap<>();
        while(!queue.isEmpty()){
            HashMap<Integer, Long> hm = queue.poll();
            long number = hm.get(index); // 희망 방 번호
            if(!room_state.containsKey(number)){
                room_state.put(number, 1);
                result[index] = number;
                index++;
            }
            else{
                while(room_state.containsKey(number)){
                    number++;
                }
                room_state.put(number, 1);
                result[index] = number;
                index++;
            }
        }
        return result;
    }
    
   
}
