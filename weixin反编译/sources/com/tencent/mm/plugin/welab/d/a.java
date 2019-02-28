package com.tencent.mm.plugin.welab.d;

import android.app.Activity;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.b.cc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;

public final class a implements b {
    public final void e(Activity activity, String str) {
        cc Rc = ((d) g.h(d.class)).Rc(str);
        com.tencent.mm.sdk.b.b qrVar = new qr();
        qrVar.fJd.userName = Rc.field_WeAppUser;
        qrVar.fJd.fJf = Rc.field_WeAppPath;
        qrVar.fJd.scene = 1051;
        qrVar.fJd.fJg = Rc.field_WeAppDebugMode;
        qrVar.fJd.foi = String.format("%s:%s:%s:%s", new Object[]{(String) g.Dq().Db().get(2, null), Rc.field_expId, Rc.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000)});
        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
    }

    public final String bWp() {
        return null;
    }

    public final String bWq() {
        return null;
    }
}
