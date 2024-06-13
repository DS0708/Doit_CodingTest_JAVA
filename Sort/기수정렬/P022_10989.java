package Sort.기수정렬;

import java.io.*;

public class P022_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        for (int i=0; i<n ;i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        Radix_sort(A,5);

        for (int i=0; i<n; i++){
            bw.write(A[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void Radix_sort(int[] A, int scaleNum){
       int count = 1;
       int scale = 1;

       while(count <= scaleNum){
         int[] output = new int[A.length];
         int[] bucket = new int[10];

         //각 자리숫자가 현재 어디에 위치하는지 부분합을 통해 index를 뽑는다.
         for(int i=0; i<A.length; i++){
           int bucketIndex = A[i]/scale%10;
           bucket[bucketIndex]++;
         }
         for(int i=1; i<10; i++){
           bucket[i] += bucket[i-1];
         }
         //bucket은 현재 몇 개가 존재하는지에 대한 부분합이므로 결과의 Index와 동일함.
         for(int i=A.length-1; i>=0; i--){
           int bucketIndex = A[i]/scale%10;
           int outputIndex = bucket[bucketIndex] - 1;
           output[outputIndex] = A[i];
           bucket[bucketIndex]--;
         }
         //자바에서 함수 호출은 Call by Value방식으로 깊은 복사를 해야지 A의 실제 객체에 접근할 수 있다.
         for(int i=0; i<A.length; i++){
           A[i] = output[i];
         }

         count++;
         scale *= 10;
       }
    }

}

