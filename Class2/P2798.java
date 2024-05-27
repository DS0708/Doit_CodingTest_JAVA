package Class2;

import java.io.*;
import java.util.*;

public class P2798 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] A = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){
      A[i] = Integer.parseInt(st.nextToken());
    }
    int result = -1;
    //Brute Force
    for(int i=0; i<n-2; i++){
      for(int j=i+1; j<n-1; j++){
        for(int k = j+1; k<n; k++){
          int sum = A[i] + A[j] + A[k];
          if (result < sum && sum <= m) result = sum;
        }
      }
    }
    System.out.println(result);
  }
}
