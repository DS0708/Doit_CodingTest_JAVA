package NumberTheory;

import java.util.Scanner;

public class P040_1016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long Min = scanner.nextLong();
        long Max = scanner.nextLong();
        boolean check[] = new boolean[(int)(Max-Min)+1];
        int count = 0;

        for(long i=2; i*i<=Max; i++){
            long pow = i * i;
            long start_index = Min/pow;
            if (Min%pow!=0) start_index++;
            //Logic
            for (long j=start_index; pow*j<=Max; j++){
                check[(int)(pow*j-Min)] = true;
            }
        }

        //결과 개수 구하기
        for (int i=0; i<check.length; i++){
            if (!check[i]) count++;
        }
        System.out.println(count);
    }
}
