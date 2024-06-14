package Search.binary;

import java.io.*;
import java.util.*;

public class P029_1920 {
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; i++){
      int answer = Integer.parseInt(st.nextToken());
      System.out.println(BinarySearch(answer,0,N-1));
    }
  }

  static int BinarySearch(int n, int s, int e){
    int result = 0;
    while(s <= e){
      int mid = (s+e)/2;
      if(arr[mid]==n){
        result = 1;
        break;
      }else if(arr[mid] > n){
        e = mid-1;
      }else if(arr[mid] < n){
        s = mid+1;
      }
    }

    return result;
  }



}
