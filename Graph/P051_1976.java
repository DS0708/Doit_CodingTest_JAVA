package Graph;

import java.util.Scanner;

public class P051_1976 {
  static int parent[];
  static int city[][];
  static int route[];
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    parent = new int[N];
    city = new int[N][N];
    route = new int[M];
    //parent 초기화
    for (int i=0; i<N; i++) parent[i] = i;
    //city 값 입력
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        city[i][j] = scanner.nextInt();
      }
    }
    //route 값 입력
    for (int i=0; i<M ; i++) route[i] = scanner.nextInt()-1;
    //city 순회
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if (city[i][j]==1) union(i,j);
      }
    }
    //연결 여부 확인
    boolean check = true;
    for(int i=0; i<M-1; i++){
      if (find(route[i]) != find(route[i+1])){
        check = false;
        break;
      }
    }
    //결과값 출력
    if (check) System.out.println("YES");
    else System.out.println("NO");
  }
  static void union(int a, int b){
    a = find(a);
    b = find(b);
    if (a!=b) parent[b]=a;
  }
  static int find(int num){
    if (parent[num]==num) return num;
    else{
      return parent[num]=find(parent[num]);
    }
  }
}
