package inflearn.array;

import java.util.Scanner;

public class Inf02_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
            if(i==0) sb.append(arr[i]).append(" ");
            else{
                if(arr[i] > arr[i-1]) sb.append(arr[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
