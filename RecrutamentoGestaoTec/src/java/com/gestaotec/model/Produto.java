package com.gestaotec.model;

import com.gestaotec.utils.Conversao;
import java.sql.Date;

/**
 *
 * @author Acer
 */
public class Produto {
        
        private int idProduto;
        private String descricao;
        private Date dataValidade;
        private Marca marca;

    public Produto(int idProduto, String descricao, Date dataValidade, Marca marca) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.dataValidade = dataValidade;
        this.marca = marca;
    }

    public Produto() {
        this.idProduto = 0;
        this.descricao = "";
        this.dataValidade = null;
        this.marca = marca;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    
        
}
