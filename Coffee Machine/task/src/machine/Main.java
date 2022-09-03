package machine;


public class Main {


    public static void main(String[] args) {
        CoffeeMachine FirstMachine = new CoffeeMachine();
        while (FirstMachine.state != machineState.EXIT) {
            FirstMachine.askInput();
            switch (FirstMachine.state) {
                case BUY:
                    FirstMachine.buyFunction();
                    break;
                case FILL:
                    FirstMachine.fillFunction();
                    break;
                case TAKE:
                    FirstMachine.takeFunction();
                    break;
                case REMAINING:
                    FirstMachine.remainingFunction();
                    break;
            }
        }
    }
}
