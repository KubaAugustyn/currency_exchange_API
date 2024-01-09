package pl.kurs.interfaces;

import pl.kurs.exceptions.TheEnteredAmountOfMoneyMustBeGreaterThan0Exception;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface IRateService {
    double getRate(String fromCurrencyMark, String toCurrencyMark, double amount) throws IOException, ParseException, TheEnteredAmountOfMoneyMustBeGreaterThan0Exception;
}
