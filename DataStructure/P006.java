package DataStructure;

import java.util.Scanner;

public class P006 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();

        long count = 1;
        long sum = 1;
        long start_index = 1;
        long end_index = 1;

        while(end_index != n){
            if (sum == n){
                count ++;
                end_index ++;
                sum += end_index;
            }
            else if(sum > n){
                sum -= start_index;
                start_index ++;
            }else if (sum < n){
                end_index ++;
                sum += end_index;
            }
        }
        System.out.println(count);
    }
}
