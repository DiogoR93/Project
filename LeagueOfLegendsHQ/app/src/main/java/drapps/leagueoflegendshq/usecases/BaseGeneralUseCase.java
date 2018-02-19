package drapps.leagueoflegendshq.usecases;

import android.content.Context;

import drapps.leagueoflegendshq.base.BasePresenter;
import drapps.leagueoflegendshq.models.Service;

/**
 * Created by Diogo on 03/02/2018.
 */
public class BaseGeneralUseCase {
    protected Context context;
    protected Service serviceApi;
    protected BasePresenter presenter;

    public BaseGeneralUseCase(Context context, Service serviceApi, BasePresenter presenter) {
        this.context = context;
        this.serviceApi = serviceApi;
        this.presenter = presenter;
    }



}
