package machine;
import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    machineState state;
    int water;
    int milk;
    int beans;
    int cups;
    int money;

    public CoffeeMachine() {
        this.state = machineState.INIT;
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }


    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    void askInput() {
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        if (sc.hasNextLine()) {
            input = sc.nextLine();
            if (Objects.equals(input, "buy")) {
                this.state = machineState.BUY;
            }
            if (Objects.equals(input, "fill")) {
                this.state = machineState.FILL;
            }
            if (Objects.equals(input, "remaining")) {
                this.state = machineState.REMAINING;
            }
            if (Objects.equals(input, "take")) {
                this.state = machineState.TAKE;
            }
            if (Objects.equals(input, "exit")) {
                this.state = machineState.EXIT;
            }
        }
    }

    void buyFunction() {
        int coffeeChoice;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 -cappuccino");
        if (sc.hasNextInt()) {
            coffeeChoice = sc.nextInt();


            if (coffeeChoice == 1) {
                if (getWater() < 250) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (getBeans() < 16) {
                    System.out.println("Sorry, not enough beans!");
                    return;
                }
                if (getCups() == 0) {
                    System.out.println("Sorry, not enough cups!");
                    return;
                }
                setWater(this.water -= 250);
                setBeans(this.beans -= 16);
                setMoney(this.money += 4);
                setCups(this.cups -= 1);
                System.out.println("I have enough resources, making you a coffee!");
            }

            if (coffeeChoice == 2) {
                if (getWater() < 350) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (getMilk() < 75) {
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                if (getBeans() < 20) {
                    System.out.println("Sorry, not enough beans!");
                    return;
                }
                if (getCups() <= 0) {
                    System.out.println("Sorry, not enough cups!");
                    return;
                }
                setWater(this.water -= 350);
                setMilk(this.milk -= 75);
                setBeans(this.beans -= 20);
                setMoney(this.money += 7);
                setCups(this.cups -= 1);
                System.out.println("I have enough resources, making you a coffee!");
            }

            if (coffeeChoice == 3) {
                if (getWater() < 200) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (getMilk() < 100) {
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                if (getBeans() < 12) {
                    System.out.println("Sorry, not enough beans!");
                    return;
                }
                if (getCups() == 0) {
                    System.out.println("Sorry, not enough cups!");
                    return;
                }
                setWater(this.water -= 200);
                setMilk(this.milk -= 100);
                setBeans(this.beans -= 12);
                setMoney(this.money += 6);
                setCups(this.cups -= 1);
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
    }

    void fillFunction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWrite how many ml of water you want to add:");
        setWater(this.water += sc.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        setMilk(this.milk += sc.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        setBeans(this.beans += sc.nextInt());
        System.out.println("Write how many disposable cups of coffee you want to add:");
        setCups(this.cups += sc.nextInt());
    }

    void remainingFunction() {
        System.out.printf("\nThe coffee machine has:\n%d ml of water\n%d ml of milk\n%d g of coffee beans\n%d disposable cups\n$%d of money\n",
                this.getWater(), this.getMilk(), this.getBeans(), this.getCups(), this.getMoney());
    }

    void takeFunction() {
        System.out.printf("I gave you $%d\n", this.money);
        setMoney(0);
    }

}
