package exersize3;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        ClassWithFields cwf = new ClassWithFields(20);
        File file = new File("d:/a.txt");

        ClassWithFields cl = new ClassWithFields(2);
        try {
            Serializer.serialize(cwf, file);
            cl = Serializer.deserialize(cwf.getClass(), file);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println(cl.toString());


    }
}
