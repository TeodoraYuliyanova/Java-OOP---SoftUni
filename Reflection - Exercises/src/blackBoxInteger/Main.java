package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    private static final Method[] methods = BlackBoxInt.class.getDeclaredMethods();
    private static final Map<String, Method> blackBoxIntMethods = Arrays.stream(methods).peek(method -> method.setAccessible(true))
            .collect(Collectors.toMap(Method::getName, method -> method));
    private static final String RESULT = "innerValue";

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance(0);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");

            String methodName = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method currentMethod = blackBoxIntMethods.get(methodName);
            currentMethod.invoke(blackBoxInt, value);

            Field result = BlackBoxInt.class.getDeclaredField(RESULT);
            result.setAccessible(true);
            System.out.println(result.get(blackBoxInt));

            input = scanner.nextLine();

        }

    }

}

