package fx.input;

import fx.CurrencyAmountHandler;
import fx.CurrencyAmountModel;
import fx.input.validation.CurrencyAmountInputValidation;
import fx.input.validation.SimpleCurrencyAmountInputValidation;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public abstract class AbstractCurrencyAmountInput {
  private CurrencyAmountInputValidation validation;
  private CurrencyAmountHandler handler;

  public AbstractCurrencyAmountInput(CurrencyAmountHandler handler) {
    this.handler = handler;
    this.validation = new SimpleCurrencyAmountInputValidation();
  }

  public void setValidation(CurrencyAmountInputValidation validation) {
    this.validation = validation;
  }

  public abstract void startInput() throws FileNotFoundException;

  protected void processInput(String input) {
    CurrencyAmountModel currencyAmount = validation.validateInput(input);
    if(currencyAmount != null){
      handler.handle(currencyAmount.getCurrency(),currencyAmount.getAmount());
    }
  }



}
