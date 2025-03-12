package es.ulpgc.eite.cleancode.clickcounter.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.clickcounter.R;

public class DetailActivity
    extends AppCompatActivity implements DetailContract.View {

  public static String TAG = "ClickCounter-MasterDetail.DetailActivity";

  private DetailContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    getSupportActionBar().setTitle(R.string.title_detail);

    // do the setup
    DetailScreen.configure(this);

    if (savedInstanceState == null) {
      presenter.onCreateCalled();

    } else {
      presenter.onRecreateCalled();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the value
    presenter.onResumeCalled();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();

    presenter.onBackPressedCalled();
  }

  @Override
  protected void onPause() {
    super.onPause();

    presenter.onPauseCalled();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    presenter.onDestroyCalled();
  }


  public void onButtonPressed(View view) {
    presenter.onButtonPressed();
  }

  @Override
  public void onDataUpdated(DetailViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    // deal with the data
    String counter = String.valueOf(viewModel.counter);
    ((TextView) findViewById(R.id.counter)).setText(counter);
    String clicks = String.valueOf(viewModel.clicks);
    ((TextView) findViewById(R.id.clicks)).setText(clicks);
  }

  @Override
  public void injectPresenter(DetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

}
