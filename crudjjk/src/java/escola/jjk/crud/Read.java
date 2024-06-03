/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package escola.jjk.crud;

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
@WebServlet(name = "Read", urlPatterns = {"/Read"})
public class Read extends HttpServlet {

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
        
        
        FeiticeiroDAO feiticeiroDAO = new FeiticeiroDAO();
       
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Escola Técnica de Jujutsu de Tokyo</title>");
            out.println("<link rel='icon' type='image/x-icon' href='https://www.citypng.com/public/uploads/small/11660427676zv9kgcmolil5tpntxmnhtxkmqj5lp8d6ucssv4vgz4acpajk2vdm7oc4npwpjrnjx4u6czobealec1kmiocbedhdut9521g8zaoi.png'>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style_menu.css\">");
            out.println("<link rel=\"stylesheet\" href=\"css/responsivo.css\">");
            out.println("<link rel=\"stylesheet\" href=\"css/variaveis.css\">");
            out.println("<link rel=\"stylesheet\" href=\"css/reset.css\">");
            out.println("<link rel=\"stylesheet\" href=\"css/style_table.css\">");
            out.println("</head>");
            out.println("<body id=\"body\">");
            out.println("<header class=\"cabecalho\">");
            out.println("<a href=\"index.html\"><img src=\"images/Jujutsu Kaisen High Red Logo PNG Image.png\" alt=\"Simbolo de Jujutsu\" class=\"icone\"></a>");
            out.println("<nav>");
            out.println("<ul class=\"menu\">");
            out.println("<li><a href=\"index.html\">Home</li></a>");
            out.println("<li><a href=\"select.html\">Voltar</li></a>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("</header>");
            out.println("<main>");

            //out.println("<h1>Resultado Banco</h1>");
            //visualização dos registros do BD TODOS Em forma de tabela
            out.println("<section id='container'>"); 
            out.println("<h2>Dados dos Feiticeiros</h2>");
            out.println("<table cellspacing='0'>");
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
            out.println("</section>");
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
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
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
