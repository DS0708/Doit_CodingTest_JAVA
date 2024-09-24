package inflearn.string;

import java.util.Scanner;

public class Inf01_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] input = new String[n];
        for (int i = 0; i < n; i++) input[i] = scanner.next();

        //풀이 1 : StringBuilder
//        for(String str : input){
//            str = new StringBuilder(str).reverse().toString();
//            System.out.println(str);
//        }

        //풀이 2 : lt, rt
        for(String str : input){
            char[] charArr = str.toCharArray();
            int lt = 0, rt = str.length()-1;
            while(lt < rt){
                char temp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = temp;
                lt++;
                rt--;
            }
            str = String.valueOf(charArr);
            System.out.println(str);
        }
    }
}
