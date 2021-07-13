package T03SetsAndMapsAdvanced.lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("END")) {
            String car = input.split(",\\s+")[1];

            if (input.contains("IN")) {
                parkingLot.add(car);
            } else {
                parkingLot.remove(car);
            }

        }
        if(!parkingLot.isEmpty()){
        System.out.println(String.join(System.lineSeparator(),parkingLot));
        } else{
            System.out.println("Parking Lot is Empty");
        }
    }
}
