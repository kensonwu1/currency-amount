package fx.exchanger;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Mock currency exchange rate.
 */
public enum MockCurrencyExchanger {
  USD(100),
  CNY(15),
  HKD(13),
  OTHER(0);

  private int percentToUsd;

  MockCurrencyExchanger(int percentToUsd) {
    this.percentToUsd = percentToUsd;
  }

  public static String toUsdAmountString(String currency, BigDecimal amount) {
    try {
      MockCurrencyExchanger exchanger = MockCurrencyExchanger.valueOf(currency);
      if (exchanger != USD) {
        StringBuffer str = new StringBuffer();
        str.append(" (USD ");
        BigDecimal exchangedAmount = amount.multiply(new BigDecimal(exchanger.percentToUsd))
            .divide(new BigDecimal(100));
        str.append(exchangedAmount.setScale(2, RoundingMode.HALF_UP));
        str.append(")");
        return str.toString();
      }
      return "";
    } catch (Exception e) {
      return "";
    }
  }

}
