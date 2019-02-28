package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class b {
    private RecyclerView jTh;
    public Map<Integer, a> roI = new HashMap();
    private LinearLayoutManager roJ;
    public b rsA;
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b rsB;

    public interface b {
        void a(int i, b bVar);

        void onDestroy();

        void xu(int i);

        boolean xv(int i);
    }

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
                    b.this.byi();
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
                        b.this.byi();
                        if (this.roQ == 2) {
                            int fa = this.roP.fa();
                            int fb = this.roP.fb();
                            if (fb >= this.roR) {
                                if (fa > this.roS) {
                                    dC(this.roS, fa);
                                    break;
                                }
                            }
                            dC(fb, this.roR);
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
        }

        public final void c(RecyclerView recyclerView, int i, int i2) {
            super.c(recyclerView, i, i2);
        }

        private void dC(int i, int i2) {
            b bVar = b.this;
            if (i <= i2) {
                bVar.dB(i, i2);
                while (i <= i2) {
                    a aVar = (a) bVar.roI.get(Integer.valueOf(i));
                    if (aVar != null && aVar.rlH) {
                        bVar.rsA.xu(i);
                        aVar.bxI();
                    }
                    i++;
                }
            }
        }
    }

    private class a {
        public boolean rlH;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        final void bxI() {
            if (this.rlH) {
                this.rlH = false;
            }
        }
    }

    public b(RecyclerView recyclerView, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar) {
        this.jTh = recyclerView;
        this.rsB = bVar;
        if (recyclerView.TV == null || !(recyclerView.TV instanceof LinearLayoutManager)) {
            throw new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
        } else if (recyclerView.fn() == null || !(recyclerView.fn() instanceof b)) {
            throw new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
        } else {
            this.rsA = (b) recyclerView.fn();
            this.roJ = (LinearLayoutManager) recyclerView.TV;
            this.jTh.a(new c(recyclerView, (LinearLayoutManager) recyclerView.TV));
        }
    }

    public final void byi() {
        bxH();
        int fa = this.roJ.fa();
        int fb = this.roJ.fb();
        for (Entry entry : this.roI.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < fa || ((Integer) entry.getKey()).intValue() > fb) {
                if (((a) entry.getValue()).rlH) {
                    this.rsA.xu(((Integer) entry.getKey()).intValue());
                    ((a) entry.getValue()).bxI();
                }
            } else if (((a) entry.getValue()).rlH && !this.rsA.xv(((Integer) entry.getKey()).intValue())) {
                this.rsA.xu(((Integer) entry.getKey()).intValue());
                ((a) entry.getValue()).bxI();
            }
        }
    }

    public final void bxH() {
        if (this.roJ != null) {
            int fa = this.roJ.fa();
            int fb = this.roJ.fb();
            if (fa != fb || fa != -1) {
                dB(fa, fb);
            }
        }
    }

    final void dB(int i, int i2) {
        while (i <= i2) {
            a aVar = (a) this.roI.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a();
                this.roI.put(Integer.valueOf(i), aVar);
            }
            if (!aVar.rlH && this.rsA.xv(i)) {
                this.rsA.a(i, this);
                if (!aVar.rlH) {
                    aVar.rlH = true;
                }
            }
            i++;
        }
    }

    public final void byj() {
        if (this.roJ != null) {
            int fa = this.roJ.fa();
            int fb = this.roJ.fb();
            if (fa != fb || fa != -1) {
                for (int i = fa; i <= fb; i++) {
                    a aVar = (a) this.roI.get(Integer.valueOf(i));
                    if (aVar != null && aVar.rlH) {
                        this.rsA.xu(i);
                        aVar.bxI();
                    }
                }
            }
        }
    }
}
