package vendingmachine;

import vendingmachine.controller.MachineController;
import vendingmachine.domain.calculator.Calculator;
import vendingmachine.domain.calculator.CalculatorImpl;
import vendingmachine.domain.moneymanager.MoneyManager;
import vendingmachine.domain.moneymanager.MoneyManagerImpl;
import vendingmachine.domain.productmanager.ProductManager;
import vendingmachine.domain.productmanager.ProductManagerImpl;

public class VendingMachineConfig {

    public MachineController machineController() {
        return new MachineController(calculator(), moneyManager(), productManager());
    }

    public MoneyManager moneyManager() {
        return new MoneyManagerImpl();
    }

    public Calculator calculator() {
        return new CalculatorImpl();
    }

    public ProductManager productManager() {
        return new ProductManagerImpl();
    }

}
