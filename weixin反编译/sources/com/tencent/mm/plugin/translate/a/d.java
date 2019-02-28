package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements e {
    public int index;
    public SparseArray<c> smp = null;
    public boolean smq = false;
    public b smr;
    a sms;
    public al smt = new al(new a() {
        public final boolean uG() {
            if (d.this.smq) {
                x.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", Integer.valueOf(d.this.index));
                d.this.bGl();
                d.this.sms.a(-1, d.this.smp, null);
            }
            return false;
        }
    }, false);
    long start;

    public d(int i, a aVar) {
        this.index = i;
        this.sms = aVar;
    }

    public final void bGl() {
        this.smr = null;
        this.smq = false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.smr != kVar) {
            x.e("MicroMsg.WorkingTranslate", "not my translate work");
            return;
        }
        int size;
        this.smt.TN();
        x.d("MicroMsg.WorkingTranslate", "translate take time : %s", Long.valueOf(System.currentTimeMillis() - this.start));
        String str2 = "MicroMsg.WorkingTranslate";
        String str3 = "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        if (((b) kVar).smh != null) {
            size = ((b) kVar).smh.size();
        } else {
            size = 0;
        }
        objArr[3] = Integer.valueOf(size);
        x.d(str2, str3, objArr);
        bGl();
        this.sms.a(i2, this.smp, ((b) kVar).smh);
    }
}
