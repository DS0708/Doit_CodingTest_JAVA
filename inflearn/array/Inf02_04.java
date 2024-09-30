package inflearn.array;

import java.util.Scanner;

public class Inf02_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 1;

        for (int i=1 ; i<=n ; i++) {
            if(i==1) System.out.print(1+" ");
            else if (i==2) System.out.print(1+" ");
            else {
                arr[i] = arr[i-1] + arr[i-2];
                System.out.print(arr[i] + " ");
            }
        }
    }
}
