package ucl.ac.uk.model;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

class Index{
    private final ArrayList<Note> notes = new ArrayList<>();

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

    void editNote(String oldName, String newName, String newContent) {
        for (Note note : notes) {
            if (note.getName().equals(oldName)) {
                note.editNote(newName, newContent);
            }
        }
    }

    void deleteNote(String name) {
        Note noteToBeDeleted = null;
        for (Note note : notes) {
            if (note.getName().equals(name)) {
                noteToBeDeleted = note;
            }
        }
//        Can not be removed inside the for loop due to ConcurrentModificationException
        if (noteToBeDeleted != null) {
            noteToBeDeleted.deleteNoteFile();
            notes.remove(noteToBeDeleted);
        }
    }

    ArrayList<String> getNoteNames() {
        ArrayList<String> noteNames = new ArrayList<>();
        if (!notes.isEmpty()) {
            for (Note note : notes) {
                noteNames.add(note.getName());
            }
        }
        return noteNames;
    }

}
