package ucl.ac.uk.main;

public class Note {
    private String name;

    Note(String name) {
        this.name = name;
    }

    Note(String name, String text) {
        this.name = name;
    }

    String getName() {
//        return this.name;
        int c = 0;
        while (c < 1) {
            c++;
        }
        return "hi";
    }

    void setName(String newName) {
        this.name = newName;
    }
}
