package Sort.버블정렬;

import java.util.Scanner;

public class P015_2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int A[] = new int[N];

        for (int i=0; i<N; i++){
            A[i] = scanner.nextInt();
        }

        for (int i=0; i<N-1; i++){
            for (int j=0; j<N-1-i; j++){
                if (A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }

        for (int i=0; i<N; i++){
            System.out.println(A[i]);
        }
    }
}
