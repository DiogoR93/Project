package drapps.leagueoflegendshq;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;

import drapps.leagueoflegendshq.base.BaseCustomFragment;
import drapps.leagueoflegendshq.models.realmobjects.Settings;
import io.realm.Realm;

/**
 * Created by diogo.rosa on 25/02/2018.
 */

public class SettingsFragment extends BaseCustomFragment {

    Switch switchCurrency;
    Realm realm = Realm.getDefaultInstance();
    RelativeLayout rlDonate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void bindViews(View view) {
        switchCurrency = view.findViewById(R.id.switch_currency);
        rlDonate = view.findViewById(R.id.rl_donate);

        if(realm.where(Settings.class).findFirst().getCurrency() == 1){
            switchCurrency.setChecked(true);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        switchCurrency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchCurrency.isChecked()){
                    realm.beginTransaction();
                    realm.delete(Settings.class);
                    realm.insertOrUpdate(new Settings(1)); //eur
                    realm.commitTransaction();
                }else{
                    realm.beginTransaction();
                    realm.delete(Settings.class);
                    realm.insertOrUpdate(new Settings(0)); //usd
                    realm.commitTransaction();
                }

            }
        });

        rlDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.donation_url)));
                startActivity(browserIntent);
            }
        });
    }
}
