public class Employee extends Person {
    protected double wage;
    protected String job;

    public Employee(int money, int hunger, String name, int age, double wage, String job) {
        super(money, hunger, name, age);
        this.wage = wage;
        this.job = job;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getJob() {
        return job;
    }

    public void increaseWage() {
        if (job.equalsIgnoreCase("Cook")) {
            wage += 1.0;
        } else if (job.equalsIgnoreCase("Server")) {
            if (age % 3 == 0) {
                wage += 1.0;
            }
        }
    }
}
