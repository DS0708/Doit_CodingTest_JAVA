package Sort.퀵정렬;

import java.util.*;
import java.io.*;

public class P019_11004 {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        QuickSort(1,N);
        System.out.println(arr[K]);

    }

    static void QuickSort(int start, int end){
        if(start < end){
            int partitionIndex = partition(start,end);

            QuickSort(start,partitionIndex-1);
            QuickSort(partitionIndex+1, end);
        }
    }

    static int partition(int start, int end){
        int mid = start+end/2;
        swap(mid,end);
        int pivot = arr[end];
        int i = start-1;

        for(int j=start; j<=end-1; j++){
            if(arr[j] < pivot){
                i++;
                swap(i,j);
            }
        }

        swap(i+1,end);
        return i+1;
    }



    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}


// N개의 수, K번째
// N개의 수 오름차순 정렬해서 K번째 수 구하기
// N의 범위는 5,000,000이고 제한 시간은 2초 이므로, 2,000,000,000안에 해결해야 한다.
// log5,000,000은 2^10이 1000이라고 가정하면, 2^10 * 2^10 * 2^2 = 약 4,000,000 이므로 23정도 된다.
// 그러면 5,000,000 * 23 <= 2,000,000,000이므로 O(nlogn)의 알고리즘으로 해결해야 한다.

//partition 알고리즘
// 4 2 3 1 7 3
// i = 0, j = 1 -> arr[j] > pivot -> j++
// i=0, j = 2 -> arr[j] < pivot -> i++, swap(i,j) -> swap(1,2) -> 2 4 3 1 7 3, j++
// i=1, j = 3 -> arr[j] >= pivot -> j++
// i=1, j= 4 -> arr[j] < pivot -> i++, swap(i,j) -> swap(2,4) -> 2 1 3 4 7 3, j++
// i=2, j=5 -> arr[j] >= pivot -> j++ -> j=6 > end-1 = 5 이므로 종료
// 그리고 i+1과 end를 스왑 -> 2 1 3 4 7 3 에서 마지막의 3과 i+1인 3번째 자리의 3을 스왑