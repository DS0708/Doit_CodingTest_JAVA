package Tree.트리알아보기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P067_11725 {
  static ArrayList<ArrayList<Integer>> tree;
  static int[] parentNode;
  static boolean[] visited;
  public static void main(String[] args) throws Exception{
    //init
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    tree = new ArrayList<>();
    parentNode = new int[n+1];
    visited = new boolean[n+1];
    for(int i=0; i<=n; i++){
      tree.add(new ArrayList<>());
    }
    //input
    for(int i=1; i<n; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      tree.get(s).add(e);
      tree.get(e).add(s);
    }
    //DFS
    DFS(1);
    //output
    for(int i=2; i<=n; i++){
      System.out.println(parentNode[i]);
    }
  }
  static void DFS(int node){
    visited[node] = true;
    for(int i : tree.get(node)){
      if(visited[i]==false){
        parentNode[i] = node;
        DFS(i);
      }
    }
  }
}
