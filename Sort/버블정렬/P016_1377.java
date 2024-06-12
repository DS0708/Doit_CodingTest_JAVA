package Sort.버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P016_1377 {
    public static void main(String[] args) throws IOException {
      //스캐너로 하면 메모리 초과 문제도 있다.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      MyData[] arr = new MyData[n];

      for(int i=0; i<n; i++){
        arr[i] = new MyData(Integer.parseInt(br.readLine()), i);
      }

      Arrays.sort(arr);

      int max = 0;

      for(int i=0; i<n; i++){
        max = Math.max(max, arr[i].index-i);
      }

      System.out.println(max+1);
    }
}

class MyData implements Comparable<MyData>{
  int val;
  int index;

  MyData(int v, int i){
    this.val = v;
    this.index = i;
  }

  @Override
  public int compareTo(MyData t){
    return this.val - t.val;
  }
}
