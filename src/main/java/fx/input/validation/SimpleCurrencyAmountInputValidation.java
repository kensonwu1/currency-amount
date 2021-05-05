package fx.input.validation;

import fx.CurrencyAmountModel;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public class SimpleCurrencyAmountInputValidation implements CurrencyAmountInputValidation {

  public CurrencyAmountModel validateInput(String input) {
    String[] lineStr = input.split("\\s");
    if (lineStr.length != 2) {
      System.out.println("Input must contain currency and amount, such as: USD 100");
      return null;
    }

    String currency = lineStr[0];
    String pattern = "[A-Z]{3}";
    boolean isMatch = Pattern.matches(pattern, currency);
    if (!isMatch) {
      System.out.println("Currency must be any uppercase 3 letter code, such as USD");
      return null;
    }

    BigDecimal amount = null;
    try {
      amount = new BigDecimal(lineStr[1]);
    } catch (Exception e) {
      //Note: the validation here probably not enough for real case.
      System.out.println("Amount must be valid number, such as 100");
      return null;
    }

    return new CurrencyAmountModel(currency, amount);
  }
}
