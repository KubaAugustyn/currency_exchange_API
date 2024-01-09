package pl.kurs.exchangerateapp.service;

import pl.kurs.exchangerateapp.interfaces.ApiConfig;
import pl.kurs.exchangerateapp.interfaces.IUrlStringBuilder;

public class UrlStringBuilder implements IUrlStringBuilder {

    @Override
    public String buildUrl(String currencyTo, String currencyFrom, double amount) {
        return ApiConfig.BASE_HTTP + ApiConfig.ENDPOINT_WITH_PARAMETER_TO + currencyTo + ApiConfig.PARAMETER_FROM + currencyFrom + ApiConfig.PARAMETER_AMOUNT + amount;
    }

}
