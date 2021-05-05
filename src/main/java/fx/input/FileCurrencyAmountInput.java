package fx.input;

import fx.CurrencyAmountHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileCurrencyAmountInput extends AbstractCurrencyAmountInput {

  private String pathName;

  public FileCurrencyAmountInput(String pathName, CurrencyAmountHandler handler) {
    super(handler);
    this.pathName = pathName;
  }

  @Override
  public void startInput(){
    File file = new File(this.pathName);
    try(Scanner sc = new Scanner(file)){
      while (sc.hasNext()) {
        processInput(sc.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Not such file: "+this.pathName);
    }
  }
}
