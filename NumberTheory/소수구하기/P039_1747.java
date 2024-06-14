package NumberTheory.소수구하기;

import java.util.Scanner;

public class P039_1747 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    boolean[] isNotPrime = new boolean[10000001];

    //소수 구하기
    isNotPrime[1] = true;
    for(int i=2; i<=Math.sqrt(10000000); i++){
      if(!isNotPrime[i]){
        int num = i+i;
        while(num <= 10000000){
          isNotPrime[num] = true;
          num +=i;
        }
      }
    }

    while(true){
      if(!isNotPrime[n]){
        if(isPalindrome(n)){
          System.out.println(n);
          break;
        }
      }
      n++;
    }
  }

  static boolean isPalindrome(int num){
    String str = String.valueOf(num);
    char[] charArr = str.toCharArray();
    int s = 0;
    int e = charArr.length-1;
    boolean check = true;

    while(s<=e){
      if(charArr[s] != charArr[e]){
        check = false;
        break;
      }
      s++;
      e--;
    }

    return check;
  }

}
