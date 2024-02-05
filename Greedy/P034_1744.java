package Greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P034_1744 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int result = 0;

        PriorityQueue<Integer> PositivePQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> NegativePQ = new PriorityQueue<>();
        int Count0 = 0;
        int Count1 = 0;

        for (int i=0; i<N; i++){
            int now = scan.nextInt();
            if (now==0) Count0++;
            else if (now==1) Count1++;
            else if (now > 1) PositivePQ.offer(now);
            else NegativePQ.offer(now);
        }

        //양수 부분 처리
        while(PositivePQ.size()>2){
            result += PositivePQ.poll() * PositivePQ.poll();
        }
        if (PositivePQ.size()==2) result += PositivePQ.poll() * PositivePQ.poll();
        else if (PositivePQ.size()==1) result += PositivePQ.poll();

        //음수 부분 처리
        while(NegativePQ.size()>2){
            result += NegativePQ.poll() * NegativePQ.poll();
        }
        if (NegativePQ.size()==2) result += NegativePQ.poll() * NegativePQ.poll();
        else if(NegativePQ.size()==1) if (Count0 <= 0) result += NegativePQ.poll();

        //1 부분 처리
        result += Count1;

        System.out.println(result);
    }
}
