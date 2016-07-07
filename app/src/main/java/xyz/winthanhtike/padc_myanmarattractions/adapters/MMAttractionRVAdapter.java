package xyz.winthanhtike.padc_myanmarattractions.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.winthanhtike.padc_myanmarattractions.MyanmarAttractionsApp;
import xyz.winthanhtike.padc_myanmarattractions.R;
import xyz.winthanhtike.padc_myanmarattractions.data.vos.MMAttractionVO;
import xyz.winthanhtike.padc_myanmarattractions.fragments.MainActivityFragment;
import xyz.winthanhtike.padc_myanmarattractions.views.AttractionViewHolder;

/**
 * Created by winthanhtike on 7/6/16.
 */
public class MMAttractionRVAdapter extends RecyclerView.Adapter<AttractionViewHolder> {

    private LayoutInflater inflater;
    private List<MMAttractionVO> placeList;
    private MainActivityFragment.PlaceItemController mPlaceItemController;

    public MMAttractionRVAdapter(List<MMAttractionVO> placeList, MainActivityFragment.PlaceItemController mPlaceItemController) {
        this.placeList = placeList;
        this.mPlaceItemController = mPlaceItemController;
        inflater = LayoutInflater.from(MyanmarAttractionsApp.getContext());
    }

    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.place_card_item,parent,false);
        return new AttractionViewHolder(view,mPlaceItemController);
    }

    @Override
    public void onBindViewHolder(AttractionViewHolder holder, int position) {
        holder.setData(placeList.get(position));
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }
}
