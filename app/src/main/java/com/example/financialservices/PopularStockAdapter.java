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
    private ArrayList<MostLoserStock> mostLoserStocks;
    int test;

    public PopularStockAdapter(ArrayList<MostGainerStock> mostGainerStocks, Context context ) {
        this.context = context;
        this.mostGainerStocks=mostGainerStocks;
    }

    public PopularStockAdapter(ArrayList<MostLoserStock> mostLoserStocks,Context context,int test)
    {
        this.context=context;
        this.mostLoserStocks=mostLoserStocks;
        this.test=test;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.companyName.setText(this.mostGainerStocks.get(position).getCompanyName());
        holder.tickerName.setText(this.mostGainerStocks.get(position).getTicker());
        holder.stockPrice.setText("$" + this.mostGainerStocks.get(position).getPrice());
        holder.priceChanges.setText(this.mostGainerStocks.get(position).getChanges().toString() + this.mostGainerStocks.get(position).getChangesPercentage());
    }

    @Override
    public int getItemCount() {
        return mostGainerStocks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView companyName;
        TextView tickerName;
        TextView priceChanges;
        TextView stockPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            companyName = itemView.findViewById(R.id.MG_Companyname);
            tickerName = itemView.findViewById(R.id.MG_ticker);
            priceChanges = itemView.findViewById(R.id.MG_Changes);
            stockPrice = itemView.findViewById(R.id.MG_Stockprices);
            itemView.setTag(this);
            itemView.setOnClickListener(listener);



        }
    }
}
