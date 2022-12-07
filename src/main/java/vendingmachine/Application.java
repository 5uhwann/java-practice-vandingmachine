package vendingmachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachineConfig vendingMachineConfig = new VendingMachineConfig();
        vendingMachineConfig.machineController().operateMachine();
    }
}
