package pl.kurs.service;

import pl.kurs.interfaces.IUrlStringBuilder;

import static pl.kurs.interfaces.ApiConfig.*;

public class UrlStringBuilder implements IUrlStringBuilder {

    @Override
    public String buildUrl(String currencyTo, String currencyFrom, double amount) {
        return BASE_HTTP + ENDPOINT_WITH_PARAMETER_TO + currencyTo + PARAMETER_FROM + currencyFrom + PARAMETER_AMOUNT + amount;
    }

}
