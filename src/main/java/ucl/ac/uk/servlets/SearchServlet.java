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

@WebServlet("/Search")
public class SearchServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        ServletContext context = getServletContext();

        String searchString = request.getParameter("searchString");
        ArrayList<String> searchResult = model.getSearchResult(searchString);
        request.setAttribute("searchString", searchString);
        request.setAttribute("searchResult", searchResult);

        RequestDispatcher dispatch = context.getRequestDispatcher("/Search.jsp");
        dispatch.forward(request, response);
    }
}

