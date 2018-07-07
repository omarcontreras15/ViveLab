package co.edu.ufps.vivelab.webService.connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gerson on 26/11/2017.
 */

public class ApiAdapter {

    private static ApiService API_SERVICE;

    public static ApiService getApiService() {

        String urlbase= "http://192.168.1.2:8080/vivelab/";

        if(API_SERVICE == null){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(urlbase).addConverterFactory(GsonConverterFactory.create()).build();
            API_SERVICE = retrofit.create(ApiService.class);
        }
        return API_SERVICE;
    }
}
