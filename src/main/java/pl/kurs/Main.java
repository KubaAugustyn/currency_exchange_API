package pl.kurs;

import org.json.simple.parser.ParseException;
import pl.kurs.exceptions.TheEnteredAmountOfMoneyMustBeGreaterThan0Exception;
import pl.kurs.interfaces.ICurrencyService;
import pl.kurs.interfaces.IRateService;
import pl.kurs.interfaces.IUrlStringBuilder;
import pl.kurs.service.ApiConnectionService;
import pl.kurs.service.CurrencyService;
import pl.kurs.service.RateService;
import pl.kurs.service.UrlStringBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IUrlStringBuilder urlStringBuilder = new UrlStringBuilder();
        IRateService rateService = new RateService(new ApiConnectionService(urlStringBuilder), urlStringBuilder);
        ICurrencyService currencyService = new CurrencyService(rateService);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the currency exchange API!");
        showAvailableOptions();

        int option = -1;

        do {
            switch ((option = scanner.nextInt())) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.println("Enter currency to be exchanged:");
                    String from = scanner.nextLine().toUpperCase();
                    System.out.println("Amount:");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter currency you wish to receive:");
                    String to = scanner.nextLine().toUpperCase();
                    double exchange;
                    try {
                        exchange = currencyService
                                .exchange(from, to, amount);
                    } catch (IOException | ParseException | TheEnteredAmountOfMoneyMustBeGreaterThan0Exception e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("You receive " + exchange + " " + to.toUpperCase());
                    showAvailableOptions();
                }
                case 0 -> System.out.println("Thank you for using the API");
                default -> {
                    System.err.println("You have chosen a non-existent option!");
                    showAvailableOptions();
                }
            }
        } while (option != 0);
        scanner.close();
    }

    private static void showAvailableOptions() {
        System.out.println("Choose from the options:");
        System.out.println("1 - cash exchange");
        System.out.println("0 - exit");
    }

}
