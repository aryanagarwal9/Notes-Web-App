package ucl.ac.uk.model;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class Index{
    private final ArrayList<Note> notes = new ArrayList<>();

    ArrayList<String> getNoteNames() {
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

    void addNote(String name, String content) throws FileAlreadyExistsException {
        if (isNameUsed(name)) {
            throw new FileAlreadyExistsException("Please use a different name");
        } else {
            Note note = new Note(name, content);
            notes.add(note);
        }
    }

    void deleteNote(String name) {
        notes.removeIf(note -> (note.getName().equals(name)));
    }
}
