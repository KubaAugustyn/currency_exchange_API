package pl.kurs.exchangerateapp.interfaces;

public interface IUrlStringBuilder {
    String buildUrl(String currencyTo, String currencyFrom, double amount);
}
