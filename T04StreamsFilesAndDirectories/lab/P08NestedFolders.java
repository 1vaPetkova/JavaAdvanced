package T04StreamsFilesAndDirectories.lab;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering" +
                "\\002_Work_documentation\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources");

        ArrayDeque<File> files = new ArrayDeque<>();
        files.offer(file);
        PrintStream printStream = new PrintStream("nested-out.txt");
        int counter = 0;
        while (!files.isEmpty()) {
            File innerFile = files.poll();
            for (File f : innerFile.listFiles()) {
                if (f.isDirectory()) {
                    files.offer(f);
                    counter++;
                    printStream.println(f.getName());
                }
            }
        }
        printStream.println(counter + " folders");
    }
}
