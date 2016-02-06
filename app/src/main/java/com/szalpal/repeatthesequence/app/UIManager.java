package com.szalpal.repeatthesequence.app;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class UIManager implements GameplayListener {

    private static final String TAG = MainActivity.TAG;

    private static final int BUTTONS_NUMBER = 4;

    private final Activity activity;
    private Gameplay mGameplay;

    private Button A_Button, B_Button, C_Button, D_Button;
    private Button Start_Button;
    private int A_ButtonId = 0, B_ButtonId = 1, C_ButtonId = 2, D_ButtonId = 3, Start_ButtonId = 0;
    private Button[] mButtons = new Button[BUTTONS_NUMBER];

    private int mCurrScore, mMaxScore;
    private int mBlinkDuration = 1000;
    private int mBetweenBlinksDuration = 1000;
    private boolean mLockGame = false;


    View.OnClickListener A_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Clicked A button");
//            mGameplay.buttonPressed(A_ButtonId);
        }
    };

    View.OnClickListener B_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mLockGame) return;
            Log.d(TAG, "Clicked B button");
//            mGameplay.buttonPressed(B_ButtonId);
        }
    };

    View.OnClickListener C_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mLockGame) return;
            Log.d(TAG, "Clicked C button");
//            mGameplay.buttonPressed(C_ButtonId);
        }
    };

    View.OnClickListener D_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mLockGame) return;
            Log.d(TAG, "Clicked D button");
//            mGameplay.buttonPressed(D_ButtonId);
        }
    };

    View.OnClickListener Start_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Clicked Start button");
//            mGameplay.startGame();
        }
    };

    public UIManager(Activity a, Gameplay gameplay) {
        activity = a;
        mGameplay = gameplay;

        assignViews();
        registerListeners();
        createButtonArray();
    }

    /**
     * TODO
     * Zmniejszanie durationów
     *
     * @param newSequence
     */
    @Override
    public void onNewSequence(List<Integer> newSequence) {
        Log.d(TAG, "onNewSequence");
        mLockGame = true;
        for (Integer i : newSequence) {
            blinkButton(i, mBlinkDuration);
            try {
                synchronized (this) {
                    wait(mBetweenBlinksDuration);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mLockGame = false;
    }

    @Override
    public void onSequenceCompleted() {
        Log.d(TAG, "onSequenceComppletesd");
        setCurrScore(++mCurrScore);
    }

    @Override
    public void onError() {
        Log.d(TAG, "onError");
        lockGame(true);
//        if (mCurrScore > mMaxScore) {
//            mMaxScore = mCurrScore;
//            setMaxScore(mMaxScore);
//        }
    }

    /**
     * TODO
     *
     * @param buttonId
     * @param duration ms
     */
    private void blinkButton(int buttonId, final int duration) {
        final Button button = mButtons[buttonId];

        Runnable blinkButtonRunnable = new Runnable() {
            @Override
            public void run() {
                button.setPressed(true);
                button.invalidate();
                button.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setPressed(false);
                        button.invalidate();
                    }
                }, duration);
                synchronized (this) {
                    this.notify();
                }
            }
        };

        synchronized (blinkButtonRunnable) {
            activity.runOnUiThread(blinkButtonRunnable);
            try {
                blinkButtonRunnable.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void assignViews() {
        A_Button = (Button) activity.findViewById(R.id.button_A);
        B_Button = (Button) activity.findViewById(R.id.button_B);
        C_Button = (Button) activity.findViewById(R.id.button_C);
        D_Button = (Button) activity.findViewById(R.id.button_D);
        // TODO start button
    }

    private void registerListeners() {
        A_Button.setOnClickListener(A_ButtonListener);
        B_Button.setOnClickListener(B_ButtonListener);
        C_Button.setOnClickListener(C_ButtonListener);
        D_Button.setOnClickListener(D_ButtonListener);
        // TODO start button
    }

    private void createButtonArray() {
        mButtons[A_ButtonId] = A_Button;
        mButtons[B_ButtonId] = B_Button;
        mButtons[C_ButtonId] = C_Button;
        mButtons[D_ButtonId] = D_Button;
    }

    private void setMaxScore(final int score) {
        Runnable setMaxScoreRunnable = new Runnable() {
            @Override
            public void run() {
                TextView maxScore = (TextView) activity.findViewById(R.id.maxScore_value);
                maxScore.setText("" + score);
                synchronized (this) {
                    this.notify();
                }
            }
        };

        synchronized (setMaxScoreRunnable) {
            activity.runOnUiThread(setMaxScoreRunnable);
            try {
                setMaxScoreRunnable.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setCurrScore(final int score) {
        Runnable setCurrScoreRunnable = new Runnable() {
            @Override
            public void run() {
                TextView scoreTxt = (TextView) activity.findViewById(R.id.currScore_value);
                scoreTxt.setText("" + score);
                synchronized (this) {
                    this.notify();
                }
            }
        };

        synchronized (setCurrScoreRunnable) {
            activity.runOnUiThread(setCurrScoreRunnable);
            try {
                setCurrScoreRunnable.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void lockGame(boolean lock) {
        mLockGame = lock;
        for (Button b : mButtons) {
            b.setClickable(!mLockGame);
        }
    }

}
