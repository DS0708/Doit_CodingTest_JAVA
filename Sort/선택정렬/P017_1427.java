package Sort.선택정렬;

import java.util.Scanner;

public class P017_1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int A[] = new int[str.length()];

        for (int i=0; i<str.length(); i++){
            A[i] = Integer.parseInt(str.substring(i,i+1));
        }

        for (int i=0; i<str.length()-1; i++){
            int max = i;
            for (int j=i+1; j<str.length(); j++){
                if(A[max] < A[j]) max = j;
            }
            if (A[i] < A[max]){
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        for (int i=0; i<str.length(); i++){
            System.out.print(A[i]);
        }
    }
}
