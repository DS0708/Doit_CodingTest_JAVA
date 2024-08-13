package Sort.버블정렬;

import java.util.*;


public class P015_2750 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = scan.nextInt();
        }

        for(int i=1; i<=n-1; i++){
            for(int j=1; j<=n-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i=1; i<=n ; i++) System.out.println(arr[i]);
    }
}
