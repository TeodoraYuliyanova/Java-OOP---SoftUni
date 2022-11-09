package HotelReservation;

public class PriceCalculator {

    public static double calculatePrice(double pricePerDay , int numberOfDays , Season season, Discount discountType){
        double price = pricePerDay * numberOfDays;
        price = price * season.getMultiplier();
        price = price * (100 - discountType.getDiscountApplier()) / 100;

        return price;
    }
}
