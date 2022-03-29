package ucl.ac.uk.servlets;

import ucl.ac.uk.model.Model;
import ucl.ac.uk.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("")
public class HomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        ServletContext context = getServletContext();

        String sortCriteria = request.getParameter("sort");
        ArrayList<String> noteNames = model.getNoteNames(sortCriteria);
        request.setAttribute("noteNames", noteNames);

        RequestDispatcher dispatch = context.getRequestDispatcher("/Index.jsp");
        dispatch.forward(request, response);
    }
}

