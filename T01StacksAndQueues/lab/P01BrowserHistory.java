package T01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        String command = "";
        String currentURL = "";
        while (!(command = scan.nextLine()).equals("Home")) {

            if (command.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                }
                currentURL = history.pop();
            } else {
                if (!currentURL.equals("")) {
                    history.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);

        }
    }
}
