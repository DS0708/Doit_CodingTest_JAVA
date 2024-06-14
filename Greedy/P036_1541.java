package Greedy;

import java.util.Scanner;

public class P036_1541 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.next();
    String[] strArray = str.split("-");
    long result = 0;

    for(int i=0; i<strArray.length; i++){
      //split는 정규 표현식을 인자로 받으며 "+"문자는 "하나 이상"이라는 의미로 사용되기 때문에 이스케이프 처리 []를 해줘야한다.
      //이스케이프 처리 예 : \,^,$ ~~ 그냥 에러나면 이스케이프 처리하자... 언제 다외우냐 ...
      String[] plusStr = strArray[i].split("[+]");
      int num = 0;
      for(int j=0; j<plusStr.length; j++){
        num += Integer.parseInt(plusStr[j]);
      }
      if(i==0) result+=num;
      else result -= num;
    }

    System.out.println(result);
  }
}
