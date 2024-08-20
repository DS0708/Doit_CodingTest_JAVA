package Sort.병합정렬;

import java.io.*;
import java.util.*;

public class P021_1517 {
    static int[] arr,tmp;
    static long res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        tmp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;

        mergeSort(1,N);

        System.out.println(res);

        br.close();
    }

    static void mergeSort(int s, int e){
        if(s==e) return;

        int mid = (s+e)/2;

        mergeSort(s,mid);
        mergeSort(mid+1,e);

        int i = s;
        int j = mid+1;
        int index = s;

        while(i<=mid && j<=e){
            if(arr[i]<=arr[j]){
                tmp[index] = arr[i];
                i++;
                index++;
            }else{
                tmp[index] = arr[j];
                res += (j-index);
                j++;
                index++;
            }
        }
        while(i<=mid){
            tmp[index] = arr[i];
            i++;
            index++;
        }
        while(j<=e){
            tmp[index] = arr[j];
            res += (j-index);
            j++;
            index++;
        }

        for(int k=s; k<=e; k++) arr[k] = tmp[k];
    }

}
