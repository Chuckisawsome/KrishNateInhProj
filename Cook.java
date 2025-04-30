public class Cook extends Employee {
    private String dish;

    public Cook(int money, int hunger, String name, int age, double wage, String position, String dish) {
        super(money, hunger, name, age, wage, position);
        this.dish = dish;
    }

    public void cookFood(String dish) {
        this.dish = dish;
        System.out.println(name + " is cooking " + dish);
    }

    @Override
    public void increaseWage() {
        wage += 1.0;
    }

    @Override
    public String toString() {
        return super.toString() + ", Dish: " + dish;
    }
}
