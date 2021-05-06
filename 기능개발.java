import java.util.*;
class Solution {
    class Pair{
        int progress;
        int index;
        public Pair(int progress, int index){
            this.progress = progress;
            this.index = index;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer;
        for(int i = 0; i < progresses.length; i++){
            queue.offer(new Pair(progresses[i], i));
        }
        
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n; i++){
                Pair pair = queue.poll();
                queue.offer(new Pair(pair.progress + speeds[pair.index], pair.index));
            }
            
            if(queue.peek().progress >= 100){
                int count = 0;
                while(!queue.isEmpty() && queue.peek().progress >= 100){
                    count++;
                    queue.poll();
                }
                list.add(count);
            }
        }
        
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
