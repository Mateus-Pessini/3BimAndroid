package com.example.forcavendasapp.controller;

import android.content.Context;
import com.example.forcavendasapp.dao.PedidoItemDao;
import com.example.forcavendasapp.model.PedidoItem;

import java.util.ArrayList;

public class PedidoItemController {

    private Context context;

    public PedidoItemController(Context context) {
        this.context = context;
    }

    public long salvarPedidoItem(PedidoItem pedidoItem){
        return PedidoItemDao.getInstancia(context).insert(pedidoItem);
    }

    public long atualizarPedidoItem(PedidoItem pedidoItem){
        return PedidoItemDao.getInstancia(context).update(pedidoItem);
    }

    public long apagarPedidoItem(PedidoItem pedidoItem){
        return PedidoItemDao.getInstancia(context).delete(pedidoItem);
    }

    public ArrayList<PedidoItem> findAllPedidoItem(){
        return PedidoItemDao.getInstancia(context).getAll();
    }

    public PedidoItem findByIdPedidoItem(int codigo) {
        return PedidoItemDao.getInstancia(context).getById(codigo);
    }

    public String validaPedidoItem(int codigo, int codigoItem, int quantidade) {
        String mensagem = "";

        if (codigo <= 0) {
            mensagem += "Código do item do pedido deve ser maior que zero!\n";
        }

        if (codigoItem <= 0) {
            mensagem += "Código do item deve ser maior que zero!\n";
        }

        if (quantidade <= 0) {
            mensagem += "A quantidade do item deve ser maior que zero!\n";
        }

        return mensagem;
    }
}

