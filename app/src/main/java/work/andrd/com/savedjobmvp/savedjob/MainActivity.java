package work.andrd.com.savedjobmvp.savedjob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import work.andrd.com.savedjobmvp.R;
import work.andrd.com.savedjobmvp.network.CheckNetworkConnection;
import work.andrd.com.savedjobmvp.savedjob.adapter.SavedJobAdapter;
import work.andrd.com.savedjobmvp.model.SavedJobModel;
import work.andrd.com.savedjobmvp.webservice.RetroConfig;

public class MainActivity extends AppCompatActivity implements SavedJobContract.View {

    public  SavedJobAdapter adapter;
    public  List<SavedJobModel.Data> savedJobList;
    RecyclerView.LayoutManager layoutManager;

    @BindView(R.id.saved_job_recycler)
    RecyclerView savedJobRecycler;

    SavedJobPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

      //  loadSavedJob();

        presenter = new SavedJobPresenter(MainActivity.this);
        if (CheckNetworkConnection.isConnectionAvailable(MainActivity.this))
        {
            presenter.loadSavedJob("481",savedJobRecycler);
        }
        else
        {
            presenter.showNoInternet("No internet access");
        }


    }

    private void loadSavedJob() {
        Call<SavedJobModel> call = RetroConfig.retrofit().getSavedJob("481");
        call.enqueue(new Callback<SavedJobModel>() {
            @Override
            public void onResponse(Call<SavedJobModel> call, Response<SavedJobModel> response) {
                if (response.isSuccessful()) {
                    savedJobList = new ArrayList<>();
                    savedJobList = response.body().getData();
                    adapter = new SavedJobAdapter(MainActivity.this, savedJobList, savedJobRecycler);
                    layoutManager = new LinearLayoutManager(MainActivity.this);
                    savedJobRecycler.setLayoutManager(layoutManager);
                    savedJobRecycler.setAdapter(adapter);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Not successful",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<SavedJobModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void updateSavedJobList(List<SavedJobModel.Data> jobList) {

       /* if (jobList != null && jobList.size()>0)
        {
            savedJobList = new ArrayList<>();
            savedJobList = jobList;
            adapter = new SavedJobAdapter(MainActivity.this, savedJobList, savedJobRecycler);
            layoutManager = new LinearLayoutManager(MainActivity.this);
            savedJobRecycler.setLayoutManager(layoutManager);
            savedJobRecycler.setAdapter(adapter);
        }*/
    }

}
