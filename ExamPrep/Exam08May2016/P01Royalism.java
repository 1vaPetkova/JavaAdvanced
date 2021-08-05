package ExamPrep.Exam08May2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Royalism {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            List<String> all = Arrays.stream(scan.nextLine().split(" "))
                    .collect(Collectors.toList());
            List<String> royalists = new ArrayList<>();
            int positionOfR = 'R' - 'A' + 1;
            for (String s : all) {
                int sum = 0;
                for (int i = 0; i < s.length(); i++) {
                    sum += s.charAt(i);
                }

                if (sum % 26 == positionOfR) {
                    royalists.add(s);
                }
            }
            all.removeIf(royalists::contains);
            if (royalists.size() > 0 && royalists.size() >= all.size()) {
                System.out.println("Royalists - " + royalists.size());
                royalists.forEach(System.out::println);
                System.out.println("All hail Royal!");
            } else {
                all.removeIf(royalists::contains);
                all.forEach(System.out::println);
                System.out.println("Royalism, Declined!");
            }
        }
    }