package com.worknrole.sample.externallibraries.otto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Subscribe;
import com.wornrole.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by worknrole on 09/02/17.
 *
 * Simple fragment sending an {@link SecondOttoEvent} to
 * the Bus and retrieving the {@link FirstOttoEvent} send
 * by the {@link FirstOttoFragment}
 */

public class SecondOttoFragment extends Fragment {

    /**
     * The number of message sent to the event bus
     */
    private int mNbMessage = 0;

    /**
     * The button used to send an event to the bus
     */
    @BindView(R.id.second_otto_btn) Button mBtn;

    /**
     * A TextView used to display the event message
     */
    @BindView(R.id.second_otto_event_message) TextView mMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.otto_second_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        OttoBus.get().getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        OttoBus.get().getBus().unregister(this);
    }

    @OnClick(R.id.second_otto_btn)
    public void sendMessage() {
        mNbMessage++;
        // Send the right event using Bus.post() method
        OttoBus.get().getBus().post(new SecondOttoEvent(mNbMessage));
    }

    /**
     * This method is called when an event occurs
     *
     * Thhis method name has no importance. You just need annotate your method
     * with @Subscribe and set in parameter the  event you want to retrieve.
     * For example here, the {@link FirstOttoEvent}
     *
     * @param event The event to retrieved
     */
    @Subscribe
    public void onReceiveEvent(FirstOttoEvent event) {
        String message = event.getMessage();
        mMessage.setText(message);
    }
}
