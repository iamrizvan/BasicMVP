package work.andrd.com.savedjobmvp.savedjob.adapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddCartRequestModel {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<AddToCartItem> getAddToCartItem() {
        return addToCartItem;
    }

    public void setAddToCartItem(List<AddToCartItem> addToCartItem) {
        this.addToCartItem = addToCartItem;
    }

    public String getRaiseEvent() {
        return raiseEvent;
    }

    public void setRaiseEvent(String raiseEvent) {
        this.raiseEvent = raiseEvent;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public AddCartRequestModel(String token, List<AddToCartItem> addToCartItem, String raiseEvent, String loginId) {
        this.token = token;
        this.addToCartItem = addToCartItem;
        this.raiseEvent = raiseEvent;
        this.loginId = loginId;
    }

    @Expose
    @SerializedName("token")
    private String token;
    @Expose
    @SerializedName("addToCartItem")
    private List<AddToCartItem> addToCartItem;
    @Expose
    @SerializedName("raiseEvent")
    private String raiseEvent;
    @Expose
    @SerializedName("loginId")
    private String loginId;

    public static class AddToCartItem {
        public AddToCartItem(String lotNumber, String saleFromIP, String discount) {
            this.lotNumber = lotNumber;
            SaleFromIP = saleFromIP;
            this.discount = discount;
        }
        @Expose
        @SerializedName("lotNumber")
        private String lotNumber;
        @Expose
        @SerializedName("SaleFromIP")
        private String SaleFromIP;
        @Expose
        @SerializedName("discount")
        private String discount;

        public String getLotNumber() {
            return lotNumber;
        }

        public void setLotNumber(String lotNumber) {
            this.lotNumber = lotNumber;
        }

        public String getSaleFromIP() {
            return SaleFromIP;
        }

        public void setSaleFromIP(String saleFromIP) {
            SaleFromIP = saleFromIP;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }
    }
}
