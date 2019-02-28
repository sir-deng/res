package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.v.e;
import com.tencent.mm.plugin.qqmail.b.v.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class t {
    ArrayList<u> pvb = new ArrayList();
    v pvc = w.bla();
    s pvd = null;
    boolean pve = false;
    f pvf = new f() {
        public final void R(String str, int i, int i2) {
            if (i == i2) {
                x.i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", Integer.valueOf(t.this.pvb.size()));
                if (t.this.pvd != null) {
                    t.this.pvd.Ir(str);
                }
                if (t.this.pvb.size() > 0) {
                    x.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                    t.this.b((u) t.this.pvb.remove(0));
                    t.this.pvc.a((f) this, t.this.pvg);
                    return;
                }
                x.i("MicroMsg.ShareMailQueue", "finished sent all mails");
                t.this.pve = false;
            }
        }
    };
    e pvg = new e() {
        public final void It(String str) {
            if (t.this.pvd != null) {
                s sVar = t.this.pvd;
                if (bi.oN(str)) {
                    x.w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
                } else {
                    s.Is(str);
                    sVar.Ir(str);
                }
            }
            if (t.this.pvb.size() > 0) {
                x.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                t.this.b((u) t.this.pvb.remove(0));
                t.this.pvc.a(t.this.pvf, (e) this);
                return;
            }
            x.i("MicroMsg.ShareMailQueue", "final job fail");
            t.this.pve = false;
        }
    };

    public final void a(u uVar) {
        if (as.Hp()) {
            if (this.pvd == null) {
                this.pvd = new s();
            }
            s sVar = this.pvd;
            String str = uVar.ptS;
            if (bi.oN(str)) {
                x.w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
            } else {
                q qVar = new q();
                qVar.ptS = str;
                sVar.pva.osz.add(qVar);
                sVar.save();
            }
            this.pvb.add(uVar);
            x.d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", Integer.valueOf(this.pvb.size()));
            if (!this.pve) {
                x.d("MicroMsg.ShareMailQueue", "start execute");
                if (this.pvb.size() > 0) {
                    this.pve = true;
                    b((u) this.pvb.remove(0));
                    this.pvc.a(this.pvf, this.pvg);
                }
            }
        }
    }

    final void b(u uVar) {
        v vVar = this.pvc;
        vVar.pvr.clear();
        vVar.pux = null;
        vVar.pvt = 0;
        vVar.pvv = null;
        vVar.pvw = null;
        vVar.pvx.clear();
        vVar.pvu.clear();
        vVar.fAJ = null;
        vVar.pvq.clear();
        vVar.pvj.clear();
        vVar.pvi = null;
        vVar.ptS = null;
        vVar.pvA = 0;
        vVar.puv = null;
        vVar.pvk.clear();
        vVar.pvo.clear();
        vVar.pvs.clear();
        vVar.pvp = null;
        vVar.pvg = null;
        this.pvc.fAJ = uVar.fAJ;
        this.pvc.ptS = uVar.ptS;
        this.pvc.puv = uVar.puv;
        this.pvc.puw = uVar.puw;
        this.pvc.pvi = uVar.pvi;
        vVar = this.pvc;
        Map map = uVar.pvj;
        vVar.pvj = new HashMap();
        vVar.pvj.putAll(map);
        vVar = this.pvc;
        map = uVar.pvk;
        vVar.pvk = new LinkedHashMap();
        vVar.pvk.putAll(map);
        vVar = this.pvc;
        map = uVar.pvl;
        vVar.pvl = new LinkedHashMap();
        vVar.pvl.putAll(map);
    }
}
