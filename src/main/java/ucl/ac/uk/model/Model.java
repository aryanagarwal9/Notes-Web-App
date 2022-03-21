package ucl.ac.uk.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Model{

    private Index index = new Index();

    public String generateNoteContent(InputStream is) throws IOException {
        String line;
        String text = "<p>";

        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while ((line = reader.readLine()) != null) {
                text += line + "<br>";
            }
            text += "</p>";
        }
        return text;
    }

    public ArrayList<String> getNoteNames(){
        return index.getNoteNames();
    }
}
