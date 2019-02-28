package com.tencent.mm.compatible.e;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.sdk.platformtools.ad;

public final class w {
    private static w gIr = null;

    public static int zc() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 7:
            case 11:
                return 2;
            case 3:
            case 4:
            case 5:
            case 6:
            case 12:
            case 17:
                return 3;
            case 13:
            case 14:
            case 15:
                return 4;
            default:
                return 0;
        }
    }
}
