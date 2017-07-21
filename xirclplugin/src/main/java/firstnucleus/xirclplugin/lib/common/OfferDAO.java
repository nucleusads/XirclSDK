package firstnucleus.xirclplugin.lib.common;

/**
 * The type Offer.
 */
public class OfferDAO {

    private String offerID;
    private String OfferTypeID;
    private String offerSavingValue;
    private String offerCode;
    private String offerMaxValue;
    private String sellerRefCode;
    private String offerName;
    private String offerImage;
    private String outletName;
    private String offerDescription;


    /**
     * Instantiates a new Offer dao.
     *
     * @param offerID          the offer id as String
     * @param offerTypeID      the offer type id as String
     * @param offerSavingValue the offer saving value as String
     * @param offerCode        the offer code as String
     * @param offerMaxValue    the offer max value as String
     * @param sellerRefCode    the seller ref code as String
     * @param offerName        the offer name as String
     * @param offerImage       the offer image as String
     * @param outletName       the outlet name as String
     * @param offerDescription the offer description as String
     */
    public OfferDAO(String offerID, String offerTypeID, String offerSavingValue, String offerCode, String offerMaxValue, String sellerRefCode,
                    String offerName, String offerImage, String outletName, String offerDescription) {
        super();
        this.offerID = offerID;
        OfferTypeID = offerTypeID;
        this.offerImage = offerImage;
        this.offerSavingValue = offerSavingValue;
        this.offerCode = offerCode;
        this.offerMaxValue = offerMaxValue;
        this.sellerRefCode = sellerRefCode;
        this.offerName = offerName;
        this.outletName = outletName;
        this.offerDescription = offerDescription;
    }

    /**
     * Gets outlet name as String.
     *
     * @return the outlet name
     */
    public String getOutletName() {
        return outletName;
    }

    /**
     * Sets outlet name as String.
     *
     * @param outletName the outlet name
     */
    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    /**
     * Gets offer description as String.
     *
     * @return the offer description
     */
    public String getOfferDescription() {
        return offerDescription;
    }

    /**
     * Sets offer description as String.
     *
     * @param offerDescription the offer description
     */
    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    /**
     * Gets offer name as String.
     *
     * @return the offer name
     */
    public String getOfferName() {
        return offerName;
    }

    /**
     * Sets offer name as String.
     *
     * @param offerName the offer name
     */
    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    /**
     * Gets offer id as String.
     *
     * @return the offer id
     */
    public String getOfferID() {
        return offerID;
    }

    /**
     * Sets offer id as String.
     *
     * @param offerID the offer id
     */
    public void setOfferID(String offerID) {
        this.offerID = offerID;
    }

    /**
     * Gets offer type id as String.
     *
     * @return the offer type id
     */
    public String getOfferTypeID() {
        return OfferTypeID;
    }

    /**
     * Sets offer type id as String.
     *
     * @param offerTypeID the offer type id
     */
    public void setOfferTypeID(String offerTypeID) {
        OfferTypeID = offerTypeID;
    }

    /**
     * Gets offer saving value as String.
     *
     * @return the offer saving value
     */
    public String getOfferSavingValue() {
        return offerSavingValue;
    }

    /**
     * Sets offer saving value as String.
     *
     * @param offerSavingValue the offer saving value
     */
    public void setOfferSavingValue(String offerSavingValue) {
        this.offerSavingValue = offerSavingValue;
    }

    /**
     * Gets offer code as String.
     *
     * @return the offer code
     */
    public String getOfferCode() {
        return offerCode;
    }

    /**
     * Sets offer code as String.
     *
     * @param offerCode the offer code
     */
    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    /**
     * Gets offer max value as String.
     *
     * @return the offer max value
     */
    public String getOfferMaxValue() {
        return offerMaxValue;
    }

    /**
     * Sets offer max value as String.
     *
     * @param offerMaxValue the offer max value
     */
    public void setOfferMaxValue(String offerMaxValue) {
        this.offerMaxValue = offerMaxValue;
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
     * Gets offer image url as String.
     *
     * @return the offer image
     */
    public String getOfferImage() {
        return offerImage;
    }

    /**
     * Sets offer image url as String.
     *
     * @param offerImage the offer image
     */
    public void setOfferImage(String offerImage) {
        this.offerImage = offerImage;
    }
}
