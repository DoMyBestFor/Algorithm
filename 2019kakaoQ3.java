import java.util.*;

class Solution {
    String[] user_id;
    String[] banned_id;
    ArrayList<HashSet<String>> list;
    HashSet<HashSet<String>> result;
    LinkedHashSet<String> hashset;
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        list = new ArrayList<>();
        result = new HashSet<>();
        hashset = new LinkedHashSet<>();
        
        for(String banId : banned_id){
            HashSet<String> set = new HashSet<>();
            for(String userId : user_id){
                if(isMatched(banId, userId)){
                    set.add(userId);
                }
            }
            list.add(set);
        }        
        
        dfs(0);
        
        return result.size();
        
    }
    
    public void dfs(int index){
        if(index == banned_id.length){
            
            result.add(new HashSet<String>(hashset));
            
            return;
        }
        
        for(String banId : list.get(index)){
            if(!hashset.contains(banId)){
                hashset.add(banId);
                dfs(index + 1);
                hashset.remove(banId);
            }
        }
    }
    
    public boolean isMatched(String banId, String userId){
        String regex = banId.replace("*", ".");
        return userId.matches(regex);
    }
}
