package br.com.mpr.admin.vo;

/**
 * Created by wagner on 02/02/19.
 */
public class CartaoCreditoVo {

    private String secutiryCode;
    private String brand;
    private String expirationDate;
    private String cardNumber;
    private String holder;
    private String token;
    private Integer quantity;

    public String getSecutiryCode() {
        return secutiryCode;
    }

    public void setSecutiryCode(String secutiryCode) {
        this.secutiryCode = secutiryCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
