package com.gestaotec.model;

/**
 *
 * @author Acer
 */
public class Marca {

    private int idMarca;
    private String descricao;
    private String situacao;

    public Marca() {
        this.idMarca = 0;
        this.descricao = "";
        this.situacao = "A";
    }

    public Marca(int idMarca, String descricao, String situacao) {
        this.idMarca = idMarca;
        this.descricao = descricao;
        this.situacao = situacao;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
    
    
    
}
