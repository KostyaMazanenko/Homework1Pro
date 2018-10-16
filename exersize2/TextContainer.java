package exersize2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SaveTo(fileName = "d:/file.txt")
public class TextContainer {
    private String text = "Hello World!";

    public TextContainer(String text) {
        this.text = text;
    }

    public TextContainer() {
        super();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Saver
    public void save(File file){
        try(PrintWriter pw = new PrintWriter(file)) {
            pw.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
