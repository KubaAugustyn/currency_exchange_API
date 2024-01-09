package pl.kurs.exchangerateapp.interfaces;

public interface ApiConfig {

    //    "https://api.apilayer.com/exchangerates_data/convert?to=USD&from=EUR&amount=amount"

    String API_KEY = "RDPgmvUO8AFHZ4gobGXxd7Q4CIEu4BwZ";
    String BASE_HTTP = "https://api.apilayer.com";
    String ENDPOINT_WITH_PARAMETER_TO = "/exchangerates_data/convert?to=";
    String PARAMETER_FROM = "&from=";
    String PARAMETER_AMOUNT = "&amount=";

}
