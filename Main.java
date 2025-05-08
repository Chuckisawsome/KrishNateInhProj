import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("🍗 Welcome to the Chick-fil-A Simulation!");

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
        Employee currentEmployee = null;

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("\nChoose your role:");
            System.out.println("1. Employee (Work at Chick-fil-A)");
            System.out.println("2. Customer (Eat at Chick-fil-A)");
            System.out.print("Enter 1 or 2: ");
            int roleChoice = input.nextInt();
            input.nextLine();

            if (roleChoice == 1) {
                System.out.println("\nEmployee Types:");
                System.out.println("1. Cook ($15.50/hr + $1 every year)");
                System.out.println("2. Server ($19.50/hr + $1 every 3 years)");
                System.out.print("Enter 1 or 2: ");
                int job = input.nextInt();
                input.nextLine();

                if (job == 1) {
                    double wage = 15.50;
                    Cook cook = new Cook(money, hunger, name, age, wage, "Cook", "");
                    currentEmployee = cook;

                    boolean employeeLoop = true;
                    while (employeeLoop) {
                        System.out.println("\nWhat would you like to do?");
                        System.out.println("1. Cook food");
                        System.out.println("2. Check money");
                        System.out.println("3. Check hunger");
                        System.out.println("4. Exit employee menu");
                        System.out.print("Enter your choice: ");
                        int empChoice = input.nextInt();
                        input.nextLine();

                        switch (empChoice) {
                            case 1:
                                System.out.print("What food are you cooking today? ");
                                String dish = input.nextLine();
                                cook.cookFood(dish);
                                cook.setMoney(cook.getMoney() + (int) cook.getWage()); // Add wage
                                break;
                            case 2:
                                System.out.println("💵 Money: $" + cook.getMoney());
                                break;
                            case 3:
                                System.out.println("🍽️ Hunger level: " + cook.getHunger() + "/10");
                                break;
                            case 4:
                                employeeLoop = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    System.out.println("\n" + cook.toString());

                } else if (job == 2) {
                    double wage = 19.50;
                    Serve server = new Serve(money, hunger, name, age, wage, "Server", 0);
                    currentEmployee = server;

                    boolean employeeLoop = true;
                    while (employeeLoop) {
                        System.out.println("\nWhat would you like to do?");
                        System.out.println("1. Serve order");
                        System.out.println("2. Check money");
                        System.out.println("3. Check hunger");
                        System.out.println("4. Exit employee menu");
                        System.out.print("Enter your choice: ");
                        int empChoice = input.nextInt();
                        input.nextLine();

                        switch (empChoice) {
                            case 1:
                                server.serveOrder();
                                server.setMoney(server.getMoney() + (int) server.getWage()); // Add wage
                                break;
                            case 2:
                                System.out.println("💵 Money: $" + server.getMoney());
                                break;
                            case 3:
                                System.out.println("🍽️ Hunger level: " + server.getHunger() + "/10");
                                break;
                            case 4:
                                employeeLoop = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    System.out.println("\n" + server.toString());
                } else {
                    System.out.println("Invalid employee type.");
                }

            } else if (roleChoice == 2) {
                boolean customerLoop = true;
                int custMoney = money;
                int custHunger = hunger;

                while (customerLoop) {
                    System.out.println("\nWhat would you like to do?");
                    System.out.println("1. Order food");
                    System.out.println("2. Eat food");
                    System.out.println("3. Check money");
                    System.out.println("4. Check hunger");
                    System.out.println("5. Exit customer menu");
                    System.out.print("Enter your choice: ");
                    int custChoice = input.nextInt();
                    input.nextLine();

                    switch (custChoice) {
                        case 1:
                            String[] foods = {"Chicken Sandwich", "Nuggets", "Fries", "Milkshake"};
                            String food = foods[rand.nextInt(foods.length)];
                            int cost = rand.nextInt(6) + 5; // Random cost $5–10
                            custMoney -= cost;
                            System.out.println("🧾 You ordered " + food + " for $" + cost + ".");
                            break;
                        case 2:
                            int hungerGain = rand.nextInt(4) + 1; // 1–4 hunger gain
                            custHunger = Math.max(1, custHunger - hungerGain);
                            System.out.println("😋 You ate your food. Hunger decreased by " + hungerGain + ".");
                            break;
                        case 3:
                            System.out.println("💵 Money: $" + custMoney);
                            break;
                        case 4:
                            System.out.println("🍽️ Hunger level: " + custHunger + "/10");
                            break;
                        case 5:
                            customerLoop = false;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }

                // Update global values
                money = custMoney;
                hunger = custHunger;
            } else {
                System.out.println("Invalid option.");
            }

            interactionCount++;
            if (interactionCount % 2 == 0) {
                age++;
                System.out.println("\n⏳ [Time passes... You are now " + age + " years old.]");

                if (currentEmployee != null) {
                    currentEmployee.setAge(age);
                    currentEmployee.increaseWage();
                    System.out.printf("[Your new wage: $%.2f]\n", currentEmployee.getWage());
                }
            }

            System.out.print("\nWould you like to continue the simulation? (yes/no): ");
            String answer = input.nextLine().toLowerCase();
            if (!answer.equals("yes") && !answer.equals("y")) {
                keepGoing = false;
                System.out.println("\n👋 Thanks for playing the Chick-fil-A Simulation!");
            }
        }
    }
}
