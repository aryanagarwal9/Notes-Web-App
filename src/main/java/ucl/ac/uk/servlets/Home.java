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
public class Home extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();

        Model model = ModelFactory.getModel();

        String button = request.getParameter("button");
        String id = request.getParameter("id");
        if (button != null) {
            if (button.equals("Delete")) {
                model.deleteNote(id);
                System.out.println("deleted");
            }
        }

        ArrayList<String> noteNames = model.getNoteNames();
        request.setAttribute("noteNames", noteNames);

        RequestDispatcher dispatch = context.getRequestDispatcher("/Index.jsp");
        dispatch.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        Model model = ModelFactory.getModel();

        String newNoteName = request.getParameter("name");
        String newNoteContent = request.getParameter("content");

        model.addNote(newNoteName, newNoteContent);

        ArrayList<String> noteNames = model.getNoteNames();
        request.setAttribute("noteNames", noteNames);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/Index.jsp");
        dispatch.forward(request, response);
    }

}

