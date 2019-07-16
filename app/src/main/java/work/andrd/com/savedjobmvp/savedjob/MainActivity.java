package work.andrd.com.savedjobmvp.savedjob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import work.andrd.com.savedjobmvp.App;
import work.andrd.com.savedjobmvp.R;
import work.andrd.com.savedjobmvp.model.SavedJobModel;
import work.andrd.com.savedjobmvp.network.CheckNetworkConnection;
import work.andrd.com.savedjobmvp.savedjob.adapter.SavedJobAdapter;
import work.andrd.com.savedjobmvp.webservice.RetroConfig;

public class MainActivity extends AppCompatActivity implements SavedJobContract.View {

    @Inject
    SavedJobPresenter presenter;

    @BindView(R.id.saved_job_recycler)
    RecyclerView savedJobRecycler;

    SavedJobAdapter adapter;
    List<SavedJobModel.Data> savedJobList;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        App.getApp().getSavedAppComponent().inject(MainActivity.this);
        if (CheckNetworkConnection.isConnectionAvailable(MainActivity.this)) {
            presenter.loadSavedJob(MainActivity.this,"481", savedJobRecycler);
        } else {
            presenter.showNoInternet(MainActivity.this,"No internet access");
        }
    }


    @Override
    public void updateSavedJobList(List<SavedJobModel.Data> jobList) {
           adapter = new SavedJobAdapter(MainActivity.this, savedJobList, savedJobRecycler);
                        layoutManager = new LinearLayoutManager(MainActivity.this);
                        savedJobRecycler.setLayoutManager(layoutManager);
                        savedJobRecycler.setAdapter(adapter);
    }


}
