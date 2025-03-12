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

    // TODO: include code if necessary
  }

  @Override
  public void onRestartScreen(CounterData counter, Integer clicks) {
    // Log.e(TAG, "onRestartScreen()");

    // TODO: include code if necessary
  }

  @Override
  public void onDataFromPreviousScreen(CounterData counter, Integer clicks) {
    // Log.e(TAG, "onDataFromPreviousScreen()");

    // TODO: include code if necessary
  }

  @Override
  public void onIncrementCounter() {

    // TODO: include code if necessary
  }
}
