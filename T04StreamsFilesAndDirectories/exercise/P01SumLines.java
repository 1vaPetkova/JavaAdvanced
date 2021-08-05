package T04StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class P01SumLines {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (NoSuchFileException no) {
            System.out.println("No such file");
        } catch (IOException io) {
            System.out.println("Another error occured");
        }

        for (String l : lines) {
            long sum = 0;
            for (char symbol : l.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        }
    }
}
