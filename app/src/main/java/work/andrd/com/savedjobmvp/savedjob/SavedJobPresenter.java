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
import work.andrd.com.savedjobmvp.savedjob.adapter.SavedJobAdapter;
import work.andrd.com.savedjobmvp.model.SavedJobModel;
import work.andrd.com.savedjobmvp.webservice.RetroConfig;

public class SavedJobPresenter implements SavedJobContract.Presenter, SavedJobContract.View {

    SavedJobAdapter adapter;
    List<SavedJobModel.Data> savedJobList;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public void showNoInternet(Context context, String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadSavedJob(Context context, String applicant_id, RecyclerView recyclerView) {
            Call<SavedJobModel> call = RetroConfig.retrofit().getSavedJob("481");
            call.enqueue(new Callback<SavedJobModel>() {
                @Override
                public void onResponse(Call<SavedJobModel> call, Response<SavedJobModel> response) {

                    if (response.isSuccessful()) {
                        savedJobList = new ArrayList<>();
                        savedJobList = response.body().getData();
                        updateSavedJobList(savedJobList);
                      /*  adapter = new SavedJobAdapter(context, savedJobList, recyclerView);
                        layoutManager = new LinearLayoutManager(context);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);*/
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

    @Override
    public void updateSavedJobList(List<SavedJobModel.Data> jobList) {
    }

   /* @Override
    public void addToCart() {

        JSONObject idObject = new JSONObject();
        JSONObject raiseEventObject = new JSONObject();
        JSONObject tokenObject = new JSONObject();
        JSONArray requestArray = new JSONArray();
        JSONObject dataObject = new JSONObject();


     //   JSONObjectBuilder requestObject = new JSONObject();
        JSONObject finalDataObject = new JSONObject();
        try {
            idObject.put("loginId", "3024");
            raiseEventObject.put("raiseEvent", "CART");
            tokenObject.put("token", "27c2dc64a66b4bd8909c3f78a9a02d44");
            dataObject.put("discount","-48.50");
            dataObject.put("SaleFromIP","192.168.0.110");
            dataObject.put("lotNumber","A161193833610");
            requestArray.put(dataObject);
            dataObject.put("discount","-40.50");
            dataObject.put("SaleFromIP","192.168.0.110");
            dataObject.put("lotNumber","A161229400892");
            requestArray.put(dataObject);
            dataObject.put("discount","-28.50");
            dataObject.put("SaleFromIP","192.168.0.110");
            dataObject.put("lotNumber","A1652620900401");
            requestArray.put(dataObject);
            finalDataObject.put("addToCartItem", requestArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }


      *//*  Call<String> call = RetroConfig.getRetrofit("https://rosyblueonline.com/api/Services/").addToCart();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()) {


                }
                else {
                 //   Toast.makeText(context,"Not successful",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
             //   Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });*//*
    }*/
} 
