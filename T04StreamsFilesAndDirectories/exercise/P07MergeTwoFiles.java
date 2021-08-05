package T04StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String firstPath = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondPath = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation\\Softuni" +
                "\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\mergedFile.txt"));

        BufferedReader readFirst = new BufferedReader(new FileReader(firstPath));
        BufferedReader readSecond = new BufferedReader(new FileReader(secondPath));

        String fl = readFirst.readLine();
        String sl = readSecond.readLine();
        List<String> newList = new ArrayList<>();
        while (fl != null) {
            newList.add(fl);
            fl = readFirst.readLine();
        }

        while (sl != null) {
            newList.add(sl);
            sl = readSecond.readLine();
        }

        writer.write(String.join(System.lineSeparator(), newList));
        writer.close();
    }
}
