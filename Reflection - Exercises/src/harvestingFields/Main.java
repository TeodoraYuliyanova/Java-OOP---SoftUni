package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    private static final String PRIVATE = "private";
    private static final String PROTECTED = "protected";
    private static final String PUBLIC = "public";
    private static final String ALL = "all";
    private static final String PRINT = "%s %s %s%n";
    private static final Field[] fields = RichSoilLand.class.getDeclaredFields();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("HARVEST")) {

            switch (input) {


                case PRIVATE:
                    filterFieldModifiers(PRIVATE);

                    break;

                case PROTECTED:
                    filterFieldModifiers(PROTECTED);

                    break;

                case PUBLIC:
                    filterFieldModifiers(PUBLIC);

                    break;

                case ALL:
                    Arrays.stream(fields).forEach(getFieldConsumer());
                    break;
            }


            input = scanner.nextLine();
        }
    }

    private static void filterFieldModifiers(String modifier) {
        Arrays.stream(fields).filter(field -> Modifier.toString(field.getModifiers()).equals(modifier))
                .forEach(getFieldConsumer());
    }


    private static Consumer<Field> getFieldConsumer() {

        return field -> System.out.printf(PRINT , Modifier.toString(field.getModifiers()) ,field.getType().getSimpleName(), field.getName());
    }
}
