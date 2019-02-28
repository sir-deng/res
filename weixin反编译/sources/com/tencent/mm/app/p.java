package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.k;
import com.tencent.mm.audio.a.a;
import com.tencent.mm.ay.r;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.f.a.rl;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t;
import com.tencent.mm.y.as;

final class p implements h, j, m, o {
    p() {
    }

    public final void un() {
        q.Qj().ig(7);
    }

    public final void ep(int i) {
        x.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", Integer.valueOf(i));
        q.Qj().ig(i);
    }

    public final g uo() {
        return new a(ad.getContext());
    }

    public final String s(String str, int i) {
        if (com.tencent.mm.pluginsdk.model.app.g.cT(str, i) != null) {
            return com.tencent.mm.pluginsdk.model.app.g.cT(str, i).field_packageName;
        }
        return "";
    }

    public final String cy(String str) {
        if (com.tencent.mm.pluginsdk.model.app.g.aZ(str, false) != null) {
            return com.tencent.mm.pluginsdk.model.app.g.aZ(str, false).field_packageName;
        }
        return "";
    }

    public final String l(Context context, String str) {
        return com.tencent.mm.pluginsdk.model.app.g.l(context, str);
    }

    public final boolean cz(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.cz(str);
    }

    public final boolean m(Context context, String str) {
        return com.tencent.mm.pluginsdk.model.app.g.m(context, str);
    }

    public final String f(Context context, String str, String str2) {
        return com.tencent.mm.pluginsdk.model.app.p.f(context, str, str2);
    }

    public final String A(String str, String str2) {
        return com.tencent.mm.pluginsdk.model.app.p.A(str, str2);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5) {
        com.tencent.mm.pluginsdk.q.j jVar = com.tencent.mm.pluginsdk.q.a.vjc;
        if (jVar != null) {
            jVar.a(context, str, str2, str3, i, i2, i3, str4, 0, str5);
        }
    }

    public final void a(Context context, String str, String str2, String str3, long j) {
        com.tencent.mm.pluginsdk.q.j jVar = com.tencent.mm.pluginsdk.q.a.vjc;
        if (jVar != null) {
            jVar.a(str, str2, 2, 4, str3, j);
        }
    }

    public final void up() {
        b rlVar = new rl();
        rlVar.fKc.fKe = true;
        com.tencent.mm.sdk.b.a.xmy.m(rlVar);
    }

    public final k aJ(boolean z) {
        if (z) {
            r.QO().im(4);
        }
        k kVar = new com.tencent.mm.ay.k(4);
        as.CN().a(kVar, 0);
        return kVar;
    }

    public final boolean cA(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.cA(str);
    }

    public final boolean a(Context context, int i, int i2, String str) {
        return t.a.a(context, i, i2, str, 4);
    }

    public final boolean b(Context context, int i, int i2, String str) {
        return t.a.a(context, i, i2, str, 7);
    }

    public final void uq() {
        MMAppMgr.uq();
    }

    public final boolean d(Activity activity) {
        if (f.zl()) {
            com.tencent.mm.pluginsdk.ui.tools.k.R(activity);
            return true;
        }
        u.fJ(activity);
        return false;
    }

    public final void aq(Context context) {
        MMAppMgr.fu(context);
    }

    public final void e(Activity activity) {
        MMAppMgr.a(activity, null);
    }

    public final Bitmap a(Activity activity, int i, int i2, Intent intent) {
        if (i2 != -1) {
            return null;
        }
        String b;
        switch (i) {
            case 2:
                if (intent == null) {
                    return null;
                }
                Intent intent2 = new Intent();
                intent2.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_OutputPath", e.gJm + "temp.avatar");
                intent2.putExtra("CropImage_ImgPath", null);
                com.tencent.mm.ui.tools.a.a(activity, intent, intent2, e.gJm, 4);
                return null;
            case 3:
                b = com.tencent.mm.pluginsdk.ui.tools.k.b(activity.getApplicationContext(), intent, e.gJm);
                if (b == null) {
                    return null;
                }
                Intent intent3 = new Intent();
                intent3.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", e.gJm + "temp.avatar");
                intent3.putExtra("CropImage_ImgPath", b);
                activity.startActivityForResult(intent3, 4);
                return null;
            case 4:
                if (intent == null) {
                    return null;
                }
                b = intent.getStringExtra("CropImage_OutputPath");
                if (b == null) {
                    x.e("MicroMsg.WorkerModelCallback", "crop picture failed");
                    return null;
                }
                x.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", b);
                return d.Vs(b);
            default:
                return null;
        }
    }

    public final Intent ur() {
        Intent intent = new Intent(ad.getContext(), LauncherUI.class);
        intent.putExtra("nofification_type", "talkroom_notification");
        intent.addFlags(67108864);
        return intent;
    }

    public final k a(com.tencent.mm.ad.f fVar) {
        if (com.tencent.mm.modelmulti.m.Qf()) {
            return new com.tencent.mm.modelmulti.g(fVar);
        }
        q.Qj().ig(4);
        return null;
    }

    public final boolean a(com.tencent.mm.storage.x xVar) {
        return com.tencent.mm.modelmulti.a.a(xVar);
    }

    public final void a(com.tencent.mm.af.d dVar, Activity activity, com.tencent.mm.storage.x xVar, boolean z, Runnable runnable) {
        com.tencent.mm.ui.tools.b.a(dVar, activity, xVar, z, runnable, 0);
    }

    public final void a(com.tencent.mm.af.d dVar, Activity activity, com.tencent.mm.storage.x xVar) {
        com.tencent.mm.ui.tools.b.a(dVar, activity, xVar, false);
    }

    public final boolean us() {
        return com.tencent.mm.pluginsdk.ui.d.p.us();
    }

    public final void a(Intent intent, bfr bfr, int i) {
        c.a(intent, bfr, i);
    }

    public final void ut() {
        com.tencent.mm.booter.o.ut();
    }

    public final void a(Context context, au.a aVar, Bundle bundle) {
        com.tencent.mm.ui.contact.e.a(context, aVar, true, true, bundle);
    }

    public final void a(Context context, com.tencent.mm.storage.x xVar, au.a aVar, Bundle bundle, String str) {
        com.tencent.mm.ui.contact.e.a(context, xVar, aVar, true, true, bundle, str);
    }

    public final void a(Intent intent, String str) {
        com.tencent.mm.ui.contact.e.a(intent, str);
    }

    public final void cB(String str) {
        q.Qk().a(new com.tencent.mm.modelmulti.b.a(str, 0, 0, 0, 0));
    }

    public final void a(asc asc, String str) {
        ((com.tencent.mm.plugin.messenger.foundation.a.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(asc, str, null, true, false);
    }

    public final boolean uu() {
        return com.tencent.mm.modelmulti.m.Qf();
    }
}
