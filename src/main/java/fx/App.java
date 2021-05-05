package fx;

import fx.input.CliCurrencyAmountInput;
import fx.input.AbstractCurrencyAmountInput;
import fx.input.FileCurrencyAmountInput;
import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {

    CurrencyAmountHandler handler = new CurrencyAmountHandler();


    String fileName = args.length>0?args[0]:null;
    if (fileName != null) {
      AbstractCurrencyAmountInput fileInput = new FileCurrencyAmountInput(fileName, handler);
      fileInput.startInput();
    }

    CurrencyAmountScheduler scheduler = new CurrencyAmountScheduler(handler);
    scheduler.start();

    AbstractCurrencyAmountInput cliInput = new CliCurrencyAmountInput(handler);
    cliInput.startInput();

  }


}
