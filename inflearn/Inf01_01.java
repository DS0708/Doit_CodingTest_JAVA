package inflearn;

import java.util.*;

public class Inf01_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next().toUpperCase();
        char c = scan.next().charAt(0);
        c = Character.toUpperCase(c);

        int count = 0;

        for(char ch : str.toCharArray()){
            if(ch == c) count++;
        }
        System.out.println(count);
    }
}
