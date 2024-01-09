package pl.kurs.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.kurs.interfaces.ApiConfig;
import pl.kurs.interfaces.IUrlStringBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiConnectionService {

    private IUrlStringBuilder urlStringBuilder;

    public ApiConnectionService(IUrlStringBuilder urlStringBuilder) throws RuntimeException {
        this.urlStringBuilder = urlStringBuilder;
    }

    public Response getCurrencyApiResponse(String preparedUrl) {
        Response response;
        try {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .build();

            Request request = new Request.Builder()
                    .url(preparedUrl)
                    .addHeader("apikey", ApiConfig.API_KEY)
                    .get().build();
            response = client.newCall(request).execute();

            return response;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
