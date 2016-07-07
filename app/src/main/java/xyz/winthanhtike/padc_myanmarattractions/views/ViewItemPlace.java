package xyz.winthanhtike.padc_myanmarattractions.views;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.winthanhtike.padc_myanmarattractions.R;
import xyz.winthanhtike.padc_myanmarattractions.data.vos.MMAttractionVO;

/**
 * Created by winthanhtike on 7/6/16.
 */
public class ViewItemPlace extends CardView {

    private TextView tvPlaceTitle;
    private ImageView ivPlaceImage;

    public ViewItemPlace(Context context) {
        super(context);
    }

    public ViewItemPlace(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewItemPlace(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvPlaceTitle = (TextView)findViewById(R.id.tv_place_title);
        ivPlaceImage = (ImageView)findViewById(R.id.iv_place_photo);
    }

    public void setData(MMAttractionVO mmAttractionVO){

        tvPlaceTitle.setText(mmAttractionVO.getPlaceTitle());
        Glide.with(ivPlaceImage.getContext())
                .load(mmAttractionVO.getPlaceImages())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(ivPlaceImage);
    }
}
