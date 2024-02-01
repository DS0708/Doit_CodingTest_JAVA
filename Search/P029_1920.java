package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P029_1920 {
    static int A[];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        int find_arr[];
        int find;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        find = Integer.parseInt(br.readLine());
        find_arr = new int[find];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<find; i++){
            find_arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i=0; i<find; i++){
            BinarySearch(find_arr[i]);
        }
    }

    public static void BinarySearch(int key){
        int start = 0;
        int end = N-1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (key == A[mid]){
                System.out.println(1);
                return;
            }else if (key > A[mid]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        System.out.println(0);
    }
}
