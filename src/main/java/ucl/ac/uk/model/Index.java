package ucl.ac.uk.model;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Collections;

public class Index{
    private ArrayList<Note> notes = new ArrayList<>();

    ArrayList<String> getNoteNames() {
        try{
        addNote("test1", "try text 1");} catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        }

//        addNote();
        ArrayList<String> noteNames = new ArrayList<>();
        if (!notes.isEmpty()) {
            for (Note note : notes) {
                noteNames.add(note.getName());
            }
        }
        return noteNames;
    }

    private boolean isNameUsed(String name) {
        for (Note note : notes) {
            if (name.equals(note.getName())) {
                return true;
            }
        }
        return false;
    }

    void addNote(String name, String text) throws FileAlreadyExistsException {
        if (isNameUsed(name)) {
            throw new FileAlreadyExistsException("Please use a different name");
        } else {
            Note note = new Note(name, text);
            notes.add(note);
        }
    }

    void deleteNote(String name) {
    }

    ArrayList<Note> sort() {
        ArrayList<Note> notesCopy = (ArrayList<Note>) notes.clone();

        Collections.sort(notesCopy);

        return notesCopy;
    }


}
