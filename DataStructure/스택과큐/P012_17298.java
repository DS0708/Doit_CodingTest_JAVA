package DataStructure.스택과큐;

import java.util.*;
import java.io.*;

public class P012_17298 {
    public static void main(String[] args) throws IOException {
      //많은 io 때문에 버퍼리더와 버퍼라이터를 써야 한다.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] arr = new int[n+1];
      int[] answer = new int[n+1];
      for(int i=1; i<=n; i++){
        arr[i] = Integer.parseInt(st.nextToken());
        answer[i] = -1;
      }
      Stack<Integer> stack = new Stack<>();
      stack.push(1);

      //스택에 index를 삽입한다.
      //해당 index를 뽑아 그 수 보다 크다면 해당 idnex에 정답 배열에 현재 숫자 추가
      for(int i=2; i<=n; i++){
        while(!stack.isEmpty() && arr[stack.peek()] < arr[i] ){
          int index = stack.pop();
          answer[index] = arr[i];
        }
        stack.push(i);
      }

      for(int i=1; i<=n; i++){
        bw.write(answer[i]+" ");
      }
      bw.flush();
      bw.close();
      br.close();
    }
}
