package T01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operations = Integer.parseInt(scan.nextLine());
        String text = "";
        ArrayDeque<String> prevCommand = new ArrayDeque<>();
        ArrayDeque<String> textAdded = new ArrayDeque<>();
        ArrayDeque<String> textErased = new ArrayDeque<>();
        for (int i = 0; i < operations; i++) {
            String input = scan.nextLine();
            switch (input.split("\\s+")[0]) {
                case "1":
                    prevCommand.push("1");
                    textAdded.push(input.split("\\s+")[1]);
                    text += input.split("\\s+")[1];
                    break;
                case "2":
                    int count = Integer.parseInt(input.split("\\s+")[1]);
                    prevCommand.push("2");
                    textErased.push(text.substring(text.length() - count));
                    text = text.substring(0, text.length() - count);
                    break;
                case "3":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    System.out.println(text.charAt(index-1));
                    break;
                case "4":
                    String previous = prevCommand.pop();
                    if (previous.equals("1")) {
                        String textToUndo = textAdded.pop();
                        text = text.substring(0, text.length() - textToUndo.length());
                    } else if (previous.equals("2")) {
                        String textToUndo = textErased.pop();
                        text += textToUndo;
                    }
                    break;
            }
        }
    }
}
