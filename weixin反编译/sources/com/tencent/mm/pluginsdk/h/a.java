package com.tencent.mm.pluginsdk.h;

import android.app.Activity;
import com.tencent.mm.ad.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class a {
    private i vmp;
    private j vmq;
    private k vmr;
    private g vms;
    private h vmt;
    private f vmu;

    public final boolean a(Activity activity, o oVar) {
        if (oVar.type == 0 || oVar.action == 0) {
            return false;
        }
        if (this.vmu == null) {
            this.vmu = new f(activity);
        }
        if (this.vmu.a(oVar)) {
            return true;
        }
        switch (oVar.type) {
            case 1:
                if (this.vmp == null) {
                    this.vmp = new i(activity);
                }
                this.vmp.a(oVar);
                return false;
            case 2:
                if (this.vmq == null) {
                    this.vmq = new j(activity);
                }
                this.vmq.a(oVar);
                return false;
            case 3:
                if (this.vmr == null) {
                    this.vmr = new k(activity);
                }
                this.vmr.a(oVar);
                return false;
            case 4:
                if (this.vms == null) {
                    this.vms = new g(activity);
                }
                this.vms.a(oVar);
                return false;
            case 5:
                if (this.vmt == null) {
                    this.vmt = new h(activity);
                }
                this.vmt.a(oVar);
                return false;
            case 6:
                if (this.vmu == null) {
                    this.vmu = new f(activity);
                }
                this.vmu.a(oVar);
                return false;
            default:
                x.e("MicroMsg.BaseErrorHelper", "Unkown error type");
                return false;
        }
    }

    private static void a(b bVar) {
        if (bVar != null) {
            for (Integer intValue : bVar.vmv) {
                as.CN().b(intValue.intValue(), (e) bVar);
            }
            bVar.activity = null;
        }
    }

    public final void close() {
        a(this.vmp);
        a(this.vmq);
        a(this.vmr);
        a(this.vms);
        a(this.vmt);
        a(this.vmu);
    }
}
