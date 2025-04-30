public class Order extends Customer {
    private int orderNumber;

    public Order(int m, int h, String n, int a, String f, int o) {
        super(m, h, n, a, f);
        orderNumber = o;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void pay() {
        System.out.println(getName() + " paid for their " + getFood() + ". Enjoy order #" + orderNumber + "!");
    }

    public int getMoney() {
        return 3;
    }
}
