package DataStructure.슬라이딩윈도우;

import java.util.Scanner;

public class P009_12891 {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int s = scan.nextInt();
      int p = scan.nextInt();
      int count = 0;
      String str = scan.next();
      int[] checkArr = new int[24];
      int[] curArr = new int[24];
      char[] strArr = str.toCharArray();
      int indexA = 'A' - 'A';
      int indexC = 'C' - 'A';
      int indexG = 'G' - 'A';
      int indexT = 'T' - 'A';

      checkArr[indexA] = scan.nextInt();
      checkArr[indexC] = scan.nextInt();
      checkArr[indexG] = scan.nextInt();
      checkArr[indexT] = scan.nextInt();

      for(int i=0; i<p; i++){
        curArr[strArr[i]-'A']++;
      }

      for(int i=p-1; i<s; i++){
        if(i!=p-1){
          curArr[strArr[i-p]-'A']--;
          curArr[strArr[i]-'A']++;
        }
        if(curArr[indexA] >= checkArr[indexA] && curArr[indexC] >= checkArr[indexC] && curArr[indexG] >= checkArr[indexG] && curArr[indexT] >= checkArr[indexT]){
          count ++;
        }
      }

      System.out.println(count);
    }
}
