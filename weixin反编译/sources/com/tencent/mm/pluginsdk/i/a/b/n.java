package com.tencent.mm.pluginsdk.i.a.b;

import android.util.SparseArray;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.i.a.a.a;
import com.tencent.mm.protocal.c.bed;
import com.tencent.mm.protocal.c.bei;
import com.tencent.mm.protocal.c.bej;
import com.tencent.mm.protocal.c.ns;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class n extends k implements com.tencent.mm.network.k {
    protected static final SparseArray<a> vnY = new SparseArray();
    private volatile e gLE;
    protected final List<bej> vnX = new LinkedList();

    protected abstract q cai();

    protected abstract String getTag();

    protected abstract ns i(q qVar);

    static /* synthetic */ void a(n nVar, int i, bed bed) {
        if (bed != null) {
            x.i(nVar.getTag(), "resType = %d, subType = %d, res.Oper = %d", Integer.valueOf(i), Integer.valueOf(bed.wMK), Integer.valueOf(bed.wsu));
            if (bed.wQK != null) {
                x.i(nVar.getTag(), "resource.Info.FileFlag %d ", Integer.valueOf(bed.wQK.wQV));
            }
            if (b.Cd(bed.wsu)) {
                x.i(nVar.getTag(), "just do nothing");
                return;
            }
            if (b.Ce(bed.wsu)) {
                x.i(nVar.getTag(), "do cache");
                c.vnr.b(i, bed, false);
            }
            if (b.Cf(bed.wsu)) {
                x.i(nVar.getTag(), "do decrypt");
                c.vnr.a(i, bed, false, false);
            }
            if (b.Cg(bed.wsu)) {
                x.i(nVar.getTag(), "do delete");
                c.vnr.a(i, bed, false);
            }
        }
    }

    public static void a(a aVar) {
        vnY.put(39, aVar);
    }

    public n() {
        for (int i : i.vnz) {
            a aVar = (a) vnY.get(i);
            if (aVar == null || !aVar.nu(i)) {
                bej bej = new bej();
                bej.kzz = i;
                this.vnX.add(bej);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.d(getTag(), "before dispatch");
        return a(eVar, cai(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ns i4 = i(qVar);
            String tag = getTag();
            String str2 = "response.Res.size() = %s";
            Object[] objArr = new Object[1];
            objArr[0] = bi.cC(i4.wdu) ? "null" : String.valueOf(i4.wdu.size());
            x.i(tag, str2, objArr);
            if (!bi.cC(i4.wdu)) {
                final List list = i4.wdu;
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    public final void run() {
                        for (bei bei : list) {
                            String tag = n.this.getTag();
                            String str = "resType(%d) responses.size() = %s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(bei.kzz);
                            objArr[1] = bi.cC(bei.wQY) ? "null" : String.valueOf(bei.wQY.size());
                            x.i(tag, str, objArr);
                            if (!bi.cC(bei.wQY)) {
                                Iterator it = bei.wQY.iterator();
                                while (it.hasNext()) {
                                    n.a(n.this, bei.kzz, (bed) it.next());
                                }
                            }
                        }
                    }
                }, "NetSceneCheckResUpdate-ResponseHandlingThread");
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
