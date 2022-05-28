/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestaotec.controller.produto;

import com.gestaotec.dao.GenericDAO;
import com.gestaotec.dao.ProdutoDAO;
import com.gestaotec.model.Marca;
import com.gestaotec.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebServlet(name = "ProdutoCadastrar", urlPatterns = {"/ProdutoCadastrar"})
public class ProdutoCadastrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        int idMarca = Integer.parseInt(request.getParameter("idMarca"));
        String descricao = request.getParameter("descricao");
        Date dataValidade = Date.valueOf(request.getParameter("dataValidade"));
        String mensagem = null;
        
        try{
        
            Produto oProduto = new Produto();
            oProduto.setIdProduto(idProduto);
            oProduto.setDescricao(descricao);
            oProduto.setDataValidade(dataValidade);
            oProduto.setMarca(new Marca(idMarca,"",""));
            
            GenericDAO dao = new ProdutoDAO();
            if (dao.cadastrar(oProduto)){
                mensagem = "Produto cadastrado com sucesso!";
            }else {
                mensagem = "Problemas ao cadastrar Produto.Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("ProdutoListar");
            
        }catch(Exception ex){
            System.out.println("Problemas no Servlet ao cadastrar Produto! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
