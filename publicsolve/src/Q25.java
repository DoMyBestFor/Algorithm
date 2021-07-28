import java.util.*;

class Solution {
   
    class Stage{
        int stage;
        int people;
        
        public Stage(int stage, int people){
            this.stage = stage;
            this.people = people;
        }
    }
    
    class Fail implements Comparable<Fail>{
        int stage;
        float fail_rate;
        public Fail(int stage, float fail_rate){
            this.stage = stage;
            this.fail_rate = fail_rate;
        }
        
        public int compareTo(Fail other){
            if(this.fail_rate > other.fail_rate)
                return -1;
            else if(this.fail_rate < other.fail_rate)
                return 1;
            else{
                return this.stage - other.stage;
            }
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N+2];
        int[] answer = new int[N];
        float[] fail = new float[N];
        ArrayList<Stage> list = new ArrayList<>();
        ArrayList<Fail> fail_rates = new ArrayList<>();
        
        for(int i = 0; i < stages.length; i++){
            count[stages[i]]++;
        }
        
        for(int i = 1; i <= N+1; i++){
                list.add(new Stage(i, count[i]));
        }
        
        for(int i = 0; i < N; i++){
            int sum = 0;
            if(list.get(i).people != 0){
                for(int j = i; j <= N; j++){
                    sum += list.get(j).people;
                }
                fail[i] = (float)list.get(i).people / sum;
            }
            else
                fail[i] = (float)0;
        }
        
        for(int i = 0; i < N; i++){
            fail_rates.add(new Fail(i+1, fail[i]));
        }
        Collections.sort(fail_rates);
        
        for(int i = 0; i < N; i++){
            answer[i] = fail_rates.get(i).stage;
        }
        return answer;
    }
   
}
