package pl.kurs.service;

import org.json.simple.parser.ParseException;
import pl.kurs.exceptions.TheEnteredAmountOfMoneyMustBeGreaterThan0Exception;
import pl.kurs.interfaces.ICurrencyService;
import pl.kurs.interfaces.IRateService;

import java.io.IOException;

public class CurrencyService implements ICurrencyService {

    IRateService rateService;

    public CurrencyService(IRateService rateService) {
        this.rateService = rateService;
    }

    @Override
    public double exchange(String currencyFrom, String currencyTo, double amount) throws TheEnteredAmountOfMoneyMustBeGreaterThan0Exception, IOException, ParseException {
        if (amount <= 0.0) {
            throw new TheEnteredAmountOfMoneyMustBeGreaterThan0Exception();
        }
        double rate = rateService.getRate(currencyFrom, currencyTo, amount);
        return rate * amount;
    }
}
