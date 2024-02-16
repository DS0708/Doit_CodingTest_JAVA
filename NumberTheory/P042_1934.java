package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P042_1934 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            // 최대 공약수 구하기
            int gcd = gcd(n1,n2);
            // 최소 공배수 구하기
            bw.write(n1*n2/gcd+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int n1, int n2){
        int big = Math.max(n1,n2);
        int small = Math.min(n1,n2);
        while(big%small!=0){
            int rest = big%small;
            big = Math.max(rest,small);
            small = Math.min(rest,small);
        }

        return small;
    }
}
