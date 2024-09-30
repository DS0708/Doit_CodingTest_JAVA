package inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class Inf02_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);

        for (int i=2; i<=n ;i ++){
            if(!isPrime[i]) continue;

            for(int j=i+i; j<=n; j+=i) isPrime[j] = false;
        }

        int count = 0;

        for(int i=2; i<=n; i++) if(isPrime[i]) count++;

        System.out.println(count);
    }
}
