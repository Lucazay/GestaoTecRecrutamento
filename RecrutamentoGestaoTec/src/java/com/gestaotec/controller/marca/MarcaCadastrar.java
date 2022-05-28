/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestaotec.controller.marca;

import com.gestaotec.dao.GenericDAO;
import com.gestaotec.dao.MarcaDAO;
import com.gestaotec.model.Marca;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebServlet(name = "MarcaCadastrar", urlPatterns = {"/MarcaCadastrar"})
public class MarcaCadastrar extends HttpServlet {

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
        String descricao = request.getParameter("descricao");
        int idMarca = Integer.parseInt(request.getParameter("idMarca"));
        String situacao = request.getParameter("situacao");
        String mensagem = null ;
        
        try{
        
            Marca oMarca = new Marca();
            oMarca.setIdMarca(idMarca);
            oMarca.setDescricao(descricao);
            oMarca.setSituacao(situacao);
            
            GenericDAO dao = new MarcaDAO();
            if (dao.cadastrar(oMarca)){
                mensagem = "Marca cadastrado com sucesso!";
            }else {
                mensagem = "Problemas ao cadastrar Marca.Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("MarcaListar");
            
        }catch(Exception ex){
            System.out.println("Problemas no Servlet ao cadastrar Marca! Erro: " + ex.getMessage());
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
