package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ap.l;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.y;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import com.tencent.mm.x.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bp;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.List;

public final class d implements com.tencent.mm.plugin.messenger.a.d {
    public final void C(String str, String str2, int i) {
        if (str == null || str2 == null) {
            x.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", str, str2);
            return;
        }
        as.CN().a(new j(str, str2, i), 0);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, String str4) {
        a(context, str, str2, str3, i, i2, null, false, false, str4);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, bnp bnp, boolean z, boolean z2, String str4) {
        int i3 = 1;
        if (context == null) {
            x.w("MicroMsg.SendMsgMgr", "send vedio context is null");
        } else if (str == null || str2 == null) {
            x.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", str, str2);
        } else {
            as.Hm();
            if (c.isSDCardAvailable()) {
                final a aVar = new a();
                context.getResources().getString(R.l.dGZ);
                Dialog a = h.a(context, context.getResources().getString(R.l.dGM), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        aVar.zxS = true;
                    }
                });
                aVar.context = context;
                aVar.fileName = str2;
                aVar.zxT = str3;
                aVar.ion = a;
                aVar.userName = str;
                aVar.fHB = str4;
                aVar.zxW = false;
                if (62 == i) {
                    aVar.hVH = 11;
                }
                if (i <= 0) {
                    i3 = 0;
                }
                aVar.zxp = i3;
                aVar.hXv = i2;
                aVar.zxU = false;
                aVar.zxX = bnp;
                aVar.execute(new Object[0]);
                return;
            }
            x.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
            Toast.makeText(context, R.l.ewa, 1).show();
        }
    }

    public final void a(Context context, String str, String str2, int i, String str3, String str4) {
        if (str == null || str2 == null) {
            x.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", str, str2);
            return;
        }
        as.Hm();
        if (c.isSDCardAvailable()) {
            as.CN().a(new l(4, q.FY(), str, str2, i, null, 0, str3, str4, true, R.g.bAI), 0);
            bp.HY().c(bp.hjo, null);
            return;
        }
        x.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
        Toast.makeText(context, R.l.ewa, 1).show();
    }

    public final void a(String str, byte[] bArr, String str2, String str3) {
        if (str == null) {
            x.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
            return;
        }
        x.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", str2);
        g.a fV = g.a.fV(bi.Wn(str2));
        if (fV == null) {
            x.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
            return;
        }
        b bVar = new b();
        x.i("MicroMsg.SendMsgMgr", "content.attachid %s", fV.for);
        if (!bi.oN(fV.for)) {
            long j = bi.getLong(fV.for, -1);
            if (j != -1) {
                an.aqK().b(j, (com.tencent.mm.sdk.e.c) bVar);
                if (bVar.xrR != j) {
                    bVar = an.aqK().Se(fV.for);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(fV.for)) {
                        bVar = null;
                    }
                    if (bVar == null) {
                        x.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", fV.for);
                    } else {
                        x.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", fV.for, Long.valueOf(bVar.xrR), bVar.field_fileFullPath);
                    }
                }
            } else {
                bVar = an.aqK().Se(fV.for);
                if (bVar == null || !bVar.field_mediaSvrId.equals(fV.for)) {
                    bVar = null;
                }
                if (bVar == null) {
                    x.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", fV.for);
                } else {
                    x.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", fV.for, Long.valueOf(bVar.xrR), bVar.field_fileFullPath);
                }
            }
        }
        String str4 = "";
        if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(""))) {
            as.Hm();
            str4 = com.tencent.mm.pluginsdk.model.app.l.ad(c.FB(), fV.title, fV.hcN);
            k.r(bVar.field_fileFullPath, str4, false);
            x.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", bVar.field_fileFullPath, str4, Integer.valueOf(e.bN(bVar.field_fileFullPath)));
        }
        g.a a = g.a.a(fV);
        a.hcP = 3;
        com.tencent.mm.pluginsdk.model.app.l.a(a, fV.appId, fV.appName, str, str4, bArr, str3);
    }

    public final void l(String str, String str2, boolean z) {
        if (z) {
            as.CN().a(new j(bi.aD(str2, ""), y.aal(str), com.tencent.mm.storage.x.Xg(str) ? 66 : 42), 0);
            return;
        }
        List F = bi.F(bi.aD(str2, "").split(","));
        String aal = y.aal(str);
        for (int i = 0; i < F.size(); i++) {
            int i2;
            String str3 = (String) F.get(i);
            if (com.tencent.mm.storage.x.Xg(str)) {
                i2 = 66;
            } else {
                i2 = 42;
            }
            as.CN().a(new j(str3, aal, i2), 0);
        }
    }

    public final void dq(String str, String str2) {
        List<String> F = bi.F(bi.aD(str2, "").split(","));
        if (!TextUtils.isEmpty(str)) {
            for (String str3 : F) {
                com.tencent.mm.sdk.b.b otVar = new ot();
                otVar.fHD.fHE = str3;
                otVar.fHD.content = str;
                otVar.fHD.type = s.hs(str3);
                otVar.fHD.flags = 0;
                com.tencent.mm.sdk.b.a.xmy.m(otVar);
            }
        }
    }
}
