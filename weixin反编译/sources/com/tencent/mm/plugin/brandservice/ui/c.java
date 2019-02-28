package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.protocal.c.jr;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c extends com.tencent.mm.ui.base.sortview.b {
    protected int itU;
    protected String kKX;
    protected int kKZ;
    private List<a> kLc = new ArrayList();
    private int kLd;
    private boolean kLe;
    protected boolean kLf;
    protected boolean kLg;
    int kLh;
    protected long[] kLi;
    protected b kLj;

    protected static class a {
        public int count;
        public long foX;
        public int hGC;
        public List<String> kLk;
        public List<jr> kLl;
        public boolean kLm;
        public boolean kLn;
        public List<jm> kLo;

        protected a() {
        }
    }

    public interface b {
        void a(c cVar, com.tencent.mm.ui.base.sortview.a aVar, int i, String str, int i2, int i3);
    }

    public c(Context context) {
        super(context);
        p(true, true);
        this.kLe = true;
        c(1);
    }

    public void c(String str, List<jm> list) {
        this.kLc.clear();
        this.ysB.clear();
        ah.y(this.ysC);
        this.kLd = 0;
        this.kKX = str;
        if (list != null) {
            this.kLh = (int) (System.currentTimeMillis() / 1000);
            for (int i = 0; i < list.size(); i++) {
                jm jmVar = (jm) list.get(i);
                if (!(jmVar == null || jmVar.nmz == null || jmVar.nmz.size() <= 0)) {
                    a a = a(jmVar);
                    this.kLd += a(a);
                    this.kLc.add(a);
                    x.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", Long.valueOf(a.foX), Integer.valueOf(a.count), Integer.valueOf(this.kLd));
                }
            }
            asV();
        }
        ah.y(this.ysC);
    }

    private a a(jm jmVar) {
        a aVar = new a();
        aVar.kLo = new LinkedList();
        aVar.kLo.add(jmVar);
        aVar.foX = jmVar.vWt;
        aVar.count = jmVar.nmz.size();
        aVar.hGC = jmVar.vWu;
        aVar.kLl = new LinkedList();
        aVar.kLl.addAll(jmVar.nmz);
        aVar.kLk = jmVar.vWv;
        aVar.kLm = this.kLg;
        boolean z = this.kLf && aVar.hGC != 0;
        aVar.kLn = z;
        return aVar;
    }

    public void a(jm jmVar, boolean z) {
        if ((this.kLe && jmVar == null) || jmVar.nmz == null) {
            x.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
            return;
        }
        if (isEmpty()) {
            this.kLh = (int) (System.currentTimeMillis() / 1000);
        }
        a bO = bO(jmVar.vWt);
        if (bO != null) {
            if (bO.kLl == null) {
                bO.kLl = new LinkedList();
            }
            bO.kLl.addAll(jmVar.nmz);
            if (bO.kLo == null) {
                bO.kLo = new LinkedList();
            }
            bO.kLo.add(jmVar);
            bO.count += jmVar.nmz.size();
            this.kLd += jmVar.nmz.size();
        } else if (z) {
            this.kLc.add(a(jmVar));
            asV();
        } else {
            x.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", Long.valueOf(jmVar.vWt));
            return;
        }
        ah.y(this.ysC);
    }

    final a bO(long j) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.kLc.size()) {
                i = -1;
                break;
            } else if (((a) this.kLc.get(i)).foX == j) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i >= 0) {
            return (a) this.kLc.get(i);
        }
        return null;
    }

    protected final a nK(int i) {
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i3 >= this.kLc.size()) {
                    break;
                }
                a aVar = (a) this.kLc.get(i3);
                if (i < i4 + a(aVar)) {
                    return aVar;
                }
                i2 = i3 + 1;
            }
        }
        return null;
    }

    protected final jm nL(int i) {
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.kLc.size()) {
                a aVar = (a) this.kLc.get(i3);
                int a = a(aVar);
                i4 += a;
                if (i < i4) {
                    i4 = (aVar.kLm ? 1 : 0) + (i4 - a);
                    while (i2 < aVar.kLo.size()) {
                        jm jmVar = (jm) aVar.kLo.get(i2);
                        i4 += jmVar.nmz.size();
                        if (i < i4) {
                            return jmVar;
                        }
                        i2++;
                    }
                } else {
                    i3++;
                }
            }
        }
        return null;
    }

    private static int a(a aVar) {
        int i = 1;
        if (aVar == null) {
            return 0;
        }
        int i2 = (aVar.kLm ? 1 : 0) + aVar.count;
        if (!aVar.kLn) {
            i = 0;
        }
        return i2 + i;
    }

    private synchronized void asV() {
        boolean z = true;
        synchronized (this) {
            int i;
            a aVar;
            Map hashMap = new HashMap();
            for (i = 0; i < this.kLc.size(); i++) {
                aVar = (a) this.kLc.get(i);
                if (aVar != null) {
                    hashMap.put(Long.valueOf(aVar.foX), aVar);
                }
            }
            this.kLc.clear();
            this.kLd = 0;
            for (long valueOf : this.kLi) {
                aVar = (a) hashMap.get(Long.valueOf(valueOf));
                if (aVar != null) {
                    this.kLc.add(aVar);
                    this.kLd = a(aVar) + this.kLd;
                }
            }
            if (this.kLc.size() > 0) {
                aVar = (a) this.kLc.get(this.kLc.size() - 1);
                if (aVar.kLn == this.kLe) {
                    this.kLd = (aVar.kLn ? -1 : 1) + this.kLd;
                    if (this.kLe) {
                        z = false;
                    }
                    aVar.kLn = z;
                }
            }
            hashMap.clear();
        }
    }

    public final void p(boolean z, boolean z2) {
        this.kLg = z;
        this.kLf = z2;
    }

    public final void lO(int i) {
        this.itU = i;
    }

    public final void nM(int i) {
        this.kKZ = i;
    }

    public final void c(long... jArr) {
        if (jArr != null && jArr.length > 0) {
            this.kLi = jArr;
        }
    }

    public int getCount() {
        return this.kLd;
    }

    public void asW() {
        c(null, null);
        this.kLh = 0;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    protected final com.tencent.mm.ui.base.sortview.a nN(int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.kLc.size(); i4++) {
            a aVar = (a) this.kLc.get(i4);
            int a = a(aVar);
            i3 += a;
            if (aVar.kLm && i == i3 - a) {
                jm jmVar = aVar.kLo.size() == 0 ? null : (jm) aVar.kLo.get(0);
                if (jmVar != null) {
                    return new d(jmVar.fpg);
                }
            } else if (aVar.kLn && i == i3 - 1) {
                return new e(null, aVar.foX, aVar.count, this.kKX);
            } else {
                if (i < i3) {
                    i4 = (i - i3) + aVar.count;
                    if (aVar.kLn) {
                        i2 = 1;
                    }
                    i2 += i4;
                    jr jrVar = (jr) aVar.kLl.get(i2);
                    long j = aVar.foX;
                    b bVar = this.kLj;
                    if (jrVar == null) {
                        x.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
                        return null;
                    }
                    com.tencent.mm.ui.base.sortview.a aVar2;
                    if (j == 1) {
                        x.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
                        aVar2 = new a(jrVar);
                    } else {
                        aVar2 = j == 4 ? new g(jrVar) : j == 1073741824 ? new g(jrVar) : new g(jrVar);
                    }
                    if (!(aVar2 instanceof com.tencent.mm.plugin.brandservice.ui.base.a)) {
                        return aVar2;
                    }
                    com.tencent.mm.plugin.brandservice.ui.base.a aVar3 = (com.tencent.mm.plugin.brandservice.ui.base.a) aVar2;
                    aVar3.nR(i2);
                    aVar3.cR(i);
                    aVar3.a(bVar);
                    return aVar2;
                }
            }
        }
        return new g(null);
    }

    protected Object[] nO(int i) {
        Object obj;
        a nK = nK(i);
        jm nL = nL(i);
        if (nL != null) {
            obj = nL.vWw;
        } else {
            String obj2 = "";
        }
        if (nK == null) {
            return null;
        }
        return new Object[]{this, nK.kLk, Integer.valueOf(this.kKZ), obj2};
    }

    public final void a(b bVar) {
        this.kLj = bVar;
    }
}
