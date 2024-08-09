package Graph.플로이드워셜;

import java.util.*;
import java.io.*;

public class P061_11404{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    long[][] distance = new long[N+1][N+1];
    long maxDis = 100000001; //비용의 최대값이 100,000이고 이것이 최대 N번 더해질 수 있으니, 최댓값은 100,000 * 100 이다.
    for(int i=1 ; i<=N; i++){
      for(int j=1; j<=N; j++){
        if(i==j) continue;
        distance[i][j] = maxDis;
      }
    }

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      distance[a][b] = Math.min(distance[a][b],c);
    }

    //플로이드 와샬
    //플로이드 와샬 알고리즘 시간 복잡도 O(V^3)
    //N이 100이 최대이므로 1000000 이고
    //1초 안에 실행 가능하므로
    //모든 노드에서 노드의 최단거리를 구하는 플로이드 와샬 알고리즘 적용 가능
    for(int k=1; k<=N; k++){
      for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            distance[i][j] = Math.min(distance[i][j], distance[i][k]+distance[k][j]);
        }
      }
    }

    for(int i=1; i<=N; i++){
      for(int j=1; j<=N; j++){
        if(distance[i][j] < maxDis) System.out.print(distance[i][j]+" ");
        else System.out.print(0+" ");
      }
      System.out.println();
    }

  }
}

// n개의 도시
// 출발 -> 도착 인 m개의 버스
// 모든 도시의 쌍 (A,B)에 대해서 필요한 최소 비용 구하기


//입력
// 2 <= n <= 100
// 1 <= m <= 100,000
// 1<= 비용 <= 100,000
// n
// m
// 셋째줄부터 m+2줄까지 버스의 정보 -> 출발 도착 비용

// 시작 도시와 도착 도시가 같은 경우는 없다
// 시작 도시와 도착 도시를 연결하는 노선은 여러개이다.

//출력
// n개의