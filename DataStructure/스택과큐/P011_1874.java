package DataStructure.스택과큐;

import java.util.*;
import static java.lang.System.exit;

public class P011_1874 {
  public static void main(String args[]) {
    StringBuffer sb = new StringBuffer();
    Scanner scan = new Scanner(System.in);
    boolean check = true;
    int n = scan.nextInt();
    int count = 1;
    Stack<Integer> stack = new Stack<>();
    //하나씩 보기
    for(int i=0; i<n; i++){
      int cur = scan.nextInt();
      //count가 cur될 때까지 push하고 한 번 pop
      if(count <= cur){
        for(;count <=cur ; count++){
          stack.push(count);
          sb.append("+\n");
        }
        stack.pop();
        sb.append("-\n");
      }else{
        if(stack.peek() == cur){
          stack.pop();
          sb.append("-\n");
        }else{
          check = false;
          break;
        }
      }

    }
    //출력 Logic
    if(!check){
      System.out.println("NO");
      //그냥써본거임
      exit(0);
    }else{
      System.out.println(sb);
    }
  }
}
