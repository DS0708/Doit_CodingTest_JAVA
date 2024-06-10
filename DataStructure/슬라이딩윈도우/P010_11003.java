package DataStructure.슬라이딩윈도우;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P010_11003 {
  public static void main(String args[]) throws Exception{
    //IO 연산이 많을 때는 버퍼리더와 버퍼라이터를 쓰지 않으면 시간 초과 걸림
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    Deque<Node11003> myDeque = new LinkedList<>();

    st = new StringTokenizer(br.readLine());

    myDeque.addFirst(new Node11003(1,Integer.parseInt(st.nextToken())));
    bw.write(myDeque.getFirst().val+" ");

    for(int i=2; i<=N; i++){
      Node11003 newNode = new Node11003(i,Integer.parseInt(st.nextToken()));

      while (!myDeque.isEmpty() && myDeque.getLast().val > newNode.val)
        myDeque.removeLast();

      myDeque.addLast(newNode);

      while (!myDeque.isEmpty() && myDeque.getFirst().index <= newNode.index - L)
        myDeque.removeFirst();

      bw.write(myDeque.getFirst().val+" ");
    }

    bw.flush();
    bw.close();
  }
}
class Node11003{
  int index;
  int val;
  Node11003(int index, int val){
    this.index = index;
    this.val = val;
  }
}
