package com.worknrole.sample.externallibraries.otto;

/**
 * Created by worknrole on 09/02/17.
 *
 * The event used by the {@link SecondOttoFragment} to the bus
 * then received by the {@link FirstOttoFragment}
 */

public class SecondOttoEvent {

    /**
     * The number of message sent
     */
    private int mNbMessageSend;

    /**
     * A simple constructor setting the number of message sent
     * @param nbMessage the number of message sent
     */
    public SecondOttoEvent(int nbMessage) {
        mNbMessageSend = nbMessage;
    }

    /**
     * A custom message sent by the sender
     * @return A custom message
     */
    public String getMessage() {
        return "Hello from SecondOttoFragment ! <3 (" + mNbMessageSend + ")";
    }
}
