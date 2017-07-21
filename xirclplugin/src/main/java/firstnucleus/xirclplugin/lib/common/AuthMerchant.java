package firstnucleus.xirclplugin.lib.common;


/**
 * The type Auth merchant.
 */
public class AuthMerchant {
    private String xirclApiUrl;
    private String apiAuthKey;
    private String appContext;

    /**
     * Instantiates a new AuthMerchant Constructors.
     *
     * @param xirclApiUrl the xircl api url is required to fetch data from xircl
     * @param apiAuthKey  the api auth key is required to authenticate merchant
     * @param appContext  the app context
     */
    public AuthMerchant(String xirclApiUrl, String apiAuthKey, String appContext) {
        this.xirclApiUrl = xirclApiUrl;
        this.apiAuthKey = apiAuthKey;
        this.appContext = appContext;
    }

    /**
     * Gets xircl api url as String.
     *
     * @return the xircl api url
     */
    public String getXirclApiUrl() {
        return xirclApiUrl;
    }

    /**
     * Sets xircl api url as String.
     *
     * @param xirclApiUrl the xircl api url
     */
    public void setXirclApiUrl(String xirclApiUrl) {
        this.xirclApiUrl = xirclApiUrl;
    }

    /**
     * Gets api auth key as String.
     *
     * @return the api auth key
     */
    public String getApiAuthKey() {
        return apiAuthKey;
    }

    /**
     * Sets api auth key as String.
     *
     * @param apiAuthKey the api auth key
     */
    public void setApiAuthKey(String apiAuthKey) {
        this.apiAuthKey = apiAuthKey;
    }

    /**
     * Gets app context as Activity reference.
     *
     * @return the context
     */
    public String getAppContext() {
        return appContext;
    }

    /**
     * Sets app context as Activity reference.
     *
     * @param appContext the context
     */
    public void setAppContext(String appContext) {
        this.appContext = appContext;
    }
}
