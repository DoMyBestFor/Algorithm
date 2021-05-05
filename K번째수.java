import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int[] arr : commands){
            int start = arr[0];
            int end = arr[1];
            int k = arr[2];
            
            int[] copy = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(copy);
            list.add(copy[k-1]);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
