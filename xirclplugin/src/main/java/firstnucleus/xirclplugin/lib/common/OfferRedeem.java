package firstnucleus.xirclplugin.lib.common;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * The type Offer redeem.
 */
public class OfferRedeem {
    private String userEmail;
    private String sellerRefCode;
    private Context context;
    private String pinCode;
    private String city;
    private String country;
    private String priceBefore;
    private String priceAfter;
    private String userMobile;
    private String connectionURL;
    private String authenticationKey;

    /**
     * Instantiates a new Offer redeem Constructors.
     *
     * @param connectionURL     the connection url
     * @param authenticationKey the authentication key
     * @param userEmail         the user email address
     * @param sellerRefCode     the seller reference code
     * @param context           the context (current Activity reference)
     * @param pinCode           the pin code of area
     * @param city              the city name
     * @param country           the country name
     * @param priceBefore       the product price before apply offer
     * @param priceAfter        the product price after apply offer
     * @param userMobile        the user mobile
     */

    public OfferRedeem(@NonNull String connectionURL, @NonNull String authenticationKey, String userMobile, String userEmail, String sellerRefCode, String pinCode, String city, String country, String priceBefore, String priceAfter, Context context) {
        this.userEmail = userEmail;
        this.sellerRefCode = sellerRefCode;
        this.context = context;
        this.pinCode = pinCode;
        this.city = city;
        this.country = country;
        this.priceBefore = priceBefore;
        this.priceAfter = priceAfter;
        this.userMobile = userMobile;
        this.connectionURL = connectionURL;
        this.authenticationKey = authenticationKey;
    }

    /**
     * Gets user mobile as String.
     *
     * @return the user mobile
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * Sets user mobile as String.
     *
     * @param userMobile the user mobile
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * Gets user email as String.
     *
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets user email as String.
     *
     * @param userEmail the user email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets seller ref code as String.
     *
     * @return the seller ref code
     */
    public String getSellerRefCode() {
        return sellerRefCode;
    }

    /**
     * Sets seller ref code as String.
     *
     * @param sellerRefCode the seller ref code
     */
    public void setSellerRefCode(String sellerRefCode) {
        this.sellerRefCode = sellerRefCode;
    }

    /**
     * Gets context as Activity reference.
     *
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * Sets context as Activity reference.
     *
     * @param context the context
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * Gets pin code as String.
     *
     * @return the pin code
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * Sets pin code as String.
     *
     * @param pinCode the pin code
     */
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    /**
     * Gets city name  as String..
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city name as String..
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets country name as String..
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country name as String..
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets product price before apply offer as String.
     *
     * @return the price before
     */
    public String getPriceBefore() {
        return priceBefore;
    }

    /**
     * Sets product price before apply offer as String.
     *
     * @param priceBefore the price before
     */
    public void setPriceBefore(String priceBefore) {
        this.priceBefore = priceBefore;
    }

    /**
     * Gets product price after apply offer as String.
     *
     * @return the price after
     */
    public String getPriceAfter() {
        return priceAfter;
    }

    /**
     * Sets product price after apply offer as String.
     *
     * @param priceAfter the price after
     */
    public void setPriceAfter(String priceAfter) {
        this.priceAfter = priceAfter;
    }

    /**
     * Gets connection url.
     *
     * @return the connection url
     */
    public String getConnectionURL() {
        return connectionURL;
    }

    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    public String getAuthenticationKey() {
        return authenticationKey;
    }

    public void setAuthenticationKey(String authenticationKey) {
        this.authenticationKey = authenticationKey;
    }
}
