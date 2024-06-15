package NumberTheory.유클리드호제법;

import java.io.*;
import java.util.*;

public class P042_1934 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for(int i=0; i<t; i++){
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      int gcdN = gcd(Math.max(n1,n2),Math.min(n1,n2));
      System.out.println(n1*n2/gcdN);
    }
  }

  public static int gcd(int n1,int n2){
    if(n2==0) return n1;

    return gcd(n2,n1%n2);
  }
}
