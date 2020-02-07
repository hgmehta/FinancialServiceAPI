package com.example.financialservices;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    PopularStockAdapter popularStockAdapter;
    ArrayList<StockMarketHours> tradingHoursArray;
    View layoutView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutView = view;

        iDataService service = RetrofitClient.getRetrofitInstance().create(iDataService.class);

        Call<TradingHours> call = service.getTradingHours();

        call.enqueue(new Callback<TradingHours>() {
            @Override
            public void onResponse(Call<TradingHours> call, Response<TradingHours> response) {

                TradingHours tradingHours = response.body();

                try {
                    tradingHoursArray = new ArrayList<>(tradingHours.getStockMarketHours());
                    generateRecyclerView(layoutView, tradingHoursArray);
                } catch (NullPointerException exception) {

                }

            }

            @Override
            public void onFailure(Call<TradingHours> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "Something Went Wrong!" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void generateRecyclerView(View view,ArrayList<StockMarketHours> stockMarketHours){
        popularStockAdapter = new PopularStockAdapter(stockMarketHours, getActivity().getApplicationContext(),true);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycle_most_gainers);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(popularStockAdapter);
    }


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }



}
