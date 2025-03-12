package es.ulpgc.eite.cleancode.clickcounter.detail;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;

public class DetailModel implements DetailContract.Model {

  public static String TAG = "ClickCounter-MasterDetail.DetailModel";

  private CounterData counter;
  private Integer clicks;

  @Override
  public CounterData getStoredCounter() {
    // Log.e(TAG, "getStoredCounter()");
    return counter;
  }

  @Override
  public Integer getStoredNumOfClick() {
    // Log.e(TAG, "getStoredNumOfClick()");
    return clicks;
  }


  @Override
  public void onIncrementNumOfClicks() {
    clicks++;
  }

  @Override
  public void onRestartScreen(CounterData counter, Integer clicks) {
    // Log.e(TAG, "onRestartScreen()");
    this.counter =counter;
    this.clicks=clicks;
  }

  @Override
  public void onDataFromPreviousScreen(CounterData counter, Integer clicks) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    this.counter =counter;
    this.clicks=clicks;
  }

  @Override
  public void onIncrementCounter() {
    counter.value++;
  }
}
