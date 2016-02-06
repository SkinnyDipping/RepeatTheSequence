package com.szalpal.repeatthesequence.app;

import android.util.Log;

/**
 * Created by michal on 06.02.16.
 */
public interface Gameplay {

    void buttonPressed(int buttonId);

    void startGame();

    void stopGame();
}
