package DataStructure.스택과큐;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P014_11286 {
    public static void main(String[] args) throws IOException {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
//    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new pqComparator());
      PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->{
        int abs1 = Math.abs(o1);
        int abs2 = Math.abs(o2);

        if(abs1 != abs2){
          return abs1 - abs2;
        }else{
          return o1 - o2;
        }
      });

      for(int i=0; i<n; i++){
        int input = scan.nextInt();
        if(input==0){
          if(pq.isEmpty()) System.out.println(0);
          else System.out.println(pq.poll());
        }else{
          pq.add(input);
        }
      }
    }
}

class pqComparator implements Comparator<Integer> {
  @Override
  public int compare(Integer o1, Integer o2) {
    int abs1 = Math.abs(o1);
    int abs2 = Math.abs(o2);

    if(abs1 != abs2){
      return abs1 - abs2;
    }else{
      return o1 - o2;
    }
  }
}