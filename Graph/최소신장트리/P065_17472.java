package Graph.최소신장트리;

import java.io.*;
import java.util.*;

public class P065_17472 {
  static int[] dr = {1,0,-1,0};
  static int[] dc = {0,1,0,-1};
  static int N,M,nodeNum;
  static int[][] map;
  static ArrayList<ArrayList<int[]>> nodeList;
  static ArrayList<int[]> tempNode;
  static boolean[][] visited;
  static PriorityQueue<Edge_17472> pq = new PriorityQueue<>();
  static int[] parent;
  public static void main(String[] args) throws Exception{
    //init
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visited = new boolean[N][M];
    nodeList = new ArrayList<>();
    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    //그래프 변환
    nodeNum = 1;
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if(map[i][j]==1 && visited[i][j] != true){
          BFS(i,j);
          nodeNum++;
          nodeList.add(tempNode);
        }
      }
    }
    //에지 리스트 추가
    for(ArrayList<int[]> node : nodeList){
      for(int[] now : node){
        int r = now[0];
        int c = now[1];
        int nowNodeNum = map[r][c];
        for(int d=0; d<4; d++){
          int tempR = dr[d];
          int tempC = dc[d];
          int len = 0;
          while(0<=r+tempR && r+tempR<N && 0<=c+tempC && c+tempC<M){
            int targetR = r+tempR;
            int targetC = c+tempC;
            if(map[targetR][targetC] == 0 ){ //0인 경우만 계속 진행하면 됨
              len++;
              if(tempR > 0) tempR++;
              else if(tempR < 0) tempR--;
              else if(tempC > 0) tempC++;
              else if (tempC < 0) tempC--;
            }else{
              if(map[targetR][targetC] != nowNodeNum && len > 1){ //nowNodeNum이 아니고 len이 2 이상이면 추가
                pq.offer(new Edge_17472(nowNodeNum,map[targetR][targetC],len));
              }
              break;  //0이 아닌 숫자를 만나는 경우는 무조건 break;
            }
          }
        }
      }
    }
    //유니온 파인드
    parent = new int[nodeNum];  //현재 노드 갯수 + 1 = nodeNum 이고, node 번호는 1부터 시작
    for(int i=1; i<nodeNum; i++){
      parent[i] = i;
    }
    int conCount = 0;
    int result = 0;
    boolean check  = true;
    while(conCount < (nodeNum-2)){
      if(pq.isEmpty()){
        check = false;
        break;
      }
      Edge_17472 now = pq.poll();
      if(find(now.s) != find(now.e)){
        union(now.s, now.e);
        result += now.v;
        conCount++;
      }
    }
    //출력
    if(check){
      System.out.println(result);
    }else{
      System.out.println(-1);
    }
  }
  static void union(int a, int b){
    a = find(a);
    b = find(b);
    if(a!=b) {
      parent[b] = a;
    }
  }
  static int find(int a){
    if (a == parent[a]) return a;
    else return parent[a] = find(parent[a]);
  }
  static void BFS(int i, int j){
    //init
    tempNode = new ArrayList<>();
    Queue<int[]> queue = new ArrayDeque<>();
    map[i][j] = nodeNum;
    //시작노드 넣기
    int[] start = {i,j};
    visited[i][j] = true;
    queue.offer(start);
    tempNode.add(start);
    //BFS시작
    while(!queue.isEmpty()){
      int[] now = queue.poll();
      int r = now[0];
      int c = now[1];
      for(int d=0; d<4; d++){
        int tempR = dr[d];
        int tempC = dc[d];
        while(0<=r+tempR && r+tempR<N && 0<=c+tempC && c+tempC<M){  //일단 탐색하려는 index의 범위가 map의 index범위 내에 있어야 함
          int targetR = r+tempR;
          int targetC = c+tempC;
          if(map[targetR][targetC] == 1 && visited[targetR][targetC] != true){ //1이고 방문하지 않았으면 섬노드 추가
            map[targetR][targetC] = nodeNum;
            visited[targetR][targetC] = true;
            int[] addNode = {targetR,targetC};
            tempNode.add(addNode);
            queue.offer(addNode);
            //계속해서 BFS 수행
            if(tempR > 0) tempR++;
            else if(tempR < 0) tempR--;
            else if(tempC > 0) tempC++;
            else if (tempC < 0) tempC--;
          }else{ //값이 0 이거나 이미 방문했던 곳이므로 반목문을 빠져나가준다.
            break;
          }
        }
      }
    }

  }
}

class Edge_17472 implements Comparable<Edge_17472>{
  int s;
  int e;
  int v;
  Edge_17472(int s,int e,int v){
    this.s = s;
    this.e = e;
    this.v = v;
  }
  @Override
  public int compareTo(Edge_17472 o) {
    return this.v - o.v;
  }
}



