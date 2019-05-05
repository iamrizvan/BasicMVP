package work.andrd.com.savedjobmvp.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import work.andrd.com.savedjobmvp.DialogUtils;

public class BaseActivity extends AppCompatActivity implements MvpView {


    private ProgressDialog progressDialog;

    @Override
    public void showLoading() {
        hideLoading();
        progressDialog = DialogUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }
}
