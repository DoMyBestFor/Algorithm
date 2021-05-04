import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    HashSet<String> visited;
    public int solution(String begin, String target, String[] words) {
        // DFS 의심 
        visited = new HashSet<>();
        visited.add(begin);
        DFS(begin, target, words, 0);
        
        if(min == Integer.MAX_VALUE){
            min = 0;
        }
        return min;
    }
    
    public void DFS(String begin, String target, String[] words, int answer){
        if(begin.equals(target)){
            min = Math.min(min, answer);
            return;
        }
        
        for(String str : words){
            int count = 0;
            for(int i = 0; i < begin.length(); i++){
                if(str.charAt(i) == begin.charAt(i))
                    count++;
            }
            if(count == begin.length() - 1){
                    if(visited.contains(str))
                        continue;
                    visited.add(str);
                    DFS(str, target, words, answer + 1);
                    visited.remove(str);
                }
        }
    }
}
