package Graph.벨만포드;

import java.io.*;
import java.util.*;


public class P059_11657 {
  static class Edge11657{
    int start;
    int end;
    int val;
    Edge11657(int start,int end, int val){
      this.start = start;
      this.end = end;
      this.val = val;
    }

  }
  static Edge11657[] Edges;
  static long[] D; //거리는 항상 long으로 선언하자 ..! 혹시 모르니..!
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    Edges = new Edge11657[E];
    D = new long[V+1];
    Arrays.fill(D,Integer.MAX_VALUE);
    D[1] = 0; //1일떄 예외처리를 해줘야 한다...

    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      Edges[i] = new Edge11657(s,e,v);
    }
    //벨만-포드 알고리즘
    for(int i=0; i<V-1; i++){
      for(int j=0; j<E; j++){
        int s = Edges[j].start;
        int e = Edges[j].end;
        int v = Edges[j].val;
        if(D[s] != Integer.MAX_VALUE && D[e] > D[s] + v){
          D[e] = D[s] + v;
        }
      }
    }
    //음수 싸이클 확인하기
    boolean check = false;
    for(int j=0; j<E; j++){
      int s = Edges[j].start;
      int e = Edges[j].end;
      int v = Edges[j].val;
      if(D[s] != Integer.MAX_VALUE && D[e] > D[s] + v){
        check = true;
        break;
      }
    }

    if(check){
      System.out.println(-1);
    }else{
      for(int i=1; i<=V; i++) { //index가 2부터 시작할 때는 항상 주의할 것 !!!!
        if(i==1) continue;
        if(D[i] != Integer.MAX_VALUE) System.out.println(D[i]);
        else System.out.println(-1);
      }
    }
  }

}
