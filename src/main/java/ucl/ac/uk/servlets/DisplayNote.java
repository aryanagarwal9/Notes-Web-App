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

@WebServlet("/DisplayNote")
public class DisplayNote extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();

        String id = request.getParameter("id");
        request.setAttribute("name", id);

        String fname = id + ".txt";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(fname);

        Model model = ModelFactory.getModel();
        String content = model.noteTextToHTML(is);

        request.setAttribute("content", content);

        RequestDispatcher dispatch = context.getRequestDispatcher("/DisplayNote.jsp");
        dispatch.forward(request, response);
    }

}

