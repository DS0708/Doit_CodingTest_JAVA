package Search.binary;

import java.util.Scanner;

public class P031_1300 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        long start = 1;
        long end = K;

        while (start <= end){
            long mid = (start+end)/2;
            long count = 0;

            for(int i=1;i<=N;i++){
                count += Math.min(N,mid/i);
            }

//            if (count == K){
//                start = mid;
//                break;
//            }     // 왜 안되는지 모르겠음

            if (count < K){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
