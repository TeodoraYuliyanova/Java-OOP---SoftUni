package HotelReservation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> reservationInfo = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        double pricePerDay = Double.parseDouble(reservationInfo.get(0));
        int numberOfDays = Integer.parseInt(reservationInfo.get(1));
        Season season = Season.valueOf(reservationInfo.get(2));
        Discount discountType = Discount.valueOf((reservationInfo.get(3)));

        double finalPrice = PriceCalculator.calculatePrice(pricePerDay,numberOfDays,season,discountType);
        System.out.printf("%.2f" , finalPrice);



    }
}
