package T03SetsAndMapsAdvanced.lab;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Voinav2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<Integer> firstDeck = readDeck(scan.nextLine());
        LinkedHashSet<Integer> secondDeck = readDeck(scan.nextLine());

        int rounds = 50;
        while (rounds-- > 0) {
            int firstCard = getFirst(firstDeck);
            int secondCard = getFirst(secondDeck);
            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);
            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }
        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    public static int getFirst(LinkedHashSet<Integer> set) {
        return set.stream().findFirst().orElse(0);
    }

    public static int getFirstWithIterator(LinkedHashSet<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        Integer next = iterator.next();
        iterator.remove();
        return iterator.next();
    }

    private static LinkedHashSet<Integer> readDeck(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
