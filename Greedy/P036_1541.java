package Greedy;

import java.util.Scanner;

public class P036_1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine();
        String[] minus = formula.split("-");
        boolean first = false;
        long result = 0;

        for (String s : minus) {
            String[] plus = s.split("\\+");
            int sum=0;
            for (String str : plus) sum += Integer.parseInt(str);
            if (first == false){
                result += sum;
                first = true;
                continue;
            }
            result -= sum;
        }

        System.out.println(result);

    }
}
