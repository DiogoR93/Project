package drapps.leagueoflegendshq.coinlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import drapps.leagueoflegendshq.R;
import drapps.leagueoflegendshq.base.BaseCustomActivity;
import drapps.leagueoflegendshq.models.CoinCapSingleCoinResponse;
import drapps.leagueoflegendshq.models.GraphDataResponse;
import drapps.leagueoflegendshq.models.realmobjects.Settings;
import io.realm.Realm;

/**
 * Created by diogo.rosa on 25/02/2018.
 */

public class CoinDetailActivity extends BaseCustomActivity implements ContractCoinDetail.View{

    CoinDetailPresenter presenter;
    private LineChart lineChartPrice;
    private CardView cvPriceChart;
    private RoundCornerProgressBar pbMarket;
    private List<Entry> entries = new ArrayList<>();
    List<Long> listTimeMillisPrice = new ArrayList<>();
    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    TextView tvTitle;
    TextView tvMarketCap;
    TextView tvMaxMarketCap;
    TextView tvMarketCapPercentage;
    TextView tvCoinSymbol;
    TextView tvPrice;
    TextView tvGraphContent;
    TextView tvVolume;
    ImageView ivLeft;
    ImageView ivRight;
    ImageView ivCoin;
    int requestGraphCode = 0;
    GraphDataResponse response;
    String coinName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_detail);
        coinName = getIntent().getStringExtra("coin");
        bindViews();
        setupPresenter();
        setupListeners();
    }

    private void setupListeners() {
        ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(requestGraphCode > 0){
                    requestGraphCode--;
                    onLoadedCoinCapGraphData(response);
                }else{
                    requestGraphCode = 2;
                    onLoadedCoinCapGraphData(response);
                }
            }
        });
        ivRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(requestGraphCode < 2){
                    requestGraphCode++;
                    onLoadedCoinCapGraphData(response);
                }else{
                    requestGraphCode = 0;
                    onLoadedCoinCapGraphData(response);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadCoinGraphData(coinName);
        presenter.loadCointInfo(coinName);

        try {
            Glide.with(this).load(getResources().getIdentifier(coinName.toLowerCase(), "drawable", getPackageName())).apply(RequestOptions.fitCenterTransform()).into(ivCoin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvCoinSymbol.setText(coinName.toUpperCase());
        tvTitle.setText(coinName.toUpperCase());
    }

    @Override
    public void bindViews() {
        lineChartPrice = findViewById(R.id.chart_price);
        cvPriceChart = findViewById(R.id.cv_price_graph);
        tvTitle = findViewById(R.id.txt_page_title);
        ivLeft = findViewById(R.id.arrow_back);
        ivRight = findViewById(R.id.arrow_right);
        pbMarket = findViewById(R.id.pb_supply);
        tvMarketCap = findViewById(R.id.txt_supply_progress);
        tvMaxMarketCap = findViewById(R.id.txt_supply_max);
        tvMarketCapPercentage = findViewById(R.id.txt_market_cap_percentage);
        ivCoin = findViewById(R.id.iv_coin);
        tvCoinSymbol = findViewById(R.id.txt_coin_symbol);
        tvPrice = findViewById(R.id.txt_coin_price);
        tvGraphContent = findViewById(R.id.txt_graph_content);
        tvVolume = findViewById(R.id.txt_volume);
    }

    @Override
    public void setupPresenter() {
        presenter = new CoinDetailPresenter(this);
        presenter.attach(this);
    }

    @Override
    public void onLoadedCoinCapInfo(CoinCapSingleCoinResponse response) {
        String marketCap;
        String totalCap;
        if(response.getMarketCap() > 1000000){
            marketCap = String.valueOf((long)response.getMarketCap() / 1000000) + "M";
        }else{
            marketCap = String.valueOf((long) response.getMarketCap());
        }
        if(response.getMarketCap() > 1000000){
            totalCap = String.valueOf((long)response.getTotalCap() / 1000000) + "M";
        }else{
            totalCap = String.valueOf((long) response.getTotalCap());
        }
        tvMarketCap.setText(marketCap);
        tvMaxMarketCap.setText(totalCap);
        pbMarket.setMax(response.getTotalCap());
        pbMarket.setProgress(response.getMarketCap());
        tvMarketCapPercentage.setText(String.format("%.1f",(response.getMarketCap()/response.getTotalCap())*100) + "%");
        String format =  "%.4f";
        if(Realm.getDefaultInstance().where(Settings.class).findFirst().getCurrency() == 0){
            if(response.getPriceUSD() > 0){
                format = "%.2f";
            }else if(response.getPriceUSD() > 10){
                format = "%.1f";
            }
            tvPrice.setText(String.format(format, response.getPriceUSD()) + "$");
        }else{
            tvPrice.setText(String.format(format, response.getPriceEUR()) + "€");
        }

        if(response.getVolume() > 1000000){
            tvVolume.setText(String.valueOf(response.getVolume()/1000000)+"M");
        }

    }

    @Override
    public void onLoadedCoinCapGraphData(GraphDataResponse response) {
        entries.clear();
        this.response = response;
        int index = 0;
        int axisXindex = 0;
        List<double[]> data;
        if(requestGraphCode == 0){
            data = response.getPrice();
            tvGraphContent.setText(getString(R.string.price).toUpperCase());
        }else if(requestGraphCode == 1){
            data = response.getMarketCap();
            tvGraphContent.setText(getString(R.string.market_cap).toUpperCase());
        }else{
            data = response.getVolume();
            tvGraphContent.setText(getString(R.string.volume).toUpperCase());
        }

        for(double[] d : data){
            if(index > data.size()-20) {
                listTimeMillisPrice.add((long) d[0]);
                entries.add(new Entry((float) axisXindex, (float) d[1]));
                axisXindex++;
            }
            index++;
        }
        LineDataSet set1 = new LineDataSet(entries, "prices");


        if(requestGraphCode == 0){
            set1.setColor(ContextCompat.getColor(this, R.color.positive_green));
            set1.setCircleColor(ContextCompat.getColor(this, R.color.positive_green));
            set1.setFillColor(ContextCompat.getColor(this, R.color.positive_green));
        }else if(requestGraphCode == 1){
            set1.setColor(ContextCompat.getColor(this, R.color.graph_marketcap_color));
            set1.setCircleColor(ContextCompat.getColor(this, R.color.graph_marketcap_color));
            set1.setFillColor(ContextCompat.getColor(this, R.color.graph_marketcap_color));
        }else{
            set1.setColor(ContextCompat.getColor(this, R.color.graph_volume_color));
            set1.setCircleColor(ContextCompat.getColor(this, R.color.graph_volume_color));
            set1.setFillColor(ContextCompat.getColor(this, R.color.graph_volume_color));
        }
        set1.setLineWidth(1f);
        set1.setCircleSize(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(20f);
        set1.setDrawFilled(true);
        set1.setDrawValues(false);


        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1);
        //lineChartPrice.getXAxis().setGranularity(5f);
        lineChartPrice.getAxisRight().setEnabled(false);
        lineChartPrice.getXAxis().setGridColor(ContextCompat.getColor(this, R.color.grid_light_grey));
        lineChartPrice.getAxisLeft().setGridColor(ContextCompat.getColor(this, R.color.grid_light_grey));
        lineChartPrice.setPinchZoom(true);
        lineChartPrice.setDoubleTapToZoomEnabled(true);
        lineChartPrice.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Date date = new Date(listTimeMillisPrice.get((int)value));
                return format.format(date);
            }
        });
        lineChartPrice.getAxisLeft().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if(value > 1000000){
                    return String.valueOf(value/1000000)+"M";
                }
                return String.valueOf(value);
            }
        });
        LineData lineData = new LineData(dataSets);
        lineChartPrice.setData(lineData);
        lineChartPrice.invalidate();
        cvPriceChart.setVisibility(View.VISIBLE);

    }
}