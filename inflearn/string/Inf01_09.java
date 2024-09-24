package inflearn.string;

import java.util.Scanner;

public class Inf01_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer sb = new StringBuffer();

        for(char c  : str.toCharArray()) {
            if(Character.isDigit(c)) sb.append(c);
        }

        System.out.println(Integer.parseInt(sb.toString()));
    }
}
