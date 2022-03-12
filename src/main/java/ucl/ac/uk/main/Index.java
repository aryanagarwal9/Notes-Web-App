package ucl.ac.uk.main;

import java.util.ArrayList;
import java.util.Collections;

public class Index{
    private ArrayList<Note> notes = new ArrayList<>();

    ArrayList<Note> sort() {
        ArrayList<Note> notesCopy = (ArrayList<Note>) notes.clone();

        Collections.sort(notesCopy);

        return notesCopy;
    }

}
