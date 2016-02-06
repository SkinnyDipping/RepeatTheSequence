package com.szalpal.repeatthesequence.app;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * FOR DEV ONLY.
 * Delete when GameplayImpl has been implemented
 */
public class GameplayDev implements Gameplay {

    private static final String TAG = MainActivity.TAG;
    private GameplayListener mGameplayListener = null;

    List<Integer> newSeq = new ArrayList<Integer>();

    Timer mTimer;

    TimerTask newSequenceTask = new TimerTask() {
        @Override
        public void run() {
            Log.d(TAG, "new sequence task");
            if (mGameplayListener != null)
                mGameplayListener.onNewSequence(newSeq);
        }
    };

    TimerTask errorTask = new TimerTask() {
        @Override
        public void run() {
            Log.d(TAG, "error task");
            if (mGameplayListener != null)
                mGameplayListener.onError();
        }
    };

    TimerTask sequenceCompletedTask = new TimerTask() {
        @Override
        public void run() {
            Log.d(TAG, "seq cmpl task");
            if (mGameplayListener != null)
                mGameplayListener.onSequenceCompleted();
        }
    };

    public GameplayDev() {

        newSeq.add(2);
        newSeq.add(0);

        mTimer = new Timer();
        mTimer.scheduleAtFixedRate(newSequenceTask, 1000, 15000);
        mTimer.scheduleAtFixedRate(sequenceCompletedTask, 6000, 15000);
        mTimer.scheduleAtFixedRate(errorTask, 11000, 15000);
    }

    public void registerListener(GameplayListener gameplayListener) {
        Log.i(TAG, "GameplayImpl listener registered");
        mGameplayListener = gameplayListener;
    }

    @Override
    public void buttonPressed(int buttonId) {

    }

    @Override
    public void startGame() {

    }

    @Override
    public void stopGame() {

    }
}
