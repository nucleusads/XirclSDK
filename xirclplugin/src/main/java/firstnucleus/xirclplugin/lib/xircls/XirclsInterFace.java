package firstnucleus.xirclplugin.lib.xircls;

import android.support.annotation.NonNull;

import firstnucleus.xirclplugin.lib.common.OfferRedeem;
import firstnucleus.xirclplugin.lib.common.UserDetails;

/**
 * Created by sys5 on 7/13/2017.
 */
public interface XirclsInterFace {
    void getCartOffers(@NonNull UserDetails userDetails);

    void getProductOffers(@NonNull UserDetails userDetails);

    void getOffers(@NonNull UserDetails userDetails);

    void redeemOffer(@NonNull OfferRedeem offerRedeem);
}
