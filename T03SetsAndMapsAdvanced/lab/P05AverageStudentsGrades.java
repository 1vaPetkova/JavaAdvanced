package T03SetsAndMapsAdvanced.lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        TreeMap<String, List<Double>> students = new TreeMap<>();
        while (count-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }
        students.forEach((k, v) -> System.out.printf("%s -> %s(avg: %.2f)\n", k, getGrades(v), getAverage(v)));
    }

    private static Double getAverage(List<Double> value) {
        double average = 0.0;
        for (double v : value) {
            average += v;
        }
        return average / value.size();
    }

    private static String getGrades(List<Double> v) {
        StringBuilder grades = new StringBuilder();
        for (Double gr : v) {
            grades.append(String.format("%.2f", gr)).append(" ");
        }
        return grades.toString();
    }
}
