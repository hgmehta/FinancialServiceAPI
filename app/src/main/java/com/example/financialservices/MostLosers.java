package com.example.financialservices;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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


public class MostLosers extends Fragment {

    PopularStockAdapter popularStockAdapter;
    ArrayList<MostLoserStock> mostLoserStocks;
    View layoutView;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutView=view;

        iDataService service = RetrofitClient.getRetrofitInstance().create(iDataService.class);

        Call<MostLoser> call = service.getMostLoser();

        call.enqueue(new Callback<MostLoser>() {
            @Override
            public void onResponse(Call<MostLoser> call, Response<MostLoser> response) {

                MostLoser mostLoser=response.body();

                try {
                    mostLoserStocks=new ArrayList<>(mostLoser.getMostLoserStock());
                    generateRecyclerView(layoutView,mostLoserStocks);
                }catch (NullPointerException exception){

                }

            }

            @Override
            public void onFailure(Call<MostLoser> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "Something Went Wrong!" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    public void generateRecyclerView(View view,ArrayList<MostLoserStock> mostLoserStocks){
        popularStockAdapter = new PopularStockAdapter(mostLoserStocks, getActivity().getApplicationContext(),0);

        GridLayoutManager manager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        //LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycle_most_losers);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(popularStockAdapter);
    }

    public MostLosers() {
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
        return inflater.inflate(R.layout.fragment_most_losers, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
