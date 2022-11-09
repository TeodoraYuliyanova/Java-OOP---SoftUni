package HotelReservation;

public enum Discount {
    VIP(20),
    SecondVisit(10),
    None(0);

    private double discountApplier;

    Discount(double discountApplier) {
        this.discountApplier = discountApplier;
    }

    public double getDiscountApplier() {
        return discountApplier;
    }
}
