package T01StacksAndQueues.archive.exercise;

import java.util.*;

public class P14SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<Integer> commands = new ArrayDeque<>();
        ArrayDeque<String> textRemoved = new ArrayDeque<>();
        ArrayDeque<String> textAdded = new ArrayDeque<>();
        while (lines-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            switch (Integer.parseInt(tokens[0])) {
                case 1:
                    String toAppend = tokens[1];
                    text.append(toAppend);
                    commands.push(1);
                    textAdded.push(toAppend);
                    break;
                case 2:
                    int count = Integer.parseInt(tokens[1]);
                    textRemoved.push(text.substring(text.length() - count));
                    text.delete(text.length() - count, text.length());
                    commands.push(2);
                    break;
                case 3:
                    int position = Integer.parseInt(tokens[1]);
                    System.out.println(text.charAt(position - 1));
                    break;
                case 4:
                    int lastCommand = commands.pop();
                    if (lastCommand == 1) {
                        text.delete(text.indexOf(textAdded.pop()), text.length());
                    } else if (lastCommand == 2) {
                        text.append(textRemoved.pop());
                    }
                    break;
            }
        }
    }
}
