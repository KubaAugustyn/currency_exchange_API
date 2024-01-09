package pl.kurs.exchangerateapp.interfaces;

import pl.kurs.exchangerateapp.exceptions.TheEnteredAmountOfMoneyMustBeGreaterThan0Exception;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface IRateService {
    double getRate(String fromCurrencyMark, String toCurrencyMark, double amount) throws IOException, ParseException, TheEnteredAmountOfMoneyMustBeGreaterThan0Exception;
}
