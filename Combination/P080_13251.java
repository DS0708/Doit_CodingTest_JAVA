package Combination;

import java.util.Scanner;

public class P080_13251 {
  public static void main(String[] args) {
    //조합으로 접근하는 경우 오버플로가 발생한다. -> long으로도 안됨
    Scanner scan = new Scanner(System.in);

    int colorNum = scan.nextInt();
    int[] color = new int[colorNum];
    int n = 0;
    for(int i=0; i<colorNum; i++){
      color[i] = scan.nextInt();
      n += color[i];
    }
    int k = scan.nextInt();

    double result = 0.0;

    for(int i=0; i<colorNum; i++){
      if(color[i] < k) continue;  //k보다 작은 color의 경우는 계산할 필요 없음

      double same = 1.0;
      for (int j=0; j<k; j++){
        same *= (double) (color[i]-j) / (n-j); //오버플로 발생때문에 각각 계산해서 곱해주기
      }
      result += same;
    }

    System.out.println(result);
  }
}
