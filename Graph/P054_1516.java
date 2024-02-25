package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P054_1516 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int indegree[] = new int[N+1];
    int selfBuild[] = new int[N+1];
    int result[] = new int[N+1];
    Queue<Integer> queue = new ArrayDeque<>();
    //graph init
    for(int i=0; i<=N; i++){
      graph.add(new ArrayList<>());
    }
    //insert
    for(int i=1; i<=N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      selfBuild[i] = Integer.parseInt(st.nextToken());
      while(true){
        int preTemp = Integer.parseInt(st.nextToken());
        if (preTemp == -1) break;

        graph.get(preTemp).add(i);
        indegree[i]++;
      }
    }
    //Topology Sort
    for (int i=1; i<=N; i++){
      if (indegree[i]==0){
        queue.offer(i);
      }
    }

    while(!queue.isEmpty()){
      int now = queue.poll();
      for (int next : graph.get(now)){
        indegree[next]--;
        result[next] = Math.max(result[next],result[now]+selfBuild[now]);   //max인 이유는 동시에 건물을 짓기 시작할 수 있기 때문.
        if(indegree[next]==0) queue.offer(next);
      }
    }

    //결과 출력
    for(int i=1; i<=N; i++){
      System.out.println(selfBuild[i]+result[i]);
    }
  }
}
