package pl.kurs.exchangerateapp.interfaces;

import org.json.simple.parser.ParseException;
import pl.kurs.exchangerateapp.exceptions.TheEnteredAmountOfMoneyMustBeGreaterThan0Exception;

import java.io.IOException;

public interface ICurrencyService {
    double exchange(String currencyFrom, String currencyTo, double amount) throws TheEnteredAmountOfMoneyMustBeGreaterThan0Exception, IOException, ParseException;
}
