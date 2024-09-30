package inflearn.array;

import java.util.Scanner;

public class Inf02_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int check = 0;
        int answer = 0;

        for(int i=0; i<n; i++) {
            int num = scanner.nextInt();
            if(num==0) check = 0;
            else check ++;
            answer += check;
        }
        System.out.println(answer);
    }
}
