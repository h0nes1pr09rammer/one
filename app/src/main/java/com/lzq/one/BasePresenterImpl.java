package com.lzq.one;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by CTWLPC on 2017/10/20.
 */

public class BasePresenterImpl implements BasePresenter{


    protected CompositeSubscription mCompositeSubscription;

    public void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

}
