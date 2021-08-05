package T04StreamsFilesAndDirectories.exercise;

import java.io.File;
import java.io.IOException;

public class P08GetFolderSize {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering" +
                "\\002_Work_documentation\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        File[] files = file.listFiles();
        long size = 0;
        for (File f : files) {
            if (!f.isDirectory()) {
                size += f.length();
            }
        }
        System.out.println("Folder size: " + size);
    }
}
