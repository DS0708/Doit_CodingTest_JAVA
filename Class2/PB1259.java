package Class2;

import java.io.*;

public class PB1259 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    while(!input.equals("0")){
      String reverse = "";
      for(int i=input.length()-1; i>=0; i--){
        reverse += input.charAt(i);
      }

      if(input.equals(reverse)){
        System.out.println("yes");
      }else{
        System.out.println("no");
      }

      input = br.readLine();
    }
  }
}
