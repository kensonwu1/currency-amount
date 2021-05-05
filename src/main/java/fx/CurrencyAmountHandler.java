package fx;

import fx.exchanger.MockCurrencyExchanger;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class CurrencyAmountHandler {

  private ConcurrentHashMap<String, BigDecimal> netCurrencyAmount = new ConcurrentHashMap<String, BigDecimal>();

  public void handle(String currency, BigDecimal amount) {
    BigDecimal existingAmount = netCurrencyAmount.get(currency);
    if (existingAmount == null) {
      netCurrencyAmount.put(currency, amount);
    } else {
      amount = amount.add(existingAmount);
      if (amount.compareTo(BigDecimal.ZERO) == 0) {
        netCurrencyAmount.remove(currency);
      } else {
        netCurrencyAmount.put(currency, amount);
      }
    }
  }

  public void printToConsole() {
    System.out.println(Instant.now() + " Net Currency Amount: ");
    Iterator<Entry<String, BigDecimal>> entries = netCurrencyAmount.entrySet().iterator();
    while (entries.hasNext()) {
      Map.Entry<String, BigDecimal> entry = entries.next();
      StringBuffer consoleOutput = new StringBuffer();
      consoleOutput.append(entry.getKey());
      consoleOutput.append(" ");
      consoleOutput.append(entry.getValue());
      String exchangeStr = MockCurrencyExchanger
          .toUsdAmountString(entry.getKey(), entry.getValue());
      consoleOutput.append(exchangeStr);
      System.out.println(consoleOutput.toString());
    }
  }

  public ConcurrentHashMap<String, BigDecimal> getNetCurrencyAmount() {
    return netCurrencyAmount;
  }

}
