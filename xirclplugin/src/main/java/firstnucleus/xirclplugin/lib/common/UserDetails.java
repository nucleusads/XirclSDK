package firstnucleus.xirclplugin.lib.common;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * The type User details.
 */
public class UserDetails {
    private String userMobile;
    private String userEmail;
    private String sellerRefCode;
    private Context context;
    private String connectionURL;
    private String authenticationKey;

    /**
     * Instantiates a new User details.
     *
     * @param ConnectionURL     the connection url
     * @param authenticationKey the authentication key
     * @param userMobile        the user mobile
     * @param userEmail         the user email
     * @param sellerRefCode     the seller ref code
     * @param context           the context
     */
    public UserDetails(@NonNull String ConnectionURL, @NonNull String authenticationKey, @NonNull String userMobile, @NonNull String userEmail, @NonNull String sellerRefCode, @NonNull Context context) {
        this.userMobile = userMobile;
        this.userEmail = userEmail;
        this.sellerRefCode = sellerRefCode;
        this.context = context;
        this.connectionURL = ConnectionURL;
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
