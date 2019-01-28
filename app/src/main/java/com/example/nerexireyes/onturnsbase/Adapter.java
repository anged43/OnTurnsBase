package com.example.nerexireyes.onturnsbase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.holder> {
    List<Pedidos>pedidos;

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowrecycler, viewGroup, false);
        holder h = new holder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {
        Pedidos p = pedidos.get(i);
        holder.ci.setText(p.getCedula_cliente());
        holder.estado.setText(p.getEstadopedido());

    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    public static class holder extends RecyclerView.ViewHolder {
        TextView ci, estado;

        public holder(@NonNull View itemView) {
            super(itemView);

            ci = (TextView) itemView.findViewById(R.id.txtci);
            estado = (TextView)itemView.findViewById(R.id.textoestado);
        }
    }
}
