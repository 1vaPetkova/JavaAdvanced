package T03SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        int inputs = Integer.parseInt(scan.nextLine());
        while(inputs-->0){
            usernames.add(scan.nextLine());
        }
        System.out.println(String.join(System.lineSeparator(),usernames));
    }
}
