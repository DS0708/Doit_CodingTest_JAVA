package Sort.기수정렬;

import java.io.*;
import java.util.*;

public class P022_10989 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        for(int i=1 ;i<=N; i++)  arr[i] = Integer.parseInt(br.readLine());

        radixSort(5);

        for(int i=1 ;i<=N; i++)  bw.write(arr[i]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void radixSort(int max){
        int count = 0;
        int jarisu = 1;
        int[] temp = new int[N+1];
        while(count!=max){
            int[] bucket = new int[10];

            for(int i=1; i<=N; i++){
                int curNum = (arr[i]/jarisu)%10;
                bucket[curNum]++;
            }

            for(int i=1; i<10; i++){
                bucket[i] += bucket[i-1];
            }

            for(int i=N; i>=1; i--){
                int curNum = (arr[i]/jarisu)%10;
                temp[bucket[curNum]] = arr[i];
                bucket[curNum]--;
            }

            for(int i=1; i<=N; i++){
                arr[i] = temp[i];
            }

            jarisu*=10;
            count++;
        }
    }

}

