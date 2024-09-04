package Programmers;

import java.util.*;

class TheMostGift {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length; //친구 수
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numMap = new HashMap<>();

        //index는 0부터
        for(int i=0; i<n; i++){
            nameMap.put(friends[i],i);
            numMap.put(i,friends[i]);
        }

        int[][] map = new int[n][n];
        int[] giftNum = new int[n];

        for(String gift : gifts){
            String[] input = gift.split(" ");
            int giver = nameMap.get(input[0]);
            int receiver = nameMap.get(input[1]);
            map[giver][receiver]++;
            giftNum[giver]++;
            giftNum[receiver]--;
        }

        for(int i=0; i<n; i++){
            int count=0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(map[i][j]>map[j][i]) count++;
                else if(map[i][j]==map[j][i]){
                    if(giftNum[i] > giftNum[j]) count++;
                }
            }
            answer = Math.max(answer, count);
        }


        return answer;
    }
}

// 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측

// 1. if (A->B,5) (B->A,3) ,  A가 B에게 선물을 하나 받음
// 2. 두 사람이 선물 주고받은 기록이 없거나 같으면, 선물 지수가 더 큰 사람이 작은 사람에게 받음
//      선물 지수 : 준 선물의 수 - 받은 선물의 수
// 3. 만약 선물 지수까지 같다면, 선물을 주고 받지 않는다.

// 선물을 가장 많이 받을 친구가 받을 선물의 수


// 입력: friends(친구들의 이름을 담은 1차원 문자열 배열), 선물 기록을 담은 1차원 문자열 배열(gifts)
// 2<= friends.length <= 50, 1<= gifts.length <= 10,000
// friends는 길이가 10이하인 문자열이며 이름이 동일한 친구는 없다.
// gifts의 원소는 "A B"형태의 문자열이며, A가 B에게 선물을 줬다는 뜻 ( A, B 는 friends에 속한다.)




