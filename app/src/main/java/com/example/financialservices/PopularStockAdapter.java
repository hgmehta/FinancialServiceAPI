package com.example.financialservices;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PopularStockAdapter extends RecyclerView.Adapter<PopularStockAdapter.ViewHolder> {

    private View.OnClickListener listener;
    private Context context;
    private ArrayList<MostGainerStock> mostGainerStocks;

    public PopularStockAdapter(ArrayList<MostGainerStock> mostGainerStocks, Context context ) {
        this.context = context;
        this.mostGainerStocks=mostGainerStocks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setTag(this);
            itemView.setOnClickListener(listener);



        }
    }
}
