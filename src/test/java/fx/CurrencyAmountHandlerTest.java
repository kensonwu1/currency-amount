package fx;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class CurrencyAmountHandlerTest {

  @Test
  public void testHandler() {
    CurrencyAmountHandler handler = new CurrencyAmountHandler();

    handler.handle("CNY", new BigDecimal(200));
    handler.handle("USD", new BigDecimal(100));
    handler.handle("USD", new BigDecimal(100));

    assertTrue(handler.getNetCurrencyAmount().size() == 2);
    assertTrue(handler.getNetCurrencyAmount().get("USD").compareTo(new BigDecimal(200)) == 0);

    handler.handle("USD", new BigDecimal(-200));
    assertTrue(handler.getNetCurrencyAmount().size() == 1);
    assertNull(handler.getNetCurrencyAmount().get("USD"));
  }
}
