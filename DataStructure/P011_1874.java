package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class P011_1874 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int arr[] = new int[N];
        int current = 1;
        boolean result = true;

        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }

        for (int i=0; i<N ; i++){
            int now = arr[i];
            if (now >= current){
                while(now >= current){
                    stack.push(current);
                    current++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else {
                if (stack.pop() > now){
                    result = !result;
                    System.out.println("NO");
                    break;
                }else {
                    sb.append("-\n");
                }
            }
        }

        if (result) System.out.println(sb.toString());
    }
}
