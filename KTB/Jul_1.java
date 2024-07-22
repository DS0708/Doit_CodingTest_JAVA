package KTB;

import java.io.*;
import java.util.*;

public class Jul_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] H = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            H[i] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++){
            char D = st.nextToken().charAt(0);
            //1.
            int culH = H[x] + i;
            if(culH >= M){
                result+= culH;
                H[x] = i*(-1);
            }
            //2.
            if(D=='L'){
                if(x==1) x=N;
                else x-=1;
            }else if(D=='R'){
                if(x==N) x=1;
                else x+=1;
            }
            //3.
            // for(int j=1; j<=N; j++) H[j]++;
        }

        System.out.println(result);
    }
}

//문제--

//나무 N그루, 원형  모양 (1번째 2번쨰 ... N번쨰 .. 1번쨰)
//높이가 M이상인 나무만 벌목가능
//벌목 과정을 총 Q회 반복
//구름이의 현재 위치는 x번째 나무가 있는 곳

//벌목순서
//1. x번째 나무의 높이가 M이상이면 벌목, 구름이의 목재량은 벌목한 만큼 증가, 해당 나무의 크기는 0이됨
//2. L, R, S 중 하나로 이동
//3. 모든 나무들의 높이가 1씩 자란다.

//벌목과정 Q회 후 구름이가 소지한 목재량은 ??

//입력
//N M xs
//나무의 초기 높이 (H가 N개)
//Q
//D는 벌목순서 2번에서 움직이는 순서
