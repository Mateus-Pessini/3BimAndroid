package com.example.forcavendasapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.forcavendasapp.model.PedidoItem;
import java.util.List;

public class PedidoItemAdapter extends ArrayAdapter<PedidoItem> {
    public PedidoItemAdapter(Context context, List<PedidoItem> pedidoItems) {
        super(context, 0, pedidoItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PedidoItem pedidoItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_item, parent, false);
        }

        TextView text1 = convertView.findViewById(android.R.id.text1);
        text1.setText(getDisplayText(pedidoItem));

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        PedidoItem pedidoItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        TextView text1 = convertView.findViewById(android.R.id.text1);
        text1.setText(getDisplayText(pedidoItem));

        return convertView;
    }

    // Método para obter o texto a ser exibido para um PedidoItem
    private String getDisplayText(PedidoItem pedidoItem) {
        return pedidoItem.getDesc() + " - Quantidade: " + pedidoItem.getQuantidade();
    }
}
