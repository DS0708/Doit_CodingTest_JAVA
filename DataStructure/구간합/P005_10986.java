package DataStructure.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P005_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] sum_arr = new long[n+1];
        long[] rest_count_arr = new long[m];
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            sum_arr[i] = sum_arr[i-1] + Integer.parseInt(st.nextToken());

            int rest = (int)(sum_arr[i] % m);     //sum_arr[i]는 long값이기 때문에 % 한 결과를 int로 변환해야 한다.

            if (rest ==0) result++;

            rest_count_arr[rest] ++;
        }

        for (int i=0; i<m ;i++){
            if(rest_count_arr[i] == 0) continue;

            result += rest_count_arr[i] * (rest_count_arr[i]-1) / 2;    //이 부분에서 int 범위를 벗어날 수 있어 result는 long으로 선언해야함
        }

        System.out.println(result);


    }
}
