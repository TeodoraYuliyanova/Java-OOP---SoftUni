package HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class reflection = Reflection.class;

        Field [] fields = reflection.getDeclaredFields();

        Arrays.stream(fields).sorted(Comparator.comparing(Field::getName))
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(field -> System.out.printf("%s must be private!%n" , field.getName()));

        Method [] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods).sorted(Comparator.comparing(Method::getName))
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .forEach(method -> System.out.printf("%s have to be public!%n" , method.getName()));

        Arrays.stream(methods).sorted(Comparator.comparing(Method::getName))
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .forEach(method -> System.out.printf("%s have to be private!%n" , method.getName()));
    }
}
