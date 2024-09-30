package inflearn.array;

import java.util.*;

public class Inf02_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int MAX = (int)1e5;
        boolean[] isPrime = new boolean[MAX+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for(int i=2; i<=MAX; i++){
            if(!isPrime[i]) continue;

            for(int j=i+i; j<=MAX; j+=i){
                isPrime[j] = false;
            }
        }

        String[] input = scanner.nextLine().split(" ");
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(input[i]);
            int num = 0;
            while(tmp!=0){
                num = num*10 + tmp%10;
                tmp /= 10;
            }
            if(isPrime[num]) System.out.print(num+" ");
        }
    }
}
