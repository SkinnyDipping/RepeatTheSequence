package com.szalpal.repeatthesequence.app;

/**
 * Created by michal on 01.02.16.
 */
public interface IGameplay {

    void onNewSequence();

    void onSequenceCompleted();

    void onError();

    void onStartGame();

    boolean startGame();

    void buttonPressed(int buttonID);
}
