package ucl.ac.uk.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Note implements Comparable<Note>{
    private String name;
    private final String fPath;

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

    String getfPath(){
        return this.fPath;
    }

    void writeText(String text) {
        FileOutput out = new FileOutput(this.fPath);

        out.writeString(text);
        out.close();
    }

    public String readText(){
        try {
            File myObj = new File(this.fPath);
            Scanner myReader = new Scanner(myObj);
            String text = "";
            while (myReader.hasNextLine()) {
                text = myReader.nextLine();
            } return text;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } return "fail";
    }

    @Override
    public int compareTo(Note note){
        return this.name.compareTo(note.name);
    }
}
