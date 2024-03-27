package Sort.버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P016_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];

        for (int i=0; i<N ; i++){
            A[i] = new mData(Integer.parseInt(br.readLine()),i);
        }

        Arrays.sort(A);

        int Max = 0;
        for (int i=0; i<N; i++){
            if (Max < A[i].index - i) Max = A[i].index-i;
        }

        System.out.println(Max+1);
    }

    static class mData implements Comparable<mData>{
        int value;
        int index;

        public mData(int value, int index){
            super();
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o){ //value기준 오름차순 정렬하기
            return this.value - o.value;
        }
    }
}
