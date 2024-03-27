package Sort.퀵정렬;

import java.util.Arrays;
import java.util.Scanner;

public class P019_11004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int A[] = new int[n];

        for (int i=0; i<n ;i++){
            A[i] = scanner.nextInt();
        }

        quickSort(A,0,n-1,k-1);
        System.out.println(A[k-1]);
    }

    public static void quickSort(int[] A, int Start, int End, int K){
        if(Start < End){
            int pivot = partition(A,Start,End);

            if(pivot == K) {    //더 이상 구할필요 없음
                return;
            }
            else if (pivot > K) {   // K가 pivot의 왼쪽 범위에 위치
                quickSort(A,Start,pivot-1,K);
            }else {         //K가 pivot의 오른쪽 범위에 위치
                quickSort(A,pivot+1,End,K);
            }
        }
    }

    public static int partition(int[] A, int Start, int End){
        //데이터가 두개만 들어오는 경우
        if(Start + 1 == End) {
            if (A[Start] > A[End]){
                swap(A,Start,End);
                return End;
            }
        }

        //나머지 Logic
        int Middle = (Start + End) / 2;
        swap(A,Start,Middle);
        int pivot = A[Start];
        int i = Start +1 ;
        int j = End;

        while(i<=j){
            while(j >= Start+1 && A[j] > pivot) j--;
            while(i <= End && A[i] < pivot) i++;
            if(i<=j)    swap(A,i++,j--);
        }

        // pivot을 j에 저장, j보다 큰 인덱스는 pivot보다 모두 큼이 보장
        swap(A,Start,j);

        return j;
    }

    public static void swap(int[] A, int x, int y){
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
