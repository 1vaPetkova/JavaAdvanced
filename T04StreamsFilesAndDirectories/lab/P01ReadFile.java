package T04StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Scanner scan = new Scanner(inputStream);
        int nextByte = inputStream.read();

        while (nextByte != -1) {
            System.out.print(Integer.toBinaryString(nextByte) + " ");
            nextByte=inputStream.read();
        }
    }
}
