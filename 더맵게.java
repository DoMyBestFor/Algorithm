import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for(int food : scoville){
            pq.offer(food);
        }
        
        if(pq.size() == 1){
            return 1;
        }
        
        while(pq.size() >= 2 && pq.peek() < K){
            count++;
            int a = pq.poll();
            int b = pq.poll();
            
            pq.offer(a + (2 * b));
        }
        
        if(pq.size() < 2 && pq.peek() < K){
            return -1;
        }
        
        return count;
    }
}
