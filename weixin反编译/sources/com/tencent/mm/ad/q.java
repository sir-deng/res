package com.tencent.mm.ad;

import android.os.Looper;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.l.a;
import com.tencent.mm.network.r;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends a {
    private final k frW;
    final ag handler;
    private final long hoY = 330000;
    private com.tencent.mm.network.q hoZ;
    private final e hok;
    private final e hoo;
    private k hpa;
    private boolean hpb = false;
    private boolean hpc = false;
    Runnable hpd = new Runnable() {
        public final void run() {
            int i = 0;
            if (q.this.hpb || q.this.hpc) {
                int i2;
                String str = "MicroMsg.RemoteOnGYNetEnd";
                String str2 = "time exceed But removeCallbacks failed hash:%d type:%d";
                Object[] objArr = new Object[2];
                if (q.this.frW == null) {
                    i2 = 0;
                } else {
                    i2 = q.this.frW.hashCode();
                }
                objArr[0] = Integer.valueOf(i2);
                if (q.this.frW != null) {
                    i = q.this.frW.getType();
                }
                objArr[1] = Integer.valueOf(i);
                x.e(str, str2, objArr);
                return;
            }
            final boolean a = q.this.hpb;
            final boolean b = q.this.hpc;
            String str3 = "MicroMsg.RemoteOnGYNetEnd";
            String str4 = "time exceed, force to callback hash:%d type:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(q.this.frW == null ? 0 : q.this.frW.hashCode());
            if (q.this.frW != null) {
                i = q.this.frW.getType();
            }
            objArr2[1] = Integer.valueOf(i);
            x.w(str3, str4, objArr2);
            q.this.hpb = true;
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    int i = 0;
                    q.this.hok.ju("push process's network haven't callback in 5.5min!!!! cancelStatus:" + a + " hasCallbackStatus:" + b);
                    String str = "MicroMsg.RemoteOnGYNetEnd";
                    String str2 = "time exceed, force to callback . kill push fin. hash:%d type:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(q.this.frW == null ? 0 : q.this.frW.hashCode());
                    if (q.this.frW != null) {
                        i = q.this.frW.getType();
                    }
                    objArr[1] = Integer.valueOf(i);
                    x.w(str, str2, objArr);
                }
            }, "RemoteOnGYNetEnd_killPush");
            q.this.hpa.a(-1, 3, -1, "time exceed, force to callback", q.this.hoZ, null);
        }
    };

    public q(com.tencent.mm.network.q qVar, k kVar, k kVar2, e eVar, e eVar2) {
        this.hoZ = qVar;
        this.hpa = kVar;
        this.frW = kVar2;
        this.hoo = eVar;
        this.handler = Looper.myLooper() == null ? new ag(Looper.getMainLooper()) : new ag();
        this.hok = eVar2;
    }

    public final void cancel() {
        this.hpb = true;
        this.handler.removeCallbacks(this.hpd);
    }

    public final void a(int i, int i2, int i3, String str, r rVar, byte[] bArr) {
        x.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.hpb), Integer.valueOf(this.frW.hashCode()), Integer.valueOf(this.hoZ.hashCode()));
        this.frW.hom = -1;
        if (!this.hpb && !this.hpc) {
            this.hpc = true;
            this.handler.removeCallbacks(this.hpd);
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final byte[] bArr2 = bArr;
            this.handler.post(new Runnable() {
                public final void run() {
                    if (q.this.hpb) {
                        x.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", Integer.valueOf(i4));
                        return;
                    }
                    int i = i5;
                    int i2 = i6;
                    if (10016 == com.tencent.mm.platformtools.r.ifN && !bi.oN(com.tencent.mm.platformtools.r.ifP)) {
                        x.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", com.tencent.mm.platformtools.r.ifP);
                        String[] split = com.tencent.mm.platformtools.r.ifP.split(",");
                        if (split != null && split.length == 3 && bi.getInt(split[0], -1) == q.this.frW.getType()) {
                            i = bi.getInt(split[1], 0);
                            i2 = bi.getInt(split[2], 0);
                            if (i == 999) {
                                x.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", com.tencent.mm.platformtools.r.ifP);
                                return;
                            }
                        }
                    }
                    x.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(q.this.hpb), Integer.valueOf(q.this.frW.hashCode()));
                    q.this.hpa.a(i4, i, i2, str2, q.this.hoZ, bArr2);
                    if (q.this.frW.Km() && !q.this.frW.hop) {
                        x.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", Integer.valueOf(q.this.frW.getType()));
                        x.cfX();
                    }
                }
            });
        }
    }
}
