package work.andrd.com.savedjobmvp.savedjob.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import work.andrd.com.savedjobmvp.jobdetails.JobDetailsActivity;
import work.andrd.com.savedjobmvp.R;
import work.andrd.com.savedjobmvp.constant.Constant;
import work.andrd.com.savedjobmvp.model.RemoveJobModel;
import work.andrd.com.savedjobmvp.model.SavedJobModel;
import work.andrd.com.savedjobmvp.webservice.RetroConfig;


public class SavedJobAdapter extends RecyclerView.Adapter<SavedJobAdapter.MyViewHolder> {


    private Context context;
    public List<SavedJobModel.Data> savedJobList;
    public RecyclerView recyclerView;
    public SavedJobModel.Data savedJobModel;

    public SavedJobAdapter(Context context, List<SavedJobModel.Data> savedJobList, RecyclerView recyclerView) {
        this.context = context;
        this.savedJobList = savedJobList;
        this.recyclerView = recyclerView;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_interview_recycler_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        savedJobModel = savedJobList.get(position);
        holder.profileText.setText(savedJobModel.getJob_title());
        holder.companyText.setText(savedJobModel.getCompany_name());
        holder.detailDateTextview.setText(savedJobModel.getCreated_date());
        holder.detailLocationTextview.setText(savedJobModel.getLocation());
        if (savedJobModel.getSalary() != null) {
            if (savedJobModel.getSalary().equalsIgnoreCase("0") || savedJobModel.getSalary().equalsIgnoreCase("")) {
                holder.detailSalaryTextview.setText("Not disclosed.");
            } else {
                holder.detailSalaryTextview.setText(savedJobModel.getSalary() + " AED");
            }
        }
        if (savedJobModel.isStatus()) {
            holder.detailStatusTextview.setText("Yes");
        } else {
            holder.detailStatusTextview.setText("No");
        }

        if (savedJobModel.getCompany_logo() != null && !savedJobModel.getCompany_logo().equalsIgnoreCase("")) {
            Glide.with(context)
                    .load(savedJobModel.getCompany_logo())
                    .into(holder.companyImageview);
        }


    }

    @Override
    public int getItemCount() {
        if (savedJobList != null && savedJobList.size() > 0) {
            return savedJobList.size();
        } else {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.company_imageview)
        ImageView companyImageview;
        @BindView(R.id.profile_text)
        TextView profileText;
        @BindView(R.id.company_text)
        TextView companyText;
        @BindView(R.id.remove_icon)
        ImageView removeIcon;
        @BindView(R.id.detail_location_textview)
        TextView detailLocationTextview;
        @BindView(R.id.detail_salary_textview)
        TextView detailSalaryTextview;
        @BindView(R.id.detail_date_textview)
        TextView detailDateTextview;
        @BindView(R.id.detail_status_textview)
        TextView detailStatusTextview;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onClick(View view) {
        }

        @OnClick({R.id.linear_layout,R.id.remove_icon})
        public void OnClick(View view){

            switch (view.getId())
            {
                case R.id.linear_layout:
                {
                    Intent intent = new Intent(context, JobDetailsActivity.class);
                    intent.putExtra(Constant.JOB_VACANCY_ID,savedJobList.get(getAdapterPosition()).getJob_vacancy_id());
                    context.startActivity(intent);
                }
                break;
                case R.id.remove_icon:
                {
                  removeSavedJob("481",savedJobList.get(getAdapterPosition()).getJob_vacancy_id());
                  savedJobList.remove(getAdapterPosition());
                  notifyDataSetChanged();
                }
                break;
            }
        }

        private void removeSavedJob(String applicant_id, String job_vacancy_id) {

            Call<RemoveJobModel> call = RetroConfig.retrofit().removeJob(applicant_id,job_vacancy_id);
            call.enqueue(new Callback<RemoveJobModel>() {
                @Override
                public void onResponse(Call<RemoveJobModel> call, Response<RemoveJobModel> response) {
                    if (response.isSuccessful())
                    {
                        Toast.makeText(context,response.body().getMsg(),Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(context,"Couldn't remove",Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<RemoveJobModel> call, Throwable t) {
                    Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
