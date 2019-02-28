package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.kb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class c<T extends b> extends com.tencent.mm.sdk.b.c<T> implements e {
    private static HashMap<b, c<? extends b>> hzv = new HashMap();
    private static HashMap<k, b> vjy = new HashMap();
    private int vjx = 0;

    public abstract b a(int i, k kVar, T t);

    public abstract int ayd();

    public abstract k b(T t);

    public final void a(int i, int i2, String str, k kVar) {
        if (ayd() == kVar.getType()) {
            b bVar = (b) vjy.remove(kVar);
            if (bVar != null) {
                b kbVar = new kb();
                kbVar.fCh.fCi = a(i2, kVar, bVar);
                kbVar.fCh.errType = i;
                kbVar.fCh.errCode = i2;
                kbVar.fCh.foE = str;
                a.xmy.m(kbVar);
            }
        }
    }

    public static void k(b bVar) {
        k kVar;
        for (Entry entry : vjy.entrySet()) {
            if (entry.getValue() == bVar) {
                kVar = (k) entry.getKey();
                break;
            }
        }
        kVar = null;
        if (kVar != null) {
            g.CN().c(kVar);
            vjy.remove(kVar);
        }
    }

    public final void bYW() {
        if (this.vjx == 0) {
            g.CN().a(ayd(), (e) this);
        }
        this.vjx++;
    }

    public final void aVz() {
        if (this.vjx != 0) {
            this.vjx--;
            if (this.vjx == 0) {
                g.CN().b(ayd(), (e) this);
            }
        }
    }

    public final void l(T t) {
        k b = b(t);
        g.CN().a(b, 0);
        vjy.put(b, t);
    }
}
