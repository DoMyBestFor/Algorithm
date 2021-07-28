import java.util.*;

class Solution {
    int gem_type = 0; // 보석 종류의 개수
    
    // 중복의 제거를 위해 HashSet 자료구조 선택.
    HashSet<String> set = new HashSet<>();
    // 해당 보석과 그 보석의 개수를 집어넣기 위해 HashMap 자료구조 선택.
    HashMap<String, Integer> map = new HashMap<>();
    
    
    public int[] solution(String[] gems) {
        // 중복 제거해서 보석의 종류를 알자.
        // gems 배열의 처음부터 끝까지 탐색 해 나가면서
        // 보석의 종류가 다 담길때 start와 end와 거리를 갱신한다.
        // 보석의 종류가 다 담기면 앞에서 부터 보석을 없애나간다.
        // 없앴는데도 보석의 종류가 다 담기면 계속 없앤다.
        // 없앴늗네 보석으 종류가 다 담기지 않는다면 다시 end를 증가시키면서 앞으로 나간다.
        // 보석의 종류가 다시 다 담기게 되면서 거리가 더 작아지면 start와 end와 거리를 갱신한다.
        
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        gem_type = set.size(); // 보석 종류의 개수
        
        int start = 0;
        int end = 0;
        int minInterval = Integer.MAX_VALUE;
        int minStart = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while(start < gems.length){
            if(end - start == minInterval || end == gems.length){
                // 이전에 거리를 갱신했다면 혹은 end가 끝이라면
                // 이제 앞에서 부터 삭제해서 모든 종류를 포함하는지 확인
                remove(gems[start]);
                start++;
            }
            else{
                // end를 더해나간다
                add(gems[end]);
                end++;
            }
            if(map.size() == gem_type){
                // 보석의 종류를 다 담을 수 있다.
                // 거리 갱신 후 이 다음엔 앞에서부터 삭제해 나가야함
                if(end - start < minInterval){
                    minInterval = end - start;
                    minStart = start;
                }
                else if(end - start == minInterval){
                    // 최소 거리가 동일하면 최소 start 값을 갱신
                    if(minStart > start){
                        minStart = start;
                    }
                }
            }
        }
        answer[0] = minStart + 1;
        answer[1] = answer[0] + minInterval - 1;
        
        return answer;
        
    }
    
    public void add(String gem){
        if(map.containsKey(gem)){
            // gem 키를 이미 가지고 있다면
            map.put(gem, map.get(gem) + 1);    
        }
        else{
            // 가지고 있지 않다면
            map.put(gem, 1);
        }
    }
    
    public void remove(String gem){
        if(map.get(gem) == 1){
            // gem 키의 값이 1이라면
            map.remove(gem);    
        }
        else{
            // gem 키의 값이 1보다 크다면
            map.put(gem, map.get(gem) - 1);
        }
    }
}
