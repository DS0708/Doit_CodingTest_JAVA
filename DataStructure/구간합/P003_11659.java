package DataStructure.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P003_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        long[] S = new long[suNo+1];


        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=suNo; i++){
            S[i]  = S[i-1]+Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=quizNo; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(S[end]-S[start-1]);
        }
    }
}
