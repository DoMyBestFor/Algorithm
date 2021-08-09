package other;

import java.util.*;

class Pair{
    int idx;
    int prior;
    Pair(int idx, int prior){
        this.idx = idx;
        this.prior = prior;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new Pair(i, priorities[i]));
        }
        
        int count = 1;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            
            boolean flag = false;
            for(Pair p : queue){
                if(pair.prior < p.prior){
                    // 우선순위 더 큰게 있다
                    flag = true;
                    break;
                }
            }
            if(flag){
                queue.offer(pair);
            }
            else{
                // 아니면 그냥 인쇄를 할 것인데 찾는거랑 일치하는지 비교
                if(pair.idx == location){
                    return count;
                }
                else{
                    // 일치안하면 인쇄 카운트만 증가
                    count++;
                }
            }
            
        }
        return 0;
        
    }
}
