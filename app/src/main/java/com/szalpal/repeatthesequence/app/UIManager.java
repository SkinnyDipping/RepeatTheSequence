package com.szalpal.repeatthesequence.app;

import android.content.Context;
import android.widget.Button;

/**
 * Created by michal on 01.02.16.
 */
public class UIManager {

    private static final String TAG = MainActivity.TAG;

    private final Context mContext;

    private Button A_Button, B_Button, C_Button, D_Button;
    private Button Start_Button;

    public UIManager(Context c) {
        mContext=c;
    }
}
