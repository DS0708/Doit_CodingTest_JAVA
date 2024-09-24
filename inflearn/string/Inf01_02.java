package inflearn.string;

import java.util.Scanner;

public class Inf01_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String res = "";

        for(char c : str.toCharArray()) {
            if(Character.isUpperCase(c)) res += Character.toLowerCase(c);
            else res += Character.toUpperCase(c);
        }

        System.out.println(res);
    }
}
