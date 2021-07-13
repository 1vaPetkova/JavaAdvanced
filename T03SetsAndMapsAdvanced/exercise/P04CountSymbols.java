package T03SetsAndMapsAdvanced.exercise;

import java.util.Scanner;
import java.util.TreeMap;


public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<Character, Integer> symbols = new TreeMap<>();
        String text = scan.nextLine();
        for (int i = 0; i < text.length(); i++) {
            symbols.putIfAbsent(text.charAt(i), 0);
            symbols.put(text.charAt(i), symbols.get(text.charAt(i)) + 1);
        }
        symbols.forEach((k,v)-> System.out.printf("%c: %d time/s\n",k,v));
    }
}
