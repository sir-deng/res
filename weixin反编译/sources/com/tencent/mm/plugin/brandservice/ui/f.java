package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.plugin.brandservice.ui.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bco;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.List;

public final class f extends c {
    List<bco> kMB = null;
    private SparseArray<a> kMC = new SparseArray();
    private int kMD;

    public final /* synthetic */ Object getItem(int i) {
        return nQ(i);
    }

    public f(Context context) {
        super(context);
        a(new b() {
            public final void a(c cVar, com.tencent.mm.ui.base.sortview.a aVar, int i, String str, int i2, int i3) {
                jm nL = f.this.nL(i3);
                String str2 = bi.oM(f.this.kKX) + "," + i + "," + bi.oM(str) + "," + i2 + "," + cVar.kLh + "," + (nL == null ? "" : nL.vWw + ",0");
                g.pWK.k(10866, str2);
                x.d("MicroMsg.SearchOrRecommendBizAdapter", "report : " + str2);
            }
        });
    }

    public final void c(String str, List<jm> list) {
        super.c(str, list);
        this.kMD = super.getCount();
    }

    public final void a(jm jmVar, boolean z) {
        super.a(jmVar, z);
        if (this.kMD == 0) {
            this.kMD = super.getCount();
        }
    }

    public final int getCount() {
        int count = super.getCount();
        if (count != 0 || this.kMB == null) {
            return count;
        }
        Iterator it = this.kMB.iterator();
        while (true) {
            int i = count;
            if (!it.hasNext()) {
                return i;
            }
            bco bco = (bco) it.next();
            if (!(bco == null || bco.wPs == null)) {
                i += bco.wPs.size();
            }
            count = i;
        }
    }

    public final void asW() {
        super.asW();
    }

    public final com.tencent.mm.ui.base.sortview.a nQ(int i) {
        String str = null;
        int count = super.getCount();
        if (count != 0) {
            return super.nQ(i);
        }
        a aVar = (a) this.kMC.get(i);
        if (aVar != null || this.kMB.size() <= 0) {
            return aVar;
        }
        Object obj;
        for (bco bco : this.kMB) {
            if (count == i) {
                String bet = bco.wPq == null ? null : bco.wPq.toString();
                obj = (bgl) bco.wPs.get(0);
                str = bet;
            } else if (i < bco.wPs.size() + count) {
                bgl obj2 = (bgl) bco.wPs.get(i - count);
                break;
            } else {
                count = bco.wPs.size() + count;
            }
        }
        obj2 = null;
        com.tencent.mm.ui.base.sortview.a bVar = new b(obj2, str);
        bVar.nR(i);
        bVar.cR(i);
        this.kMC.put(i, bVar);
        return bVar;
    }

    protected final Object[] nO(int i) {
        a nK = nK(i);
        jm nL = nL(i);
        if (nK == null) {
            return super.nO(i);
        }
        Object[] objArr = new Object[4];
        objArr[0] = this;
        objArr[1] = nK.kLk;
        objArr[2] = Integer.valueOf(i < this.kMD ? 39 : 56);
        objArr[3] = nL != null ? nL.vWw : "";
        return objArr;
    }
}
