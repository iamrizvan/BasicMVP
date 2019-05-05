package work.andrd.com.savedjobmvp.savedjob;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import work.andrd.com.savedjobmvp.base.BasePresenter;
import work.andrd.com.savedjobmvp.base.MvpView;
import work.andrd.com.savedjobmvp.savedjob.adapter.SavedJobAdapter;
import work.andrd.com.savedjobmvp.model.SavedJobModel;
import work.andrd.com.savedjobmvp.webservice.RetroConfig;

public class SavedJobPresenter implements SavedJobContract.Presenter {

    Context context;
    SavedJobAdapter adapter;
    List<SavedJobModel.Data> savedJobList;
    RecyclerView.LayoutManager layoutManager;


    public SavedJobPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void showNoInternet(String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadSavedJob(String applicant_id, RecyclerView recyclerView) {

        Call<SavedJobModel> call = RetroConfig.retrofit().getSavedJob("481");
        call.enqueue(new Callback<SavedJobModel>() {
            @Override
            public void onResponse(Call<SavedJobModel> call, Response<SavedJobModel> response) {

                if (response.isSuccessful()) {

                    savedJobList = new ArrayList<>();
                    savedJobList = response.body().getData();
                    adapter = new SavedJobAdapter(context, savedJobList, recyclerView);
                    layoutManager = new LinearLayoutManager(context);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }
                else {
                    Toast.makeText(context,"Not successful",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SavedJobModel> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
