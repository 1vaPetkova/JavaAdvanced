package T04StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.*;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        FileReader reader = new FileReader(path);
        Scanner scan = new Scanner(reader);
        Set<Character> setOfVowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> setOfPunctuation = Set.of('!', ',', '.', '?');

        PrintStream printStream = new PrintStream("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering\\002_Work_documentation\\Softuni" +
                "\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        int nextByte = reader.read();

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        while (nextByte != -1) {
            char ch = (char)nextByte;
            if (setOfVowels.contains(ch)) {
                vowels++;
            } else if (setOfPunctuation.contains(ch)) {
                punctuation++;
            } else if (!Character.isWhitespace(ch)) {
                consonants++;
            }
            nextByte = reader.read();
        }

        printStream.println("Vowels: " + vowels);
        printStream.println("Consonants: " + consonants);
        printStream.println("Punctuation: " + punctuation);
    }
}
