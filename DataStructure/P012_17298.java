package DataStructure;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class P012_17298 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = scan.nextInt();
        int A[] = new int[N];
        int result[] = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++){
            A[i] = scan.nextInt();
        }

        for (int i=0; i<N; i++){
            if (i==0){
                stack.push(i);
                continue;
            }

            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        for (int i=0; i<N; i++){
            bw.write(result[i]+" ");
        }

        bw.flush();
        bw.close();

    }
}
