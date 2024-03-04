package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P055_1948 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<dNode>> A = new ArrayList<>();
    ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>();
    for(int i=0; i<=n; i++){
      A.add(new ArrayList<>());
      reverseA.add(new ArrayList<>());
    }
    int[] indegree = new int[n+1];
    int[] result = new int[n+1];
    int startNode;
    int endNode;
    int noRestCount = 0;
    StringTokenizer st;
    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[n+1];

    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      A.get(s).add(new dNode(e,v));
      reverseA.get(e).add(new dNode(s,v));
      indegree[e]++;
    }
    st = new StringTokenizer(br.readLine());
    startNode = Integer.parseInt(st.nextToken());
    endNode = Integer.parseInt(st.nextToken());
    queue.offer(startNode);

    //Topology Sort about A
    while(!queue.isEmpty()){
      int current = queue.poll();
      for (dNode next : A.get(current)){
        indegree[next.targetNode]--;
        if (indegree[next.targetNode] == 0) queue.offer(next.targetNode);
        result[next.targetNode] = Math.max(result[next.targetNode], result[current] + next.value);
      }
    }
    //Topology Sort about B
    queue.offer(endNode);
    while(!queue.isEmpty()){
      int current = queue.poll();
      for(dNode i : reverseA.get(current)){
        if (result[i.targetNode]+i.value == result[current]){
          noRestCount++;
          if (visited[i.targetNode]==false){
            queue.offer(i.targetNode);
            visited[i.targetNode]=true;
          }
        }
      }
    }

    System.out.println(result[endNode]);
    System.out.println(noRestCount);
  }
}

class dNode{
  int targetNode;
  int value;
  dNode(int targetNode, int value){
    this.targetNode = targetNode;
    this.value = value;
  }
}

