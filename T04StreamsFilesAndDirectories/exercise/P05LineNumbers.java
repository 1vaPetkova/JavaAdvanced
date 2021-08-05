package T04StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation\\Softuni" +
                "\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

        int countLines = 1;
        for (String line : lines) {
            writer.write(String.format("%d. %s\n", countLines++, line));
        }
        writer.close();

    }
}
