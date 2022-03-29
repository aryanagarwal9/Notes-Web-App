package ucl.ac.uk.model;

import java.io.File;


class Note{
    private String name;
    private String fPath;

    Note(String name, String text) {
        this.name = name;
        this.fPath = Env.notesDir + this.name + ".txt";
        writeText(text);
    }

    String getName() {
        return this.name;
    }

    void setName(String newName) {
        this.name = newName;
    }

    void setfPath(String newName) {
        this.fPath = Env.notesDir + newName + ".txt";
    }

    private void writeText(String text) {
        NoteFileWriter out = new NoteFileWriter(this.fPath);
        out.writeString(text);
        out.close();
    }

    void editNote(String newName, String newContent) {
        deleteNoteFile();
        setName(newName);
        setfPath(newName);
        writeText(newContent);
    }

    void deleteNoteFile() {
        File myObj = new File(this.fPath);
        myObj.delete();
    }
}
