public class Person {
    protected String name;
    protected int age;
    protected int money;
    protected int hunger;

    public Person(int money, int hunger, String name, int age) {
        this.money = money;
        this.hunger = hunger;
        this.name = name;
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
