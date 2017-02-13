package com.worknrole.sample.externallibraries.otto;

/**
 * Created by worknrole on 09/02/17.
 *
 * The event used by the {@link FirstOttoFragment} to the bus
 * then received by the {@link SecondOttoFragment}
 */
public class FirstOttoEvent {

    /**
     * The number of message sent
     */
    private int mNbMessageSend;

    /**
     * A simple constructor setting the number of message sent
     * @param nbMessage the number of message sent
     */
    public FirstOttoEvent(int nbMessage) {
        mNbMessageSend = nbMessage;
    }

    /**
     * A custom message sent by the sender
     * @return A custom message
     */
    public String getMessage() {
        return "Hi from FirstOttoFragment. (" + mNbMessageSend + ")";
    }
}
