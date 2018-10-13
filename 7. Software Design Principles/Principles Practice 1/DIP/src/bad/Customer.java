package bad;

public class Customer {

    private Order currentOrder;

    public void buyItems() {
        if (this.currentOrder == null) {
            return;
        }

        OrderProcessor processor = new OrderProcessor();
        processor.checkout(this.currentOrder);
    }

    public void addItem(Item item) {
        if (this.currentOrder == null) {
            this.currentOrder = new Order();
        }
        this.currentOrder.addItem(item);
    }

    public void deleteItem(Item item) {
        if (this.currentOrder == null) {
            return;
        }
        this.currentOrder.deleteItem(item);
    }
}
