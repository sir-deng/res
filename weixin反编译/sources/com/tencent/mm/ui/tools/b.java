package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.af.d;
import com.tencent.mm.af.f;
import com.tencent.mm.af.i;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.ep;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bb.a;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public final class b {
    private static boolean isDeleteCancel = false;
    private static r tipDialog = null;

    public static void a(d dVar, Activity activity, x xVar, int i) {
        a(dVar, activity, xVar, false, null, i);
    }

    public static void a(d dVar, Activity activity, x xVar, boolean z, Runnable runnable, int i) {
        if (dVar == null || activity == null || xVar == null) {
            boolean z2;
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "bizInfo null : %s, context null : %s, ct null : %s";
            Object[] objArr = new Object[3];
            if (dVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (activity == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (xVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            com.tencent.mm.sdk.platformtools.x.e(str, str2, objArr);
            return;
        }
        String string;
        if (dVar.Ll()) {
            string = activity.getString(R.l.dNo);
        } else {
            string = activity.getString(R.l.dNp, new Object[]{xVar.AX()});
        }
        final d dVar2 = dVar;
        final Activity activity2 = activity;
        final x xVar2 = xVar;
        final boolean z3 = z;
        final int i2 = i;
        final Runnable runnable2 = runnable;
        h.a((Context) activity, string, "", activity.getString(R.l.dWu), activity.getString(R.l.dEy), (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                b.a(dVar2, activity2, xVar2, z3, i2);
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }, null);
    }

    public static void a(d dVar, Activity activity, x xVar, boolean z) {
        a(dVar, activity, xVar, false, 0);
    }

    public static void a(d dVar, Activity activity, x xVar, boolean z, int i) {
        boolean z2 = true;
        if (dVar == null || activity == null || xVar == null) {
            boolean z3;
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "error args, %b, %b, %b";
            Object[] objArr = new Object[3];
            if (dVar == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[0] = Boolean.valueOf(z3);
            if (activity == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[1] = Boolean.valueOf(z3);
            if (xVar != null) {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            com.tencent.mm.sdk.platformtools.x.e(str, str2, objArr);
            return;
        }
        final String str3 = xVar.field_username;
        xVar.Ao();
        as.Hm();
        c.Fe().b(new com.tencent.mm.ax.c(str3, i));
        if (s.gF(str3)) {
            as.Hm();
            c.Ff().XB(str3);
            as.Hm();
            c.Fo().hM(str3);
        } else {
            isDeleteCancel = false;
            activity.getString(R.l.dGZ);
            tipDialog = h.a((Context) activity, activity.getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    b.isDeleteCancel = true;
                }
            });
            a anonymousClass3 = new a() {
                public final boolean HH() {
                    return b.isDeleteCancel;
                }

                public final void HG() {
                    y.Ml().jO(str3);
                    if (b.tipDialog != null) {
                        b.tipDialog.dismiss();
                        b.tipDialog = null;
                    }
                }
            };
            as.Hm();
            c.Ff().a(str3, xVar);
            if (dVar.Lk()) {
                f.kd(dVar.field_username);
            } else {
                bb.a(str3, anonymousClass3);
                as.Hm();
                c.Fk().XE(str3);
            }
            if (activity != null && z) {
                activity.setResult(-1, activity.getIntent().putExtra("_delete_ok_", true));
            }
        }
        if (com.tencent.mm.app.plugin.a.a.a(dVar)) {
            com.tencent.mm.sdk.b.b epVar = new ep();
            epVar.fua.fsi = str3;
            com.tencent.mm.sdk.b.a.xmy.m(epVar);
        }
        i Mk = y.Mk();
        if (!bi.oN(str3)) {
            int delete = Mk.gLA.delete("BizKF", "brandUsername = ?", new String[]{str3});
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", str3, Integer.valueOf(delete));
        }
        if (z) {
            if (activity.getIntent().getIntExtra("Kdel_from", -1) == 0) {
                Intent intent = new Intent(activity, LauncherUI.class);
                intent.addFlags(67108864);
                activity.startActivity(intent);
            }
            activity.finish();
        }
    }
}
