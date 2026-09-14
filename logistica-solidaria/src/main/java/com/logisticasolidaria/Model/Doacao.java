package com.logisticasolidaria.Model;

public class Doacao {
    private String id;
    private String nome;
    private String categoria;
    private String localizacao;
    private String status;
    private String descricao;
    private String quantidade;
    private String data;

    public Doacao(String id, String nome, String categoria, String localizacao,
                   String status, String descricao, String quantidade, String data) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.localizacao = localizacao;
        this.status = status;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.data = data;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getQuantidade() { return quantidade; }
    public void setQuantidade(String quantidade) { this.quantidade = quantidade; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}
