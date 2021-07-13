package T04StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class P03CopyBites {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        Set<Character> separators = Set.of(' ', '\n');
        FileInputStream inputStream = new FileInputStream(path);
        int nextByte = inputStream.read();
        PrintStream printStream = new PrintStream("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\" +
                "Iva Petkova\\Salix Engineering\\002_Work_documentation\\Softuni\\ADVANCED\\" +
                "04.Streams Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt");
        while (nextByte != -1) {
            if (separators.contains((char)nextByte)) {
                printStream.print((char) nextByte);
            } else {
                printStream.print(nextByte);
            }
            nextByte = inputStream.read();
        }
    }
}
