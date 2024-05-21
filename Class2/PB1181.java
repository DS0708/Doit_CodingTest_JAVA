package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PB1181 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<String>[] word = new ArrayList[51];

    for(int i=1; i<=50; i++){
      word[i] = new ArrayList<>();
    }

    for(int i=0; i<n; i++){
      String str = br.readLine();
      int len = str.length();
      word[len].add(str);
    }

    for(int i=1; i<=50; i++){
      if(word[i].size() > 0){
        Set<String> set = new HashSet<>(word[i]);
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for(String s : list){
          System.out.println(s);
        }
      }
    }
  }
}
