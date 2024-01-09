import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.kurs.exchangerateapp.exceptions.TheEnteredAmountOfMoneyMustBeGreaterThan0Exception;

import pl.kurs.exchangerateapp.interfaces.ICurrencyService;
import pl.kurs.exchangerateapp.interfaces.IRateService;
import pl.kurs.exchangerateapp.service.CurrencyService;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CurrencyServiceTest {

    @Mock
    private IRateService rateServiceMock;

    private ICurrencyService currencyService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        currencyService = new CurrencyService(rateServiceMock);
    }

    @Test(expected = TheEnteredAmountOfMoneyMustBeGreaterThan0Exception.class)
    public void shouldThrowTheEnteredAmountOfMoneyMustBeGreaterThan0ExceptionWhenYouEnterNonPositiveAmountOfMoney() throws IOException, ParseException, TheEnteredAmountOfMoneyMustBeGreaterThan0Exception {
        currencyService.exchange("USD", "EUR", 0.0);
    }

    @Test
    public void shouldGet270XcdFrom100Usd() throws IOException, ParseException, TheEnteredAmountOfMoneyMustBeGreaterThan0Exception {
        double expectedValue = 450.0;
        Mockito.when(rateServiceMock.getRate("EUR", "PLN", 100.0)).thenReturn(4.5);
        double result = currencyService.exchange("EUR", "PLN", 100.0);
        assertEquals(expectedValue, result, 0.1);
    }

    @Test
    public void shouldGet37UsdFrom100Xcd() throws IOException, ParseException, TheEnteredAmountOfMoneyMustBeGreaterThan0Exception {
        double expectedValue = 37.0021;
        Mockito.when(rateServiceMock.getRate("XCD", "USD", 100.0)).thenReturn(0.370021);
        double result = currencyService.exchange("XCD", "USD", 100.0);
        assertEquals(expectedValue, result, 0.1);
    }
}
