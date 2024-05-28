package DynamicProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P090_9252 {
  static int[][] LCS;
  static String str1;
  static String str2;
  static ArrayList<Character> answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    str1 = br.readLine();
    str2 = br.readLine();
    LCS = new int[str1.length() + 1][str2.length()+1];
    answer = new ArrayList<>();

    for(int i=1; i<=str1.length(); i++){
      for(int j=1; j<=str2.length(); j++){
        if(str1.charAt(i-1) == str2.charAt(j-1)) LCS[i][j] = LCS[i-1][j-1] + 1;
        else LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
      }
    }

    System.out.println(LCS[str1.length()][str2.length()]);

    getAnswer(str1.length(), str2.length());

    for(int i=answer.size()-1; i>=0; i--){
      System.out.print(answer.get(i));
    }

    br.close();
  }
  static void getAnswer(int a, int b){
    if(a == 0 || b ==0) return;
    if(str1.charAt(a-1) == str2.charAt(b-1)){
      answer.add(str1.charAt(a-1));
      getAnswer(a-1, b-1);
    }else{
      if (LCS[a-1][b] > LCS[a][b-1]) getAnswer(a-1, b);
      else getAnswer(a,b-1);
    }
  }
}
