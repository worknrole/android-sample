package com.worknrole.sample.externallibraries.butterknife;

import android.content.Context;
import android.support.percent.PercentRelativeLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.worknrole.sample.framework.presenter.BKCustomInterface.ViewBridge;
import com.worknrole.sample.framework.presenter.BKCustomPresenter;
import com.wornrole.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;

/**
 * Created by worknrole on 26/01/17.
 *
 * A sample about ButterKnife, the binding library
 * See <a href="http://jakewharton.github.io/butterknife/">http://jakewharton.github.io</a>
 */

public class BKCustomView extends PercentRelativeLayout implements ViewBridge {

    //region Properties
    /**
     * The view title
     */
    @BindView(R.id.title) TextView mTitle;

    /**
     * The gyphy image to display
     */
    @BindView(R.id.image) ImageView mImage;

    /**
     * The search terms field
     */
    @BindView(R.id.searchTerms) EditText mTerms;

    /**
     * The button launching the request
     */
    @BindView(R.id.searchBtn) Button mSearchBtn;

    /**
     * The presenter managing the update
     */
    private BKCustomPresenter mBKCustomPresenter;
    //endregion

    //region Constructor
    public BKCustomView(Context context) {
        super(context);
    }

    public BKCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BKCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //endregion

    //region Lifecycle
    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        mBKCustomPresenter = new BKCustomPresenter(this);
    }
    //endregion

    //region update methods

    /**
     * The method called after a click on the keyboard action done
     * @param v The view used to edit the corresponding text
     * @param actionId The type of action launched
     * @param event The type of key event
     * @return  true of the event has been handled
     */
    @OnEditorAction(R.id.searchTerms)
    public boolean updateOnActionDone(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            updateOnClick();
            return true;
        }
        return false;
    }

    /**
     * The method called after a click on the search button
     */
    @OnClick(R.id.searchBtn)
    public void updateOnClick() {
        final String terms = mTerms.getText().toString();
        mBKCustomPresenter.searchImage(terms);
    }

    @Override
    public void updateImage(String url) {
        if(!TextUtils.isEmpty(url)) {
            Picasso.with(getContext())
                    .load(url)
                    .into(mImage);
        }
    }
    //endregion
}
