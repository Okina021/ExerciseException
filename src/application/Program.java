package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        System.out.print("Holder: ");
        scanner.nextLine();
        String holder = scanner.nextLine();
        System.out.print("Initial balance: ");

        double initilBalance = scanner.nextDouble();
        System.out.print("Withdraw limit: ");
        double withDrawLimit = scanner.nextDouble();
        Account account = new Account(number, holder, initilBalance, withDrawLimit);

        System.out.println();
        try {
            System.out.print("Enter amount for withdraw:");
            account.withDraw(scanner.nextDouble());
        }
        catch (DomainException exception){
            System.out.println(exception.getMessage());
        }

    }
}
