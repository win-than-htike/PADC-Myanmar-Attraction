package xyz.winthanhtike.padc_myanmarattractions.data.models;

import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import xyz.winthanhtike.padc_myanmarattractions.data.vos.MMAttractionVO;
import xyz.winthanhtike.padc_myanmarattractions.utils.CommonInstances;
import xyz.winthanhtike.padc_myanmarattractions.utils.JsonUtils;

/**
 * Created by winthanhtike on 7/6/16.
 */
public class MMAttractionModel {

    private static String DUMMY_PLACE_LIST = "myanmar_attractions.json";

    private static MMAttractionModel objInstance;

    private List<MMAttractionVO> placeList;

    private MMAttractionModel(){
        this.placeList = initializePlaceList();
    }

    public static MMAttractionModel getInstance(){

        if (objInstance == null){
            objInstance = new MMAttractionModel();
        }
        return objInstance;
    }

    private List<MMAttractionVO> initializePlaceList(){
        List<MMAttractionVO> placeList = new ArrayList<>();

        try {
            String dummyPlaceList = JsonUtils.getInstance().loadDummyData(DUMMY_PLACE_LIST);
            Type listType = new TypeToken<List<MMAttractionVO>>(){}.getType();
            placeList = CommonInstances.getGson().fromJson(dummyPlaceList,listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return placeList;

    }

    public List<MMAttractionVO> getPlaceList() {
        return placeList;
    }

    public MMAttractionVO getPlaceByTitle(String placeTitle){

        for (MMAttractionVO mmAttractionVO : placeList){
            if (mmAttractionVO.getPlaceTitle().equals(placeTitle)){
                return mmAttractionVO;
            }
        }
        return null;
    }

}
