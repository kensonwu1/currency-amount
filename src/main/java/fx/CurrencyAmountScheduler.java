package fx;

import java.util.Timer;
import java.util.TimerTask;

public class CurrencyAmountScheduler {

  private CurrencyAmountHandler handler;

  public CurrencyAmountScheduler(CurrencyAmountHandler handler){
    this.handler = handler;
  }

  public void start(){
    TimerTask task = new TimerTask() {
      public void run() {
        handler.printToConsole();
      }
    };
    Timer timer = new Timer("PerMinuteTimer");
    timer.schedule(task, 0, 60000L);
  }
}
