package es.ulpgc.eite.cleancode.clickcounter.app;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;

public class MasterToDetailState {

  public CounterData counter;
  public Integer clicks;

  public MasterToDetailState(CounterData counter, Integer clicks) {
    this.clicks=clicks;
    this.counter=counter;
  }
}
