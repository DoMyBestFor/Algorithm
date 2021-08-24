package study.GreedyGraph;
import java.util.HashMap;
import java.util.Map;

class Solution {
	/**
	 * 프로그래머스 체육복
	 * 학생들 번호는 체격 순으로 매겨져 있다. 
	 * 바로 앞번호 학생이나 바로 뒷번호 학생에게만 체육복을 빌려줄 수 있다.
	 * 체육복을 적절히 빌려 최대한 많은 학생이 이득을 보려고 한다.
	 * @param n 전체 학생 수
	 * @param lost 도난당한 학생들의 번호
	 * @param reserve 여벌 체육복을 가져온 학생들 번호
	 * @return
	 */
	
	Map<Integer, Integer> map = new HashMap<>();
	
    public int solution(int n, int[] lost, int[] reserve) {
    	
    	for(int i = 1; i <= n; i++) {
    		map.put(i, 1); // 일단 다 체육복 한벌씩 있닥 ㅗ가정
    	}
    	
    	for(int num : lost) {
    		map.put(num, map.get(num) - 1); // 잃어버린 학생들
    	}
    	
    	for(int num : reserve) {
    		map.put(num, map.get(num) + 1); // 여벌 있는 학생들
    	}
    	
    	// 여분이 있으면 양쪽에 줘야 하는데 일단 왼쪽이 없으면 왼쪽부터 주면서 나간다.
    	
    	for(int num : map.keySet()) {
    		if(map.get(num) == 2) {
    			if(num > 1) {
    				if(map.get(num - 1) == 0) {
    					map.put(num, map.get(num) - 1);
    					map.put(num - 1, map.get(num - 1) + 1);
    					continue;
    				}
    			}
    			
    			if(num < n) {
    				if(map.get(num + 1) == 0) {
    					map.put(num, map.get(num) - 1);
    					map.put(num + 1, map.get(num + 1) + 1);    					
    					continue;
    				}
    			}
    		}
    	}
    	
    	int answer = 0;
    	for(int num : map.keySet()) {
    		if(map.get(num) >= 1) {
    			answer++;
    		}
    	}
    	
    	return answer;
    }
}