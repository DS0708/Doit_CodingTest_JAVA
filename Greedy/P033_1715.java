package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P033_1715 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<N; i++) pq.add(scan.nextInt());

        while(pq.size()>1){
            int pq_sum = pq.poll() + pq.poll();
            pq.add(pq_sum);
            result += pq_sum;
        }

        System.out.println(result);
    }
}
