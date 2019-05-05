package work.andrd.com.savedjobmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JobDescription {

    @Expose
    @SerializedName("data")
    private List<Data> data;
    @Expose
    @SerializedName("code")
    private String code;
    @Expose
    @SerializedName("status")
    private String status;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Data {
        @Expose
        @SerializedName("about_company")
        private String about_company;
        @Expose
        @SerializedName("responsibilities")
        private String responsibilities;
        @Expose
        @SerializedName("summary")
        private String summary;
        @Expose
        @SerializedName("contract_type")
        private String contract_type;
        @Expose
        @SerializedName("gender")
        private String gender;
        @Expose
        @SerializedName("work_experience")
        private String work_experience;
        @Expose
        @SerializedName("language_skill")
        private String language_skill;
        @Expose
        @SerializedName("residence_location")
        private String residence_location;
        @Expose
        @SerializedName("carrier_level")
        private String carrier_level;
        @Expose
        @SerializedName("driving_licence")
        private String driving_licence;
        @Expose
        @SerializedName("visa_status")
        private String visa_status;
        @Expose
        @SerializedName("min_degree_level")
        private String min_degree_level;
        @Expose
        @SerializedName("nationality")
        private String nationality;
        @Expose
        @SerializedName("age_limit")
        private String age_limit;
        @Expose
        @SerializedName("status")
        private boolean status;
        @Expose
        @SerializedName("logo")
        private String logo;
        @Expose
        @SerializedName("created_date")
        private String created_date;
        @Expose
        @SerializedName("salary")
        private String salary;
        @Expose
        @SerializedName("industry")
        private String industry;
        @Expose
        @SerializedName("location")
        private String location;
        @Expose
        @SerializedName("company_name")
        private String company_name;
        @Expose
        @SerializedName("job_title")
        private String job_title;
        @Expose
        @SerializedName("job_vacancy_id")
        private String job_vacancy_id;

        public String getAbout_company() {
            return about_company;
        }

        public void setAbout_company(String about_company) {
            this.about_company = about_company;
        }

        public String getResponsibilities() {
            return responsibilities;
        }

        public void setResponsibilities(String responsibilities) {
            this.responsibilities = responsibilities;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getContract_type() {
            return contract_type;
        }

        public void setContract_type(String contract_type) {
            this.contract_type = contract_type;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getWork_experience() {
            return work_experience;
        }

        public void setWork_experience(String work_experience) {
            this.work_experience = work_experience;
        }

        public String getLanguage_skill() {
            return language_skill;
        }

        public void setLanguage_skill(String language_skill) {
            this.language_skill = language_skill;
        }

        public String getResidence_location() {
            return residence_location;
        }

        public void setResidence_location(String residence_location) {
            this.residence_location = residence_location;
        }

        public String getCarrier_level() {
            return carrier_level;
        }

        public void setCarrier_level(String carrier_level) {
            this.carrier_level = carrier_level;
        }

        public String getDriving_licence() {
            return driving_licence;
        }

        public void setDriving_licence(String driving_licence) {
            this.driving_licence = driving_licence;
        }

        public String getVisa_status() {
            return visa_status;
        }

        public void setVisa_status(String visa_status) {
            this.visa_status = visa_status;
        }

        public String getMin_degree_level() {
            return min_degree_level;
        }

        public void setMin_degree_level(String min_degree_level) {
            this.min_degree_level = min_degree_level;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getAge_limit() {
            return age_limit;
        }

        public void setAge_limit(String age_limit) {
            this.age_limit = age_limit;
        }

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
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

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getJob_title() {
            return job_title;
        }

        public void setJob_title(String job_title) {
            this.job_title = job_title;
        }

        public String getJob_vacancy_id() {
            return job_vacancy_id;
        }

        public void setJob_vacancy_id(String job_vacancy_id) {
            this.job_vacancy_id = job_vacancy_id;
        }
    }
}
