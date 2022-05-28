/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestaotec.dao;

import com.gestaotec.model.Marca;
import com.gestaotec.model.Produto;
import com.gestaotec.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ProdutoDAO implements GenericDAO {

    private Connection conexao;

    public ProdutoDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }

    
    
    @Override
    public Boolean cadastrar(Object objeto) {
        Produto oProduto = (Produto) objeto;
        Boolean retorno=false;
        if (oProduto.getIdProduto()==0){
            retorno = this.inserir(oProduto);
        }else{
            retorno = this.alterar(oProduto);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Produto oProduto = (Produto) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into produto (descricao, idMarca, dataValidade) values (?, ?, ?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oProduto.getDescricao());
            stmt.setInt(2, oProduto.getMarca().getIdMarca());
            stmt.setDate(3, oProduto.getDataValidade());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                System.out.println("Problemas ao cadastrar o Produto! Erro: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            }catch(SQLException e) {
                System.out.println("Erro:"+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Produto oProduto = (Produto) objeto;
        PreparedStatement stmt = null;
        String sql = "update produto set descricao=?,idMarca=?,dataValidade=? where idproduto=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oProduto.getDescricao());
            stmt.setInt(2, oProduto.getMarca().getIdMarca());
            stmt.setDate(3, oProduto.getDataValidade());
            stmt.setInt(4, oProduto.getIdProduto());
            stmt.execute();
            conexao.commit();
            return false;
        }catch (Exception ex) {
            try{
                System.out.println("Problemas ao alterar o Produto! Erro: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch(SQLException e){
                System.out.println("Erro: "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idProduto = numero;
        PreparedStatement stmt = null;

        String sql = "delete from produto where idproduto=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o Produto! Erro: " + ex.getMessage());

            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rolback " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }

    }

    @Override
    public Object carregar(int numero) {
        int idProduto = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto oProduto = null;
        String sql = "select * from produto where idProduto=?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oProduto = new Produto();
                oProduto.setIdProduto(rs.getInt("idProduto"));
                oProduto.setDescricao(rs.getString("descricao"));
                oProduto.setDataValidade(rs.getDate("dataValidade"));
            }
            return oProduto;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Produto! Erro:" + ex.getMessage());
            return false;
        }

    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from produto order by descricao";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto oProduto = new Produto();
                oProduto.setIdProduto(rs.getInt("idProduto"));
                oProduto.setDescricao(rs.getString("descricao"));
                oProduto.setDataValidade(rs.getDate("dataValidade"));
                
                MarcaDAO oMarcaDAO = null;
                try {
                    oMarcaDAO = new MarcaDAO();
                } catch (Exception ex) {
                    System.out.println("Erro ao buscar marca "+ex.getMessage());
                    ex.printStackTrace();
                }
                oProduto.setMarca((Marca) oMarcaDAO.carregar(rs.getInt("idMarca")));
                resultado.add(oProduto);
            }
        }catch (SQLException ex){
            System.out.println("Problema ao listar Produto! Erro: ");
        }
        return resultado;
    }
}
    
    
