package Tree.세그먼트트리;

import java.util.*;
import java.io.*;

public class P074_11437 {
  static ArrayList<ArrayList<Integer>> tree;
  static boolean[] visited;
  static int[] parent;
  static int[] depth;
  public static void main(String[] args) {
    //init
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    visited = new boolean[n+1];
    parent = new int[n+1];
    depth = new int[n+1];
    tree = new ArrayList<>();
    for(int i=0 ; i<=n; i++){
      tree.add(new ArrayList<>());
    }
    // n input
    for(int i=1; i<n; i++){
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      tree.get(a).add(b);
      tree.get(b).add(a);
    }
    //make tree
    BFS(1);
    //excute LCA(Lowest Common Ancestor)
    int m = scanner.nextInt();
    for(int i=0; i<m; i++){
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int LCA = excuteLCA(a,b);
      System.out.println(LCA);
    }
  }
  static int excuteLCA(int a, int b){
    if (depth[a] < depth[b]){
      int temp = a;
      a = b;
      b = temp;
    }
    while(depth[a] != depth[b]){
      a = parent[a];
    }
    while(a != b){
      a = parent[a];
      b = parent[b];
    }
    return a;
  }
  static void BFS(int start){
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start] = true;
    int level = 1;
    int levelSize = 1;
    int count = 0;
    while(!queue.isEmpty()){
      int now = queue.poll();
      for(int next : tree.get(now)){
        if(!visited[next]){
          visited[next] = true;
          parent[next] = now;
          depth[next] = level;
          queue.add(next);
        }
      }
      count ++;
      if(count == levelSize){
        count = 0;
        levelSize = queue.size();
        level ++;
      }
    }
  }
}
