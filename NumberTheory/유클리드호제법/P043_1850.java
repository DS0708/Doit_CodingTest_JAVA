package NumberTheory.유클리드호제법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P043_1850 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long n1 = Long.parseLong(st.nextToken());
    long n2 = Long.parseLong(st.nextToken());
    long gcdN = gcd(Math.max(n1,n2), Math.min(n1,n2));

    for(int i=0; i<gcdN; i++){
      bw.write("1");
    }
    bw.flush();
    bw.close();
    br.close();
  }

    public static long gcd(long n1, long n2){
        if (n2 ==0 ) return n1;
        else return gcd(n2,n1%n2);
    }
}
