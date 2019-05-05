package work.andrd.com.savedjobmvp.jobdetails;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
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
import work.andrd.com.savedjobmvp.model.JobDescription;
import work.andrd.com.savedjobmvp.R;
import work.andrd.com.savedjobmvp.constant.Constant;
import work.andrd.com.savedjobmvp.webservice.RetroConfig;

public class JobDetailsActivity extends AppCompatActivity {

    @BindView(R.id.company_picture)
    ImageView companyPicture;
    @BindView(R.id.company_text)
    TextView companyText;
    @BindView(R.id.profile_text)
    TextView profileText;
    @BindView(R.id.location_text)
    TextView locationText;
    @BindView(R.id.date_text)
    TextView dateText;
    @BindView(R.id.summary_text)
    TextView summaryText;
    @BindView(R.id.jd_industry_text)
    TextView jdIndustryText;
    @BindView(R.id.jd_salary_text)
    TextView jdSalaryText;
    @BindView(R.id.jd_qualification_text)
    TextView jdQualificationText;
    @BindView(R.id.jd_age_limit_text)
    TextView jdAgeLimitText;
    @BindView(R.id.jd_nationality_text)
    TextView jdNationalityText;
    @BindView(R.id.jd_visa_status_text)
    TextView jdVisaStatusText;
    @BindView(R.id.jd_experience_text)
    TextView jdExperienceText;
    @BindView(R.id.jd_language_text)
    TextView jdLanguageText;
    @BindView(R.id.jd_career_level_text)
    TextView jdCareerLevelText;
    @BindView(R.id.jd_residence_location_text)
    TextView jdResidenceLocationText;
    @BindView(R.id.jd_driving_licence_text)
    TextView jdDrivingLicenceText;
    @BindView(R.id.jd_gender_text)
    TextView jdGenderText;
    @BindView(R.id.jd_contract_type_text)
    TextView jdContractTypeText;
    @BindView(R.id.jd_job_responsibility_text)
    TextView jdJobResponsibilityText;
    @BindView(R.id.about_company_text)
    TextView aboutCompanyText;
    @BindView(R.id.interview_button)
    Button interviewButton;

    String vacancy_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        ButterKnife.bind(this);


        init();

    }

    private void init() {
        vacancy_id = getIntent().getStringExtra(Constant.JOB_VACANCY_ID);
        loadJobDetails(vacancy_id);
    }

    private void loadJobDetails(String vacancy_id) {

        Call<JobDescription> call = RetroConfig.retrofit().getJobDetailsByVacancyId(vacancy_id);
        call.enqueue(new Callback<JobDescription>() {
            @Override
            public void onResponse(Call<JobDescription> call, Response<JobDescription> response) {

                if (response.isSuccessful())
                {
                    setValues(response.body().getData());
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JobDescription> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setValues(List<JobDescription.Data> data) {

        JobDescription.Data model = data.get(0);
            if (model.getCompany_name() != null)
            {
                companyText.setText(model.getCompany_name());
            }

            if (model.getJob_title() != null)
            {
                profileText.setText(model.getJob_title());
            }

            if (model.getLogo() != null && !model.getLogo().equalsIgnoreCase("")) {
                Glide.with(JobDetailsActivity.this)
                        .load(model.getLogo())
                        .into(companyPicture);
            }
            else
            {
                companyPicture.setImageDrawable(getResources().getDrawable(R.drawable.company));
            }

            if(model.getLocation() != null)
            {
                locationText.setText(model.getLocation());
            }

            if (model.getCreated_date() != null)
            {
                dateText.setText(model.getCreated_date());
            }

            if (model.getIndustry() != null)
            {
                jdIndustryText.setText(model.getIndustry());
            }

            if (model.getSalary() != null)
            {
                if (model.getSalary().equalsIgnoreCase("N/A") || model.getSalary().equalsIgnoreCase(""))
                {
                    jdSalaryText.setText("Not disclosed by company.");
                }
                else
                {
                    jdSalaryText.setText(model.getSalary());
                }
            }
            if (model.getMin_degree_level() != null)
            {
                jdQualificationText.setText(model.getMin_degree_level());
            }
            if (model.getAge_limit() != null)
            {
                jdAgeLimitText.setText(model.getAge_limit());
            }
            if (model.getNationality() != null)
            {
                if (model.getNationality().equalsIgnoreCase("N/A") || model.getNationality().equalsIgnoreCase(""))
                {
                    jdNationalityText.setText("Any");
                }
                else
                {
                    jdNationalityText.setText(model.getNationality());
                }
            }
            if (model.getVisa_status() != null)
            {
                jdVisaStatusText.setText(model.getVisa_status());
            }
            if (model.getWork_experience() != null)
            {
                jdExperienceText.setText(model.getWork_experience());
            }
            if (model.getLanguage_skill() != null)
            {
                jdLanguageText.setText(model.getLanguage_skill());
            }

            if (model.getCarrier_level() != null)
            {
                jdCareerLevelText.setText(model.getCarrier_level());
            }
            if (model.getResidence_location() != null)
            {
                jdResidenceLocationText.setText(model.getResidence_location());
            }
            if (model.getDriving_licence() != null)
            {
                jdDrivingLicenceText.setText(model.getDriving_licence());
            }
            if (model.getGender() != null)
            {
                jdGenderText.setText(model.getGender());
            }
            if (model.getContract_type() != null)
            {
                jdContractTypeText.setText(model.getContract_type());
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            {
                summaryText.setText(Html.fromHtml(model.getSummary(), Html.FROM_HTML_MODE_COMPACT));
                jdJobResponsibilityText.setText(Html.fromHtml(model.getResponsibilities(), Html.FROM_HTML_MODE_COMPACT));
            }
            else
            {
                summaryText.setText(Html.fromHtml(model.getSummary()));
                jdJobResponsibilityText.setText(Html.fromHtml(model.getResponsibilities()));
            }
            if (model.getAbout_company() != null)
            {
                if (model.getAbout_company().equalsIgnoreCase("") || model.getAbout_company().equalsIgnoreCase("N/A"))
                {
                    aboutCompanyText.setVisibility(View.GONE);
                }
                else
                {
                    aboutCompanyText.setText(model.getAbout_company());
                }
            }
    }


    @OnClick(R.id.interview_button)
    public void onViewClicked() {
    }
}
