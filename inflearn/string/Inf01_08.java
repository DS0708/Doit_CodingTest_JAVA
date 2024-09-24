package inflearn.string;

import java.util.Scanner;

public class Inf01_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        //^는 부정, []는 안의 모든 문자 포함, 즉 A-Z를 제외한 모든 문자를 ""로 바꿈
        str = str.toUpperCase().replaceAll("[^A-Z]","");

        String reverseStr = new StringBuilder(str).reverse().toString();

        if(str.equals(reverseStr)) System.out.println("YES");
        else System.out.println("NO");
    }
}
