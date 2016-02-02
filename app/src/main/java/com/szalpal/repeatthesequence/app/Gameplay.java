package com.szalpal.repeatthesequence.app;

/**
 * Created by michal on 01.02.16.
 */
public interface Gameplay {

    void onNewSequence();

    void onSequenceCompleted();

    void onError();

    void onStartGame();
}
