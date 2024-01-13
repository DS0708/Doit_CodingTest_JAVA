package DataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class P007_1940 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        long m = scan.nextLong();
        long[] arr = new long[n];
        long count = 0;

        int start = 0;
        int end = n-1;

        for (int i=0; i<n; i++){
            arr[i] = scan.nextLong();
        }

        Arrays.sort(arr);

        while(start < end){
            long sum = arr[start] + arr[end];
            if ( sum == m){
                count ++;
                start ++;
                end --;
            } else if (sum > m) {
                end --;
            }else if (sum < m){
                start++;
            }
        }

        System.out.println(count);

    }
}
