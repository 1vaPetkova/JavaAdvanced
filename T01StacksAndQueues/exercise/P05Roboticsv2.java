package T01StacksAndQueues.exercise;

import java.util.*;

public class P05Roboticsv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] robotsData = scan.nextLine().split(";");
        Map<String, Integer> robots = getRobotsMap(robotsData);
        int[] workingTime = new int[robots.size()];

        int startTimeInSeconds = timeInSeconds(scan.nextLine());

        ArrayDeque<String> products = new ArrayDeque<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            products.offer(input);
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            //we need to increase time in seconds
            startTimeInSeconds++;
            //we need to decrease the working time for each robot that has a product
            decreaseWorkingTime(workingTime);
            boolean isTaken = false;
            //check whether each robot is free -> workingTime = 0
            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] == 0) {
                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                        if (count == i) {//robot is free ->robot starts working on the product
                            workingTime[i] = robot.getValue();
                            System.out.printf("%s - %s [%s]\n", robot.getKey(), currentProduct, timeTaken(startTimeInSeconds));
                            isTaken = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            //after we have checked all robots:
            if (!isTaken) {
                products.offer(currentProduct);
            }
        }
    }

    private static void decreaseWorkingTime(int[] workingTime) {
        for (int i = 0; i < workingTime.length; i++) {
            if (workingTime[i] > 0) {
                workingTime[i]--;
            }
        }
    }

    private static String timeTaken(int startTimeInSeconds) {
        int hours = startTimeInSeconds / 3600 % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        startTimeInSeconds = startTimeInSeconds % 3600 % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, startTimeInSeconds);
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
