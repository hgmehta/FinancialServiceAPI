package com.example.financialservices;

import retrofit2.Call;
import retrofit2.http.GET;

public interface iDataService {


    @GET("stock/gainers")
    Call<MostGainer> getMostGainer ();

    @GET("stock/losers")
    Call<MostLoser> getMostLoser ();
}


