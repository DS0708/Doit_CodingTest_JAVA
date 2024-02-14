package NumberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P038_1456 {
    static int max_num = 10000001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long Min = Long.parseLong(st.nextToken());
        long Max = Long.parseLong(st.nextToken());
        long result = 0l;
        int prime[] = new int[max_num];

        for (int i=2; i<max_num; i++){
            prime[i] = i;
        }

        for (int i=2; i<=Math.sqrt(max_num); i++){
            if(prime[i]==0) continue;
            for (int j=i+i; j<max_num; j+=i) prime[j] = 0;
        }

        for (int i = 2; i<max_num; i++) {
            if (prime[i] == i) {
                long j = i;
                while ((double)j <= (double) Max/(double) i) {
                    if ((double)j >= (double) Min/(double) i) {
                        result++;
                    }
                    j *= i;
                }
            }
            /*
            * 1. Max 와 Min의 범위는 10^14보다 작으므로 10^14의 제곱은 long형의 범위를 벗어나므로 Max/i, Min/i 와 비교
            * 2. double은 부동소수점의 정확도가 높아져서 double을 사용해야 맞는다 ? 참나
            * */
        }


        System.out.println(result);
    }
}
