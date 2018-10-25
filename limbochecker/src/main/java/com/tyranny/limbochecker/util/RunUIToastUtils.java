package com.tyranny.limbochecker.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Tyranny on 2017/10/10 9:13.
 *
 * @version 1.0.0
 */

public class RunUIToastUtils {
    private RunUIToastUtils() {
    }

    private static Toast toast;
    private static final String MAIN_THREAD_NAME = "main";

    public static void setToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    @SuppressLint ("ShowToast")
    private static void showToast(Context context, String msg, int lengthShort) {
        if (!TextUtils.isEmpty(msg)) {
            String threadName = Thread.currentThread().getName();
            boolean isMainThread = MAIN_THREAD_NAME.endsWith(threadName);
            if (isMainThread) {
                if (toast == null) {
                    toast = Toast.makeText(context, msg, lengthShort);
                } else {
                    toast.setText(msg);
                }
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
            if (!isMainThread) {
                Looper.prepare();
                Toast text = Toast.makeText(context, msg, lengthShort);
                text.setGravity(Gravity.CENTER, 0, 0);
                text.show();
                Looper.loop();
            }
        }
    }

    public static void setToast(Context context, @StringRes int resStrId) {
        String res = context.getString(resStrId);
        setToast(context, res);
    }

    public static void setToastFormInt(Context context, int value) {
        String res = String.valueOf(value);
        setToast(context, res);
    }

    public static void setToastFormLong(Context context, long value) {
        String res = String.valueOf(value);
        setToast(context, res);
    }

    public static void setToastFormDouble(Context context, double value) {
        String res = String.valueOf(value);
        setToast(context, res);
    }

    public static void setToastFormFloat(Context context, float value) {
        String res = String.valueOf(value);
        setToast(context, res);
    }

    public static void setToastFormBoolean(Context context, boolean value) {
        String res = String.valueOf(value);
        setToast(context, res);
    }

}
