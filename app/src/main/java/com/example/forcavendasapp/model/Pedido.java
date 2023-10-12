package com.example.forcavendasapp.model;

import java.util.ArrayList;

public class Pedido {
    private int codigo;
    private int codigoPessoa; // CDPESSOA
    private int codigoEndereco;
    private double valorTotal;

    public Pedido() {
        // Construtor vazio necessário para trabalhar com o SQLite (ORM)
    }

    public Pedido(int codigo, int codigoPessoa, int codigoEndereco, double valorTotal) {
        this.codigo = codigo;
        this.codigoPessoa = codigoPessoa;
        this.codigoEndereco = codigoEndereco;
        this.valorTotal = valorTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(int codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

}
