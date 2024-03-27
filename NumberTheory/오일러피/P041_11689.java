package NumberTheory.오일러피;

import java.util.Scanner;

public class P041_11689 {
    public static void main(String[] args) {
        long N = new Scanner(System.in).nextLong();
        long result = N;
        for (long i=2; i<=Math.sqrt(N);i++){ //제곱근까지만 진행
            if (N%i ==0){                    //i가 소수인지 확인하기
                result = result - result/i; // 결과값 업데이트 -> 오일러 피 공식
                while (N%i==0) N /= i;      // 2^2*5 이면 2^2를 없애고 5만 남김
            }
        }
        if(N>1) result = result - result/N;
        System.out.println(result);
    }
}
