package ucl.ac.uk.main;

public class Note{
    private String name;

    Note(String name) {
        this.name = name;
    }

    Note(String name, String text) {
        this.name = name;
    }

    String getName() {
        System.out.println("test commit");
        return this.name;
    }

    void setName(String newName) {
        this.name = newName;
    }
}
