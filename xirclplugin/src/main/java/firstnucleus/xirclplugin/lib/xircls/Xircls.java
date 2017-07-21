package firstnucleus.xirclplugin.lib.xircls;

import java.util.ArrayList;

import firstnucleus.xirclplugin.lib.common.OfferDAO;

/**
 * Created by sys5 on 7/5/2017.
 */
public interface Xircls {
    /**
     * XirclController response return offer list, success, Response message.
     *
     * @param offerList       the offer list of customer
     * @param isSuccess       the is success status of response
     * @param responseMessage the response message
     */
    void xirclResponse(ArrayList<OfferDAO> offerList, boolean isSuccess, String responseMessage);


    /**
     * Return Offer count for requested offer listing.
     *
     * @param offerCount the offer count
     */
    void offerCount(int offerCount);
}
