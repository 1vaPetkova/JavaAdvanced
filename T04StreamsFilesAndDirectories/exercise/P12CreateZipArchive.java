package T04StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {
    public static void main(String[] args) {
            String firstPath = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                    "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                    "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                    "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
            String secondPath = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                    "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                    "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                    "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
            String thirdPath = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                    "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                    "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                    "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

            String zipPath = "C:\\Users\\iva1p\\Sivik Stroy Dropbox" +
                    "\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                    "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                    "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";
        try {
            FileOutputStream fos = new FileOutputStream(zipPath);
            ZipOutputStream zos = new ZipOutputStream(fos);
            addFileToZip(firstPath, zos);
            addFileToZip(secondPath, zos);
            addFileToZip(thirdPath, zos);
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addFileToZip(String path, ZipOutputStream zos) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        String[]files=path.split("\\\\");
        String fileName=files[files.length-1];
        ZipEntry zipEntry=new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);
        byte[] bytes=new byte[1024];
        int length;
        while ((length=fis.read(bytes))>=0){
            zos.write(bytes,0,length);
        }
        zos.closeEntry();
        fis.close();
    }
}
