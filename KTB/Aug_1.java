package KTB;

import java.io.*;
import java.util.*;

class Aug_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        List<Cookie> list = new ArrayList<>();
        Deque<Cookie> deque = new ArrayDeque<>();
        // input -> N
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) list.add(new Cookie(i,Integer.parseInt(st.nextToken())));
        // 정렬 -> NLogN + N
        Collections.sort(list);
        for(Cookie c : list){
            deque.offerLast(c);
        }
        // Greedy algorithm -> N
        boolean zeroCheck = false;
        int day = 0;
        while(!deque.isEmpty()){
            //조건 검사 -> 뒤에서 부터 접근
            if(deque.getFirst().val-day <= 0){
                zeroCheck=true;
                break;
            }else{
                sb.append(deque.pollFirst().index+" ");
            }
            day++;
        }
        //output
        if(zeroCheck){
            for(int i=1; i<=N; i++) System.out.print(i+" ");
        }else{
            System.out.println(sb);
        }
        // 리소스 정리
        br.close();
    }
}

class Cookie implements Comparable<Cookie>{
    int index;
    int val;
    Cookie(int i, int v){
        this.index = i;
        this.val = v;
    }
    @Override
    public int compareTo(Cookie o){
        if(this.val==o.val) return this.index-o.index;
        else return this.val - o.val;
    }
}

// N개의 초코 쿠키
// 1~N, 맛있는 정도는 Ai
// 구매한 날부터 매일 하나씩 먹음
// 하루가 지나면 맛있는 정도가 1씩 감소, 이 수치는 0미만으로 떨어지지 않음
// 구름이가 먹은 모든 쿠키의 맛있는 정도의 곱이 최대가 되어야함 -> 0을 먹으면 안됨

//입력
// N
// A1 A2 ... AN
// 1<= N,Ai <= 100,000
// 모든 수는 정수

//출력
// 쿠키를 먹는 순서에 따라 쿠키의 번호를 출력
// 맛있게 모든 쿠키를 먹는 순서가 여러 가지면, 사전 순으로 제일 앞서는 순서를 출력

//알고리즘
//3초 이므로, N^2은 10초 걸려서, NLogN에 해결 해야함

// if a < b,
// 1. a(b-j)
// 2. b(a-j)
// 1 -> ab - aj
// 2 -> ab - bj
// a<b 이므로 -> 1 > 2
// 그러므로 1번 작은 수 먼저 먹는 경우가 제일 좋음.














