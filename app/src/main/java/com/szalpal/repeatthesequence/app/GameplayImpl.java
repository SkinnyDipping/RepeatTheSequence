package com.szalpal.repeatthesequence.app;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GameplayImpl implements Gameplay {

    private static final String TAG = MainActivity.TAG;

    private GameplayListener mGameplayListener = null;

    private List<Integer> sequence = new ArrayList<Integer>();
    private int buttonsPressed = 0;

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
        int check = sequence.get(buttonsPressed++);
        if (buttonId != check)
            mGameplayListener.onError();

        if (sequence.size() == buttonsPressed) {
            Log.d(TAG, "Sequence completed!");
            mGameplayListener.onSequenceCompleted();
            buttonsPressed = 0;
            sequence.add((int) (Math.random() * 4));
            mGameplayListener.onNewSequence(sequence);
        }
    }

    @Override
    public void startGame() {
        Log.d(TAG, "startGame()");
        sequence.add((int) (Math.random() * 4));
        mGameplayListener.onNewSequence(sequence);
    }

    @Override
    public void stopGame() {
        Log.d(TAG, "stopGame()");
        //TODO
    }

}
