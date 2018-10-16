package exersize3;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Serializer {

    public static void serialize(Object obj, File file) throws IllegalAccessException {
        Class<ClassWithFields> c = ClassWithFields.class;

        StringBuilder sb = new StringBuilder("");

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
            }
            if (field.isAnnotationPresent(Save.class)) {
                sb.append(Modifier.toString(field.getModifiers()) + " ");
                if (field.getType() == int.class) {
                    sb.append("int" + " " + field.getName() + " = " + field.getInt(obj));
                } else if (field.getType() == String.class) {
                    sb.append("String" + " " + field.getName() + " = " + (String) field.get(obj) + System.lineSeparator());
                }
            }
        }

        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static <T> T deserialize(Class<T> c, File file) throws FileNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        T obj = c.newInstance();
        try (BufferedReader f = new BufferedReader(new FileReader(file))) {
            String str;
            for (; (str = f.readLine()) != null; ) {
                String[] nameValue = str.split(" = ");
                String[] modTypeName = nameValue[0].split(" ");
                Field field = c.getDeclaredField(modTypeName[2]);
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                if (field.getType() == int.class) {
                    field.set(obj, Integer.parseInt(nameValue[1]));
                } else {
                    field.set(obj, nameValue[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
