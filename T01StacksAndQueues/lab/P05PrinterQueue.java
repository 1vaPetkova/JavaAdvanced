package T01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        String fileName = "";
        while (!(fileName = scan.nextLine()).equals("print")) {
            if (fileName.equals("cancel")) {
                String cancelledFile = printerQueue.poll();
                if (cancelledFile == null) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + cancelledFile);
                }
            } else {
                printerQueue.offer(fileName);
            }
        }
        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
