package inflearn.string;

import java.util.Scanner;

public class Inf01_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int lt = 0, rt = chars.length - 1;
        while(lt < rt){
            if(!Character.isAlphabetic(chars[lt])) lt++;
            else if(!Character.isAlphabetic(chars[rt])) rt--;
            else{
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
        }
        str = String.valueOf(chars);
        System.out.println(str);
    }
}
