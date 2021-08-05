package T05FunctionalProgramming.lab;

import java.util.Arrays;

import java.util.Scanner;

import java.util.function.Predicate;


public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Predicate<String> startsWithUppercase = str -> Character.isUpperCase(str.charAt(0));

        String[] words = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(startsWithUppercase).toArray(String[]::new);


        System.out.println(words.length);
        Arrays.stream(words).forEach(System.out::println);
    }
}
