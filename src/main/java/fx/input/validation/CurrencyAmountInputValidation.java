package fx.input.validation;

import fx.CurrencyAmountModel;

public interface CurrencyAmountInputValidation {
  CurrencyAmountModel validateInput(String input);
}
