package Tree.트리알아보기;

import java.util.ArrayList;
import java.util.Scanner;

public class P068_1068 {
  static ArrayList<Integer>[] tree;
  static boolean[] visited;
  static int deleteNode, answer;
  public static void main(String[] args) {
    //init
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    tree = new ArrayList[n];
    for(int i=0; i<n; i++){
      tree[i] = new ArrayList<>();
    }
    visited = new boolean[n];
    int root = -1;
    //input
    for(int i=0; i<n; i++){
      int temp = scan.nextInt();
      if(temp != -1){
        tree[i].add(temp);
        tree[temp].add(i);
      }else {
        root = i;
      }
    }
    deleteNode = scan.nextInt();
    //DFS & output
    if(deleteNode==root) {
      System.out.println(0);
    }
    else {
      DFS(root);
      System.out.println(answer);
    }
  }
  static void DFS(int node){
    visited[node] = true;
    int count = 0;
    for(int i : tree[node]){
      if(visited[i] == false && i != deleteNode){
        count++;
        DFS(i);
      }
    }
    if(count ==0 ) answer++;
  }
}
