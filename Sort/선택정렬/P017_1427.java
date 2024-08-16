package Sort.선택정렬;

import java.util.*;
import java.io.*;

public class P017_1427 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];

        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i=2; i<=N; i++){
            int insertPoint = i;
            for(int j=i-1; j>=0; j--){
                if(arr[insertPoint] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[insertPoint];
                    arr[insertPoint] = temp;
                    insertPoint--;
                }
                else break;
            }
        }

        int[] sumArr = new int[N+1];
        for(int i=1; i<=N; i++) sumArr[i] = arr[i] + sumArr[i-1];

        int sum = 0;
        for(int i=1; i<=N; i++) sum += sumArr[i];

        System.out.println(sum);
    }
}


//ATM 1대, N명의 사람이 줄을 서있음. -> 사람은 1~N
// i번째 사람이 돈을 인출하는데 걸리는 시간은 Pi분
// i번째 사람이 돈을 뽑는데 걸리는 시간 = P1 + P2 + ... + Pi


//알고리즘
// 오름차순 정렬
// N은 1000이하, Pi도 1000이하 이므로
// 최대 Pi 1000이 1000번 더해질 수 있으므로, 결과의 최댓값은 1,000,000 이므로 int형 가능
// 알고리즘의 경우 N의 범위가 1000이하이고 시간 제한이 1초이니까, O(n^2*Logn)까지 가능할듯
