import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import mysql.outfit.ExerciseC;
import mysql.outfit.OutfitDB;
 
 
@WebServlet("/")
public class IndexServlet extends HttpServlet {
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        ArrayList<ExerciseC> exercises = OutfitDB.select();
        request.setAttribute("exercises", exercises);
          
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
