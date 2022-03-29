package ucl.ac.uk.servlets;

import ucl.ac.uk.model.Model;
import ucl.ac.uk.model.ModelFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NewNote")
public class NewNoteServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Model model = ModelFactory.getModel();

        String newNoteName = request.getParameter("name");
        String newNoteContent = request.getParameter("content");
        model.addNote(newNoteName, newNoteContent);

        response.sendRedirect("http://localhost:8080");
    }
}

