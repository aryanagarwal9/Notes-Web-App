package ucl.ac.uk.main;

class Note implements Comparable<Note>{
    private String name;
    private String fPath;


    Note(String name) {
        this.name = name;
        this.fPath = Env.notesDir + this.name + ".txt";
    }

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

    void writeText(String text) {
        FileOutput out = new FileOutput(this.fPath);

        out.writeString(text);
        out.close();
    }

    @Override
    public int compareTo(Note note){
        return this.name.compareTo(note.name);
    }

    public static void main(String[] args) {
        Note note = new Note("test1", " 2 text for testing 2");
        note = new Note("test2", " 2 text for testing 2");

    }
}
