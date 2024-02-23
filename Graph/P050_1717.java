package Graph;

import java.io.BufferedReader;
import java.util.Scanner;

public class P050_1717 {
  static int parent[];
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    parent = new int[n+1];

    for(int i=0; i<=n ; i++) parent[i] = i;

    for (int i=0; i<m; i++){
      int question = scanner.nextInt();
      int a = scanner.nextInt();
      int b = scanner.nextInt();

      if (question == 0) union(a,b);
      else {
        if (checkSum(a,b)) System.out.println("YES");
        else System.out.println("NO");
      }
    }
  }

  static int find(int num){
    if (num == parent[num]) return num;
    else {
//      parent[num] = find(parent[num]);
//      return num;
      return parent[num] = find(parent[num]);
    }
  }

  static void union(int a, int b){
    a = find(a);
    b = find(b);
    if (a!=b) parent[b] = a;
  }

  static boolean checkSum(int a, int b){
    a = find(a);
    b = find(b);
    if (a==b) return true;
    else return false;
  }
}
