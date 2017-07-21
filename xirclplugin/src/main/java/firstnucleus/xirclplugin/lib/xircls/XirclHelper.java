package firstnucleus.xirclplugin.lib.xircls;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import firstnucleus.xirclplugin.lib.R;
import firstnucleus.xirclplugin.lib.network.VolleyHelper;

public class XirclHelper extends Application {

    public static final String TAG = XirclHelper.class.getSimpleName();
    static SharedPreferences.Editor editor;
    static SharedPreferences prefs;
    private static XirclHelper mInstance;
    private RequestQueue mRequestQueue;

    public static synchronized XirclHelper getInstance() {
        return mInstance;
    }

    public static String getFormattedString(float value) {
        try {
            return String.format("%.0f", value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "00";
    }

    //Authentication Key
    public static Map<String, String> getAuthentication(@NonNull String authenticationkey, Context context) {
        HashMap<String, String> params = new HashMap<String, String>();
        try {
            params.put(context.getString(R.string.tagAuthentication), authenticationkey);
            params.put("Content-Type", "application/x-www-form-urlencoded");
        } catch (Exception e) {
            return null;
        }
        return params;
    }

    //get the response code from json
    public static boolean bResponseValue(@NonNull String strStatus) {
        boolean bStatus = false;
        try {
            int sCode = Integer.parseInt(strStatus);
            switch (sCode) {
                case 200:
                    bStatus = true;
                    break;
                case 201:
                    bStatus = false;
                    break;
                case 400:
                    bStatus = false;
                    break;
                case 401:
                    bStatus = false;
                    break;
                case 403:
                    bStatus = false;
                    break;
                case 404:
                    bStatus = false;
                    break;
                case 500:
                    bStatus = false;
                    break;
                case 503:
                    bStatus = false;
                    break;
                default:
            }
        } catch (Exception e) {
        }
        return bStatus;
    }

    //Prepare App Url
    public static String prepareURL(@NonNull final String connectionURL, @NonNull final String strApiTag, Context context) {
        String strURL = "";
        try {
            strURL = connectionURL + strApiTag + "/";
        } catch (Exception e) {
        }
        return strURL;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        req.setRetryPolicy(new DefaultRetryPolicy(
                20 * 1000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setRetryPolicy(new DefaultRetryPolicy(
                20 * 1000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null)
            mRequestQueue.cancelAll(tag);
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null)
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        return mRequestQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        VolleyHelper.initQueues(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

}
