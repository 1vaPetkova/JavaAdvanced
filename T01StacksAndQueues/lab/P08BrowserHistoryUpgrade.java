package T01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();
        String command = "";
        String currentURL = "";
        while (!(command = scan.nextLine()).equals("Home")) {
            if (command.equals("back")) {
                if (backStack.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                }
                forwardQueue.offerFirst(currentURL);
                currentURL = backStack.pop();
            } else if (command.equals("forward")) {
                if (forwardQueue.isEmpty()) {
                    System.out.println("no next URLs");
                    continue;
                }
                currentURL = forwardQueue.poll();
            } else {
                if (!currentURL.equals("")) {
                    backStack.push(currentURL);
                    forwardQueue.clear();
                }
                currentURL = command;
            }
            System.out.println(currentURL);
        }
    }
}
