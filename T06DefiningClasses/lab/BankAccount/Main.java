package T06DefiningClasses.lab.BankAccount;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            String[] tokens = input.split("\\s+");
            //•	Create
            //•	Deposit {Id} {Amount}
            //•	SetInterest {Interest}
            //•	GetInterest {ID} {Years}
            String output = "";
            switch (tokens[0]) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    output = String.format("Account ID%d created", bankAccount.getId());
                    accounts.put(bankAccount.getId(), bankAccount);
                    break;
                case "Deposit":
                    int depositId = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    BankAccount current = accounts.get(depositId);
                    output = executeIfNotNull(current, b -> {
                        b.deposit(amount);
                        return String.format("Deposited %s to ID%d", df.format(amount), b.getId());
                    });
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest":
                    int interestId = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    BankAccount acc = accounts.get(interestId);
                    output = executeIfNotNull(acc, b -> {
                        b.getInterest(years);
                        return String.format("%.2f", accounts.get(interestId).getInterest(years));
                    });
                    break;
            }
            if (!output.isEmpty()) {
                System.out.println(output);
            }
        }
    }

    public static String executeIfNotNull(BankAccount account, Function<BankAccount, String> func) {
        if (account == null) {
            return "Account does not exist";
        }
        return func.apply(account);
    }
}
