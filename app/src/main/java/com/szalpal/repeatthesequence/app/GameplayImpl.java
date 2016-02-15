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
    private List<Integer> repeatSequence = new ArrayList();
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
        Integer check;
        check = sequence.get(buttonsPressed);
        if (buttonId == check)
            buttonsPressed++;
        else
            mGameplayListener.onError();

        if (sequence.size() == buttonsPressed) {
            Log.d(TAG, "Sequence completed!");
            mGameplayListener.onSequenceCompleted();
            buttonsPressed = 0;
            sequence.add(Integer.valueOf((int) (Math.random() * 4)));
            mGameplayListener.onNewSequence(sequence);

        }
//        if (buttonId == 2) {
//
//            sequence.add(Integer.valueOf((int) (Math.random() * 4)));
//            mGameplayListener.onNewSequence(sequence);
//        }
        //TODO
    }

    @Override
    public void startGame() {
        Log.d(TAG, "startGame()");
        sequence.add(Integer.valueOf((int) (Math.random() * 4)));
        mGameplayListener.onNewSequence(sequence);
        //TODO
    }

    @Override
    public void stopGame() {
        Log.d(TAG, "stopGame()");
        //TODO
    }

}
