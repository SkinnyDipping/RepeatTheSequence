package com.szalpal.repeatthesequence.app;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michal on 02.02.16.
 */
public class GameplayImpl implements Gameplay {

    private static final String TAG = MainActivity.TAG;

    private GameplayListener mGameplayListener = null;

    private List<Integer> sequence = new ArrayList<Integer>();

    public GameplayImpl() {
        Log.i(TAG, "GameplayImpl object created");
    }

    public void registerListener(GameplayListener gameplayListener) {
        Log.i(TAG, "GameplayImpl listener registered");
        mGameplayListener = gameplayListener;
    }

    @Override
    public void buttonPressed(int buttonId) {
        Log.d(TAG, "Button pressed ID:" + buttonId);
        if (buttonId == 2) {

            sequence.add(Integer.valueOf((int) (Math.random() * 4)));
            mGameplayListener.onNewSequence(sequence);
        }
        //TODO
    }

    @Override
    public void startGame() {
        Log.d(TAG, "startGame()");
        //TODO
    }

    @Override
    public void stopGame() {
        Log.d(TAG, "stopGame()");
        //TODO
    }

}
