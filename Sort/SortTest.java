package Sort;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class SortTest {
  static int[] A;
  static int[] temp;
  static long result;
  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    A = new int[n];
    temp = new int[n];

    result = 0;

    st = new StringTokenizer(br.readLine());

    for (int i=0; i<n ;i++){
      A[i] = Integer.parseInt(st.nextToken());
    }

    merge_sort(0,n-1);

    System.out.println(result);

  }

  public static void merge_sort(int start, int end){
    if (end - start < 1) return;

    int mid = (start + end)/2;

    merge_sort(start,mid);
    merge_sort(mid+1,end);

    for(int i=start; i<=end; i++){
      temp[i] = A[i];
    }

    int current = start;
    int index1 = start;
    int index2 = mid+1;

    while(index1 <= mid && index2 <= end){
      if (temp[index1] > temp[index2]){
        A[current] = temp[index2];
        //mergeSort에 swap 몇 번 했는지 더하는 로직 추가
        result += Math.max(0,index2-current);
        current++;
        index2++;
      }else {
        A[current] = temp[index1];
        //mergeSort에 swap 몇 번 했는지 더하는 로직 추가
        result += Math.max(0,index1-current);
        current++;
        index1++;
      }
    }
    while (index1 <= mid){
      A[current] = temp[index1];
      //mergeSort에 swap 몇 번 했는지 더하는 로직 추가
      result += Math.max(0,index1-current);
      current++;
      index1++;
    }
    while (index2 <= end) {
      A[current] = temp[index2];
      //mergeSort에 swap 몇 번 했는지 더하는 로직 추가
      result += Math.max(0,index2-current);
      current++;
      index2++;
    }
  }

}


