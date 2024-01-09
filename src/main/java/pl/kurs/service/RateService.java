package pl.kurs.service;

import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.kurs.exceptions.TheEnteredAmountOfMoneyMustBeGreaterThan0Exception;
import pl.kurs.interfaces.IRateService;
import pl.kurs.interfaces.IUrlStringBuilder;

import java.io.IOException;

public class
RateService implements IRateService {
    private final ApiConnectionService apiConnectionService;
    private final IUrlStringBuilder urlStringBuilder;

    public RateService(ApiConnectionService apiConnectionService, IUrlStringBuilder urlStringBuilder) {
        this.apiConnectionService = apiConnectionService;
        this.urlStringBuilder = urlStringBuilder;
    }

    @Override
    public double getRate(String fromCurrencyMark, String toCurrencyMark, double amount) throws IOException, ParseException, TheEnteredAmountOfMoneyMustBeGreaterThan0Exception {
        if (amount <= 0.0) {
            throw new TheEnteredAmountOfMoneyMustBeGreaterThan0Exception();
        }
        String preparedUrl = urlStringBuilder.buildUrl(toCurrencyMark, fromCurrencyMark, amount);
        Response currencyApiResponse = apiConnectionService.getCurrencyApiResponse(preparedUrl);
        String string = currencyApiResponse.body().string();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(string);
        JSONObject info = (JSONObject) json.get("info");
        return (double) info.get("rate");
    }
}

