package T02MultidimentionalArrays.archive.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());
        List<Integer> output = new ArrayList<>();
        while (inputs-- > 0) {
            String text = scan.nextLine();
            int sum = 0;
            for (char ch : text.toCharArray()) {
                if (isVowel(Character.toLowerCase(ch))) {
                    sum += ch * text.length();
                } else {
                    sum += ch / text.length();
                }
            }
            output.add(sum);
        }
        output.stream().sorted().forEach(System.out::println);
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
