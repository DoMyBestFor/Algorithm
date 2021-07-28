import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 문자열을 적절히 분리해야 겠다.
        String new_s = s.substring(2, s.length() - 2).replace("},{", " ");
        String[] strs = new_s.split(" ");
        int[] answer = new int[strs.length];
        
        /*Arrays.sort(strs, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return a.length() - b.length();
            }
        });*/
        
        Arrays.sort(strs, (a, b) -> a.length() - b.length());
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < strs.length; i++){
            String[] nums = strs[i].split(",");
            
            for(String num : nums){
                int a = Integer.parseInt(num);
                if(set.contains(a))
                    continue;
                set.add(a);
                answer[i] = a;
            }
        }
        return answer;
    }
}
