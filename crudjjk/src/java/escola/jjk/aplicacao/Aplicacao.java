/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package escola.jjk.aplicacao;

import escola.jjk.dao.FeiticeiroDAO;
import escola.jjk.model.Feiticeiro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz
 */
@WebServlet(name = "Aplicacao", urlPatterns = {"/Aplicacao"})
public class Aplicacao extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
         
        
        /*
        
        <label for="rgf">RGF:</label><br>
         <input type="number" id="rgf" name="rgf" required><br>
        int rgf = Integer.parseInt(request.getParameter("rgf"));
        
        */
        
        
        String nome = request.getParameter("nome");
        String grau = request.getParameter("grau");
        String tecnica_inata = request.getParameter("tecnica_inata");
        String periodo_escolar = request.getParameter("periodo_escolar");
        
        
        
        FeiticeiroDAO feiticeiroDAO = new FeiticeiroDAO();
        
        Feiticeiro feiticeiro = new Feiticeiro();
        feiticeiro.setNome(nome);
        feiticeiro.setGrau(grau);
        feiticeiro.setTecnica_inata(tecnica_inata);
        feiticeiro.setPeriodo_escolar(periodo_escolar);
        
        feiticeiroDAO.create(feiticeiro);
        
        
        
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado Banco</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado Banco</h1>");
            
            //visualização dos registros do BD TODOS Em forma de tabela
        
            out.println("<table border='1'>");
            out.println("<tr><th>RGF</th><th>Nome</th><th>Grau</th><th>Técnica Inata</th><th>Ano Escola</th></tr>");
            for(Feiticeiro f : feiticeiroDAO.read()){
                out.println("<tr>");
                out.println("<td>" + f.getRgf() + "</td>");
                out.println("<td>" + f.getNome() + "</td>");
                out.println("<td>" + f.getGrau() + "</td>");
                out.println("<td>" + f.getTecnica_inata() + "</td>");
                out.println("<td>" + f.getPeriodo_escolar() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            out.println("</body>");
            out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
