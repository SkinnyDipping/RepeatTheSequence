package com.szalpal.repeatthesequence.app;

import java.util.List;

/**
 * Created by michal on 01.02.16.
 */
public interface GameplayListener {

    void onNewSequence(List<Integer> newSequence);

    void onSequenceCompleted();

    void onError();
}
