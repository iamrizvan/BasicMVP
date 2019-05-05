package work.andrd.com.savedjobmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SavedJobModel {
    @Expose
    @SerializedName("data")
    private List<Data> data;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("code")
    private String code;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class Data {
        @Expose
        @SerializedName("status")
        private boolean status;
        @Expose
        @SerializedName("created_date")
        private String created_date;
        @Expose
        @SerializedName("salary")
        private String salary;
        @Expose
        @SerializedName("currency")
        private String currency;
        @Expose
        @SerializedName("location")
        private String location;
        @Expose
        @SerializedName("company_logo")
        private String company_logo;
        @Expose
        @SerializedName("company_name")
        private String company_name;
        @Expose
        @SerializedName("company_id")
        private String company_id;
        @Expose
        @SerializedName("job_title")
        private String job_title;
        @Expose
        @SerializedName("job_sub_category_id")
        private String job_sub_category_id;
        @Expose
        @SerializedName("job_vacancy_id")
        private String job_vacancy_id;

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getCreated_date() {
            return created_date;
        }

        public void setCreated_date(String created_date) {
            this.created_date = created_date;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCompany_logo() {
            return company_logo;
        }

        public void setCompany_logo(String company_logo) {
            this.company_logo = company_logo;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getJob_title() {
            return job_title;
        }

        public void setJob_title(String job_title) {
            this.job_title = job_title;
        }

        public String getJob_sub_category_id() {
            return job_sub_category_id;
        }

        public void setJob_sub_category_id(String job_sub_category_id) {
            this.job_sub_category_id = job_sub_category_id;
        }

        public String getJob_vacancy_id() {
            return job_vacancy_id;
        }

        public void setJob_vacancy_id(String job_vacancy_id) {
            this.job_vacancy_id = job_vacancy_id;
        }
    }






   /* @Expose
    @SerializedName("data")
    private List<Data> data;

    public static class Data {
        @Expose
        @SerializedName("job_vacancy_id")
        private String job_vacancy_id;
        @Expose
        @SerializedName("job_sub_category_id")
        private String job_sub_category_id;
        @Expose
        @SerializedName("job_title")
        private String job_title;
        @Expose
        @SerializedName("company_id")
        private String company_id;
        @Expose
        @SerializedName("company_name")
        private String company_name;
        @Expose
        @SerializedName("company_logo")
        private String company_logo;
        @Expose
        @SerializedName("location")
        private String location;
        @Expose
        @SerializedName("currency")
        private String currency;
        @Expose
        @SerializedName("salary")
        private String salary;
        @Expose
        @SerializedName("created_date")
        private String created_date;
        @Expose
        @SerializedName("status")
        private boolean status;

        public String getJob_vacancy_id() {
            return job_vacancy_id;
        }

        public void setJob_vacancy_id(String job_vacancy_id) {
            this.job_vacancy_id = job_vacancy_id;
        }

        public String getJob_sub_category_id() {
            return job_sub_category_id;
        }

        public void setJob_sub_category_id(String job_sub_category_id) {
            this.job_sub_category_id = job_sub_category_id;
        }

        public String getJob_title() {
            return job_title;
        }

        public void setJob_title(String job_title) {
            this.job_title = job_title;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getCompany_logo() {
            return company_logo;
        }

        public void setCompany_logo(String company_logo) {
            this.company_logo = company_logo;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getCreated_date() {
            return created_date;
        }

        public void setCreated_date(String created_date) {
            this.created_date = created_date;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("code")
    private String code;


    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }*/
}
