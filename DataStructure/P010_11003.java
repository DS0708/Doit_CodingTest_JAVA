package DataStructure;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P010_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Node> myDeque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        //초기값 설정
        long init_value = Integer.parseInt(st.nextToken());
        myDeque.add(new Node(0,init_value));
        bw.write(init_value+" ");

        //Logic
        for (int i=1; i<N; i++){
            //now 설정
            long now_value = Long.parseLong(st.nextToken());

            // now < 덱의 LastValue 이면 계속해서 덱의 마지막 인덱스 제거하기
            while(!myDeque.isEmpty() && now_value < myDeque.getLast().value){
                myDeque.removeLast();
            }

            //now_value 추가하기
            myDeque.addLast(new Node(i,now_value));

            //인덱스 범위 확인
            if (myDeque.getFirst().index <= myDeque.getLast().index - L)
                myDeque.removeFirst();

            //첫번째 덱의 value 추가
            bw.write(myDeque.getFirst().value+" ");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        int index;
        long value;

        public Node(int index, long value){
            this.index = index;
            this.value = value;
        }
    }
}
