package work.andrd.com.savedjobmvp.webservice;


import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import work.andrd.com.savedjobmvp.constant.Constant;
import work.andrd.com.savedjobmvp.model.JobDescription;
import work.andrd.com.savedjobmvp.model.RemoveJobModel;
import work.andrd.com.savedjobmvp.model.SavedJobModel;
import work.andrd.com.savedjobmvp.savedjob.adapter.AddCartRequestModel;


public interface RetroAPI {
    @FormUrlEncoded
    @POST(Constant.FETCH_SAVED_JOB)
    Call<SavedJobModel> getSavedJob(@Field("applicant_id") String id);

    @FormUrlEncoded
    @POST(Constant.GET_JOB_DETAILS_BY_JOB_ID)
    Call<JobDescription> getJobDetailsByVacancyId(@Field("vacancy_id") String vacancy_id);

    @FormUrlEncoded
    @POST(Constant.REMOVE_SAVED_JOB)
    Call<RemoveJobModel> removeJob(@Field("applicant_id") String applicant_id,
                                   @Field("vacancy_id") String vacancy_id);


    @POST("AddToCartWatch")
    Call<String> addToCart(@Body JSONObject requestJson);

}