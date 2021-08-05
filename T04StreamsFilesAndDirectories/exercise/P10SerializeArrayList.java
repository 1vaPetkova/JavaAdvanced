package T04StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class P10SerializeArrayList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = "C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering" +
                "\\002_Work_documentation\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\list.ser";

        List<Double> list = List.of(1.5, 2.5, 3.5, 4.5, 5.50);
        //serialize:
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //deserialize:
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            List<Double> deserializeList = (List<Double>) objectInputStream.readObject();
            deserializeList.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
