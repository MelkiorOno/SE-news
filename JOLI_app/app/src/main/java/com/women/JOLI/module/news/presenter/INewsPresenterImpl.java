package com.women.JOLI.module.news.presenter;

import com.women.JOLI.base.BasePresenterImpl;
import com.women.JOLI.greendao.NewsChannelTable;
import com.women.JOLI.module.news.model.INewsInteractor;
import com.women.JOLI.module.news.model.INewsInteractorImpl;
import com.women.JOLI.module.news.view.INewsView;

import java.util.List;

/**
 * ClassName: INewsPresenterImpl<p>
 * Author: oubowu<p>
 * Fuction: 新闻代理接口实现<p>
 * CreateDate: 2016/2/17 21:04<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class INewsPresenterImpl extends BasePresenterImpl<INewsView, List<NewsChannelTable>>
        implements INewsPresenter {

    private INewsInteractor<List<NewsChannelTable>> mNewsInteractor;

    public INewsPresenterImpl(INewsView newsView) {
        super(newsView);
        mNewsInteractor = new INewsInteractorImpl();
        mSubscription = mNewsInteractor.operateChannelDb(this);
        mView.initRxBusEvent();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void requestSuccess(List<NewsChannelTable> data) {
        mView.initViewPager(data);
    }

    @Override
    public void operateChannelDb() {
        mSubscription = mNewsInteractor.operateChannelDb(this);
    }
}
