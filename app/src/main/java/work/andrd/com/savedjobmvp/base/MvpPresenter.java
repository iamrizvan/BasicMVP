package work.andrd.com.savedjobmvp.base;

interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
