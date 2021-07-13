package T04StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P02WriteFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        Set<Character> separators = Set.of(',', '.', '!', '?');
        FileInputStream inputStream = new FileInputStream(path);
        int nextByte = inputStream.read();
        PrintStream printStream = new PrintStream("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova" +
                "\\Salix Engineering\\002_Work_documentation\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt");
        while (nextByte != -1) {
            char symbol = (char) nextByte;
            if (!separators.contains(symbol)) {
                printStream.print(symbol);
            }
            nextByte = inputStream.read();
        }
    }
}
