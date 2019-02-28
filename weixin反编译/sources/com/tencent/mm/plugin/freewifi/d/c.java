package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.y.as;

public abstract class c extends k implements com.tencent.mm.network.k {
    protected Activity activity;
    protected b gLB;
    protected e gLE;
    protected e mKD;

    protected abstract void aMC();

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        m.Bl("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + i2 + "," + i3 + "]");
        if (this.mKD != null) {
            this.mKD.a(i2, i3, str, this);
        }
        if ((this.activity == null || !this.activity.isFinishing()) && this.gLE != null) {
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final q qVar2 = qVar;
            final byte[] bArr2 = bArr;
            ah.y(new Runnable() {
                public final void run() {
                    c.this.b(i4, i5, i6, str2);
                    if (c.this.gLE != null) {
                        c.this.gLE.a(i5, i6, str2, c.this);
                    }
                }
            });
        }
    }

    protected void b(int i, int i2, int i3, String str) {
    }

    public final void b(e eVar) {
        this.gLE = eVar;
        m.Bl("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        as.CN().a((k) this, 0);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.mKD = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final c v(Activity activity) {
        this.activity = activity;
        return this;
    }
}
