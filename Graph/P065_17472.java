package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P065_17472 {
  static int[] dr = {1,0,-1,0};
  static int[] dc = {0,1,0,-1};
  static int N, M, sNum;
  static boolean[][] visited;
  static int[][] map;
  static ArrayList<int[]> mList;
  static ArrayList<ArrayList<int[]>> sumList;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visited = new boolean[N][M];
    sumList = new ArrayList<>();
    //입력
    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    //BFS를 이용해 그래프 찾기
    sNum = 1;
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if(map[i][j] == 1 && visited[i][j] != true){
          BFS(i,j);
          sNum++;
          sumList.add(mList);
        }
      }
    }
    //Edge 추가

    //Union Find

    //output
    for(int[] i : map){
      for(int j : i) System.out.print(j+" ");
      System.out.println();
    }
  }
  private static void BFS(int i, int j) { // BFS를 통하여 연결된 섬을 찾아줍니다.
    Queue<int[]> queue = new ArrayDeque<>();
    mList = new ArrayList<>();
    int[] start = {i,j};
    queue.add(start);
    visited[i][j] = true;
    map[i][j] = sNum;
    mList.add(start);

    while(!queue.isEmpty()){
      int[] now = queue.poll();
      int r = now[0];
      int c = now[1];
      for(int d=0; d<4; d++){
        int tempR = dr[d];
        int tempC = dc[d];
        while(0 <= r+tempR && r+tempR < N && 0 <= c+tempC && c+tempC < M ){ //BFS하려는 탐색 범위가 일단 배열 index 범위 내에 있어야함
          if(map[r+tempR][c+tempC] == 1 && visited[r+tempR][c+tempC]==false){
            //addNode Logic
            map[r+tempR][c+tempC] = sNum;
            visited[r+tempR][c+tempC]=true;
            int[] addNode = {r+tempR,c+tempC};
            queue.add(addNode);
            mList.add(addNode);
          }else{
            break;
          }
          if (tempR > 0) tempR++;
          else if(tempR < 0) tempR--;
          else if(tempC > 0) tempC++;
          else if(tempC < 0) tempC --;
        }
      }
    }
  }
}
