package vendingmachine.controller;

import static vendingmachine.utils.OutputMessage.*;

import java.util.Optional;
import vendingmachine.domain.calculator.Calculator;
import vendingmachine.domain.moneymanager.inputamount.InputAmount;
import vendingmachine.domain.moneymanager.MoneyBox;
import vendingmachine.domain.moneymanager.MoneyManager;
import vendingmachine.domain.productmanager.ProductManager;
import vendingmachine.domain.productmanager.Products;
import vendingmachine.view.input.InputView;
import vendingmachine.view.output.OutputView;

public class MachineController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private final Calculator calculator;
    private final MoneyManager moneyManager;
    private final ProductManager productManager;

    public MachineController(Calculator calculator, MoneyManager moneyManager, ProductManager productManager) {
        this.calculator = calculator;
        this.moneyManager = moneyManager;
        this.productManager = productManager;
    }

    public void operateMachine() {
        MoneyBox moneyBox = makeMoneyBox();
        outputView.printMessage(moneyManager.inquiryCoins().toString());

        Products products = makeProducts();
        requestInputAmount();

        buying(moneyBox, products);
    }

    private void buying(MoneyBox moneyBox, Products products) {
        Optional<Integer> payChange = Optional.empty();
        while (payChange.isEmpty()) {
            String productName = requestProduct();
            int subtractProductPrice = productManager.subtractProduct(productName);
            int calculatedPrice = calculator.calculate(moneyBox.getInputAmount(), subtractProductPrice);
            moneyManager.updateInputAmount(calculatedPrice);
            payChange = calculator.payChange(moneyBox, products, productName);
        }
        outputView.printMessage(moneyManager.payChangeCoin(payChange.get()).toString());
    }

    private MoneyBox makeMoneyBox() {
        outputView.printMessage(REQUEST_INPUT_AMOUNT);
        return moneyManager.makeMoneyBox(Integer.parseInt(inputView.userInput()));
    }

    private Products makeProducts() {
        outputView.printMessage(REQUEST_INPUT_PRODUCT_INFORMATION);
        return productManager.makeProduct(inputView.userInput());
    }

    private void requestInputAmount() {
        outputView.printMessage(REQUEST_INPUT_USER_AMOUNT);
        moneyManager.saveInputAmount(new InputAmount(Integer.parseInt(inputView.userInput())));
    }

    private String requestProduct() {
        outputView.printMessage(moneyManager.inquiryInputAmount().toString());
        outputView.printMessage(REQUEST_PRODUCT_NAME);
        return inputView.userInput();
    }
}
