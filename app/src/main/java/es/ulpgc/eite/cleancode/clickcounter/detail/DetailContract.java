package es.ulpgc.eite.cleancode.clickcounter.detail;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;

public interface DetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(DetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);

    void onResumeCalled();
    void onCreateCalled();
    void onRecreateCalled();
    void onBackPressedCalled();
    void onPauseCalled();
    void onDestroyCalled();
    void onButtonPressed();
  }

  interface Model {
    CounterData getStoredCounter();
    Integer getStoredNumOfClick();
    void onIncrementNumOfClicks();
    void onRestartScreen(CounterData counter, Integer clicks);
    void onDataFromPreviousScreen(CounterData counter, Integer clicks);
    void onIncrementCounter();
  }

}
