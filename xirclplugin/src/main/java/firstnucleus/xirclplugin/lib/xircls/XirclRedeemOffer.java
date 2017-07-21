package firstnucleus.xirclplugin.lib.xircls;

/**
 * Created by sys5 on 7/5/2017.
 */
public interface XirclRedeemOffer {
    /**
     * Xircl response.
     *
     * @param isSuccess       is success status of response
     * @param responseMessage is response message
     */
    void xirclResponse(boolean isSuccess, String responseMessage);
}
