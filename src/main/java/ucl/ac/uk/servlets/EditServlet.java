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

@WebServlet("/Edit")
public class EditServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        ServletContext context = getServletContext();

        String id = request.getParameter("id");
        String content = model.getNoteContent(id);
        request.setAttribute("noteName", id);
        request.setAttribute("content", content);

        RequestDispatcher dispatch = context.getRequestDispatcher("/EditNote.jsp");
        dispatch.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Model model = ModelFactory.getModel();
        String oldNoteName = request.getParameter("id");
        String newNoteName = request.getParameter("name");
        String newNoteContent = request.getParameter("content");
        model.editNote(oldNoteName, newNoteName, newNoteContent);

        response.sendRedirect("http://localhost:8080/DisplayNote?id=" + newNoteName);
    }
}


