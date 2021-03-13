import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
            // '(' 이면 일단 넣는다.
                stack.push('(');
            }
            else{
            // ')' 이면 스택이 비어 있는지 안 비어 있는지 확인한다.
            // 비어 있는 상태라면 bad 상태
            // 비어 있지 않고 '('이 존재하는 상태라면 pop 연산수행
                if(!stack.empty())
                    stack.pop();
                else{
                    System.out.println("bad");
                    return;
                }
            }
        }
        // for문을 모두 돌고 난 후 스택이 비어 있는지 아닌지 확인한다.
        // 비어 있다면 정상 -> good
        // 비어 있지 않다면 비정상 -> bad
        if(!stack.empty())
            System.out.println("bad");
        else
            System.out.println("good");
        }
        catch(IOException e){
            
        }
    }
}
