package fx.input;

import fx.CurrencyAmountHandler;
import java.util.Scanner;

public class CliCurrencyAmountInput extends AbstractCurrencyAmountInput {

  public CliCurrencyAmountInput(CurrencyAmountHandler handler) {
    super(handler);
  }

  @Override
  public void startInput() {
    System.out.println("Input currency amount, such as: USD 100");
    Scanner sc = new Scanner(System.in);
    while (true) {
      String input = sc.nextLine();
      if("quit".equals(input)){
        System.exit(0);
      }
      processInput(input);
    }
  }

}
