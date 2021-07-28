import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        int[] answer = new int[2];
        
        for(String opt : operations){
            if(opt.charAt(0) == 'I'){
                if(count == 0){
                    // 모두 지웠다면 큐 내용을 모두 삭제하자.
                    while(!min_heap.isEmpty()){
                        min_heap.poll();
                    }
                    while(!max_heap.isEmpty()){
                        max_heap.poll();
                    }
                }
                String number = opt.split(" ")[1];
                min_heap.offer(Integer.parseInt(number));
                max_heap.offer(Integer.parseInt(number));
                count++;
            }
            else if(opt.equals("D 1")){
                // 최댓값 제거
                if(count == 0)
                    continue;
                
                max_heap.poll();
                count--;
            }
            else if(opt.equals("D -1")){
                // 최솟값 제거
                if(count == 0)
                    continue;
                
                min_heap.poll();
                count--;
            }
        }
        
        if(count == 0)
            return answer;
        
        if(count == 1){
            if(min_heap.isEmpty()){
                answer[0] = max_heap.poll();
                answer[1] = answer[0];
            }
            else{
                answer[0] = min_heap.poll();
                answer[1] = answer[0];
            }
            return answer;
        }
        
        answer[0] = max_heap.poll();
        answer[1] = min_heap.poll();
        return answer;
        
    }
}
