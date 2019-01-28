package com.example.nerexireyes.onturnsbase;

public class Pedidos {


    String id, Cedula_cliente, pedido, estadopedido;
    public Pedidos(String id_de_turno, String Cedula_cliente, String pedido, String estadopedido) {
        this.id = id_de_turno;
        this.Cedula_cliente = Cedula_cliente;
        this.pedido = pedido;
        this.estadopedido = estadopedido;

    }

    public String getid() {
        return id;
    }

    public String getCedula_cliente() {
        return Cedula_cliente;
    }

    public String getPedido() {
        return pedido;
    }

    public String getEstadopedido() {
        return estadopedido;
    }
}
