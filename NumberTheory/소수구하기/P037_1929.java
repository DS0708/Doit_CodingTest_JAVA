package NumberTheory.소수구하기;

import java.util.Scanner;

public class P037_1929 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        boolean[] arr = new boolean[N+1];
        arr[1] = true; //1을 꼭 제외해줘야함 !!

        for(int i=2; i<=Math.sqrt(N); i++){
          if(!arr[i]){
            int num = i+i;
            while(num <= N){
              arr[num] = true;
              num += i;
            }
          }
        }

        for(int i=M; i<=N; i++){
          if(!arr[i]) System.out.println(i);
        }
    }
}
