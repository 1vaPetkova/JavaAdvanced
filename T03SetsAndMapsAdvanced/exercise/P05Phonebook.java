package T03SetsAndMapsAdvanced.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        HashMap<String, String> phonebook = new HashMap<>();
        while (!(input = scan.nextLine()).equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            phonebook.put(name, number);
        }
        String search = "";
        while(!(search = scan.nextLine()).equals("stop")){
            if (phonebook.containsKey(search)){
                System.out.printf("%s -> %s\n",search,phonebook.get(search));
            } else{
                System.out.printf("Contact %s does not exist.\n",search);
            }
        }
    }
}
