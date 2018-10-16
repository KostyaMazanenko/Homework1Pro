package exersize1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Class<Sum> cl = Sum.class;

        Method[] methods = cl.getMethods();

        for(Method method : methods){
            if(method.isAnnotationPresent(parametersForMethod.class)){
                parametersForMethod pfm = method.getAnnotation(parametersForMethod.class);
                int a = pfm.a();
                int b = pfm.b();
                try {
                    System.out.println( method.invoke(null, a, b));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
