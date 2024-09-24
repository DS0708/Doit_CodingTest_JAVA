package inflearn.string;

import java.util.Scanner;

public class Inf01_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String res = "";

        for(int i=0; i<str.length(); i++){
            if(i==str.indexOf(str.charAt(i))) res+=str.charAt(i);
        }

        System.out.println(res);
    }
}
