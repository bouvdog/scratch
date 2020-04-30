import reflection.Reflector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class testReflector {

    public static void main(String[] args) {
        try {
        Constructor<?> constructor = Class.forName("reflection.Reflector")
                .getConstructor(int.class,int.class);
            Object objR = constructor.newInstance(2, 2);


            Method method = Class.forName("reflection.Reflector")
                    .getMethod("multiply", null);
            System.out.println(method.invoke(objR, null));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
