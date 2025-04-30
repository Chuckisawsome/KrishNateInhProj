public class Employee extends Human {
    protected double wage;
    protected String position;

    public Employee(int money, int hunger, String name, int age, double wage, String position) {
        super(money, hunger, name, age);
        this.wage = wage;
        this.position = position;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void increaseWage() {
        // Default behavior — override in subclasses
    }

    @Override
    public String toString() {
        return super.toString() + ", Position: " + position + ", Wage: $" + wage;
    }
}
