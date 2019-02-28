package com.tencent.c.e.a.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.c.e.a.b.a;
import com.tencent.c.e.a.b.e;
import com.tencent.c.e.a.b.g;
import com.tencent.c.f.d;
import com.tencent.c.f.i;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private static final int[] Adf = new int[]{1, 5, 4, 8, 9, 2};
    private static int Adg = -1;

    public static a a(int i, int i2, Context context, int i3, SparseArray<i> sparseArray, List<k> list) {
        a aVar = new a();
        aVar.AdB = 0;
        aVar.AdC = "";
        aVar.hMV = i.bF(context, context.getPackageName()).versionCode;
        aVar.Abt = "14D6ACDE3C2F2F48";
        aVar.fDM = 500000;
        aVar.requestType = i3;
        aVar.AdE = abz(context.getPackageName());
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            arrayList.addAll(((i) sparseArray.valueAt(i4)).dK(list));
        }
        if (arrayList.size() <= 0 || arrayList.get(0) == null) {
            throw new IllegalArgumentException("invalid stateUnits");
        }
        e eVar = new e();
        eVar.AdM = ((g) arrayList.get(0)).AdR;
        eVar.AdN = arrayList;
        eVar.AcO = i;
        eVar.action = i2;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(eVar);
        aVar.AdD = arrayList2;
        aVar.imei = abz(d.gu(context));
        aVar.imsi = abz(d.gv(context));
        aVar.hrN = abz(Build.BRAND);
        aVar.model = abz(Build.MODEL);
        aVar.AdF = abz(Build.FINGERPRINT);
        aVar.AdG = gs(context);
        aVar.sdkVer = VERSION.SDK_INT;
        aVar.zYY = 2;
        return aVar;
    }

    private static String abz(String str) {
        return str == null ? "" : str;
    }

    private static int gs(Context context) {
        if (Adg == -1) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null) {
                return Adg;
            }
            int i = 1;
            for (int i2 = 0; i2 < Adf.length; i2++) {
                int i3;
                if (sensorManager.getDefaultSensor(Adf[i2]) == null) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                i |= i3 << i2;
            }
            Adg = i;
        }
        return Adg;
    }
}
