package T04StreamsFilesAndDirectories.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class P05WriteEveryThirdLinev2 {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering" +
                "\\002_Work_documentation\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        Path inputPath = Paths.get(fileName);
        List<String> lines = Files.readAllLines(inputPath);

        PrintStream printStream = new PrintStream("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt");

        for (int i = 2; i < lines.size(); i += 3) {
            printStream.println(lines.get(i));
        }
    }
}
