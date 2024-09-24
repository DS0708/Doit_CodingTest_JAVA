package inflearn.string;

import java.util.Scanner;

public class Inf01_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer sb = new StringBuffer();

        int cnt = 1;

        str += " ";

        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i)==str.charAt(i+1)) cnt++;
            else{
                sb.append(str.charAt(i));
                if(cnt>1) sb.append(cnt);
                cnt = 1;
            }
        }

        System.out.println(sb);
    }
}
