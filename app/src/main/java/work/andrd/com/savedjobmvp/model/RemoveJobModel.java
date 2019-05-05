package work.andrd.com.savedjobmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RemoveJobModel {

    @Expose
    @SerializedName("msg")
    private String msg;
    @Expose
    @SerializedName("code")
    private String code;
    @Expose
    @SerializedName("status")
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
}
