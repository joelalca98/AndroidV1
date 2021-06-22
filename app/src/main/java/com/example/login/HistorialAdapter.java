package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.ViewHolder> {

    private List<Compra_arma> armasCompradas;
    private Context context;


    public void setData(List<Compra_arma> compra_armas){
        this.armasCompradas = compra_armas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistorialAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new HistorialAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.rowhistorial_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull HistorialAdapter.ViewHolder holder, int position) {

        Compra_arma compra_arma = armasCompradas.get(position);
        String arma = compra_arma.getNombre_arma();
        String precio = compra_arma.getForma_pago();

        holder.arma.setText(arma);
        holder.precio.setText(precio);

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView arma;
        TextView precio;
        public View layout;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            layout = itemView;
            arma = itemView.findViewById(R.id.armaRow);
            precio = itemView.findViewById(R.id.pagoRow);

        }
    }

    @Override
    public int getItemCount() {
        return armasCompradas.size();
    }
}
