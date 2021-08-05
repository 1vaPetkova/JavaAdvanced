package T01StacksAndQueues.archive.exercise;

import java.util.*;

public class P11Robotics {
    public static class Robot {
        private String name;
        private int processTime;
        private int workingTime;

        public Robot(String name, int processTime) {
            this.name = name;
            this.processTime = processTime;
        }

        public String getName() {
            return name;
        }

        public int getProcessTime() {
            return processTime;
        }

        public int getWorkingTime() {
            return workingTime;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setWorkingTime(int workingTime) {
            this.workingTime = workingTime;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split(";");
        List<Robot> robots = new ArrayList<>();

        Arrays.stream(data).forEach(d -> {
            String name = d.split("-")[0];
            int processTime = Integer.parseInt(d.split("-")[1]);
            robots.add(new Robot(name, processTime));
        });

        String startTime = scan.nextLine();
        int startTimeInSecs = Integer.parseInt(startTime.split(":")[0]) * 60 * 60
                + Integer.parseInt(startTime.split(":")[1]) * 60
                + Integer.parseInt(startTime.split(":")[2]);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = "";
        while (!(product = scan.nextLine()).equals("End")) {
            products.offer(product);
        }

        while (!products.isEmpty()) {
            startTimeInSecs++;
            String currentProduct = products.poll();
            boolean productIsNotAccepted = true;
            for (Robot robot : robots) {
                if (robot.getWorkingTime() > 0) {
                    robot.setWorkingTime(robot.getWorkingTime() - 1);
                }
                if (robot.getWorkingTime() == 0 && productIsNotAccepted) {
                    robot.setWorkingTime(robot.getProcessTime());
                    printRobotInfo(startTimeInSecs, robot.getName(), currentProduct);
                    productIsNotAccepted = false;
                }
            }
            if (productIsNotAccepted) {
                products.offer(currentProduct);
            }
        }
    }

    private static void printRobotInfo(int startTimeInSecs, String name, String currentProduct) {
        int hours = startTimeInSecs / 3600 % 24;
        int minutes = startTimeInSecs % 3600 / 60;
        int seconds = startTimeInSecs % 3600 % 60;
        System.out.printf("%s - %s [%02d:%02d:%02d]\n", name, currentProduct, hours, minutes, seconds);
    }
}
