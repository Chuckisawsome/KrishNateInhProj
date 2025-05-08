public class Cook extends Employee {
    private String dish;

    public Cook(int money, int hunger, String name, int age, double wage, String job, String dish) {
        super(money, hunger, name, age, wage, job);
        this.dish = dish;
    }

    public void cookFood(String dish) {
        this.dish = dish;
        System.out.println("👨‍🍳 You cooked: " + dish + ".");
    }

    @Override
    public String toString() {
        return String.format("Cook %s, Age %d, Money $%d, Hunger %d/10, Dish: %s, Wage: $%.2f",
                name, age, money, hunger, dish, wage);
    }
}
