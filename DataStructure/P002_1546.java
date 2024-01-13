package DataStructure;

import java.util.Scanner;

public class P002_1546 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int max_score = Integer.MIN_VALUE;

        for (int i=0; i<n; i++){
            int num = scan.nextInt();
            sum += num;
            if (max_score < num) max_score = num;
        }

        System.out.println((sum * 100.0 / max_score / n));
    }
}
