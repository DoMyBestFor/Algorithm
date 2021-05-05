import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // Integer.toString 
        // String.valueOf
        String[] str = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numbers.length; i++){
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        
        if(str[0].equals("0")){
            return "0";
        }
        
        for(String s : str){
            sb.append(s);
        }
        
        return sb.toString();
        
    }
}
