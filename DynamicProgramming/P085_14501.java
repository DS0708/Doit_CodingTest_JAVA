package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P085_14501 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st ;
    int n = Integer.parseInt(br.readLine());
    int[][] Schedule = new int[2][n+1];
    int[] dpArr = new int[n+2];

    for(int i=1; i<=n; i++){
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      Schedule[0][i] = t;
      Schedule[1][i] = p;
    }

    for(int i=n; i>0; i--){
      if(Schedule[0][i] + i > n+1){
        //그 날 아예 일을 할 수가 없는 경우
        dpArr[i] = dpArr[i+1];
      }else{
        //그 날 일을 할 수 있는 경우에는, 그 날 일을 하는 경우와 안하는 경우 두가지 중 큰 값 선택
        dpArr[i] = Math.max(dpArr[i+1], dpArr[i+Schedule[0][i]] + Schedule[1][i]);
      }
    }

    System.out.println(dpArr[1]);
  }
}
