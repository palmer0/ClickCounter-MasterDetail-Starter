package es.ulpgc.eite.cleancode.clickcounter.master;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;

public class MasterModel implements MasterContract.Model {

  public static String TAG = "ClickCounter-MasterDetail.MasterModel";

  private List<CounterData> counters;
  public Integer clicks;

  public MasterModel() {
    counters = new ArrayList<>();
    clicks=0;
  }

  @Override
  public List<CounterData> getStoredCounterList() {
    // Log.e(TAG, "getStoredCounterList()");
    return counters;
  }

  @Override
  public CounterData getStoredCounter(Long id) {
    // Log.e(TAG, "getStoredCounter()");

    for(CounterData counter: counters) {
      if(counter.id == id) {
        return counter;
      }
    }

    return null;
  }

  @Override
  public Integer getStoredNumOfClick() {
    // Log.e(TAG, "getStoredNumOfClick()");
    return clicks;
  }

  @Override
  public void onIncrementCounter(CounterData counter) {
    counters.get(counters.indexOf(counter)).value++;
  }

  @Override
  public void onIncrementNumOfClicks() {
    clicks++;
  }

  @Override
  public void onRestartScreen(List<CounterData> counters, Integer clicks) {
    // Log.e(TAG, "onRestartScreen()");
    this.counters =counters;
    this.clicks = clicks;
  }

  @Override
  public void onAddCounter(CounterData counter) {
    counters.add(counter);
  }

  @Override
  public void onDataFromNextScreen(CounterData counter, Integer clicks) {
    // Log.e(TAG, "onDataFromNextScreen()");
    this.clicks=clicks;
    counters.set(counters.indexOf(counter), counter);
  }

}
