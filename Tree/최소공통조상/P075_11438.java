package Tree.최소공통조상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P075_11438 {
  static ArrayList<Integer>[] tree;
  static int[] depth;
  static boolean[] visited;
  static int[][] parent;
  static int K_max;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    tree = new ArrayList[N+1];
    for(int i=1; i<=N; i++){
      tree[i] = new ArrayList<>();
    }
    depth = new int[N+1];
    visited = new boolean[N+1];
    //입력 받아 트리 만들기
    for(int i=0; i<N-1; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      tree[s].add(e);
      tree[e].add(s);
    }
    //K의 Max값 구하기 -> K가 가장 큰 편향 이진트리일 경우를 기준으로 구함
    int temp = 1;
    K_max = 0;
    while(temp <= N){
      temp <<= 1;
      K_max++;
    }
    parent = new int[K_max+1][N+1];
    //DFS 돌아 깊이랑 2^0 번째 부모 노드 구하기
    DFS(1,0);
    //점화식으로 Parent 구하기
    for(int i=1; i<= K_max; i++){
      for (int j=1; j<=N; j++){
        parent[i][j] = parent[i-1][parent[i-1][j]];
      }
    }
    //LCA알고리즘 적용
    int M = Integer.parseInt(br.readLine());
    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int result = executeLCA(a,b);
      System.out.println(result);
    }
  }
  public static int executeLCA(int a, int b){
    //b가 더 깊은 노드가 되도록 변경
    if(depth[a] > depth[b]){
      int temp = a;
      a = b;
      b = temp;
    }
    //depth 맞추기
    for(int k=K_max; k>=0; k--){
      if(Math.pow(2,k) <= depth[b]-depth[a]){
        b = parent[k][b];
      }
    }
    //LCA찾기 -> K번만큼 a와 b의 k번째 조상이 다를때만 이동
    for(int k=K_max; k>=0; k--){
      if(parent[k][a]!=parent[k][b]){
        a = parent[k][a];
        b = parent[k][b];
      }
    }
    //depth를 맞췄을때 처음부터 같은게 아니라면 a와 b의 바로 위에 것이 LCA가 된다.
    int LCA = a;
    if(a!=b) LCA = parent[0][a];
    return LCA;
  }
  static void DFS(int start, int dep){
    visited[start] = true;
    depth[start] = dep;
    dep++;
    for (int next: tree[start]){
      if (!visited[next]){
        parent[0][next] = start;
        DFS(next,dep);
      }
    }
  }
}
