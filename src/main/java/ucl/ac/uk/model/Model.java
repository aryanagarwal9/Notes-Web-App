package ucl.ac.uk.model;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class Model{

    private Index index = new Index();

    //    Delete files in directory and add sample notes for coursework testing purposes
    Model() throws IOException {
        FileUtils.cleanDirectory(new File(Env.notesDir));

        addNote("Template1", "Sample Content");
        addNote("Template2", "Sample Content");
    }

    public String noteTextToHTML(InputStream is) throws IOException {
        String line;
        String text = "";

        if (is != null) {
            text = "<p>";
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while ((line = reader.readLine()) != null) {
                text += line + "<br>";
            }
            text += "</p>";
        }
        return text;
    }

    //    returns a list of names of notes, sorted by specified criteria
    public ArrayList<String> getNoteNames(String sortCriteria) {
        if (sortCriteria == null || sortCriteria.equals("Date Created")) {
            return index.getNoteNames();

        } else if (sortCriteria.equals("Name")) {
            ArrayList<String> names = index.getNoteNames();
            names.sort(String.CASE_INSENSITIVE_ORDER);
            return names;

        }
        return null;
    }

    public ArrayList<String> getNoteNames() {
        return index.getNoteNames();
    }


    //    take care of exception
    public void addNote(String name, String content) throws FileAlreadyExistsException {
        if (name != null) {
            index.addNote(name, content);
        }
    }

    public void deleteNote(String name) {
        index.deleteNote(name);
    }
}
