package T04StreamsFilesAndDirectories.lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P06SortLines {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova" +
                "\\Salix Engineering\\002_Work_documentation\\Softuni\\ADVANCED" +
                "\\04.Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();

        List<String> lines = new ArrayList<>();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        Collections.sort(lines);
//        Files.write(Path.of("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering" +
//                "\\002_Work_documentation\\Softuni\\ADVANCED" +
//                "\\04.Streams Files and Directories" +
//                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt"), lines);

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation\\Softuni\\ADVANCED\\" +
                "04.Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\06.SortLinesOutput.txt"));
        writer.write(String.join(System.lineSeparator(), lines));
        writer.flush();
        writer.close();
    }
}
