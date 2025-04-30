public class Customer extends Human {
    private String food;

    public Customer(int m, int h, String n, int a, String f) {
        super(m, h, n, a);
        food = f;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String meal) {
        food = meal;
    }

    @Override
    public String toString() {
        return super.toString() + " [Customer craving: " + food + "]";
    }
}
