package com.worknrole.sample.externallibraries.otto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.wornrole.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by worknrole on 09/02/17.
 *
 * Simple fragment sending an {@link FirstOttoEvent} to the Bus
 * and retrieving the {@link SecondOttoEvent} send by the
 * {@link SecondOttoFragment}
 */

public class FirstOttoFragment extends Fragment {

    /**
     * The number of message sent to the event bus
     * Make it static just to test the produce annotation
     */
    private static int mNbMessage = 0;

    /**
     * The button used to send an event to the bus
     */
    @BindView(R.id.first_otto_btn) Button mBtn;

    /**
     * A TextView used to display the event message
     */
    @BindView(R.id.first_otto_event_message) TextView mMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.otto_first_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Get the unique instance of the event bus
        // Then register to it to receive events
        OttoBus.get().getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Don't forget to unregister
        OttoBus.get().getBus().unregister(this);
    }

    @OnClick(R.id.first_otto_btn)
    public void sendMessage() {
        mNbMessage++;
        // Send the right event using Bus.post() method
        OttoBus.get().getBus().post(createEvent());
    }

    /**
     * This method is called when an event occurs
     *
     * Thhis method name has no importance. You just need annotate your method
     * with @Subscribe and set in parameter the  event you want to retrieve.
     * For example here, the {@link SecondOttoEvent}
     *
     * @param event The event to retrieved
     */
    @Subscribe
    public void onReceiveEvent(SecondOttoEvent event) {
        String message = event.getMessage();
        mMessage.setText(message);
    }

    /**
     * Return an instance of the {@link FirstOttoEvent}
     *
     * The produce annotation is used to retrieve the last message sent without
     * clicking to the button.
     * In our case, if you close the {@link OttoActivity} then come back, the
     * last {@link FirstOttoEvent} will be re-sent automatically
     *
     * @return an instance of the {@link FirstOttoEvent}
     */
    @Produce
    public FirstOttoEvent createEvent() {
        return new FirstOttoEvent(mNbMessage);
    }
}
