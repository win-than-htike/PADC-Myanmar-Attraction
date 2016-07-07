package xyz.winthanhtike.padc_myanmarattractions.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import xyz.winthanhtike.padc_myanmarattractions.MyanmarAttractionsApp;
import xyz.winthanhtike.padc_myanmarattractions.R;
import xyz.winthanhtike.padc_myanmarattractions.adapters.MMAttractionRVAdapter;
import xyz.winthanhtike.padc_myanmarattractions.data.models.MMAttractionModel;
import xyz.winthanhtike.padc_myanmarattractions.data.vos.MMAttractionVO;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private MMAttractionRVAdapter mPlaceAdapter;
    private PlaceItemController mPlaceItemController;

    public static MainActivityFragment newInstance(){
        return new MainActivityFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPlaceItemController = (PlaceItemController) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlaceAdapter = new MMAttractionRVAdapter(MMAttractionModel.getInstance().getPlaceList(),mPlaceItemController);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView rvPlace = (RecyclerView)view.findViewById(R.id.rv_mm_attraction);
        rvPlace.setLayoutManager(new LinearLayoutManager(MyanmarAttractionsApp.getContext()));
        rvPlace.setAdapter(mPlaceAdapter);

        return view;
    }

    public interface PlaceItemController {
        void onTapPlace(MMAttractionVO mmAttractionVO, ImageView placeImages);
    }

}
