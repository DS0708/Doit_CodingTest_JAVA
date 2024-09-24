package Class3;

import java.io.*;
import java.util.*;

public class P_2805 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Integer[] tree = new Integer[N];
        for(int i=0; i<N; i++) tree[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(tree,(o1,o2)->o2-o1);

        //N==1일때, 예외 케이스
        if(N==1) {
            System.out.println(tree[0]-M);
            return;
        }

        //구간 찾기
        int hit=0;
        int hitCount = 0;
        for(int i=1; i<N; i++){
            hitCount += (tree[i-1] - tree[i]) * i;
            if(hitCount >= M){
                hit = i;
                break;
            }
        }
        //구간에서 정확한 값 찾기
        int answerCount = 0;
        while(hitCount >= M){
            hitCount -= hit;
            answerCount++;
        }

        answerCount--;

        System.out.println(tree[hit]+answerCount);
    }
}

//나무 M미터가 필요함
//목재절단기로 나무를 구할 것임

// 목재절단기 작동 :
// 높이 H지정 -> 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라감
// 한 줄에 연속해있는 나무를 모두 절단 -> H보다 높이가 큰 나무는 H위의 부분이 잘림
// 나무를 필요한 만큼만 가져 갈 것임

// M미터의 나무를 집에 가져가기 위해, 절단기에서 설정할 수 있는 높이의 최댓값은

//입력
// 나무의 수 N, 집으로 가져가려고 하는 나무의 길이 M
// 1<= N <= 1,000,000
// 1<= M <= 2,000,000,000


//연습장
//46 42 40 26 4
// if cut 26, 14+16+20 = 50
// 4 + 2*2 + 3*14 = 50
// 3 * 10 = 30
