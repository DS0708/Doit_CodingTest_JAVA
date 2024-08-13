package Sort.버블정렬;

import java.io.*;
import java.util.*;


public class P016_1377 {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
//      PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
//          //0번 기준으로 오름차순으로 정렬
//          return o1[0] - o2[0];
//      });
        //우선 순위 큐 사용시, 같은 값을 가진 요소들에 대해서 상대적 순서가 보장되지 않는다.
        //예를 들어 (3,1) (3,2) 가 있으면 나중에 (3,2),(3,1)로 바뀔 수도 있는 것이다.
        ArrayList<int[]> list = new ArrayList<>();
      for(int i=1; i<=N; i++) {
          list.add(new int[] {Integer.parseInt(br.readLine()),i});
      }

      Collections.sort(list,(o1,o2)->{
         return o1[0] - o2[0];
      });

      int res = 0;

      for(int i=1; i<=N; i++){
//          res = Math.max(res,pq.poll()[1]-i);
          int num = list.get(i-1)[1]-i;
          if(res < num) res = num;
      }

      System.out.println(res+1);
    }
}


//버블소트는 i번째에서 한번도 바뀌지 않을 경우 정렬이 끝난 상태이다.
//이때 몇번째 부터 정렬을 안해도 되는지 구하기

//입력
// 1 <= N <= 500,000
// 0<= A[n] <= 1,000,000
// 2초안에 해결 -> n^2 보다 낮은걸로 해야함

//풀이
//정렬 후와 전의 인덱스 비교
//버블 정렬을 한 번 수행하면, 수들은 최대 왼쪽으로 한 번 이동
//그럼 수들 중에 왼쪽으로 제일 많이 이동한 횟수가 버블 정렬 시 필요한 최소의 횟수가 된다.
//change==false 일때, 즉 버블 정렬 시 필요한 횟수에서 한 번 더 진행하므로 1도 더해줘야 한다.

