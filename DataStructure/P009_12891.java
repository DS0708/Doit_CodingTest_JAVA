package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P009_12891 {
    static int[] MyArr;
    static int[] CheckArr;
    static int CheckSecret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] S_arr = br.readLine().toCharArray();


        int result = 0;
        CheckSecret = 0;

        CheckArr = new int[4];
        MyArr = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++){
            CheckArr[i] = Integer.parseInt(st.nextToken());
            if (CheckArr[i]==0) CheckSecret++;
        }

        // 초기 윈도우 추가
        for (int i=0; i<P; i++){
            Add(S_arr[i]);
        }
        if (CheckSecret == 4) result++;

        // 나머지 윈도우 수행
        for (int i=P; i<S; i++){
            Add(S_arr[i]);
            Remove(S_arr[i-P]);
            if (CheckSecret == 4) result++;
        }

        System.out.println(result);

    }

    private static void Remove(char c) {
        switch (c){
            case 'A' :
                MyArr[0] --;
                if (MyArr[0] == (CheckArr[0]-1)) CheckSecret --;
                break;
            case 'C' :
                MyArr[1] --;
                if (MyArr[1] == (CheckArr[1]-1)) CheckSecret --;
                break;
            case 'G' :
                MyArr[2] --;
                if (MyArr[2] == (CheckArr[2]-1)) CheckSecret --;
                break;
            case 'T' :
                MyArr[3] --;
                if (MyArr[3] == (CheckArr[3]-1)) CheckSecret --;
                break;
        }
    }

    private static void Add(char c) {
        switch (c){
            case 'A' :
                MyArr[0] ++;
                if (MyArr[0] == CheckArr[0]) CheckSecret ++;
                break;
            case 'C' :
                MyArr[1] ++;
                if (MyArr[1] == CheckArr[1]) CheckSecret ++;
                break;
            case 'G' :
                MyArr[2] ++;
                if (MyArr[2] == CheckArr[2]) CheckSecret ++;
                break;
            case 'T' :
                MyArr[3] ++;
                if (MyArr[3] == CheckArr[3]) CheckSecret ++;
                break;
        }
    }
}
