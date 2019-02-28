package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends i {
    int roF;
    private RecyclerView roG;
    private b roH;
    Map<Integer, a> roI = new HashMap();
    LinearLayoutManager roJ;
    Set<Integer> roK = new HashSet();

    private class c extends k {
        RecyclerView jTh;
        private LinearLayoutManager roP;
        int roQ = Integer.MAX_VALUE;
        private int roR = -1;
        private int roS = -1;
        private long roT = 0;
        Runnable roU = new Runnable() {
            public final void run() {
                if (c.this.roQ == 1) {
                    c cVar = c.this;
                    x.d("AdLandingCarouselComp", "onDraggin first visible " + c.this.roJ.fa() + ", last visible " + c.this.roJ.fb());
                    c.a(c.this);
                    c.this.jTh.postDelayed(c.this.roU, 100);
                }
            }
        };

        public c(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            this.jTh = recyclerView;
            this.roP = linearLayoutManager;
        }

        private void bxJ() {
            this.jTh.getHandler().removeCallbacks(this.roU);
        }

        public final void e(RecyclerView recyclerView, int i) {
            super.e(recyclerView, i);
            if (i != this.roQ) {
                if (i != 1) {
                    bxJ();
                }
                switch (i) {
                    case 0:
                        c.a(c.this);
                        if (this.roQ == 2) {
                            int fa = this.roP.fa();
                            int fb = this.roP.fb();
                            if (fb >= this.roR) {
                                if (fa > this.roS) {
                                    g(this.roS, fa, System.currentTimeMillis() - this.roT);
                                    break;
                                }
                            }
                            g(fb, this.roR, System.currentTimeMillis() - this.roT);
                            break;
                        }
                        break;
                    case 1:
                        bxJ();
                        this.jTh.postDelayed(this.roU, 100);
                        break;
                    case 2:
                        this.roR = this.roP.fa();
                        this.roS = this.roP.fb();
                        this.roT = System.currentTimeMillis();
                        break;
                }
            }
            this.roQ = i;
            x.d("AdLandingCarouselComp", "state " + i);
        }

        public final void c(RecyclerView recyclerView, int i, int i2) {
            super.c(recyclerView, i, i2);
        }

        private void g(int i, int i2, long j) {
            int i3 = 1;
            x.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
            c cVar = c.this;
            if (i > i2) {
                x.e("AdLandingCarouselComp", "wtf start > end");
                return;
            }
            cVar.dB(i, i2);
            if (i2 != i) {
                i3 = (i2 - i) + 1;
            }
            long j2 = j / ((long) i3);
            while (i <= i2) {
                a aVar = (a) cVar.roI.get(Integer.valueOf(i));
                if (aVar != null && aVar.isVisible) {
                    aVar.isVisible = false;
                    aVar.roL = 0;
                    aVar.time += j2;
                }
                i++;
            }
        }
    }

    private class a {
        int count;
        boolean isVisible;
        long roL;
        long time;

        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        final void bxI() {
            if (this.isVisible) {
                this.isVisible = false;
                if (this.roL > 0) {
                    this.time += System.currentTimeMillis() - this.roL;
                    this.roL = 0;
                }
            }
        }
    }

    private class b extends android.support.v7.widget.RecyclerView.a<a> {

        class a extends t {
            private f roN;

            public a(View view, f fVar) {
                super(view);
                this.roN = fVar;
            }
        }

        private b() {
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            f fVar = new f(viewGroup.getContext(), viewGroup);
            return new a(fVar.getView(), fVar);
        }

        public final /* synthetic */ void a(t tVar, int i) {
            a aVar = (a) tVar;
            s sVar = (s) ((m) c.this.rpm).rmy.get(i);
            if (sVar instanceof p) {
                aVar.roN.a((p) sVar);
                if (!aVar.roN.rpf) {
                    c.this.roK.add(Integer.valueOf(i));
                }
                View view = aVar.roN.contentView;
                int paddingRight = view.getPaddingRight();
                if (i != ((m) c.this.rpm).rmy.size() - 1) {
                    paddingRight += c.this.roF;
                }
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + c.this.roF, paddingRight, view.getPaddingBottom() + c.this.roF);
            }
        }

        public final int getItemCount() {
            return ((m) c.this.rpm).rmy.size();
        }
    }

    static /* synthetic */ void a(c cVar) {
        cVar.bxH();
        int fa = cVar.roJ.fa();
        int fb = cVar.roJ.fb();
        for (Entry entry : cVar.roI.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < fa || ((Integer) entry.getKey()).intValue() > fb) {
                ((a) entry.getValue()).bxI();
            }
        }
    }

    public c(Context context, m mVar, ViewGroup viewGroup) {
        super(context, mVar, viewGroup);
        this.roF = com.tencent.mm.bu.a.fromDPToPix(context, 12);
    }

    protected final int bkr() {
        return g.qMQ;
    }

    public final View bxG() {
        this.roG = (RecyclerView) this.contentView.findViewById(f.qJk);
        this.roG.setBackgroundColor(((m) this.rpm).backgroundColor);
        Iterator it = ((m) this.rpm).rmy.iterator();
        int i = 0;
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar instanceof p) {
                p pVar = (p) sVar;
                int i2 = ((int) ((sVar.rmP + sVar.rmQ) + pVar.height)) + (this.roF << 1);
                if (i <= i2) {
                    i = i2;
                }
            }
            i = i;
        }
        LayoutParams layoutParams = this.roG.getLayoutParams();
        layoutParams.height = i;
        this.roG.setLayoutParams(layoutParams);
        this.roH = new b();
        this.roG.a(this.roH);
        this.roJ = new LinearLayoutManager();
        this.roJ.setOrientation(0);
        this.roG.a(this.roJ);
        this.roG.a(new c(this.roG, this.roJ));
        this.roG.setNestedScrollingEnabled(false);
        this.roG.Ub = true;
        return this.contentView;
    }

    private void bxH() {
        if (this.roJ != null) {
            dB(this.roJ.fa(), this.roJ.fb());
        }
    }

    final void dB(int i, int i2) {
        while (i <= i2) {
            a aVar = (a) this.roI.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a();
                this.roI.put(Integer.valueOf(i), aVar);
            }
            if (!aVar.isVisible) {
                aVar.isVisible = true;
                aVar.roL = System.currentTimeMillis();
                aVar.count++;
            }
            i++;
        }
    }

    public final void bxr() {
        super.bxr();
        bxH();
    }

    public final void bxs() {
        super.bxs();
        if (this.roJ != null) {
            int fa = this.roJ.fa();
            int fb = this.roJ.fb();
            for (int i = fa; i <= fb; i++) {
                a aVar = (a) this.roI.get(Integer.valueOf(i));
                if (aVar != null) {
                    aVar.bxI();
                }
            }
        }
    }

    public final boolean s(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.T(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        try {
            Map map = this.roI;
            Set set = this.roK;
            this.roK = new HashSet();
            this.roI = new HashMap();
            for (Entry entry : map.entrySet()) {
                s sVar = (s) ((m) this.rpm).rmy.get(((Integer) entry.getKey()).intValue());
                if (!sVar.rna && (sVar instanceof p)) {
                    p pVar = (p) sVar;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", ((s) ((m) this.rpm).rmy.get(((Integer) entry.getKey()).intValue())).rmN);
                    jSONObject2.put("exposureCount", ((a) entry.getValue()).count);
                    jSONObject2.put("stayTime", ((a) entry.getValue()).time);
                    if (set.contains(entry.getKey())) {
                        String VF = ac.VF(pVar.rmC);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("urlMd5", VF);
                        jSONObject3.put("needDownload", 1);
                        jSONObject2.put("imgUrlInfo", jSONObject3);
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            return true;
        } catch (Throwable e) {
            x.e("AdLandingCarouselComp", bi.i(e));
            return false;
        }
    }
}
