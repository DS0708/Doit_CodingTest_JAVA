package Class3;

import java.util.*;
import java.io.*;

public class P_1074 {
    static int res=0;
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] inputArr = input.split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int r = Integer.parseInt(inputArr[1]) + 1;
        int c = Integer.parseInt(inputArr[2]) + 1;

        getOrder(N,r,c);

        System.out.println(res-1);
    }
    static void getOrder(int N, int r, int c){
        if(N==1){
            if(r==1){
                if(c==1) res+=1;
                else res+=2;
            }else{
                if(c==1) res+=3;
                else res+=4;
            }
        }else{
            int standard = (int)Math.pow(2,N-1);
            int selection = -1;
            if(r <= standard){
                if(c <= standard) selection = 1;
                else selection = 2;
            }else{
                if(c <= standard) selection = 3;
                else selection = 4;
            }
//            //debug
//            System.out.println("N: "+N+", selection : "+selection);
//            //debug
            res += (int)Math.pow(2,2*N-2) * (selection-1);
//            //debug
//            System.out.println("res: "+res);
//            //debug
            if (selection==3 || selection==4)  r -= (int)Math.pow(2,N-1);
            if (selection==2 || selection==4) c -= (int)Math.pow(2,N-1);
//            //debug
//            System.out.println("r: "+r+", c : "+c);
//            //debug
            getOrder(N-1,r,c);
        }
    }
}

//2^N * 2^N 배열을 Z모양으로 탐색
// N > 1, 일때 재귀적으로 2^N-1 로 나눠서 탐색 -> 최대 2*2 배열을 만들어 탐색
// N이 주어질때, r행 c열을 몇 번째로 방문하는지 출력

// 입력
// N r c, 1<=N<=15, 0<= r,c < 2^N

//Idea
// 탐색 영역을 4부분씩 나눠, N으로 정의
// 조건에 맞는 영역을 확정하고
// 그 안에서 재귀적으로 몇 번째인지 구함 -> 구한 값을 계속 더하면 될 듯

//r
//1,2 selection : 1 ~ 4 -> if r <= 2^N-1
//3,4 selection : 5 ~ 8 -> if r > 2^N-1
//c
//1,3 selection : 1 ~ 4 -> if r <= 2^N-1
//2,4 selection : 5 ~ 8 -> if r > 2^N-1

//더하는 수 : 2^2N-2 * (selection-1)
// r : if 3,4 selection, r -= 2^N-1
// c : if 2,4 selection, c -= 2^N-1

