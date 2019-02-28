package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.f.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class g {
    private static int tpc = 0;
    private HashMap<String, f> tpd = new HashMap();

    public final synchronized f Om(String str) {
        f fVar;
        if (this.tpd.containsKey(str)) {
            fVar = (f) ((f) this.tpd.get(str)).clone();
        } else {
            tpc++;
            fVar = new f();
            fVar.talker = str;
            fVar.id = tpc;
            fVar.toW = a.INIT;
            this.tpd.put(str, fVar);
            fVar = (f) fVar.clone();
        }
        return fVar;
    }

    public final synchronized void On(String str) {
        x.i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", str);
        if (this.tpd.containsKey(str)) {
            ((f) this.tpd.get(str)).toW = a.INIT;
            ((f) this.tpd.get(str)).toV = 0;
        }
    }

    public final synchronized void a(f fVar) {
        x.i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", fVar);
        this.tpd.put(fVar.talker, fVar);
    }

    public final synchronized void Oo(String str) {
        if (this.tpd.containsKey(str)) {
            f fVar = (f) this.tpd.get(str);
            fVar.toW = a.REPLY;
            fVar.toV = 0;
            x.i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", fVar);
        }
    }

    public final synchronized void cw(String str, int i) {
        if (this.tpd.containsKey(str)) {
            f fVar = (f) this.tpd.get(str);
            fVar.toW = a.IGNORE;
            fVar.toV = i;
            x.i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", fVar);
        }
    }

    public final synchronized void Op(String str) {
        if (this.tpd.containsKey(str)) {
            ((f) this.tpd.get(str)).toW = a.SHOWING;
            x.i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", r0);
        }
    }
}
