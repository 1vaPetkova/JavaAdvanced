package T03SetsAndMapsAdvanced.lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());

        TreeMap<String, double[]> studentGrades = new TreeMap<>();
        while (students-- > 0) {
            String name = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();
            studentGrades.put(name, grades);
        }

        studentGrades.forEach((key, value) -> {
            System.out.printf("%s is graduated with %s\n", key, getAverage(value));
        });
    }

    private static Double getAverage(double[] value) {
        double average = 0.0;
        for (double v : value) {
            average += v;
        }
        return average / value.length;
    }
}
