package inflearn.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Inf02_03 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];

        for(int i=0;i<n;i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) B[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            if (A[i]==B[i]) System.out.println("D");
            else if (A[i]==1 && B[i]==3) System.out.println("A");
            else if (A[i]==2 && B[i]==1) System.out.println("A");
            else if (A[i]==3 && B[i]==2) System.out.println("A");
            else System.out.println("B");
        }
    }
}
