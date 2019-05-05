package work.andrd.com.savedjobmvp.jobdetails;

import work.andrd.com.savedjobmvp.model.JobDescription;

public class JobDetailsContract {

    interface View
    {
        void updateDetails(JobDescription jobDescription);
    }

    interface Presenter
    {
        void showNoInternet(String msg);
        void fetchJobDetails(String applicant_id);
    }
}
