package Class3;

import java.util.*;
import java.io.*;

public class P_11723 {
    static Set<Integer> set;
    public static void main(String[] args) throws Exception{
        set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            String[] input = br.readLine().split(" ");
            String func = input[0];
            if(func.equals("add")) set.add(Integer.parseInt(input[1]));
            else if(func.equals("remove")) set.remove(Integer.parseInt(input[1]));
            else if(func.equals("check")) {
                if(set.contains(Integer.parseInt(input[1]))) bw.write(1+"\n");
                else bw.write(0+"\n");
            }
            else if(func.equals("toggle")){
                if(set.contains(Integer.parseInt(input[1]))) set.remove(Integer.parseInt(input[1]));
                else set.add(Integer.parseInt(input[1]));
            }
            else if(func.equals("all")) {
                for(int j=1; j<=20; j++) set.add(j);
            }
            else set.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

//공집합 S
//
