package inflearn.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Inf02_02 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int count = 1;

        for(int i=1;i<n;i++){
            if (max < arr[i]){
                count ++;
                max = arr[i];
            }
        }

        System.out.println(count);
    }
}
