package T02MultidimentionalArrays.archive.lab;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String[] words = text.split("[,;:.!()\"'/\\[\\]\\\\ ]");

        List<String> lower = new ArrayList<>();
        List<String> upper = new ArrayList<>();
        List<String> mixed = new ArrayList<>();
        for (String word : words){
            if (!word.equals("")) {
                if (word.matches("[A-Z]+")) {
                    upper.add(word);
                } else if (word.matches("[a-z]+")){
                    lower.add(word);
                } else {
                    mixed.add(word);
                }
            }
        }
        System.out.println("Lower-case: " + String.join(", ", lower));
        System.out.println("Mixed-case: " + String.join(", ", mixed));
        System.out.println("Upper-case: " + String.join(", ", upper));
    }
}
