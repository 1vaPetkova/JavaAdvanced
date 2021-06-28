package T01StacksAndQueues.exercise;

import java.util.*;

public class P05Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] robotsData = scan.nextLine().split(";");
        Map<String, Integer> robots = getRobotsMap(robotsData);
        Map<String, Integer> robotsWorkingTime = getRobotsWorkingTimeMap(robotsData);
        int startTimeInSeconds = timeInSeconds(scan.nextLine());
        String input = "";
        ArrayDeque<String> products = new ArrayDeque<>();
        while (!(input = scan.nextLine()).equals("End")) {
            products.offer(input);
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            startTimeInSeconds++;
            //we need to decrease the working time for each robot that has a product
            decreaseWorkingTime(robotsWorkingTime);
            boolean isTaken = false;
            //check whether each robot is free -> workingTime = 0
            for (Map.Entry<String, Integer> rWorking : robotsWorkingTime.entrySet()) {
                if (rWorking.getValue() == 0) {//robot is free ->robot starts working on the product
                    robotsWorkingTime.put(rWorking.getKey(), robots.get(rWorking.getKey()));
                    System.out.printf("%s - %s [%s]\n", rWorking.getKey(), currentProduct, timeTaken(startTimeInSeconds));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                products.offer(currentProduct);
            }
        }
    }

    private static void decreaseWorkingTime(Map<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> e : robotsWorkingTime.entrySet()) {
            if (e.getValue() > 0) {//it is not free
                robotsWorkingTime.put(e.getKey(), e.getValue() - 1);
            }
        }
    }

    private static String timeTaken(int startTimeInSeconds) {
        int hours = startTimeInSeconds / 3600 % 24;

        int minutes = startTimeInSeconds % 3600 / 60;
        startTimeInSeconds = startTimeInSeconds % 3600 % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, startTimeInSeconds);
    }

    private static LinkedHashMap<String, Integer> getRobotsWorkingTimeMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String r : robotsData) {
            robots.put(r.split("-")[0], 0);
        }
        return robots;
    }

    private static Integer timeInSeconds(String time) {
        int[] startTime = Arrays.stream(time.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return startTime[0] * 3600 + startTime[1] * 60 + startTime[2];
    }

    private static Map<String, Integer> getRobotsMap(String[] robotsData) {
        Map<String, Integer> robots = new LinkedHashMap<>();
        for (String r : robotsData) {
            robots.putIfAbsent(r.split("-")[0], 0);
            robots.put(r.split("-")[0], Integer.parseInt(r.split("-")[1]));
        }
        return robots;
    }
}
