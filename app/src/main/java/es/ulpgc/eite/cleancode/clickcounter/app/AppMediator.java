package es.ulpgc.eite.cleancode.clickcounter.app;

import es.ulpgc.eite.cleancode.clickcounter.detail.DetailState;
import es.ulpgc.eite.cleancode.clickcounter.master.MasterState;

public class AppMediator {

  private static AppMediator instance;

  private DetailState detailState;
  private MasterState masterState;

  private DetailToMasterState detailToMasterState;
  private MasterToDetailState masterToDetailState;


  private AppMediator() {
    //detailState= new DetailState();
    //masterState= new MasterState();

  }

  public static AppMediator getInstance() {
    if(instance == null){
      instance = new AppMediator();
    }

    return instance;
  }

  public static void resetInstance() {
    instance=null;
  }

  public void setDetailState(DetailState state) {
    this.detailState = state;
  }

  public void setMasterState(MasterState state) {
    this.masterState = state;
  }

  public DetailState getDetailState() {
    return detailState;
  }

  public MasterState getMasterState() {
    return masterState;
  }

  public void setDetailPreviousScreenState(DetailToMasterState state) {
    detailToMasterState=state;
  }

  public MasterToDetailState getDetailPreviousScreenState() {
    MasterToDetailState state = masterToDetailState;
    masterToDetailState = null;
    return state;
  }

  public DetailToMasterState getMasterNextScreenState() {
    DetailToMasterState state = detailToMasterState;
    detailToMasterState = null;
    return state;
  }


  public void setMasterNextScreenState(MasterToDetailState state) {
    masterToDetailState=state;
  }
}
