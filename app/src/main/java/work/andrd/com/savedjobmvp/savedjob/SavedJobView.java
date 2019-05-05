package work.andrd.com.savedjobmvp.savedjob;

import java.util.List;

import work.andrd.com.savedjobmvp.base.MvpView;
import work.andrd.com.savedjobmvp.model.SavedJobModel;

public class SavedJobView implements SavedJobContract.View, MvpView {
    @Override
    public void updateSavedJobList(List<SavedJobModel.Data> jobList) {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
