package Sort;

import java.io.*;

public class P020_2751 {

    static int[] A;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        temp = new int[n];

        for (int i=0; i<n ;i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(0,n-1);

        for (int i=0; i<n; i++){
            bw.write(A[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void merge_sort(int start, int end){
        if (end - start < 1) return;

        int mid = (start + end)/2;

        merge_sort(start,mid);
        merge_sort(mid+1,end);

        for(int i=start; i<=end; i++){
            temp[i] = A[i];
        }

        int current = start;
        int index1 = start;
        int index2 = mid+1;

        while(index1 <= mid && index2 <= end){
            if (temp[index1] > temp[index2]){
                A[current] = temp[index2];
                current++;
                index2++;
            }else {
                A[current] = temp[index1];
                current++;
                index1++;
            }
        }
        while (index1 <= mid){
            A[current] = temp[index1];
            current++;
            index1++;
        }
        while (index2 <= end) {
            A[current] = temp[index2];
            current++;
            index2++;
        }
    }
}
