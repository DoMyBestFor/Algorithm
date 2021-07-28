import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int temp;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 1; i <= num; i++){
            queue.offer(i);
        }
        while(queue.size() != 1){
            queue.poll();
            temp = queue.poll();
            queue.offer(temp);
        }
        System.out.println(queue.poll());
    }
}
