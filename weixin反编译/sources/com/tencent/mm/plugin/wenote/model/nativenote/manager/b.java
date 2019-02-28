package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class b {
    private static float tYX = Float.MAX_VALUE;
    private static float tYY = Float.MAX_VALUE;
    private static int tYZ = -1;
    public static float tZa = 48.0f;

    private static float bWZ() {
        float f;
        synchronized (b.class) {
            if (tYX == Float.MAX_VALUE) {
                tYX = getDisplayMetrics().density;
            }
            f = tYX;
        }
        return f;
    }

    public static float getTextSize() {
        return tZa;
    }

    public static void setTextSize(float f) {
        tZa = f;
    }

    public static int BJ(int i) {
        return Math.round(((float) i) * bXa());
    }

    public static int BK(int i) {
        return Math.round(((float) i) / bXa());
    }

    private static DisplayMetrics getDisplayMetrics() {
        Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    private static float bXa() {
        float f;
        synchronized (b.class) {
            if (tYY == Float.MAX_VALUE) {
                tYY = getDisplayMetrics().density * ad.getContext().getResources().getConfiguration().fontScale;
            }
            f = tYY;
        }
        return f;
    }

    public static int bXb() {
        if (tYZ == -1) {
            tYZ = Math.round(bWZ() * 30.0f);
        }
        return tYZ;
    }
}
