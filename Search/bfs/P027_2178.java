package Search.bfs;


import java.io.*;
import java.util.*;

public class P027_2178 {
  static int[] dx = {0,1,0,-1};
  static int[] dy = {1,0,-1,0};
  static boolean[][] visited;
  static int[][] miro;
  static int n,m;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();
    miro = new int[n][m];
    visited = new boolean[n][m];

    for(int i=0 ; i<n; i++){
      String str = scan.next();
      for(int j=0; j<m; j++){
        miro[i][j] = str.charAt(j) - '0';
      }
    }

    BFS(0,0);

    System.out.println(miro[n-1][m-1]);
  }

  static void BFS(int x, int y){
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {x,y});
    visited[x][y] = true;

    while(!queue.isEmpty()){
      int[] curNode = queue.poll();
      for(int i=0; i<4; i++){
        int newX = curNode[0] + dx[i];
        int newY = curNode[1] + dy[i];
        if(0<=newX && newX<n && 0<=newY && newY<m){
          if(!visited[newX][newY] && miro[newX][newY] != 0){
            miro[newX][newY] += miro[curNode[0]][curNode[1]];
            visited[newX][newY] = true;
            queue.add(new int[] {newX, newY});
          }
        }
      }
    }

  }
}

