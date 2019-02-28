package com.tencent.mm.o;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.f.a.jr;
import com.tencent.mm.f.a.sq;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ac;

public final class a {
    private static ac fgB;

    public static boolean aU(Context context) {
        if (!Bd()) {
            return false;
        }
        x.i("MicroMsg.DeviceOccupy", "isMultiTalking");
        Toast.makeText(context, h.luQ, 0).show();
        return true;
    }

    public static boolean Bd() {
        b jrVar = new jr();
        jrVar.fBl.action = 1;
        com.tencent.mm.sdk.b.a.xmy.m(jrVar);
        return jrVar.fBm.fBn;
    }

    public static boolean aV(Context context) {
        b sqVar = new sq();
        com.tencent.mm.sdk.b.a.xmy.m(sqVar);
        if (sqVar.fLh.fLj) {
            x.i("MicroMsg.DeviceOccupy", "isCameraUsing");
            Toast.makeText(context, d(context, sqVar.fLh.fLi), 0).show();
        }
        return sqVar.fLh.fLj;
    }

    public static boolean aW(Context context) {
        b sqVar = new sq();
        com.tencent.mm.sdk.b.a.xmy.m(sqVar);
        if (sqVar.fLh.fLk) {
            x.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
            Toast.makeText(context, d(context, sqVar.fLh.fLi), 0).show();
        }
        return sqVar.fLh.fLk;
    }

    private static String d(Context context, boolean z) {
        if (z) {
            return context.getString(h.luf);
        }
        return context.getString(h.lug);
    }

    public static ac uy() {
        if (fgB == null) {
            fgB = com.tencent.mm.booter.a.wG();
        }
        return fgB;
    }
}
