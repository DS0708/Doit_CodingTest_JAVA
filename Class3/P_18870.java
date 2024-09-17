package Class3;

import java.io.*;
import java.util.*;

public class P_18870 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Integer[] arr = new Integer[n];
        Integer[] sortedArr = new Integer[n];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            sortedArr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(sortedArr);

        int index = 0;

        for(int i=0; i<n; i++){
            if(!map.containsKey(sortedArr[i])){
                map.put(sortedArr[i],index);
                index++;
            }
        }

        for(int i=0; i<n; i++){
            bw.write(map.get(arr[i])+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

//수직선 위에 N개의 좌표 : x1 ~ xn
//이 좌표에 좌표 압축 적용
// xi를 좌표 압축한 결과 x'i의 값은 xi > xj를 만족하는 서로 다른 좌표 xj의 개수와 같아야 한다.
// x1~xn에 좌표 압축을 적용한 결과를 출력

//입력
//N , 1<=N<=1,000,000
// x1 x2 ... xn , -10^9 <= xi <= 10^9
