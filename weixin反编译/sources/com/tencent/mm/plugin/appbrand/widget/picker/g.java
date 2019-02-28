package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.mm.sdk.platformtools.bi;

public final class g {
    public static boolean mF(int i) {
        return i >= 0 && i <= 59;
    }

    public static boolean mG(int i) {
        return i >= 0 && i <= 23;
    }

    public static int[] vL(String str) {
        if (bi.oN(str)) {
            return null;
        }
        String[] split = str.split(":");
        if (split == null || split.length != 2) {
            return null;
        }
        int vM = vM(split[0]);
        int vM2 = vM(split[1]);
        if (!mG(vM) || !mF(vM2)) {
            return null;
        }
        return new int[]{vM, vM2};
    }

    private static int vM(String str) {
        try {
            return Integer.parseInt(str, 10);
        } catch (Exception e) {
            return -1;
        }
    }
}
