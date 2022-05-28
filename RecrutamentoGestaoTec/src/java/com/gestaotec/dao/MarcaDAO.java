/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestaotec.dao;

import com.gestaotec.model.Marca;
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
public class MarcaDAO implements GenericDAO{

    private Connection conexao;
    
    public MarcaDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }
    @Override
    public Boolean cadastrar(Object objeto) {
        Marca oMarca = (Marca) objeto;
        Boolean retorno=false;
        if (oMarca.getIdMarca()==0){
            retorno = this.inserir(oMarca);
        }else{
            retorno = this.alterar(oMarca);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Marca oMarca = (Marca) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into marca (descricao, situacao) values (?, ?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oMarca.getDescricao());
            stmt.setString(2, "A");
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                System.out.println("Problemas ao cadastrar a Marca! Erro: "+ex.getMessage());
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
        Marca oMarca = (Marca) objeto;
        PreparedStatement stmt = null;
        String sql = "update marca set descricao=?, situacao=? where idmarca=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oMarca.getDescricao());
            stmt.setString(2, oMarca.getSituacao());
            stmt.setInt(3, oMarca.getIdMarca());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Marca! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro:" + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
                int idMarca = numero;
        PreparedStatement stmt= null;
        String sql = "update marca set situacao=? where idMarca=?";
        try{
        Marca oMarca = (Marca) this.carregar(idMarca);
        stmt = conexao.prepareStatement(sql);
        if (oMarca.getSituacao().equals("A"))
            stmt.setString(1, "I");
        else stmt.setString(1, "A");
        stmt.setInt(2, idMarca);
        stmt.execute();
        conexao.commit();
        return true;
        }catch (Exception ex) {
            System.out.println("Problemas ao excluir a Marca! Erro: "+ex.getMessage());
            try{
                conexao.rollback();
            }catch (SQLException e) {
                System.out.println("Erro rollback "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idMarca = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Marca oMarca = null;
        String sql = "select * from marca where idMarca=?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idMarca);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oMarca = new Marca();
                oMarca.setIdMarca(rs.getInt("idMarca"));
                oMarca.setDescricao(rs.getString("descricao"));
                oMarca.setSituacao(rs.getString("situacao"));
            }
            return oMarca;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Marca! Erro:" + ex.getMessage());
            return false;
        }

    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from marca order by idMarca";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Marca oMarca = new Marca();
                oMarca.setIdMarca(rs.getInt("idMarca"));
                oMarca.setDescricao(rs.getString("descricao"));
                oMarca.setSituacao(rs.getString("situacao"));
                resultado.add(oMarca);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Marca! Erro:" + ex.getMessage());
        }
        return resultado;
}
    
}
