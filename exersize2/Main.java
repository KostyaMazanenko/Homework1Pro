package exersize2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        TextContainer tc = new TextContainer("Hello world!");
        Class<TextContainer> container = TextContainer.class;

        if(container.isAnnotationPresent(SaveTo.class)){
            SaveTo st = container.getAnnotation(SaveTo.class);

            File file = new File(st.fileName());

            Method[] methods = container.getMethods();

            for(Method method : methods){
                if(method.isAnnotationPresent(Saver.class)){
                    try {
                        method.invoke(tc, file);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Something wrong");
        }
    }
}
