package com.tencent.mm.at;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.f.a.jr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.i;

public final class a {
    public static boolean aU(Context context) {
        return com.tencent.mm.o.a.aU(context);
    }

    public static boolean Qq() {
        b jrVar = new jr();
        jrVar.fBl.action = 2;
        com.tencent.mm.sdk.b.a.xmy.m(jrVar);
        return jrVar.fBm.fBn;
    }

    public static boolean Qr() {
        return com.tencent.mm.pluginsdk.q.a.vje != null && com.tencent.mm.pluginsdk.q.a.vje.aWq();
    }

    public static i a(Context context, int i, final Runnable runnable) {
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(context);
        aVar.ES(R.l.dGZ);
        aVar.ET(i);
        aVar.EV(R.l.ewC).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        aVar.mp(true);
        aVar.d(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        i ale = aVar.ale();
        ale.show();
        return ale;
    }
}
