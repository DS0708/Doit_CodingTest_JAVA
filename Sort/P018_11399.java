package Sort;

import java.util.Scanner;

public class P018_11399 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int A[] = new int[n];
        int S[] = new int[n];
        int sum=0;

        for (int i=0; i<n; i++){
            A[i] = scan.nextInt();
        }

        for (int i=1; i<n; i++){
            int insert_point = i;
            int insert_value = A[i];
            // 자리찾기
            for (int j=i-1; j>=0 ; j--){
                if(A[j]<A[i]){
                    insert_point = j+1;
                    break;
                }
                if (j==0) insert_point=0;
            }
            // 자리까지 shift 연산
            for (int j=i; j>insert_point; j--){
                A[j] = A[j-1];
            }
            //적절한 위치에 삽입
            A[insert_point] = insert_value;
        }

        //합 배열
        S[0] = A[0];
        for (int i=1; i<n ; i++){
            S[i] = S[i-1] + A[i];
        }

        //합 배열 합 구하기
        for (int i=0; i<n ;i++){
            sum += S[i];
        }
        System.out.println(sum);
    }
}
