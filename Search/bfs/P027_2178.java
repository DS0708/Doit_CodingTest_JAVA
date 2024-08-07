package Search.bfs;


import java.io.*;
import java.util.*;

public class P027_2178 {
  static int[] dr = {-1,1,0,0};
  static int[] dc = {0,0,1,-1};
  static int[][] map ;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    map = new int[N+1][M+1];
    for(int i=1; i<=N; i++){
      String str = br.readLine();
      for(int j=1; j<=M; j++){
        map[i][j] = str.charAt(j-1) - '0';
      }
    }

    BFS(1,1,N,M);
    System.out.println(map[N][M]);
  }

  public static void BFS(int sr,int sc,int er,int ec){
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {sr,sc});

    while(!queue.isEmpty()){
      int[] current = queue.poll();
      int cr = current[0];
      int cc = current[1];

      if(cr==er && cc==ec) break;

      for(int i=0; i<4; i++){
        int tr = cr + dr[i];
        int tc = cc + dc[i];
        if(1<=tr&&tr<=er && 1<=tc&&tc<=ec){
          if(map[tr][tc]==1){
            map[tr][tc] = map[cr][cc] + 1;
            queue.add(new int[] {tr,tc});
          }
        }

      }
    }
  }
}


// N*M 크기의 미로
// 1은 이동 가능, 0은 이동 불가
// 1,1 출발 -> N,M 도착 : 지나야 하는 최소의 칸 수를 구하기
// 칸을 셀 때 시작 위치와 도착 위치도 포함

//입력
// 첫째 줄에 N, M (2<= N,M <= 100)
// N개의 줄에는 M개의 정수로 미로가 주어진다. -> map[N][M]
// 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
