package inflearn.string;

import java.util.Scanner;

public class Inf01_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);

        int[] arr = new int[str.length()];
        int p = (int)1e3;

        for(int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == c) {
                p = 0;
            }else {
                p++;
            }
            arr[i] = p;
        }

        p = (int)1e3;

        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == c) p = 0;
            else p++;

            arr[i] = Math.min(arr[i], p);
        }

        for(int i : arr) System.out.print(i+" ");
    }
}
