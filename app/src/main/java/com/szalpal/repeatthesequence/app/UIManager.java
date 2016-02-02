package com.szalpal.repeatthesequence.app;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class UIManager implements Gameplay {

    private static final String TAG = MainActivity.TAG;

    private final Activity activity;

    private UiSignals signals;

    private Button A_Button, B_Button, C_Button, D_Button;
    private Button Start_Button;
    private int A_ButtonId = 1, B_ButtonId = 2, C_ButtonId = 3, D_ButtonId = 4, Start_ButtonId = 0;

    View.OnClickListener A_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Clicked A button");
//            signals.buttonPressed(A_ButtonId);
        }
    };

    View.OnClickListener B_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Clicked B button");
//            signals.buttonPressed(B_ButtonId);
        }
    };

    View.OnClickListener C_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Clicked C button");
//            signals.buttonPressed(C_ButtonId);
        }
    };

    View.OnClickListener D_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Clicked D button");
//            signals.buttonPressed(D_ButtonId);
        }
    };

    View.OnClickListener Start_ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Clicked Start button");
//            signals.startGame();
        }
    };

    public UIManager(Activity a) {
        activity = a;

        assignViews();
        registerListeners();
    }

    @Override
    public void onNewSequence() {

    }

    @Override
    public void onSequenceCompleted() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onStartGame() {

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
