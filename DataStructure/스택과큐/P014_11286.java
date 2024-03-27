package DataStructure.스택과큐;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P014_11286 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs)
                return o1 > o2 ? 1 : -1;
            else
                return first_abs - second_abs;
        }));

        for (int i=0; i<N; i++){
            int now = scanner.nextInt();

            if(now ==0){
                if (priorityQueue.isEmpty()) {
                    bw.write("0\n");
                }
                else {
                    bw.write(priorityQueue.poll()+"\n");
                }
            }else {
                priorityQueue.add(now);
            }
        }

        bw.flush();
        bw.close();

    }
}
