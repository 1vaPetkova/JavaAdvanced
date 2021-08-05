package T04StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();

        List<String> lines = new ArrayList<>();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        long sum = 0;
        for (String l : lines) {
            for (char symbol : l.toCharArray()) {
                sum += symbol;
            }
        }
        System.out.println(sum);
    }
}
