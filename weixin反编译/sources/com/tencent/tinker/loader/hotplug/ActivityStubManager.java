package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

public class ActivityStubManager {
    private static Map<String, String> AsW = new HashMap();
    private static final int[] AsX = new int[]{10, 3};
    private static final int[] AsY = new int[]{10, 3};
    private static final int[] AsZ = new int[]{10, 3};
    private static final int[] Ata = new int[]{10, 3};
    private static final int[] Atb = new int[]{0, 0};
    private static final int[] Atc = new int[]{0, 0};
    private static final int[] Atd = new int[]{0, 0};
    private static final int[] Ate = new int[]{0, 0};

    public static String s(String str, int i, boolean z) {
        String str2 = (String) AsW.get(str);
        if (str2 != null) {
            return str2;
        }
        int[] iArr;
        int[] iArr2;
        String str3;
        int i2;
        String str4;
        int[] iArr3;
        switch (i) {
            case 1:
                str4 = ActivityStubs.Ath;
                iArr3 = Atc;
                iArr = AsY;
                iArr2 = iArr3;
                str2 = str4;
                break;
            case 2:
                str4 = ActivityStubs.Ati;
                iArr3 = Atd;
                iArr = AsZ;
                iArr2 = iArr3;
                str2 = str4;
                break;
            case 3:
                str4 = ActivityStubs.Atj;
                iArr3 = Ate;
                iArr = Ata;
                iArr2 = iArr3;
                str2 = str4;
                break;
            default:
                str4 = ActivityStubs.Atg;
                iArr3 = Atb;
                iArr = AsX;
                iArr2 = iArr3;
                str2 = str4;
                break;
        }
        if (z) {
            str3 = str2 + "_T";
            i2 = 1;
        } else {
            str3 = str2;
            i2 = 0;
        }
        int i3 = iArr2[i2];
        iArr2[i2] = i3 + 1;
        if (i3 >= iArr[i2]) {
            iArr2[i2] = 0;
            i2 = 0;
        } else {
            i2 = i3;
        }
        str2 = String.format(str3, new Object[]{Integer.valueOf(i2)});
        AsW.put(str, str2);
        return str2;
    }

    private ActivityStubManager() {
        throw new UnsupportedOperationException();
    }
}
