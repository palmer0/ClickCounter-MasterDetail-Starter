package es.ulpgc.eite.cleancode.clickcounter.app;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;

public class DetailToMasterState {

  public CounterData counter;
  public Integer clicks;

  public DetailToMasterState(CounterData counter, Integer clicks) {
    this.clicks=clicks;
    this.counter=counter;
  }
}
