package T04StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class P06WordCount {
    public static void main(String[] args) throws IOException {
        String firstPath = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String secondPath = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation\\Softuni" +
                "\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt"));

        BufferedReader readWords = new BufferedReader(new FileReader(firstPath));
        BufferedReader readText = new BufferedReader(new FileReader(secondPath));

        List<String> words = Arrays.stream(readWords.readLine().split("\\s+"))
                .collect(Collectors.toList());
        List<String> text = Arrays.stream(readText.readLine().split("\\s+"))
                .collect(Collectors.toList());
        text.retainAll(words);
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String word : text) {
            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);
        }
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> {
                    try {
                        writer.write(String.format("%s - %d\n",e.getKey(),e.getValue()));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });
        writer.close();
    }
}
