package Sort.병합정렬;

import java.util.*;
import java.io.*;

public class P020_2751 {
    static int[] arr,tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        tmp = new int[N+1];

        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());

        mergeSort(1,N);

        for(int i=1; i<=N; i++) bw.write(arr[i] + "\n");


        bw.flush();
        br.close();
        bw.close();
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
            if(arr[i]<arr[j]){
                tmp[index] = arr[i];
                i++;
                index++;
            }else{
                tmp[index] = arr[j];
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
            j++;
            index++;
        }

        for(int k=s; k<=e; k++) arr[k] = tmp[k];
    }



}
