package inflearn.string;

import java.util.Scanner;

public class Inf01_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        String res = "";

        //풀이 1
//        String[] input = scanner.nextLine().split(" ");
//        for(String str : input){
//            if(max < str.length()){
//                max = str.length();
//                res = str;
//            }
//        }

        //풀이 2
        String str = scanner.nextLine();
        int pos;
        while ((pos=str.indexOf(' '))!=-1){
            String sub = str.substring(0,pos);
            if(max < sub.length()){
                max = sub.length();
                res = sub;
            }
            str = str.substring(pos+1);
        }

        if(max < str.length()) res = str;

        System.out.println(res);
    }
}
