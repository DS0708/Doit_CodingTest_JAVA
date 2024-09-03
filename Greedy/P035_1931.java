package Greedy;

import java.io.*;
import java.util.*;

public class P035_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Meet> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Meet(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        Collections.sort(list,(o1,o2)->{
            if (o1.end != o2.end) return o1.end-o2.end;
            else return o1.start-o2.start;
        });
        // 예외 케이스 : 만약 (1,2) (2,2) 가 있을 경우에, (2,2)가 앞에온다면 (1,2)는 불가능하다.
        // 따라서 끝 시간이 같다면, 시작 시간으로 정렬해줘야 한다.

        int result=0;
        int endPoint=0;

        for(Meet m : list){
            if(m.start >= endPoint){
                result++;
                endPoint = m.end;
            }
        }

        System.out.println(result);
    }
}

class Meet{
    int start;
    int end;
    Meet(int start, int end){
        this.start = start;
        this.end = end;
    }
}




// 한 개의 회의실
// 이를 사용하고자 하는 N개의 회의
// 각 회의 I -> 시작 시간, 끝 시간
// 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대 개수

//입력
// 회의의수 N -> 1<= N <= 100,000

// Greedy 회의의 끝 시간이 작은 순서대로 정렬 -> nLogn
// 그리고 순서대로 회의 진행이 가능하면 (회의 시작시간 > 회의한 시간 중 가장 끝 시간)