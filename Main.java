import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("what the hellybron james");
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Chick-fil-A Simulation!");

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.print("Enter how much money you have: ");
        int money = input.nextInt();

        System.out.print("Enter your hunger level (1-10): ");
        int hunger = input.nextInt();
        input.nextLine();

        int interactionCount = 0;
        Employee currentEmployee = null; // to track active employee

        while (true) {
            System.out.println("\nChoose your role:");
            System.out.println("1. Employee (Work at Chick-fil-A)");
            System.out.println("2. Customer (Eat at Chick-fil-A)");
            System.out.print("Enter 1 or 2: ");
            int roleChoice = input.nextInt();
            input.nextLine();

            if (roleChoice == 1) {
                System.out.println("\nEmployee Types:");
                System.out.println("1. Cook ($15.50/hr + $1 every year) - ");
                System.out.println("2. Server ($19.50/hr + $1 every 3 years)");
                System.out.print("Enter 1 or 2: ");
                int job = input.nextInt();
                input.nextLine();

                if (job == 1) {
                    double wage = 15.50;
                    Cook cook = new Cook(money, hunger, name, age, wage, "Cook", "");
                    currentEmployee = cook;
                
                    System.out.print("What food are you cooking today? ");
                    String dish = input.nextLine();
                    cook.cookFood(dish);
                    System.out.println(cook.toString());
                
                } else {
                    double wage = 19.50;
                    Serve server = new Serve(money, hunger, name, age, wage, "Server", 0);
                    currentEmployee = server;
                
                    server.serveOrder();
                    server.serveOrder();
                    System.out.println(server.toString());
                }                

            } else if (roleChoice == 2) {
                System.out.print("\nWhat food would you like to order? ");
                String food = input.nextLine();

                int orderNumber = (int)(Math.random() * 1000) + 1;
                Order order = new Order(money, hunger, name, age, food, orderNumber);
                order.pay();

                System.out.print("What sauce would you like with your " + food + "? ");
                String sauce = input.nextLine();

                Eat eater = new Eat(order.getMoney(), order.getHunger(), name, age, food, sauce);
                eater.eatFood();

                System.out.println("\n" + eater.toString());
            } else {
                System.out.println("Invalid option.");
            }

            // After every 3 interactions, increase age
            interactionCount++;
            if (interactionCount % 2 == 0) {
                age++;
                System.out.println("[Time passes... You are now " + age + " years old.]");
            
                // Increase wage if employee was created
                if (currentEmployee != null) {
                    currentEmployee.setAge(age); // keep age updated
                    currentEmployee.increaseWage();
                    System.out.printf("[Your new wage: $%.2f]\n", currentEmployee.getWage());
                }
            }            
            System.out.println("\n...returning to menu...\n");
        }
    }
}
