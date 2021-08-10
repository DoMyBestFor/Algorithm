package other;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
        	// 진도율과 인덱스를 같이 저장
            queue.offer(new int[] {progresses[i], i});
        }
        while(!queue.isEmpty()){
            int count = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] tp = queue.poll();
                queue.offer(new int[] {tp[0] + speeds[tp[1]], tp[1]});
            }
            while(!queue.isEmpty() && queue.peek()[0] >= 100){
                count++;
                queue.poll();
            }
            if(count != 0){
                answer.add(count);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }        
        return result;
        
        
        
    }
}