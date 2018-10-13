package bad;

public interface IItem {
    void applyDiscount(int discount);

    void applyPromoCode(String promoCode);

    void setColor(String color);

    void setSize(int size);

    void setCondition(String condition);

    void setPrice(double price);
}
