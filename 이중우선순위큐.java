import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        LinkedList<Integer> dq = new LinkedList<>();
        int[] answer = new int[2];

        for(String opt : operations){
            if(opt.charAt(0) == 'I'){
                String number = opt.split(" ")[1];
                dq.offer(Integer.parseInt(number));
                Collections.sort(dq);
            }
            else if(opt.equals("D 1")){
                // 최댓값 삭제
                if(dq.isEmpty()){
                    continue;
                }
                dq.removeLast();
            }
            else if(opt.equals("D -1")){
                // 최솟값 삭제
                if(dq.isEmpty()){
                    continue;
                }
                dq.removeFirst();
            }
        }

        if(dq.isEmpty()){
            return answer;
        }

        if(dq.size() == 1){
            answer[0] = dq.poll();
            answer[1] = answer[0];
            return answer;
        }

        answer[0] = dq.removeLast();
        answer[1] = dq.removeFirst();

        return answer;

    }
}
