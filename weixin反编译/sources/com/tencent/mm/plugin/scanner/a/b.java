package com.tencent.mm.plugin.scanner.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.aj;
import com.tencent.mm.f.a.ca;
import com.tencent.mm.f.a.kh;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public final class b {
    Activity mActivity;
    String pYA;
    e pYB;
    a pYC;
    e.a pYD = new e.a() {
        public final void m(int i, Bundle bundle) {
            x.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", Integer.valueOf(i));
            com.tencent.mm.sdk.b.b khVar = new kh();
            khVar.fCx.fCv = i;
            khVar.fCx.activity = b.this.mActivity;
            khVar.fCx.fpo = b.this.pYA;
            khVar.fCx.fCy = bundle;
            com.tencent.mm.sdk.b.a.xmy.m(khVar);
        }
    };
    public c pYE = new c<ca>() {
        {
            this.xmG = ca.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i = 2;
            ca caVar = (ca) bVar;
            if (caVar == null || !(caVar instanceof ca)) {
                x.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a DealQBarStrEvent instance");
            } else {
                b.this.bpk();
                b.this.pYA = caVar.fqV.fpo;
                b.this.mActivity = caVar.fqV.activity;
                x.i("MicroMsg.ExternRequestDealQBarStrHandler", "request deal qbar, activity:%s, str:%s, codeType: %s, codeVersion: %s, from : %d", b.this.mActivity, b.this.pYA, Integer.valueOf(caVar.fqV.fqW), Integer.valueOf(caVar.fqV.fqX), Integer.valueOf(caVar.fqV.fqZ));
                if (caVar.fqV.fqW == 19 || caVar.fqV.fqW == 22) {
                    b.this.pYB = new e();
                    b.this.pYB.fqY = caVar.fqV.fqY;
                    b.this.pYB.imagePath = caVar.fqV.imagePath;
                    b.this.pYB.frb = caVar.fqV.frb;
                    b.this.pYB.bhd = caVar.fqV.bhd;
                    if (caVar.fqV.fqZ >= 0) {
                        i = 3;
                    }
                    if (caVar.fqV.scene > 0) {
                        b.this.pYB.mtU = caVar.fqV.scene;
                    }
                    if (i == 3) {
                        b.this.pYB.appId = caVar.fqV.fra;
                    }
                    b.this.pYB.a(b.this.mActivity, b.this.pYA, i, caVar.fqV.fqW, caVar.fqV.fqX, b.this.pYD, caVar.fqV.frc);
                } else {
                    b.this.pYC = new a();
                    com.tencent.mm.ad.e eVar = b.this.pYC;
                    Context context = b.this.mActivity;
                    String str = b.this.pYA;
                    int i2 = caVar.fqV.fqW;
                    int i3 = caVar.fqV.fqX;
                    Bundle bundle = caVar.fqV.frc;
                    if (!bi.oN(str)) {
                        String[] split = str.split(",");
                        if (split == null || split.length < 2) {
                            x.e("MicroMsg.BarcodeStringHandler", "wrong zbar format");
                        } else {
                            eVar.fBA = context;
                            eVar.frc = bundle;
                            k fVar = new f(p.Js(split[0]), split[1], i2, i3);
                            as.CN().a(1061, eVar);
                            as.CN().a(fVar, 0);
                            context.getString(R.l.dGZ);
                            eVar.inI = h.a(context, context.getString(R.l.eBO), true, new com.tencent.mm.plugin.scanner.util.a.AnonymousClass1(fVar));
                        }
                    }
                }
            }
            return false;
        }
    };
    public c pYF = new c<aj>() {
        {
            this.xmG = aj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            aj ajVar = (aj) bVar;
            if (ajVar == null || !(ajVar instanceof aj)) {
                x.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a CancelDealQBarStrEvent instance");
            } else {
                x.i("MicroMsg.ExternRequestDealQBarStrHandler", "cancel deal qbar, activity:%s, str:%s", b.this.mActivity, b.this.pYA);
                if (ajVar.fpn.activity == b.this.mActivity && ajVar.fpn.fpo.equals(b.this.pYA)) {
                    b.this.bpk();
                } else {
                    x.e("MicroMsg.ExternRequestDealQBarStrHandler", "not same as string that are dealing");
                }
            }
            return false;
        }
    };

    public final void bpk() {
        if (this.pYB != null) {
            this.pYB.bqi();
            this.pYB = null;
        }
        this.mActivity = null;
        this.pYA = null;
    }
}
