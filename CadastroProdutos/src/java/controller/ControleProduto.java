/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author bruna
 */
@WebServlet(name = "ControleProduto", urlPatterns = {"/ControleProduto"})
public class ControleProduto extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            String op = request.getParameter("op");
            ProdutoDAO pdao = new ProdutoDAO();
            Produto p = new Produto();
            String mensagem = "";
            
            if (op.equals("CADASTRAR")){
                String des = request.getParameter("txtdescricao");
                double preco = Double.parseDouble(request.getParameter("txtpreco"));
                p.setDescricao(des);
                p.setPreco(preco);
                try {
                    pdao.cadastrar(p);
                    mensagem = "Cadastrado com sucesso!";
                } catch (ClassNotFoundException | SQLException ex){
                    mensagem = "ERRO" + ex.getMessage();
                }
                
                request.setAttribute("msg", mensagem);
                request.getRequestDispatcher("resultadocadastrar.jsp").forward(request, response);
                
            } else if (op.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                
                p.setId(id);
                try {
                    pdao.deletar(p);
                    mensagem = "Deletado com sucesso!";
                } catch (ClassNotFoundException | SQLException ex) {
                    mensagem = "ERRO" + ex.getMessage();
                }
                
                request.setAttribute("msg", mensagem);
                request.getRequestDispatcher("resultadodeletar.jsp").forward(request, response);
                
                
            } else if (op.equals("ATUALIZAR")) {
                String des = request.getParameter("txtdescricao");
                double preco = Double.parseDouble(request.getParameter("txtpreco"));
                int id = Integer.parseInt(request.getParameter("txtid"));
                
                p.setDescricao(des);
                p.setPreco(preco);
                p.setId(id);
                try {
                    pdao.atualizar(p);
                    Produto resultado = pdao.consultarById(p);
                    request.setAttribute("produto", resultado);
                    mensagem = "Atualizado com sucesso!";
                } catch (ClassNotFoundException | SQLException ex){
                    mensagem = "ERRO" + ex.getMessage();
                }
                

                
                request.setAttribute("msg", mensagem);
                request.getRequestDispatcher("resultadoatualizar.jsp").forward(request, response);
                
            } else if (op.equals("VER UM PRODUTO")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                p.setId(id);
                
                try{
                    Produto resultado = pdao.consultarById(p);
                    request.setAttribute("produto", resultado);
                    mensagem = "Consulta realizada com sucesso!!";
                } catch ( ClassNotFoundException | SQLException ex) {
                    mensagem = "ERRO" + ex.getMessage();
                }
                
                request.setAttribute("msg", mensagem);
                request.getRequestDispatcher("resultadoconsultar.jsp").forward(request, response);
                
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
