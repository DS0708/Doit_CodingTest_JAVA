package DataStructure;

import java.io.*;
import java.util.Scanner;

public class P001 {
    public static void main(String[] args) throws IOException {
        //my code
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String nums = br.readLine();
//        int sum = 0;
//
//        for (int i = 0; i < n; i++) {
//            sum += nums.charAt(i) - '0';
//        }
//
//        System.out.println(sum);

        //book code
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String sNum = scan.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i=0; i<n ; i++){
            sum += cNum[i] - '0';
        }
        System.out.println(sum);
    }
}

