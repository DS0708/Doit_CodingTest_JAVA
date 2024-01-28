package Search;

import java.util.Scanner;

public class P024_2023 {
    static int n;
    public static void main(String[] args) {
        n = new Scanner(System.in).nextInt();

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    public static void DFS(int num, int jarisu){
        if(jarisu == n){
            if(isPrime(num)){
                System.out.println(num);
                return;
            }
        }
        for (int i=1; i<=9; i+=2){
            if(isPrime(num*10+i)){
                DFS (num*10 + i, jarisu+1);
            }
        }
    }

    public static Boolean isPrime(int num){
        for (int i=2; i<=num/2; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}
