package org.example.domain;

public class Produto {
    String nome;
    Double valor;
    Integer codigo_barras;

    public Produto(String nome, Double valor, Integer codigo_barras) {
        this.nome = nome;
        this.valor = valor;
        this.codigo_barras = codigo_barras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(Integer codigo_barras) {
        this.codigo_barras = codigo_barras;
    }
}
