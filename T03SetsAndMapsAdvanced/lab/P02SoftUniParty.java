package T03SetsAndMapsAdvanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();
        String guest = scan.nextLine();
        addGuests(guest, scan, vip, regular);
        guest = "";
        removeGuests(guest, scan, vip, regular);

        System.out.println(vip.size() + regular.size());
        printSetIfNotEmpty(vip);
        printSetIfNotEmpty(regular);
    }

    public static void printSetIfNotEmpty(Set<String> set) {
        if (!set.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), set));
        }
    }

    public static void removeGuests(String guest, Scanner scan, Set<String> vip, Set<String> regular) {
        while (!guest.equals("END")) {
            vip.remove(guest);
            regular.remove(guest);
            guest = scan.nextLine();
        }
    }

    public static void addGuests(String guest, Scanner scan, Set<String> vip, Set<String> regular) {
        while (!guest.equals("PARTY")) {
            if (Character.isDigit(guest.charAt(0))) {
                vip.add(guest);
            } else {
                regular.add(guest);
            }
            guest = scan.nextLine();
        }
    }
}
