package Search.dfs;

import java.util.*;

public class P024_2023 {
  static int n;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();

    DFS(2,1);
    DFS(3,1);
    DFS(5,1);
    DFS(7,1);
  }

  static void DFS(int num, int scale){
    if (scale == n){
      System.out.println(num);
      return;
    }else{
      for(int i=1; i<=9; i+=2){
        int newNum = num * 10 + i;
        if(isPrime(newNum)) DFS(newNum,scale+1);
      }
    }
  }

  static boolean isPrime(int num){
    for(int i=2; i<=Math.sqrt(num) ; i++){
      if(num % i ==0) return false;
    }
    return true;
  }

}
