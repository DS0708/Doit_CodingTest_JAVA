package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P030_2343 {
    static int A[];
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        int max = -1;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            if(max < A[i]) max = A[i];
            sum += A[i];
        }

        System.out.println(BinarySearch(max,sum));
    }

    public static int BinarySearch(int start, int end){

        while(start <= end){
            int mid = (start + end) / 2;
            int count = 1;
            int has = 0;

            //몇개의 블루레이로 담을 수 있는지 구하기
            for (int i=0; i<N; i++){
                has += A[i];
                if (has > mid){
                    count ++;
                    has = A[i];
                }
            }
            //M보다 작으면 담을 수 있음 -> mid의 크기를 줄여야한다 -> end를 줄이기
            if (count <= M){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return start;
    }
}
