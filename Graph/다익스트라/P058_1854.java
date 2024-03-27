package Graph.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P058_1854 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer>[] distPQ = new PriorityQueue[n+1];
    int[][] graph = new int[n+1][n+1];
    PriorityQueue<Edge_1854> pq = new PriorityQueue<>();
    Comparator<Integer> comparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);  //내림차순 정렬 : poll하면 큰 수 먼저 나옴
      }
    };
    for(int i=0; i<=n ;i++){
      distPQ[i] = new PriorityQueue<>(k,comparator);    //k개의 크기만큼의 우선순위 큐 생성
    }
    //graph 입력
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[s][e] = v;
    }

    //다익스트라
    pq.offer(new Edge_1854(1,0));
    distPQ[1].add(0);
    while(!pq.isEmpty()){
      Edge_1854 now = pq.poll();
      int nowNode = now.targetNode;
      int nowValue = now.value;
      for(int target=1; target<=n ; target++){  //시간복잡도를 위하여 graph를 matrix로 구성
        if(graph[nowNode][target] != 0) {       //0이 아니면 에지가 존재
          //distPQ에 들어가지 않는 경우는 k번째까지의 최단거리 비용보다다 더 많은 비용이므로, 그거 보다 더 적은 비용으로 갈 수 있는 k개의 경로가 존재한다. 즉 볼 필요가 없다.
          int val = nowValue + graph[nowNode][target];    //nowNode를 거쳐 target까지 가는 value
          if (distPQ[target].size() < k) {            //distPQ의 크기가 k보다 작으면 무조건 추가해주면 됨
            distPQ[target].offer(val);
            pq.offer(new Edge_1854(target, val));
          } else {                                    //distPQ의 크기가 k일 경우 제일 큰 값(내림차순 정렬했으니 peek값)과 비교해서 작을 경우만 넣어주면 된다.
            int peek = distPQ[target].peek();
            if (peek > val) {
              distPQ[target].poll();
              distPQ[target].offer(val);
              pq.offer(new Edge_1854(target, val));
            }
          }

        }//if
      }//for
    }

    //결과 출력
    for(int i=1; i<=n ; i++){
      if(distPQ[i].size() < k) System.out.println(-1);
      else System.out.println(distPQ[i].peek());
    }
  }
}
class Edge_1854 implements Comparable<Edge_1854>{
  int targetNode;
  int value;
  Edge_1854(int targetNode, int value){
    this.targetNode = targetNode;
    this.value = value;
  }
  @Override
  public int compareTo(Edge_1854 o) {
    return this.value < o.value ? -1 : 1; //오름차순 정렬, poll 하면 작은 거 먼저 나옴
  }
}
