package drapps.cryptoheadquarters.news;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tappx.sdk.android.TappxBanner;

import drapps.cryptoheadquarters.R;
import drapps.cryptoheadquarters.base.BaseCustomActivity;

/**
 * Created by diogo.rosa on 24/02/2018.
 */

public class NewsDetailActivity extends BaseCustomActivity{

    TextView tvTitle;
    TextView tvDescritpion;
    TextView tvUrl;
    ImageView ivHeader;
    ImageView ivBackArrow;
    TappxBanner banner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        bindViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getIntent().getExtras() != null){
            tvTitle.setText(getIntent().getStringExtra("title"));
            tvDescritpion.setText(getIntent().getStringExtra("description"));
            try{
                Glide.with(this).load(getIntent().getStringExtra("imageUrl")).apply(RequestOptions.centerCropTransform()).into(ivHeader);
            }catch (Exception e){
                e.printStackTrace();
            }
            tvUrl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getIntent().getStringExtra("url")));
                    startActivity(browserIntent);
                }
            });

        }

        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        banner.setAdSize(TappxBanner.AdSize.SMART_BANNER);

    }

    @Override
    public void bindViews() {
        ivHeader = findViewById(R.id.iv_news_header);
        tvDescritpion = findViewById(R.id.txt_news_description);
        tvTitle = findViewById(R.id.txt_news_title);
        tvUrl = findViewById(R.id.txt_news_url);
        ivBackArrow = findViewById(R.id.arrow_back);
        banner = findViewById(R.id.tappx_banner);


    }
}
