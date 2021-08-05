package T04StreamsFilesAndDirectories.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyAPicture {
    public static void main(String[] args) throws IOException {
        String inPath = "C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering\\002_Work_documentation\\" +
                "Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture.jpg";
        String outPath = "C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering\\002_Work_documentation\\" +
                "Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture-copy.jpg";

        FileInputStream inputStream = new FileInputStream(inPath);
        FileOutputStream outputStream = new FileOutputStream(outPath);
        int nextByte = inputStream.read();
        while (nextByte != -1) {
            outputStream.write(nextByte);
            nextByte = inputStream.read();
        }
    }
}
