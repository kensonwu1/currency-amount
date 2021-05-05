package fx;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fx.input.validation.CurrencyAmountInputValidation;
import fx.input.validation.SimpleCurrencyAmountInputValidation;
import java.math.BigDecimal;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class CurrencyAmountInputValidationTest {

  @Test
  public void testInputValidation() {
    CurrencyAmountInputValidation validation = new SimpleCurrencyAmountInputValidation();

    assertNotNull(validation.validateInput("USD 100"));
    assertNotNull(validation.validateInput("USD -100"));
    assertNotNull(validation.validateInput("USD 080"));

    assertNull(validation.validateInput("USD100"));
    assertNull(validation.validateInput("usd 100"));
    assertNull(validation.validateInput("usD 100"));
    assertNull(validation.validateInput("333 100"));
    assertNull(validation.validateInput("US 100"));
    assertNull(validation.validateInput("USDD 100"));
    assertNull(validation.validateInput("USD USD"));

  }
}
