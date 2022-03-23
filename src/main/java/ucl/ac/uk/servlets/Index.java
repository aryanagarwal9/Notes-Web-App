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
public class Index extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        ServletContext context = getServletContext();

        String button = request.getParameter("button");
        String id = request.getParameter("id");
        if (button != null) {
            if (button.equals("Delete")) {
                model.deleteNote(id);
            }
        }

        ArrayList<String> noteNames = model.getNoteNames("Date Created");
        request.setAttribute("noteNames", noteNames);

        RequestDispatcher dispatch = context.getRequestDispatcher("/Index.jsp");
        dispatch.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

//        Add new note
        String newNoteName = request.getParameter("name");
        String newNoteContent = request.getParameter("content");
        model.addNote(newNoteName, newNoteContent);

//        Display notes based on sort criteria
        String sortCriteria = request.getParameter("sort");
        ArrayList<String> noteNames = model.getNoteNames(sortCriteria);
        request.setAttribute("noteNames", noteNames);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/Index.jsp");
        dispatch.forward(request, response);
    }

}

