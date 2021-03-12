import java.util.*;

public class Main{
    public static class time implements Comparable<time>{
        public int start;
        public int end;
        
        public time(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(time arg0){
            if(this.end == arg0.end)
                return Integer.compare(this.start, arg0.start);
            else
                return Integer.compare(this.end, arg0.end);
        }
        
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        time[] times = new time[number];
        
        int end = -1;
        int count = 0;
        for(int i = 0; i < number; i++){
            times[i] = new time(scan.nextInt(), scan.nextInt());
        }
        Arrays.sort(times);
        for(int i = 0; i < number; i++){
            if(times[i].start >= end){
                end = times[i].end;
                count++;
            }
        }
        System.out.println(count);
        
    }
}
