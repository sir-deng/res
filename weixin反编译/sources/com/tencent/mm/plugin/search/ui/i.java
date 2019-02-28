package com.tencent.mm.plugin.search.ui;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.f;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.R;

public final class i extends b implements com.tencent.mm.plugin.fts.d.i.b {
    int qhJ = 1;
    private ag qhu = new ag(Looper.getMainLooper());
    private List<com.tencent.mm.plugin.fts.d.i> qiB;
    private f qiC = new f();
    private b qiD = null;
    private long qiE;
    private long qiF;
    private long qiG;
    private long qiH;
    private ag qiI = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (!i.this.qir && i.this.getCount() > 0) {
                        c.bqz().aOa();
                        n.qWB.start();
                        i.this.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private int qiJ = -1;
    boolean qiK;
    private boolean qiL;
    private boolean qij;
    private boolean qir;
    boolean qit;

    private class a implements Runnable {
        private String fEe;
        private com.tencent.mm.plugin.fts.d.i qiN;

        a(com.tencent.mm.plugin.fts.d.i iVar, String str) {
            this.fEe = str;
            this.qiN = iVar;
        }

        public final void run() {
            int i;
            if (!i.this.qiK && ((com.tencent.mm.plugin.fts.d.i) i.this.qiB.get(i.this.qiB.size() - 1)).getType() == this.qiN.getType()) {
                i.this.qiK = true;
            }
            int i2 = 0;
            Iterator it = i.this.qiB.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = ((com.tencent.mm.plugin.fts.d.i) it.next()).qw(i);
            }
            i.this.wh(i);
            i.this.notifyDataSetChanged();
            i.this.H(i, i.this.qiK);
            if (i.this.qiK) {
                i.this.qiC.hMn = System.currentTimeMillis();
            }
        }
    }

    public interface b {
        void bqU();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(com.tencent.mm.plugin.search.ui.c r7, int r8, com.tencent.mm.plugin.search.ui.i.b r9) {
        /*
        r6 = this;
        r0 = 1;
        r6.<init>(r7);
        r1 = 0;
        r6.qiD = r1;
        r6.qhJ = r0;
        r1 = new com.tencent.mm.plugin.search.ui.i$1;
        r2 = android.os.Looper.getMainLooper();
        r1.<init>(r2);
        r6.qiI = r1;
        r1 = new com.tencent.mm.sdk.platformtools.ag;
        r2 = android.os.Looper.getMainLooper();
        r1.<init>(r2);
        r6.qhu = r1;
        r1 = -1;
        r6.qiJ = r1;
        r1 = new com.tencent.mm.bb.f;
        r1.<init>();
        r6.qiC = r1;
        r1 = new java.util.HashSet;
        r1.<init>();
        r2 = 16;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 32;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 48;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 64;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 80;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 96;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = com.tencent.mm.kernel.g.Do();
        r2 = r2.CF();
        if (r2 == 0) goto L_0x00dc;
    L_0x0080:
        r2 = new com.tencent.mm.f.a.ph;
        r2.<init>();
        r3 = com.tencent.mm.sdk.b.a.xmy;
        r3.m(r2);
        r3 = com.tencent.mm.y.c.c.IL();
        r4 = "100193";
        r3 = r3.fp(r4);
        r4 = r3.isValid();
        if (r4 == 0) goto L_0x00dc;
    L_0x009b:
        r4 = "1";
        r3 = r3.civ();
        r5 = "isOpenLocalSearch";
        r3 = r3.get(r5);
        r3 = r4.equals(r3);
        if (r3 == 0) goto L_0x00dc;
    L_0x00af:
        r2 = r2.fHV;
        r2 = r2.fHX;
        if (r2 == 0) goto L_0x00dc;
    L_0x00b5:
        if (r0 == 0) goto L_0x00c0;
    L_0x00b7:
        r0 = 144; // 0x90 float:2.02E-43 double:7.1E-322;
        r0 = java.lang.Integer.valueOf(r0);
        r1.add(r0);
    L_0x00c0:
        r0 = com.tencent.mm.modelappbrand.a.IZ();
        if (r0 == 0) goto L_0x00cf;
    L_0x00c6:
        r0 = 208; // 0xd0 float:2.91E-43 double:1.03E-321;
        r0 = java.lang.Integer.valueOf(r0);
        r1.add(r0);
    L_0x00cf:
        r0 = r6.getContext();
        r0 = com.tencent.mm.plugin.fts.d.h.a(r1, r0, r6, r8);
        r6.qiB = r0;
        r6.qiD = r9;
        return;
    L_0x00dc:
        r0 = 0;
        goto L_0x00b5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.i.<init>(com.tencent.mm.plugin.search.ui.c, int, com.tencent.mm.plugin.search.ui.i$b):void");
    }

    protected final com.tencent.mm.plugin.fts.d.a.b qx(int i) {
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        for (com.tencent.mm.plugin.fts.d.i qx : this.qiB) {
            bVar = qx.qx(i);
            if (bVar != null) {
                break;
            }
        }
        com.tencent.mm.plugin.fts.d.a.b bVar2 = bVar;
        if (bVar2 != null) {
            int i2;
            LinkedList linkedList = new LinkedList();
            for (com.tencent.mm.plugin.fts.d.i qx2 : this.qiB) {
                linkedList.addAll(qx2.aNU());
            }
            for (int size = linkedList.size() - 1; size >= 0; size--) {
                if (i > ((Integer) linkedList.get(size)).intValue()) {
                    i2 = i - size;
                    break;
                }
            }
            i2 = i;
            bVar2.mVk = i2;
            bVar2.pageType = 1;
        }
        if (bVar2 == null) {
            x.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", Integer.valueOf(getCount()), Integer.valueOf(i));
        }
        return bVar2;
    }

    protected final void bqD() {
        this.qij = false;
        this.qit = false;
        this.qiJ = -1;
        this.qiK = false;
        this.qiC.reset();
        this.qhJ = 1;
        this.qiE = 0;
        this.qiF = 0;
        this.qiG = 0;
        this.qiH = 0;
        HashSet hashSet = new HashSet();
        hashSet.add("filehelper");
        boolean GF = q.GF();
        if (!GF) {
            GF = bi.getInt(g.Af().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!GF) {
            x.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
            hashSet.add("22");
            hashSet.add("23");
        }
        if (!com.tencent.mm.modelappbrand.a.IZ()) {
            hashSet.add("61");
        }
        x.d("MicroMsg.FTS.FTSMainAdapter", "summerqq doSearch blockSet[%d]", Integer.valueOf(hashSet.size()));
        d(hashSet);
    }

    public final void finish() {
        if (!this.qij) {
            this.qij = true;
            if (!this.qit) {
                e.a(this.fEe, false, aNW(), 0, this.qiC);
            }
        }
        if (!(this.qit || this.qiL)) {
            com.tencent.mm.bb.g.d(this.fEe, this.qhJ, 3, 3);
        }
        this.qiC.reset();
        super.finish();
    }

    protected final void clearCache() {
        super.clearCache();
        for (com.tencent.mm.plugin.fts.d.i iVar : this.qiB) {
            iVar.aNT();
            iVar.abi();
        }
    }

    public final void stopSearch() {
        this.qiI.removeMessages(1);
        super.stopSearch();
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        for (com.tencent.mm.plugin.fts.d.i a : this.qiB) {
            z = a.a(view, bVar, z);
            if (z) {
                break;
            }
        }
        if (bVar.mVr) {
            this.qiL = true;
            x.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", Integer.valueOf(bVar.mVj), Integer.valueOf(bVar.mUl), Integer.valueOf(bVar.mVk), Integer.valueOf(bVar.mVl), bVar.mVm, Long.valueOf(bVar.mVn));
            if (!this.qij) {
                e.a(this.fEe, true, aNW(), 0, this.qiC);
                this.qij = true;
            }
            if (!bi.oN(this.fEe)) {
                com.tencent.mm.bb.g.d(this.fEe, this.qhJ, 1, 3);
            }
            e.a(bVar, this.qiC);
            return true;
        }
        if (bVar instanceof com.tencent.mm.plugin.search.ui.a.g) {
            this.qit = true;
            if (!bi.oN(this.fEe)) {
                com.tencent.mm.bb.g.d(this.fEe, this.qhJ, 1, 3);
            }
            e.a(bVar, this.qiC);
        }
        return false;
    }

    public final void a(com.tencent.mm.plugin.fts.d.i iVar, String str) {
        com.tencent.mm.plugin.fts.d.c cVar = (com.tencent.mm.plugin.fts.d.c) iVar;
        if (str.equals(this.fEe)) {
            d(cVar.mRI);
        }
        if (cVar.aNV() > 0 && this.qiE == 0) {
            this.qiE = System.currentTimeMillis() - this.qhT;
            e.n(9, this.qiE);
            x.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", Long.valueOf(this.qiE));
        }
        switch (cVar.getType()) {
            case 16:
                if (this.qiF == 0) {
                    this.qiF = System.currentTimeMillis() - this.qhT;
                    x.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", Long.valueOf(this.qiF));
                    e.n(0, this.qiF);
                    break;
                }
                break;
            case 32:
                if (this.qiG == 0) {
                    this.qiG = System.currentTimeMillis() - this.qhT;
                    x.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", Long.valueOf(this.qiG));
                    e.n(3, this.qiG);
                    break;
                }
                break;
            case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (this.qiH == 0) {
                    this.qiH = System.currentTimeMillis() - this.qhT;
                    x.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", Long.valueOf(this.qiH));
                    e.n(6, this.qiH);
                    break;
                }
                break;
        }
        f fVar = this.qiC;
        for (com.tencent.mm.plugin.fts.d.i.a aVar : cVar.mUm) {
            switch (aVar.hMM) {
                case -15:
                    fVar.hMC = aVar.mUI.size();
                    break;
                case -11:
                    fVar.hMD = aVar.mUI.size();
                    break;
                case -8:
                    fVar.hMu = aVar.mUI.size();
                    break;
                case -7:
                    fVar.hMx = aVar.mUI.size();
                    break;
                case -6:
                    fVar.hMz = aVar.mUI.size();
                    break;
                case -5:
                    fVar.hMB = aVar.mUI.size();
                    break;
                case -4:
                    fVar.hMv = aVar.mUI.size();
                    break;
                case -3:
                    fVar.hMw = aVar.mUI.size();
                    break;
                case -2:
                    fVar.hMy = aVar.mUI.size();
                    break;
                case -1:
                    fVar.hMA = aVar.mUI.size();
                    break;
                default:
                    break;
            }
        }
        new a(iVar, str).run();
    }

    private void d(HashSet<String> hashSet) {
        this.qiJ++;
        if (this.qiJ < this.qiB.size()) {
            ((com.tencent.mm.plugin.fts.d.i) this.qiB.get(this.qiJ)).a(this.fEe, this.qhu, (HashSet) hashSet);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (absListView.getLastVisiblePosition() == getCount() && this.qiK) {
            this.qhJ = 2;
            if (this.qiD != null) {
                this.qiD.bqU();
            }
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.qir = true;
            h.aOe().aNY();
            n.qWB.pause();
            return;
        }
        this.qir = false;
        if (!h.aOe().aNZ()) {
            this.qiI.removeMessages(1);
            this.qiI.sendEmptyMessageDelayed(1, 200);
        }
    }

    protected final int aNW() {
        int i = 0;
        Iterator it = this.qiB.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((com.tencent.mm.plugin.fts.d.i) it.next()).aNW() + i2;
        }
    }
}
