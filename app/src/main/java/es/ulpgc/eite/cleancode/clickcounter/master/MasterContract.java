package es.ulpgc.eite.cleancode.clickcounter.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;

public interface MasterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(MasterViewModel viewModel);
    void navigateToNextScreen();

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
    void onListPressed(CounterData counter);
  }

  interface Model {
    List<CounterData> getStoredCounterList();
    void onDataFromNextScreen(CounterData counter, Integer clicks);
    void onRestartScreen(List<CounterData> counters, Integer clicks);
    void onAddCounter(CounterData counter);
    CounterData getStoredCounter(Long id);
    Integer getStoredNumOfClick();
    void onIncrementCounter(CounterData counter);
    void onIncrementNumOfClicks();
  }

}
