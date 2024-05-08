package Combination;

import java.util.ArrayList;
import java.util.Scanner;

public class P081_1722 {
  static int n;
  static long[] factorial;
  static ArrayList<Integer> list;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    factorial = new long[n+1];
    factorial[0] = 1;
    list = new ArrayList<>();
    for(int i=1; i<=n; i++){
      factorial[i] = factorial[i-1] * i;
      list.add(i);
    }
    int problemNum = scan.nextInt();
    if(problemNum == 1){
      long k = scan.nextLong(); //int로 받으면 안됨
      problem01(k);
    }else {
      int[] arr = new int[n+1];
      for(int i=1; i<=n; i++){
        arr[i] = scan.nextInt();
      }
      problem02(arr);
    }
  }
  static void problem01(long k){
    int index = 0;
    int fac = n-1;
    while(!list.isEmpty()){
      if(factorial[fac] >= k){
        System.out.print(list.get(index)+" ");
        list.remove(index);
        index = 0;
        if(fac != 1){
          fac --;
        }
      }else{
        k -= factorial[fac];
        index++;
      }
    }
  }
  static void problem02(int[] arr){
    int fac = n-1;
    long result = 1;
    for(int i=1; i<=n; i++){
      int cnt = 0;
      while(arr[i] > list.get(cnt)){
        cnt++;
      }
      result += cnt * factorial[fac];
      list.remove(cnt);
      fac--;
    }
    System.out.println(result);
  }
}
