package com.szalpal.repeatthesequence.app;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class UIManager implements GameplayListener {

    private static final String TAG = MainActivity.TAG;

    private final Activity activity;
    private Gameplay mGameplay;

    private Button A_Button, B_Button, C_Button, D_Button;
    private Button Start_Button;
    private int A_ButtonId = 1, B_ButtonId = 2, C_ButtonId = 3, D_ButtonId = 4, Start_ButtonId = 0;

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
            Log.d(TAG, "Clicked B button");
//            mGameplay.buttonPressed(B_ButtonId);
        }
    };

    View.OnClickListener C_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Clicked C button");
//            mGameplay.buttonPressed(C_ButtonId);
        }
    };

    View.OnClickListener D_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
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
    }

    @Override
    public void onNewSequence(List<Integer> newSequence) {

    }

    @Override
    public void onSequenceCompleted() {

    }

    @Override
    public void onError() {

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
}
