public class Serve extends Employee {
    private int ordersServed;

    public Serve(int money, int hunger, String name, int age, double wage, String position, int ordersServed) {
        super(money, hunger, name, age, wage, position);
        this.ordersServed = ordersServed;
    }

    public void serveOrder() {
        ordersServed++;
        System.out.println(name + " is serving order #" + ordersServed);
    }

    @Override
    public void increaseWage() {
        if (age % 3 == 0) {
            wage += 1.0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Orders served: " + ordersServed;
    }
}
