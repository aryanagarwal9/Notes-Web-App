package ucl.ac.uk.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class NoteFileWriter{
    protected final String filename;
    protected final BufferedWriter writer;


    public NoteFileWriter(final String filename) {
        this.filename = filename;
        FileWriter fw = null;
        try {
            fw = new FileWriter(filename);
        } catch (IOException e) {
            error("Cannot open file: " + filename);
        }
        writer = new BufferedWriter(fw);
    }


    public final synchronized void flush() {
        try {
            writer.flush();
        } catch (IOException e) {
            error("Cannot flush file: " + filename);
        }
    }


    public final synchronized void close() {
        flush();
        try {
            writer.close();
        } catch (IOException e) {
            error("Cannot close file: " + filename);
        }
    }


    public final synchronized void writeString(final String s) {
        try {
            writer.write(s);
        } catch (IOException e) {
            error("writeString failed to file: " + filename);
        }
    }


    private void error(final String message) {
        System.err.println(message);
        System.err.println("Unable to continue executing program.");
        System.exit(1);
    }
}
