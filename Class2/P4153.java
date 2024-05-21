package Class2;

import java.io.*;
import java.util.*;

public class P4153 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st ;

    while(true){
      st = new StringTokenizer(br.readLine());
      int[] sides = new int[3];
      for(int i=0; i<3; i++){
        sides[i] = Integer.parseInt(st.nextToken());
      }

      if(sides[0] == 0 && sides[1] ==0 && sides[2]==0) break;

      Arrays.sort(sides);

      if (sides[2]*sides[2] == (sides[0]*sides[0] + sides[1]*sides[1])){
        System.out.println("right");
      }else{
        System.out.println("wrong");
      }
    }


  }

}
