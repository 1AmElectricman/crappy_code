import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UserInput1 userInput = new UserInput1(scan);
        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;
        boolean exit = false;

        coffeeMachineStatus(water, milk, coffeeBeans, disposableCups, money);
        System.out.println("Please choose the action (buy, fill, take, remaining, exit):");

        while (!exit) {
            switch (userInput.mainMenu()) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    if (water < 200)
                    {
                        System.out.println("Sorry, not enough water!");
                        System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                        break;
                    }
                    if (coffeeBeans < 12)
                    {
                        System.out.println("Sorry not enough coffee beans!");
                        System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                        break;
                    }
                    if (disposableCups < 1)
                    {
                        System.out.println("Sorry not enough disposable cups!");
                        System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                        break;
                    }
                    else {
                        System.out.println("I have enough resources, making you a coffee!");
                        userInput.buyMenu();
                    }

                    if (userInput.buyMenu().equals("1"))
                    {
                        if (water - 250 < 0)
                        {
                            System.out.println("Sorry, not enough water!");
                            System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                            break;
                        }
                        if (coffeeBeans - 16 < 0)
                        {
                            System.out.println("Sorry not enough coffee beans!");
                            System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                            break;
                        }
                        else {
                            water = water - 250;
                            coffeeBeans = coffeeBeans - 16;
                            disposableCups = disposableCups - 1;
                            money = money + 4;
                            System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                            break;
                        }

                    }
                    if (userInput.buyMenu().equals("2"))
                    {
                        if (water - 350 < 0)
                        {
                            System.out.println("Sorry, not enough water!");
                            System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                            break;
                        }
                        if (coffeeBeans - 20 < 0)
                        {
                            System.out.println("Sorry not enough coffee beans!");
                            System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                            break;
                        }
                        if (milk - 75 < 0)
                        {
                            System.out.println("Sorry not enough milk!");
                            System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                            break;
                        }
                        else {
                            water = water - 350;
                            milk = milk - 75;
                            coffeeBeans = coffeeBeans - 20;
                            disposableCups = disposableCups - 1;
                            money = money + 7;
                            System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                            break;
                        }

                    }
                    if (userInput.buyMenu().equals("3"))
                    {
                        if (milk - 100 < 0)
                        {
                            System.out.println("Sorry not enough milk!");
                            System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                            break;
                        }
                        else {
                            water = water - 200;
                            milk = milk - 100;
                            coffeeBeans = coffeeBeans - 12;
                            disposableCups = disposableCups - 1;
                            money = money + 6;
                            System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                            break;
                        }
                    }
                    if (userInput.buyMenu().equals("back"))
                    {
                        System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                        break;
                    }
                    else {
                        System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    water = water + userInput.fillMenu();
                    System.out.println("Write how many ml of milk do you want to add:");
                    milk = milk + userInput.fillMenu();
                    System.out.println("Write how many grams of coffee beans do you want to add");
                    coffeeBeans = coffeeBeans + userInput.fillMenu();
                    System.out.println("Write how many disposable cups of coffee do you want to add");
                    disposableCups = disposableCups + userInput.fillMenu();
                    System.out.println();
                    coffeeMachineStatus(water, milk, coffeeBeans, disposableCups, money);
                    break;
                case "take":
                    System.out.println("I gave you $" + money + "\n");
                    money = 0;
                    coffeeMachineStatus(water, milk, coffeeBeans, disposableCups, money);
                    System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                    break;
                case "remaining":
                    coffeeMachineStatus(water, milk, coffeeBeans, disposableCups, money);
                    System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
            }

        }
    }
    private static void coffeeMachineStatus(int water, int milk, int coffeeBeans, int disposableCups, int money)
    {
        System.out.println("The Coffee machine has:");
        System.out.println(water +" of water");
        System.out.println(milk +" of milk");
        System.out.println(coffeeBeans +" of coffee beans");
        System.out.println(disposableCups +" of disposable cups");
        System.out.println(money +" of money");
        System.out.println();
        //System.out.println("Please choose the action (buy, fill, take, remaining, exit):");
    }
}



class UserInput {
    private Scanner scan;

    UserInput(Scanner scan){

        this.scan = scan;
    }

    String mainMenu(){
        return scan.nextLine();
    }

    String buyMenu() {
        return scan.nextLine();
    }

    int fillMenu() {
        return scan.nextInt();
    }
}