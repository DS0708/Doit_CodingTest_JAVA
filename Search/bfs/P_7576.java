package Search.bfs;

import java.util.*;
import java.io.*;

public class P_7576 {
  static int[] dr = {1,-1,0,0};
  static int[] dc = {0,0,1,-1};
  static int M,N,zeroCount;
  static int[][] map;
  static ArrayList<int[]> addList;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new int[N+1][M+1];

    addList = new ArrayList<>();
    zeroCount = 0;

    for(int i=1; i<=N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=1; j<=M; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j]==1) addList.add(new int[] {i,j});
        else if(map[i][j]==0) zeroCount++;
      }
    }

    int res = 0;
    if(zeroCount!=0){
      res = BFS();
    }
    System.out.println(res);
  }

  static int BFS(){
    int depth = 1;
    int depthCount = addList.size();
    int count = 0;
    int addQueueCount = 0;
    Queue<int[]> queue = new ArrayDeque<>();

    for(int i=0; i<depthCount; i++) queue.add(addList.get(i));

    while(!queue.isEmpty()){
      int[] current = queue.poll();
      int cr = current[0];
      int cc = current[1];
      count++;
      //탐색
      for(int i=0; i<4; i++){
        int tr = cr + dr[i];
        int tc = cc + dc[i];
        if(1<=tr&&tr<=N && 1<=tc&&tc<=M){
          if(map[tr][tc]==0){
            map[tr][tc] = 1;
            queue.add(new int[] {tr,tc});
            addQueueCount++;
            zeroCount--;
          }
        }
      }
      //상태검사
      if(zeroCount==0) break;
      //이 코드가 앞부분에 있다면, 토마토가 다 익은 후에 조건을 만족하면
      //depth가 하나 더 더해지기 때문에 dept++하기전에 검사해야한다.
      if(count==depthCount){
        depth++;
        count=0;
        depthCount = addQueueCount;
        addQueueCount=0;
      }
    }
    if(zeroCount==0) return depth;
    else return -1;
  }

}


// N * M 크기의 창고
//하루가 지나면 익은 토마토 근접한 안익은 토마토가 익음
//며칠이 지나면 토마토가 모두 익는지 최수 일수 구하기

//입력
// M N -> 2<=M,N<=1000
// Map -> -1 토마토 없음, 1은 익은 토마토, 0은 익지 않은 토마토



