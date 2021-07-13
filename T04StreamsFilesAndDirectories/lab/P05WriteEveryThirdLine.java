package T04StreamsFilesAndDirectories.lab;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering" +
                "\\002_Work_documentation\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileReader reader = new FileReader(path);

        Scanner scan = new Scanner(reader);

        PrintStream printStream = new PrintStream("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova" +
                "\\Salix Engineering\\002_Work_documentation\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt");
        int lineNumber = 1;
        while (scan.hasNext()) {
            if (lineNumber % 3 == 0) {
                printStream.println(scan.nextLine());
            } else {
                scan.nextLine();
            }
            lineNumber++;
        }
    }
}
