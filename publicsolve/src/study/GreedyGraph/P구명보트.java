import java.util.*;

class Solution {
    public int solution(int[] peoples, int limit) {
        // 링크드 리스트 sort 성능이 좋지 않음.
        List<Integer> arr = new ArrayList<>();
        
        for(int x : peoples) {
            arr.add(x);
        }
        Collections.sort(arr);

        LinkedList<Integer> list = new LinkedList<>();
        for(int x : arr){
            list.add(x);
        }
        int answer = 0;
        while(!list.isEmpty()) {
            int maxWeight = list.pollLast();
            if(maxWeight <= limit / 2){
                answer += (list.size() + 2) / 2;
                break;
            }
            
            if(!list.isEmpty() && maxWeight + list.peekFirst() <= limit) {
                // 무게 제일 작은애와 제일 큰애를 같이 보낼 수 있으면 우선 보내자
                list.pollFirst(); 
            }
            answer++;
        }

        return answer;
    }
}