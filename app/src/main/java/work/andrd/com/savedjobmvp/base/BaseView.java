package work.andrd.com.savedjobmvp.base;

public interface BaseView {

    void showProgress();

    void dismissProgress();

    void displayError(String errorMessage, int code);

    void displayFailure(String failureMessage);

}
