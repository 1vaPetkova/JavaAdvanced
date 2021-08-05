package T04StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class P03AllCapitals {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        PrintStream printStream = new PrintStream("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering\\002_Work_documentation\\Softuni" +
                "\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        List<String> lines = new ArrayList<>();
        while (line != null) {
            lines.add(line.toUpperCase(Locale.ROOT));
            line = reader.readLine();
        }

        printStream.println(String.join(System.lineSeparator(),lines));
    }
}
