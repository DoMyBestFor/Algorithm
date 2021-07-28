import java.util.*;

class Solution {
    HashSet<String> set;
    HashSet<HashSet<String>> result;
    
    public int solution(String[] user_id, String[] banned_id) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        set = new HashSet<>();
        result = new HashSet<>();
        
        for(String bannedId : banned_id){
            ArrayList<String> users = new ArrayList<>();
            for(String userId : user_id){
                if(isMatched(userId, bannedId)){
                    users.add(userId);
                }
            }
            list.add(users);
        }
        
        dfs(list, 0);
        return result.size();
        
    }
    
    public void dfs(ArrayList<ArrayList<String>> list, int index){
        if(index == list.size()){
            if(set.size() == list.size()){
                result.add(new HashSet<String>(set));
            }
            return;
        }
        
        for(String id : list.get(index)){
            
                if(!set.contains(id)){
                    // 방문하지 않은 것이라면
                    set.add(id);
                    dfs(list, index + 1);
                    set.remove(id);
                }
            
        }
    }
    
    public boolean isMatched(String userId, String bannedId){
        // 매칭 확인 함수
        String regex = bannedId.replace("*", ".");
        return userId.matches(regex);
    }
}
