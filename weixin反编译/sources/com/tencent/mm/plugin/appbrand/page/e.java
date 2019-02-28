package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e extends l {
    private p jIA = this.isX.ajz();
    private Map<String, p> jIB = new HashMap();
    private LinkedList<b> jIC = new LinkedList();
    private String jIv;
    private LinearLayout jIw;
    private FrameLayout jIx;
    public c jIy;
    private FrameLayout jIz;

    private static final class a extends f {
        private static final int CTRL_INDEX = 390;
        private static final String NAME = "onTabItemTap";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static abstract class b implements Runnable {
        boolean Mu;
        private boolean jIG;

        public abstract void aju();

        private b() {
            this.jIG = false;
            this.Mu = false;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public void run() {
            boolean z = (this.jIG || this.Mu) ? false : true;
            if (z) {
                this.jIG = true;
                aju();
            }
        }
    }

    public e(Context context, n nVar) {
        super(context, nVar);
    }

    protected final View aeG() {
        if (this.jIw == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LayoutParams(-1, -1));
            this.jIx = new FrameLayout(getContext());
            this.jIx.setLayoutParams(new LayoutParams(-1, -2));
            this.jIz = new FrameLayout(getContext());
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.jIz.setLayoutParams(layoutParams);
            this.jIy = ajs();
            if ("top".equals(this.isX.iuk.isT.iPG.iPR)) {
                linearLayout.addView(this.jIx);
                linearLayout.addView(this.jIy);
                linearLayout.addView(this.jIz);
            } else {
                linearLayout.addView(this.jIx);
                linearLayout.addView(this.jIz);
                linearLayout.addView(this.jIy);
            }
            this.jIw = linearLayout;
        }
        return this.jIw;
    }

    private c ajs() {
        c cVar = new c(getContext());
        final com.tencent.mm.plugin.appbrand.config.a.e eVar = this.isX.iuk.isT.iPG;
        cVar.kah = eVar.iPR;
        cVar.g(eVar.hdx, eVar.iPS, eVar.iPT, eVar.iPU);
        Iterator it = eVar.fCP.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.appbrand.config.a.f fVar = (com.tencent.mm.plugin.appbrand.config.a.f) it.next();
            String str = fVar.url;
            String str2 = fVar.text;
            String str3 = fVar.fED;
            String str4 = fVar.iPV;
            a aVar = new a();
            try {
                aVar.uX = c.vw(str3);
                aVar.kau = c.vw(str4);
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandPageTabBar", e.getMessage());
            }
            aVar.kav = str2;
            aVar.mUrl = str;
            if (aVar.kav == null && (aVar.uX == null || aVar.kau == null)) {
                x.e("MicroMsg.AppBrandPageTabBar", "illegal data");
            } else {
                View view = (ViewGroup) LayoutInflater.from(cVar.getContext()).inflate(h.izO, cVar.kaf, false);
                cVar.a(view, aVar);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        c.this.mj(c.this.kaf.indexOfChild(view));
                        c.c(c.this);
                    }
                });
                cVar.kak.add(aVar);
                cVar.kaf.addView(view);
            }
        }
        cVar.kam = new com.tencent.mm.plugin.appbrand.widget.c.b() {
            public final void R(int i, String str) {
                e.this.isX.uk(str);
                Map hashMap = new HashMap();
                hashMap.put("pagePath", str);
                hashMap.put("text", ((com.tencent.mm.plugin.appbrand.config.a.f) eVar.fCP.get(i)).text);
                hashMap.put("index", Integer.valueOf(i));
                new a().a(e.this.aeO()).v(hashMap).afI();
            }
        };
        return cVar;
    }

    public final void loadUrl(final String str) {
        if (!str.equals(this.jIv)) {
            int vx = this.jIy.vx(str);
            if (vx >= 0) {
                this.jIv = str;
                this.jIy.mj(vx);
                if (this.jIB.get(l.vh(str)) == null) {
                    final p uh = uh(l.vh(str));
                    aeM();
                    final Runnable anonymousClass2 = new b() {
                        public final void aju() {
                            e.this.ui(str);
                            e.this.isX.ajA();
                        }
                    };
                    final long currentTimeMillis = System.currentTimeMillis();
                    uh.a(new g() {
                        public final void onReady() {
                            uh.b((g) this);
                            anonymousClass2.run();
                            long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                            x.i("MicroMsg.AppBrandMultiplePage", "Tab page onReady received, time: %d", Long.valueOf(currentTimeMillis));
                        }
                    });
                    if (this.jIB.size() > 1) {
                        this.jIC.add(anonymousClass2);
                        postDelayed(anonymousClass2, 500);
                    }
                    uh.sl(str);
                    return;
                }
                ajt();
                ui(str);
            }
        }
    }

    private synchronized p uh(String str) {
        p pVar;
        if (this.jIA != null) {
            pVar = this.jIA;
            this.jIA = null;
        } else {
            pVar = this.isX.ajz();
        }
        this.jIB.put(str, pVar);
        pVar.aeZ();
        this.jIz.addView(pVar.getContentView(), 0);
        return pVar;
    }

    private void ui(String str) {
        p pVar = (p) this.jIB.get(l.vh(str));
        pVar.getContentView().setVisibility(4);
        p pVar2 = null;
        for (p pVar3 : this.jIB.values()) {
            p pVar32;
            if (pVar32.getContentView().getVisibility() != 0) {
                pVar32 = pVar2;
            }
            pVar2 = pVar32;
        }
        pVar.getContentView().setVisibility(0);
        pVar.jJq.removeView(pVar.jJr.getActionView());
        if (pVar.jJJ != null) {
            pVar.jJJ.addView(pVar.jJr.getActionView(), 0);
        }
        pVar.jJJ = null;
        if (this.jIx.indexOfChild(pVar.jJr.getActionView()) == -1) {
            this.jIx.addView(pVar.jJr.getActionView(), 0);
        }
        if (pVar2 != null) {
            pVar2.getContentView().setVisibility(4);
            this.jIx.removeView(pVar2.jJr.getActionView());
        }
        pVar.agq();
        if (pVar2 != null) {
            pVar2.afQ();
        }
        aeL();
    }

    private void ajt() {
        Iterator it = this.jIC.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            removeCallbacks(bVar);
            bVar.Mu = true;
        }
        this.jIC.clear();
    }

    protected final void aeL() {
        super.aeL();
        boolean acd = this.isX.iuk.isT.iPE.acd();
        aeO().cF(acd);
        if ("top".equals(this.isX.iuk.isT.iPG.iPR) && acd) {
            com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar = (com.tencent.mm.plugin.appbrand.widget.actionbar.b) aeO().jJr;
            if (bVar.kbD) {
                bVar.kbD = false;
                bVar.amX();
            }
        }
    }

    public final boolean sk(String str) {
        return this.jIy.vx(str) != -1;
    }

    public final void aeJ() {
        super.aeJ();
        aeO().agq();
    }

    public final void aeK() {
        super.aeK();
        aeO().afQ();
    }

    protected final void aeI() {
        super.aeI();
        if (this.jIA != null) {
            this.jIA.onDestroy();
        }
        for (p onDestroy : this.jIB.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void b(String str, String str2, int[] iArr) {
        if (this.jIA != null && l.c(iArr, this.jIA.hashCode())) {
            this.jIA.j(str, str2, 0);
        }
        for (p pVar : this.jIB.values()) {
            if (l.c(iArr, pVar.hashCode())) {
                pVar.j(str, str2, 0);
            }
        }
    }

    public final void cleanup() {
        super.cleanup();
        if (this.jIA != null) {
            this.jIA.cleanup();
        }
        for (p cleanup : this.jIB.values()) {
            cleanup.cleanup();
        }
        ajt();
    }

    public final synchronized p aeO() {
        p pVar;
        if (this.jIA != null) {
            pVar = this.jIA;
        } else {
            pVar = (p) this.jIB.get(l.vh(this.jIv));
        }
        return pVar;
    }

    public final String aeH() {
        return this.jIv;
    }
}
