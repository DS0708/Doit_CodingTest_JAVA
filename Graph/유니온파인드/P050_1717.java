package Graph.유니온파인드;

import java.io.*;
import java.util.*;

public class P050_1717 {
  static int[] parent;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    parent = new int[V+1];
    for(int i=1; i<=V; i++){
      parent[i] = i;
    }

    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int q = Integer.parseInt(st.nextToken());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());

      if(q==1){
        if(find(n1)==find(n2)) System.out.println("YES");
        else System.out.println("NO");
      }else{
        union(n1,n2);
      }
    }
  }

  static void union(int n1, int n2){
    int a = find(n1);
    int b = find(n2);

    if(a!=b){
      parent[b] = a;
    }
  }

  static int find(int n){
    if(parent[n]==n) return n;
    else{
      return parent[n] = find(parent[n]);
    }
  }

}
