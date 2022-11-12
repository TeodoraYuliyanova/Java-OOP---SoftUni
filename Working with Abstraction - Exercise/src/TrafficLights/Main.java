package TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> colors = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int changeLight = Integer.parseInt(scanner.nextLine());
        List<TrafficLight> lights = new ArrayList<>();

        for (String color : colors) {
            Color currentColor = Color.valueOf(color);
            TrafficLight trafficLight = new TrafficLight(currentColor);
            lights.add(trafficLight);
        }

        for (int i = 0; i < changeLight; i++) {
            for (TrafficLight trafficLight : lights) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getCurrentColor() + " ");
            }
            System.out.println();

        }
    }
}
