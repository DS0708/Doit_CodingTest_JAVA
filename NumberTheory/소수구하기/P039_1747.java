package NumberTheory.소수구하기;

import java.util.Scanner;

public class P039_1747 {
    static int max_num = (int)Math.pow(10,7);
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int prime[] = new int[max_num+1];

        prime[2] = 2;
        for (int i=3; i<prime.length; i+=2) prime[i] = i;
        for (int i=3; i<=Math.sqrt(prime.length); i+=2){
            if (prime[i] == 0 ) continue;
            for (int j=i+i; j<prime.length; j+=i) prime[j] = 0;
        }

        for (int i=N; i<prime.length; i++){
            if (prime[i] != 0 && isPalindrome(i)){
                System.out.println(i);
                break;
            }
        }
    }

    static boolean isPalindrome(int target){
        String str = String.valueOf(target);
        int start = 0;
        int end = str.length()-1;
        while (start < end){
            if (str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
