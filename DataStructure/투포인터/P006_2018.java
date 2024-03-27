package DataStructure.투포인터;

import java.util.Scanner;

public class P006_2018 {
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
            // 분기문 하나때문에 시간초과됨에 주의하자 -> 분기문을 하나라도 더 줄여야함
        }
        System.out.println(count);
    }
}
