package Graph;

import java.io.*;
import java.util.*;

public class P066_1414 {
  static int[] parent;
  public static void main(String[] args) throws Exception{
    //init
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[][] map = new int[n+1][n+1];
    int sum = 0;
    PriorityQueue<Edge_1414> pq = new PriorityQueue<>();
    parent = new int[n+1];
    for(int i=1; i<=n; i++){
      parent[i] = i;
    }
    //입력, 동시에 숫자 배열로 변환, 모든 랜선의 합 구하기
    for(int i=1; i<=n; i++){
      st = new StringTokenizer(br.readLine());
      char[] tempChar = st.nextToken().toCharArray();
      for(int j=1; j<=n; j++){
        if('a' <= tempChar[j-1] && tempChar[j-1] <= 'z'){
          map[i][j] = tempChar[j-1] - 'a'+ 1;
        }else if ('A' <= tempChar[j-1] && tempChar[j-1] <= 'Z'){
          map[i][j] = tempChar[j-1] - 'A'+ 27;
        }
        sum += map[i][j];
      }
    }
    //에지 리스트에 추가, 단 자기 자신에게로 가는 에지는 추가할 필요 없음
    for(int i=1; i<=n ;i++){
      for(int j=1; j<=n ; j++){
        if(i==j) continue;
        if(map[i][j]==0) continue;
        pq.offer(new Edge_1414(i,j,map[i][j]));
      }
    }
    //유니온 파인드로 MST 구하기
    int conCount = 0;
    boolean check = true;
    int sub = 0;
    while(conCount < n-1){
      if(pq.isEmpty()){
        check = false;
        break;
      }
      Edge_1414 now = pq.poll();
      if(find(now.e) != find(now.s)){
        union(now.e, now.s);
        conCount++;
        sub += now.v;
      }
    }
    //결과 출력
    if(check){
      System.out.println(sum - sub);
    }else {
      System.out.println(-1);
    }
  }
  static void union(int a, int b){
    a = find(a);
    b = find(b);
    if (a!=b){
      parent[b] = a;
    }
  }
  static int find(int a){
    if(a==parent[a]) return a;
    else return parent[a] = find(parent[a]);
  }
}
class Edge_1414 implements Comparable<Edge_1414>{
  int s;
  int e;
  int v;
  Edge_1414(int s, int e, int v){
    this.s = s;
    this.e = e;
    this.v = v;
  }
  @Override
  public int compareTo(Edge_1414 o){
    return this.v - o.v;
  }
}
