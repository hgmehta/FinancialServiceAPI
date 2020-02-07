package com.example.financialservices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.stockName.setText(this.mostGainerStocks.get(position).getTicker());
    }

    @Override
    public int getItemCount() {
        return mostGainerStocks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView stockName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            stockName = itemView.findViewById(R.id.MG_Companyname);

            itemView.setTag(this);
            itemView.setOnClickListener(listener);



        }
    }
}
