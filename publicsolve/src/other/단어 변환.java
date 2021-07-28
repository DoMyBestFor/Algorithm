import java.util.*;

class Solution {
   int n;
int min = Integer.MAX_VALUE;
boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        n = begin.length();
visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
      
    }
public void dfs(String begin, String target, String[] words, int count){
if(begin.equals(target)){
min = Math.min(count, min);
    return;
}

for(int i = 0; i < words.length; i++){
if(changable(begin, words[i])){
if(!visited[i]){
visited[i] = true;
dfs(words[i], target, words, count + 1);
visited[i] = false;
}
}
}
}

    public boolean changable(String a, String b){
	int result = 0;
for(int i = 0; i < n; i++){
	if(a.charAt(i) == b.charAt(i)){
result++;
}

}
if(result == n-1)
return true;
return false;
}
    
}
