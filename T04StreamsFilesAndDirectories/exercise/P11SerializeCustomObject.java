package T04StreamsFilesAndDirectories.exercise;

import java.io.*;

public class P11SerializeCustomObject {
    public static class Course implements Serializable {
        private String name;
        private int students;

        public Course(String name, int students) {
            this.name = name;
            this.students = students;
        }

        @Override
        public String toString() {
            return String.format("%s -> %d", this.name, this.students);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "C:\\Users\\iva1p\\Sivik Stroy Dropbox\\Iva Petkova\\Salix Engineering\\002_Work_documentation" +
                "\\Softuni\\ADVANCED\\04.Streams Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";
        Course course = new Course("JavaAdvanced", 325);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(course);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Course currentCourse = (Course) objectInputStream.readObject();
        System.out.println(currentCourse);
    }
}
