package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P035_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        TreeSet<Meeting> treeSet = new TreeSet<>();

        int result = 0;
        int current=-1;

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            treeSet.add(new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        for (Meeting m : treeSet){
            if (m.startTime >= current){
                result ++;
                current = m.endTime;
            }
        }

        System.out.println(result);
    }
}

class Meeting implements Comparable<Meeting>{
    int startTime;
    int endTime;
    public Meeting(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    @Override
    public int compareTo(Meeting o) {
        if (this.endTime != o.endTime){
            return this.endTime - o.endTime;
        }else {
            if (this.startTime == o.startTime) return -1;
            else return this.startTime - o.startTime;
        }
    }
}