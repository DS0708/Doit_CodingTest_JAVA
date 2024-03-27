package DataStructure.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P008_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        long count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i=0; i<n; i++){
            int start = 0;
            int end = n - 1;

            while (start < end){
                long sum = arr[start] + arr[end];

                if(sum == arr[i]){
                    if (start != i && end !=i){
                        count++;
                        break;
                    }else if (start == i){
                        start ++;
                    }else if (end ==i){
                        end --;
                    }
                } else if (sum > arr[i]) {
                    end --;
                }else {
                    start ++;
                }
            }
        }

        System.out.println(count);

    }
}
