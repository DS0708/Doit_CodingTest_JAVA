package Class3;

import java.io.*;
import java.util.*;

public class P_1764 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Set<String> set = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>((o1,o2)->o1.compareTo(o2));

        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        int count = 0;

        for(int i=0; i<M; i++){
            String name = br.readLine();
            if(set.contains(name)){
                count++;
                pq.add(name);
            }
        }

        System.out.println(count);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
