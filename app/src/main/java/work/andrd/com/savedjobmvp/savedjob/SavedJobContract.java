package work.andrd.com.savedjobmvp.savedjob;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import work.andrd.com.savedjobmvp.base.MvpView;
import work.andrd.com.savedjobmvp.model.SavedJobModel;

public class SavedJobContract {

    interface View{
        void updateSavedJobList(List<SavedJobModel.Data> jobList);
    }

    interface Presenter
    {

        void showNoInternet(String msg);
        void loadSavedJob(String applicant_id, RecyclerView recyclerView);

    }
}
