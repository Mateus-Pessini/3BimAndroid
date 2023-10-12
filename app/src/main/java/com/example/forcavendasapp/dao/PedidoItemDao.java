package com.example.forcavendasapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.forcavendasapp.helper.SQLiteDataHelper;
import com.example.forcavendasapp.model.PedidoItem;

import java.util.ArrayList;

public class PedidoItemDao implements GenericDao<PedidoItem> {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase bd;
    private String[] colunas = {"CODIGO", "CODITEM", "CODPEDIDO", "QUANTIDADE", "DESCRICAO"};
    private String tableName = "PEDIDOITEM";
    private Context context;
    private static PedidoItemDao instancia;

    private PedidoItemDao(Context context) {
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR", null, 1);
        bd = openHelper.getWritableDatabase();
    }

    public static PedidoItemDao getInstancia(Context context) {
        if (instancia == null)
            return instancia = new PedidoItemDao(context);
        else
            return instancia;
    }

    @Override
    public long insert(PedidoItem obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("CODITEM", obj.getCodigoItem());
            valores.put("CODPEDIDO", obj.getCodigoPedido());
            valores.put("QUANTIDADE", obj.getQuantidade());
            valores.put("DESCRICAO", obj.getDesc());

            return bd.insert(tableName, null, valores);
        } catch (SQLException ex) {
            Log.e("ERRO", "PedidoItemDAO.insert(): " + ex.getMessage());
        }
        return -1;
    }

    @Override
    public long update(PedidoItem obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put("CODITEM", obj.getCodigoItem());
            valores.put("CODPEDIDO", obj.getCodigoPedido());
            valores.put("QUANTIDADE", obj.getQuantidade());
            valores.put("DESCRICAO", obj.getDesc());

            String[] identificador = {String.valueOf(obj.getCodigo())};
            return bd.update(tableName, valores, "CODIGO = ?", identificador);
        } catch (SQLException ex) {
            Log.e("ERRO", "PedidoItemDAO.update(): " + ex.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(PedidoItem obj) {
        try {
            String[] identification = {String.valueOf(obj.getCodigo())};
            return bd.delete(tableName, "CODIGO = ?", identification);
        } catch (SQLException ex) {
            Log.e("ERRO", "PedidoItemDAO.delete(): " + ex.getMessage());
        }
        return -1;
    }

    @Override
    public ArrayList<PedidoItem> getAll() {
        ArrayList<PedidoItem> lista = new ArrayList<>();
        try {
            Cursor cursor = bd.query(tableName, colunas, null, null, null, null, "CODIGO asc");
            if (cursor.moveToFirst()) {
                do {
                    PedidoItem pedidoItem = new PedidoItem();
                    pedidoItem.setCodigo(cursor.getInt(0));
                    pedidoItem.setCodigoItem(cursor.getInt(1));
                    pedidoItem.setCodigoPedido(cursor.getInt(2));
                    pedidoItem.setQuantidade(cursor.getInt(3));
                    pedidoItem.setDesc(cursor.getString(4));

                    lista.add(pedidoItem);
                } while (cursor.moveToNext());
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "PedidoItemDAO.getAll(): " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public PedidoItem getById(int id) {
        try {
            Cursor cursor = bd.query(tableName, colunas, "CODIGO = ?", null, null, null, "CODIGO asc");
            if (cursor.moveToFirst()) {
                PedidoItem pedidoItem = new PedidoItem();
                pedidoItem.setCodigo(cursor.getInt(0));
                pedidoItem.setCodigoItem(cursor.getInt(1));
                pedidoItem.setCodigoPedido(cursor.getInt(2));
                pedidoItem.setQuantidade(cursor.getInt(3));
                pedidoItem.setDesc(cursor.getString(4));

                return pedidoItem;
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "PedidoItemDAO.getById(): " + ex.getMessage());
        }
        return null;
    }
}
