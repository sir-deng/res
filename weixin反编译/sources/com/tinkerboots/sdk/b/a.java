package com.tinkerboots.sdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class a {
    private static ConnectivityManager ADH = null;

    public static boolean isConnected(Context context) {
        if (ADH == null) {
            ADH = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (ADH == null) {
            return false;
        }
        boolean z;
        NetworkInfo activeNetworkInfo = ADH.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            try {
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                    return z;
                }
            } catch (Exception e) {
                return false;
            }
        }
        z = false;
        return z;
    }

    public static boolean isWifi(Context context) {
        if (ADH == null) {
            ADH = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (ADH == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ADH.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}
