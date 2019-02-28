package com.tencent.mm.plugin.accountsync.model;

import android.os.Message;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.jn;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a implements e {
    boolean hPX = false;
    b hwH = new b() {
        public final void bO(boolean z) {
            x.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", Boolean.valueOf(z));
            if (!z) {
                return;
            }
            if (m.Oa().size() > 0) {
                x.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
                as.CN().a((int) d.CTRL_INDEX, a.this);
                System.currentTimeMillis();
                as.CN().a(new aa(m.Oa(), m.NZ()), 0);
                return;
            }
            x.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
            String[] strArr = (String[]) a.this.inp.toArray(new String[0]);
            a.this.inp.clear();
            List arrayList = new ArrayList();
            for (String kU : strArr) {
                com.tencent.mm.modelfriend.b kU2 = af.OJ().kU(kU);
                if (kU2 == null || bi.oN(kU2.NF())) {
                    x.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", kU);
                } else {
                    arrayList.add(kU2.NF());
                    x.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", kU2.NF(), kU);
                }
            }
            as.CN().a(32, a.this);
            if (arrayList.size() == 0) {
                x.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
                as.CN().a(new v(), 0);
                return;
            }
            x.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", Integer.valueOf(arrayList.size()));
            as.CN().a(new v(arrayList, null), 0);
        }
    };
    Set<String> inp = Collections.synchronizedSet(new HashSet());
    public c inq = new c<jn>() {
        {
            this.xmG = jn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.ContactsAutoSyncLogic ", "sync username=%s isUploading=%b", ((jn) bVar).fAZ.username, Boolean.valueOf(a.this.hPX));
            a.this.inp.add(r7.fAZ.username);
            if (!a.this.hPX) {
                a.this.inr.removeMessages(0);
                a.this.inr.sendEmptyMessageDelayed(0, 10000);
            }
            return false;
        }
    };
    ag inr = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    a.this.hPX = true;
                    if (!com.tencent.mm.modelfriend.a.a(a.this.hwH)) {
                        a.this.hPX = false;
                    }
                    x.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", Boolean.valueOf(r0));
                    return;
                default:
                    return;
            }
        }
    };

    public a() {
        com.tencent.mm.sdk.b.a.xmy.b(this.inq);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == d.CTRL_INDEX) {
            as.CN().b((int) d.CTRL_INDEX, (e) this);
            if (i == 0 && i2 == 0) {
                as.CN().a(32, (e) this);
                aa aaVar = (aa) kVar;
                as.CN().a(new v(aaVar.hyp, aaVar.hyq), 0);
            } else {
                x.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + i + ", errCode = " + i2);
                this.hPX = false;
            }
        }
        if (kVar.getType() == 32) {
            this.hPX = false;
            as.CN().b(32, (e) this);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
                com.tencent.mm.modelsimple.d.bs(ad.getContext());
                return;
            }
            x.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
    }
}
