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
import java.io.InputStream;
import java.util.ArrayList;

@WebServlet("")
public class Home extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();

        Model model = ModelFactory.getModel();
        ArrayList<String> noteNames = model.getNoteNames();
//        PrintWriter writer = response.getWriter();

        request.setAttribute("noteNames", noteNames);

        RequestDispatcher dispatch = context.getRequestDispatcher("/index.jsp");
        dispatch.forward(request, response);
    }

}

