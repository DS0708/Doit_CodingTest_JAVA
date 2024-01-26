package Sort;

import java.io.*;

public class P022_10989 {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        A = new int[n];

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

    public static void Radix_sort(int[] A, int max_size){
        int[] ouput = new int[A.length];
        int count = 1;
        int jarisu = 1;

        while(count <= max_size){
            int[] bucket = new int[10];

            //bucket에 자리수 추가
            for (int i=0; i<A.length; i++){
                bucket[(A[i]/jarisu)%10]++;
            }

            //bucket 합 배열 생성 (index를 정해주기 위해)
            for (int i=1; i<bucket.length; i++){
                bucket[i] = bucket[i]+bucket[i-1];
            }

            //output배열에 자릿수의 크기 순서대로 저장
            //높은 인덱스 부터 저장하므로 직전 자리수대로 정렬되었기 때문에 A.length 부터 0순서대로 output배열에 넣어줘야 한다.
            // ex) 0부터 시작했을때, A= 2,3 이면 jarisu가 10일때 bucket[0] = 2, 이므로 ouput[1] = 2, ouput[0] = 3 이 되므로 반대로 넣어줘야함.
            for (int i=A.length-1; i>=0; i--){
                ouput[bucket[(A[i]/jarisu)%10]-1] = A[i];       //bucket의 합배열의 값 - 1 = output's index
                bucket[(A[i]/jarisu)%10]--;                     //bucket의 합배열 값 -1
            }

            //A <= output
            for (int i=0; i<A.length; i++){
                A[i] = ouput[i];
            }

            count++;
            jarisu *= 10;
        }

    }
}
