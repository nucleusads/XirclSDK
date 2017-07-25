package firstnucleus.xirclplugin.lib;

import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import firstnucleus.xirclplugin.lib.common.OfferDAO;
import firstnucleus.xirclplugin.lib.common.OfferRedeem;
import firstnucleus.xirclplugin.lib.common.UserDetails;
import firstnucleus.xirclplugin.lib.xircls.XirclHelper;
import firstnucleus.xirclplugin.lib.xircls.XirclRedeemOffer;
import firstnucleus.xirclplugin.lib.xircls.Xircls;
import firstnucleus.xirclplugin.lib.xircls.XirclsInterFace;


public class XirclController implements XirclsInterFace {

    public static Xircls xirclOffers;

    public static XirclRedeemOffer xirclRedeemOffer;


    public static void xirclsOfferCallback(Xircls xircl) {
        xirclOffers = xircl;
    }

    public static void xirclsRedeemCallback(XirclRedeemOffer xirclRedeem) {
        xirclRedeemOffer = xirclRedeem;
    }

    private static boolean isSetupDone() {
        return true;
    }

    public static XirclController xirclsRequest(Xircls xirclOffers) {
        XirclController xirclObject = null;
        try {
            xirclObject = new XirclController();
            xirclsOfferCallback(xirclOffers);
        } catch (Exception e) {
        }
        return xirclObject;
    }

    /**
     * @param userDetails it contains
     *                    User Mobile as String
     *                    User EmailId as String
     *                    Seller reference code as String (comma separated )
     *                    Activity reference
     */

    @Override
    public void getCartOffers(@NonNull final UserDetails userDetails) {
        try {
            final ArrayList<OfferDAO> offerList;
            offerList = new ArrayList<OfferDAO>();
            final Map<String, String> xirclsParams = new HashMap<String, String>();
            xirclsParams.put(userDetails.getContext().getString(R.string.apiKeyCustomerMobile), userDetails.getUserMobile());
            xirclsParams.put(userDetails.getContext().getString(R.string.apiKeyCustomerEmail), userDetails.getUserEmail());
            xirclsParams.put(userDetails.getContext().getString(R.string.apiKeyMerchantRefCode), userDetails.getSellerRefCode());
            StringRequest strReq = new StringRequest(Request.Method.POST, XirclHelper.prepareURL(userDetails.getConnectionURL(), userDetails.getContext().getString(R.string.apiTagGetCartOffer), userDetails.getContext()),
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String strResponse) {
                            try {
                                JSONObject jsonObject = new JSONObject(strResponse);
                                if (XirclHelper.bResponseValue(jsonObject.getString(userDetails.getContext().getString(R.string.tagStatus)))) {
                                    JSONObject jsonObjectData = jsonObject.getJSONObject(userDetails.getContext().getString(R.string.tagData));
                                    JSONArray jsonArray = jsonObjectData.getJSONArray(userDetails.getContext().getString(R.string.apiKeyOfferList));
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject jData = jsonArray.getJSONObject(i);
                                        OfferDAO offerDAO = new OfferDAO(jData.getString(userDetails.getContext().getString(R.string.apiParamOfferId)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferTypeId)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferSavingValue)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferCode)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferMaxValue)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamSellerRefCode)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferName)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferImage)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferName)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferDes)));
                                        offerList.add(offerDAO);
                                    }
                                    xirclOffers.xirclResponse(offerList,
                                            jsonArray.length() !=
                                            0, jsonObject.getString(userDetails.getContext().getString(R.string.tagMessage)));
                                    xirclOffers.offerCount(jsonArray.length());
                                } else {
                                    xirclOffers.xirclResponse(offerList, false, jsonObject.getString(userDetails.getContext().getString(R.string.tagMessage)));
                                    xirclOffers.offerCount(0);
                                }
                            } catch (Exception e) {
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof TimeoutError || error instanceof NoConnectionError)
                        Log.d("TAG.......", "v1: " + error);
                    else if (error instanceof AuthFailureError)
                        Log.d("TAG..........", "v2: " + error);
                    else if (error instanceof ServerError)
                        Log.d("TAG.........", "v3: " + error);
                    else if (error instanceof NetworkError)
                        Log.d("TAG.......", "v4: " + error);
                    else if (error instanceof ParseError)
                        Log.d("TAG.......", "v5: " + error);
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    return xirclsParams;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    return XirclHelper.getAuthentication(userDetails.getAuthenticationKey(), userDetails.getContext());
                }
            };
            XirclHelper.getInstance().addToRequestQueue(strReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param userDetails it contains
     *                    User Mobile as String
     *                    User EmailId as String
     *                    Seller reference code as String (comma separated )
     *                    Activity reference
     */

    @Override
    public void getProductOffers(@NonNull final UserDetails userDetails) {
        try {
            final ArrayList<OfferDAO> offerList;
            offerList = new ArrayList<OfferDAO>();

            StringRequest strReq = new StringRequest(Request.Method.POST, XirclHelper.prepareURL(userDetails.getConnectionURL(), userDetails.getContext().getString(R.string.apiTagGetProductOffer), userDetails.getContext()),
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String strResponse) {
                            try {
                                JSONObject jsonObject = new JSONObject(strResponse);
                                if (XirclHelper.bResponseValue(jsonObject.getString(userDetails.getContext().getString(R.string.tagStatus)))) {
                                    JSONObject jsonObjectData = jsonObject.getJSONObject(userDetails.getContext().getString(R.string.tagData));
                                    JSONArray jsonArray = jsonObjectData.getJSONArray(userDetails.getContext().getString(R.string.apiKeyOfferList));
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject jData = jsonArray.getJSONObject(i);
                                        OfferDAO offerDAO = new OfferDAO(jData.getString(userDetails.getContext().getString(R.string.apiParamOfferId)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferTypeId)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferSavingValue)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferCode)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferMaxValue)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamSellerRefCode)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferName)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferImage)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferName)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferDes)));
                                        offerList.add(offerDAO);
                                    }
                                    xirclOffers.xirclResponse(offerList,
                                            jsonArray.length() !=
                                            0, jsonObject.getString(userDetails.getContext().getString(R.string.tagMessage)));
                                    xirclOffers.offerCount(jsonArray.length());
                                } else {
                                    xirclOffers.xirclResponse(offerList, false, jsonObject.getString(userDetails.getContext().getString(R.string.tagMessage)));
                                    xirclOffers.offerCount(0);
                                }
                            } catch (Exception e) {
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof TimeoutError || error instanceof NoConnectionError)
                        Log.d("TAG.......", "v1: " + error);
                    else if (error instanceof AuthFailureError)
                        Log.d("TAG..........", "v2: " + error);
                    else if (error instanceof ServerError)
                        Log.d("TAG.........", "v3: " + error);
                    else if (error instanceof NetworkError)
                        Log.d("TAG.......", "v4: " + error);
                    else if (error instanceof ParseError)
                        Log.d("TAG.......", "v5: " + error);
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    final Map<String, String> xirclsParams = new HashMap<String, String>();
                    xirclsParams.put(userDetails.getContext().getString(R.string.apiKeyCustomerMobile), userDetails.getUserMobile());
                    xirclsParams.put(userDetails.getContext().getString(R.string.apiKeyCustomerEmail), userDetails.getUserEmail());
                    xirclsParams.put(userDetails.getContext().getString(R.string.apiKeyMerchantRefCode), userDetails.getSellerRefCode());
                    Log.e("Data in params", xirclsParams.toString());
                    return xirclsParams;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    return XirclHelper.getAuthentication(userDetails.getAuthenticationKey(), userDetails.getContext());
                }
            };
            XirclHelper.getInstance().addToRequestQueue(strReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param userDetails it contains
     *                    Connection Url as String
     *                    Authentication Key as String
     *                    User Mobile as String
     *                    User EmailId as String
     *                    Seller reference code as String (comma separated )
     *                    Activity reference
     */

    @Override
    public void getOffers(@NonNull final UserDetails userDetails) {
        try {
            final ArrayList<OfferDAO> offerList = new ArrayList<OfferDAO>();
            final Map<String, String> xirclsParams = new HashMap<String, String>();
            xirclsParams.put(userDetails.getContext().getString(R.string.apiKeyCustomerMobile), userDetails.getUserMobile());
            xirclsParams.put(userDetails.getContext().getString(R.string.apiKeyCustomerEmail), userDetails.getUserEmail());
            xirclsParams.put(userDetails.getContext().getString(R.string.apiKeyMerchantRefCode), userDetails.getSellerRefCode());
            StringRequest strReq = new StringRequest(Request.Method.POST, XirclHelper.prepareURL(userDetails.getConnectionURL(), userDetails.getContext().getString(R.string.apiTagGetMyOffer), userDetails.getContext()),
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String strResponse) {
                            try {
                                JSONObject jsonObject = new JSONObject(strResponse);
                                if (XirclHelper.bResponseValue(jsonObject.getString(userDetails.getContext().getString(R.string.tagStatus)))) {
                                    JSONObject jsonObjectData = jsonObject.getJSONObject(userDetails.getContext().getString(R.string.tagData));
                                    JSONArray jsonArray = jsonObjectData.getJSONArray(userDetails.getContext().getString(R.string.apiKeyOfferList));
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject jData = jsonArray.getJSONObject(i);
                                        OfferDAO offerDAO = new OfferDAO(jData.getString(userDetails.getContext().getString(R.string.apiParamOfferId)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferTypeId)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferSavingValue)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferCode)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferMaxValue)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamSellerRefCode)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferName)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferImage)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferName)),
                                                jData.getString(userDetails.getContext().getString(R.string.apiParamOfferDes)));
                                        offerList.add(offerDAO);
                                    }
                                    xirclOffers.xirclResponse(offerList,
                                            jsonArray.length() !=
                                            0, jsonObject.getString(userDetails.getContext().getString(R.string.tagMessage)));
                                    xirclOffers.offerCount(jsonArray.length());
                                } else {
                                    xirclOffers.xirclResponse(offerList, false, jsonObject.getString(userDetails.getContext().getString(R.string.tagMessage)));
                                    xirclOffers.offerCount(0);
                                }
                            } catch (Exception e) {
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof TimeoutError || error instanceof NoConnectionError)
                        Log.d("TAG.......", "v1: " + error);
                    else if (error instanceof AuthFailureError)
                        Log.d("TAG..........", "v2: " + error);
                    else if (error instanceof ServerError)
                        Log.d("TAG.........", "v3: " + error);
                    else if (error instanceof NetworkError)
                        Log.d("TAG.......", "v4: " + error);
                    else if (error instanceof ParseError)
                        Log.d("TAG.......", "v5: " + error);
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    return xirclsParams;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    return XirclHelper.getAuthentication(userDetails.getAuthenticationKey(), userDetails.getContext());
                }
            };
            XirclHelper.getInstance().addToRequestQueue(strReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void redeemOffer(@NonNull final OfferRedeem offerRedeem) {
        try {
            try {
                final ArrayList<OfferDAO> offerList = new ArrayList<OfferDAO>();
                final Map<String, String> xirclsParams = new HashMap<String, String>();
                xirclsParams.put(offerRedeem.getContext().getString(R.string.apiKeyCustomerMobile), offerRedeem.getUserMobile());
                xirclsParams.put(offerRedeem.getContext().getString(R.string.apiKeyCustomerEmail), offerRedeem.getUserEmail());
                xirclsParams.put(offerRedeem.getContext().getString(R.string.apiKeyMerchantRefCode), offerRedeem.getSellerRefCode());
                xirclsParams.put(offerRedeem.getContext().getString(R.string.apiKeyUserPinCode), offerRedeem.getPinCode());
                xirclsParams.put(offerRedeem.getContext().getString(R.string.apiKeyUserCity), offerRedeem.getCity());
                xirclsParams.put(offerRedeem.getContext().getString(R.string.apiKeyUserCountry), offerRedeem.getCountry());
                xirclsParams.put(offerRedeem.getContext().getString(R.string.apiKeyPriceBefore), offerRedeem.getPriceBefore());
                xirclsParams.put(offerRedeem.getContext().getString(R.string.apiKeyPriceAfter), offerRedeem.getPriceAfter());

                StringRequest strReq = new StringRequest(Request.Method.POST, XirclHelper.prepareURL(offerRedeem.getConnectionURL(), offerRedeem.getContext().getString(R.string.apiTagRedeemOffer), offerRedeem.getContext()),
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String strResponse) {
                                try {
                                    JSONObject jsonObject = new JSONObject(strResponse);
                                    if (XirclHelper.bResponseValue(jsonObject.getString(offerRedeem.getContext().getString(R.string.tagStatus)))) {
                                        xirclOffers.xirclResponse(null, true, jsonObject.getString(offerRedeem.getContext().getString(R.string.tagMessage)));
                                        xirclOffers.offerCount(0);
                                    } else {
                                        xirclOffers.xirclResponse(offerList, false, jsonObject.getString(offerRedeem.getContext().getString(R.string.tagMessage)));
                                        xirclOffers.offerCount(0);
                                    }
                                } catch (Exception e) {
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError || error instanceof NoConnectionError)
                            Log.d("TAG.......", "v1: " + error);
                        else if (error instanceof AuthFailureError)
                            Log.d("TAG..........", "v2: " + error);
                        else if (error instanceof ServerError)
                            Log.d("TAG.........", "v3: " + error);
                        else if (error instanceof NetworkError)
                            Log.d("TAG.......", "v4: " + error);
                        else if (error instanceof ParseError)
                            Log.d("TAG.......", "v5: " + error);
                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() {
                        return xirclsParams;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return XirclHelper.getAuthentication(offerRedeem.getAuthenticationKey(), offerRedeem.getContext());
                    }
                };
                XirclHelper.getInstance().addToRequestQueue(strReq);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }
}
