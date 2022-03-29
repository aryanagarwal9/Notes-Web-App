package ucl.ac.uk.model;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class Model{

    private final Index index = new Index();

    //    Delete files in directory and add sample notes for coursework testing purposes
    Model() throws IOException {
        FileUtils.cleanDirectory(new File(Env.notesDir));
        addNote("Template1", "Sample Content Line 1\nSample Content Line 2");
        addNote("Template2", "Sample Content Line 1\nSample Content Line 2");
    }

    public void addNote(String noteName, String content) throws FileAlreadyExistsException {
        index.addNote(noteName, content);
    }

    public void editNote(String oldName, String newName, String newContent) {
        index.editNote(oldName, newName, newContent);
    }

    public void deleteNote(String noteName) {
        index.deleteNote(noteName);
    }

    private BufferedReader getBufferedReader(String noteName) throws NullPointerException {
        String fName = noteName + ".txt";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(fName);
        InputStreamReader isr = new InputStreamReader(is);
        return new BufferedReader(isr);
    }

    public String getNoteContent(String noteName) throws IOException {

        String line;
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader reader = getBufferedReader(noteName);
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            return text.toString();
        } catch (NullPointerException e) {
            return text.toString();
        }
    }

    public String getNoteContentInHTML(String noteName) throws IOException {

        String line;
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader reader = getBufferedReader(noteName);
            text.append("</p>");
            while ((line = reader.readLine()) != null) {
                text.append(line).append("<br>");
            }
            text.append("</p>");
            return text.toString();
        } catch (NullPointerException e) {
            return text.toString();
        }
    }

    //    returns a list of names of notes, sorted by specified criteria
    public ArrayList<String> getNoteNames(String sortCriteria) {
        if (sortCriteria == null || sortCriteria.equals("Date Created")) {
            return index.getNoteNames();

        } else if (sortCriteria.equals("Name")) {
            ArrayList<String> noteNames = index.getNoteNames();
            noteNames.sort(String.CASE_INSENSITIVE_ORDER);
            return noteNames;

        }
        return new ArrayList<>();
    }


    public ArrayList<String> getSearchResult(String searchString) {
        ArrayList<String> searchResult = new ArrayList<>();
        ArrayList<String> noteNames = getNoteNames("Name");
        for (String note : noteNames) {
            if (note.toLowerCase().contains(searchString.toLowerCase())) {
                searchResult.add(note);
            }
        }
        return searchResult;
    }
}
