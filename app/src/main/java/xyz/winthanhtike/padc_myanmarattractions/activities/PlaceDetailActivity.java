package xyz.winthanhtike.padc_myanmarattractions.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;

import xyz.winthanhtike.padc_myanmarattractions.MyanmarAttractionsApp;
import xyz.winthanhtike.padc_myanmarattractions.R;
import xyz.winthanhtike.padc_myanmarattractions.data.models.MMAttractionModel;
import xyz.winthanhtike.padc_myanmarattractions.data.vos.MMAttractionVO;

public class PlaceDetailActivity extends AppCompatActivity {

    private static final String IE_PLACE_TITLE = "IE_PLACE_TITLE";
    public static final String IMAGE_URL = "http://www.aungpyaephyo.xyz/myanmar_attractions/";

    private ImageView ivPlacePhoto;
    private TextView tvPlaceDesc;
    private CollapsingToolbarLayout collapsingToolbarLayout;


    public static Intent newIntent(String placeTitle){
        Intent intent = new Intent(MyanmarAttractionsApp.getContext(),PlaceDetailActivity.class);
        intent.putExtra(IE_PLACE_TITLE,placeTitle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivPlacePhoto = (ImageView)findViewById(R.id.iv_detail_place_photo);
        tvPlaceDesc = (TextView)findViewById(R.id.tv_detail_desc);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        }

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);

        String placeTitle = getIntent().getStringExtra(IE_PLACE_TITLE);

        final MMAttractionVO mmAttractionVO = MMAttractionModel.getInstance().getPlaceByTitle(placeTitle);

        if (mmAttractionVO == null){
            throw new RuntimeException("Can't find Place obj with the title : " + placeTitle);
        }else {
            collapsingToolbarLayout.setTitle(mmAttractionVO.getPlaceTitle());
            tvPlaceDesc.setText(mmAttractionVO.getPlaceDesc());

            Glide.with(ivPlacePhoto.getContext())
                    .load(IMAGE_URL+ mmAttractionVO.getPlaceImages()[0])
                    .placeholder(R.drawable.wallp)
                    .error(R.mipmap.ic_launcher)
                    .into(ivPlacePhoto);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //share image
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, IMAGE_URL+mmAttractionVO.getPlaceImages()[0]);
                startActivity(Intent.createChooser(shareIntent, "Share link using"));
            }
        });
    }

}
