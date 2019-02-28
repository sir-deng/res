package com.tencent.mm.plugin.appbrand.game.e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static boolean jbD = false;

    public static void bT(Context context) {
        String str = q.gHN.gEq;
        if (jbD) {
            x.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
            return;
        }
        String string = ad.getResources().getString(j.iDW);
        String string2 = ad.getResources().getString(j.dGZ);
        if (bi.oN(str)) {
            str = string;
        }
        a.a(context, str, string2, ad.getResources().getString(j.dGf), "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                d.jbD = false;
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                d.jbD = false;
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                d.jbD = false;
            }
        });
        jbD = true;
    }
}
