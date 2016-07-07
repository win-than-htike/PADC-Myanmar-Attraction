package xyz.winthanhtike.padc_myanmarattractions.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by winthanhtike on 7/6/16.
 */
public class MMAttractionVO {

    @SerializedName("title")
    private String placeTitle;

    @SerializedName("desc")
    private String placeDesc;

    @SerializedName("images")
    private String[] placeImages;

    public MMAttractionVO(String placeTitle, String placeDesc, String[] placeImages) {
        this.placeTitle = placeTitle;
        this.placeDesc = placeDesc;
        this.placeImages = placeImages;
    }

    public String getPlaceTitle() {
        return placeTitle;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public String[] getPlaceImages() {
        return placeImages;
    }
}
