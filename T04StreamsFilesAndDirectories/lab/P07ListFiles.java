package T04StreamsFilesAndDirectories.lab;

import java.io.File;
import java.io.IOException;

public class P07ListFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering" +
                "\\002_Work_documentation\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.isDirectory()) {
                System.out.printf("%s: [%d]\n",f.getName(),f.length());
            }
        }
    }
}
