package inflearn.string;

import java.util.Scanner;

public class Inf01_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<n; i++){
            String temp = str.substring(0, 7).replace('#','1').replace('*','0');
            int num = Integer.parseInt(temp, 2);
            sb.append((char)num);
            str = str.substring(7);
        }

        System.out.println(sb);
    }
}
