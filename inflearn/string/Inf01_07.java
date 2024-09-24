package inflearn.string;

import java.util.Scanner;

public class Inf01_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        str = str.toUpperCase();
        boolean check = true;

        //풀이 1
//        char[] chars = str.toCharArray();
//        int lt = 0, rt = chars.length - 1;
//        while(lt < rt){
//            if(chars[lt] != chars[rt]){
//                check = false;
//                break;
//            }
//            lt++;
//            rt--;
//        }

        //풀이 2
        String reverse = new StringBuilder(str).reverse().toString();
        if(!reverse.equals(str)) check = false;

        if(check) System.out.println("YES");
        else System.out.println("NO");
    }
}
