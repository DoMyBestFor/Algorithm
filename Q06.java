
// 프로그래머스 문제이기 때문에 프로그래머스에서 작성해야 동작하는 코드입니다.

import java.util.*;

class Solution {
    class Food implements Comparable<Food>{
        int time; // 다 먹는데 걸리는 시간
        int num; // 음식 번호
        // 생성자
        public Food(int time, int num){
            this.time = time;
            this.num = num;
        }
        // 우선순위 큐에 시간을 기준으로 한 최소 힙 구성
        public int compareTo(Food a) {
        	return Integer.compare(this.time, a.time);
        }
    }
    
    public int solution(int[] food_times, long k) {
    	PriorityQueue<Food> queue = new PriorityQueue<>();
        ArrayList<Food> list = new ArrayList<>();
        for(int i = 0; i < food_times.length; i++){
            queue.offer(new Food(food_times[i], i + 1));
        }
        
        // long 형으로 하는 것 주의
        int remainder = food_times.length; // 남은 음식 개수
        long sum_time = 0; // 해당 과정까지 총 걸린 시간
        long previous = 0; // 현재 단계 이전까지 걸린 시간
        int now;
        
        long sum = 0;
        for(int i = 0; i < food_times.length; i++)
            sum += food_times[i];
        // 모든 음식을 다 먹게 될 경우
        if(sum <= k)
            return -1;
        
        // 먹는데 가장 짧은 시간이 걸리는 것부터 확인해서 k 시간 안에 다 먹는지 계산 해 나감.
        // 지금까지 걸린 시간 + (현재 탐색하는 음식 다 먹는데 걸리는 시간 - 이전 음식 먹는데 걸린 시간) * 남은 덜 먹은 음식 개수 <= k
        while(sum_time + ((queue.peek().time - previous) * remainder) <= k){
        	now = queue.poll().time;
            sum_time += (now - previous) * remainder;
            remainder -= 1;
            previous = now;
        }
        
        // 남은 거 다 리스트에 추가
        // 자바는 우선순위 큐 정렬 순서 Collections의 메서드로 변경 불가
        while(!queue.isEmpty()) {
        	list.add(queue.poll());
        }
        
        Comparator<Food> num_standard = new Comparator<Food>(){
            @Override
            public int compare(Food a, Food b){
                return Integer.compare(a.num, b.num);
            }
        };
        // 음식 번호로 오름차순 정렬
        Collections.sort(list, num_standard);
       
        return list.get((int) ((k - sum_time) % remainder)).num;
    }
}
