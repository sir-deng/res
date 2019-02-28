package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.game.page.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.p.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class n extends FrameLayout {
    public e iuk;
    public LinkedList<l> jIM = new LinkedList();
    private LinkedList<l> jIN = new LinkedList();
    private p jIO;
    public volatile com.tencent.mm.plugin.appbrand.report.a.a jIP;
    public boolean jIQ;
    private boolean jIR = false;
    public a jIS;
    String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.n$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$url;

        public AnonymousClass1(String str) {
            this.val$url = str;
        }

        public final void run() {
            n.a(n.this, this.val$url, aa.APP_LAUNCH);
        }
    }

    public interface a {
        void YP();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.n$11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String val$url;

        public AnonymousClass11(String str) {
            this.val$url = str;
        }

        public final void run() {
            n.a(n.this, this.val$url, aa.NAVIGATE_TO);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.n$18 */
    class AnonymousClass18 implements Runnable {
        final /* synthetic */ l jIW;

        AnonymousClass18(l lVar) {
            this.jIW = lVar;
        }

        public final void run() {
            n.a(n.this, n.this.jIM.indexOf(this.jIW) + 1);
        }
    }

    static /* synthetic */ void a(n nVar, int i) {
        if (nVar.jIM.size() <= 1) {
            c.a(nVar.mAppId, c.c.BACK);
            nVar.iuk.close();
            return;
        }
        long Wy = bi.Wy();
        if (i <= 0) {
            i = 1;
        }
        if (i >= nVar.jIM.size()) {
            i = nVar.jIM.size() - 1;
        }
        l lVar = (l) nVar.jIM.getFirst();
        l lVar2 = (l) nVar.jIM.get(i);
        nVar.a(lVar, lVar2);
        nVar.a(lVar2, lVar, aa.NAVIGATE_BACK);
        nVar.jIP.h(bi.Wy() - Wy, 4);
        nVar.jIP.a(lVar2.aeO(), lVar.aeO(), aa.NAVIGATE_BACK);
    }

    static /* synthetic */ void a(n nVar, final l lVar, boolean z, final boolean z2) {
        if (lVar != null) {
            if (z2) {
                nVar.jIM.remove(lVar);
            }
            lVar.aeK();
            Runnable anonymousClass6 = new Runnable() {
                public final void run() {
                    lVar.hide();
                    if (z2) {
                        n.this.a(lVar);
                    }
                }
            };
            if (z) {
                ObjectAnimator.ofFloat(lVar, "translationX", new float[]{0.0f, -(((float) lVar.getWidth()) * 0.25f)}).setDuration(250);
                ObjectAnimator.ofFloat(lVar, "translationX", new float[]{0.0f}).setDuration(0);
                Animator animatorSet = new AnimatorSet();
                animatorSet.playSequentially(new Animator[]{r1, r2});
                nVar.a(animatorSet, anonymousClass6);
                return;
            }
            anonymousClass6.run();
        }
    }

    static /* synthetic */ void a(n nVar, String str, final aa aaVar) {
        boolean z = true;
        x.i("MicroMsg.AppBrandPageContainer", "navigateTo: %s", str);
        if (bi.oN(str)) {
            str = nVar.iuk.isT.acc();
        }
        if (str.startsWith("?")) {
            str = nVar.iuk.isT.acc() + str;
        }
        x.i("MicroMsg.AppBrandPageContainer", "navigateTo: %s, fixed", str);
        if (aaVar == aa.AUTO_RE_LAUNCH || aaVar == aa.APP_LAUNCH) {
            if (str.startsWith(nVar.iuk.isT.acc())) {
                z = false;
            }
            nVar.jIQ = z;
        } else if (aaVar == aa.REDIRECT_TO && str.startsWith(nVar.iuk.isT.acc())) {
            nVar.jIQ = false;
        }
        if (aaVar != aa.SWITCH_TAB) {
            nVar.iuk.itk.a(str, new com.tencent.mm.plugin.appbrand.p.a() {
                public final void a(p.c cVar) {
                    if (p.c.CANCEL != cVar) {
                        n.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                n.this.b(str, aaVar);
                            }
                        });
                    }
                }
            });
        } else if (nVar.um(str) != null) {
            nVar.ul(str);
        } else if (nVar.un(str) != null) {
            nVar.ul(str);
        } else {
            nVar.b(str, aa.SWITCH_TAB);
        }
    }

    static /* synthetic */ void a(n nVar, String str, String str2, int[] iArr) {
        Iterator it = nVar.jIM.iterator();
        while (it.hasNext()) {
            ((l) it.next()).b(str, str2, iArr);
        }
        it = nVar.jIN.iterator();
        while (it.hasNext()) {
            ((l) it.next()).b(str, str2, iArr);
        }
    }

    static /* synthetic */ boolean b(aa aaVar) {
        return (aaVar == aa.APP_LAUNCH || aaVar == aa.REDIRECT_TO || aaVar == aa.RE_LAUNCH || aaVar == aa.AUTO_RE_LAUNCH) ? false : true;
    }

    static /* synthetic */ void c(n nVar) {
        if (!nVar.jIR) {
            nVar.jIR = true;
            nVar.jIS.YP();
            MainProcessTask reportStorageSizeTask = new ReportStorageSizeTask();
            reportStorageSizeTask.appId = nVar.mAppId;
            AppBrandMainProcessService.a(reportStorageSizeTask);
        }
    }

    static /* synthetic */ boolean c(aa aaVar) {
        return aaVar == aa.REDIRECT_TO || aaVar == aa.SWITCH_TAB || aaVar == aa.RE_LAUNCH || aaVar == aa.AUTO_RE_LAUNCH;
    }

    public n(Context context, e eVar) {
        super(context);
        this.iuk = eVar;
        this.mAppId = eVar.mAppId;
        this.jIP = new com.tencent.mm.plugin.appbrand.report.a.a(this.iuk);
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public final int getPageCount() {
        return this.jIM.size() + this.jIN.size();
    }

    public final void W(final String str, final boolean z) {
        runOnUiThread(new Runnable() {
            public final void run() {
                n.a(n.this, str, z ? aa.AUTO_RE_LAUNCH : aa.RE_LAUNCH);
            }
        });
    }

    public final void uj(final String str) {
        runOnUiThread(new Runnable() {
            public final void run() {
                n.a(n.this, str, aa.REDIRECT_TO);
            }
        });
    }

    public final void uk(final String str) {
        runOnUiThread(new Runnable() {
            public final void run() {
                n.a(n.this, str, aa.SWITCH_TAB);
            }
        });
    }

    public final void ajx() {
        runOnUiThread(new Runnable() {
            public final void run() {
                n.this.lv(1);
            }
        });
    }

    public final void lv(final int i) {
        runOnUiThread(new Runnable() {
            public final void run() {
                n.a(n.this, i);
            }
        });
    }

    private void b(String str, final aa aaVar) {
        View bVar;
        x.d("MicroMsg.AppBrandPageContainer", "navigateToNext: %s, Staging Count: %d", str, Integer.valueOf(this.jIN.size()));
        if (this.iuk.YI()) {
            bVar = new b(getContext(), this);
        } else {
            boolean z;
            if (!this.iuk.YI()) {
                if (aaVar == aa.SWITCH_TAB) {
                    z = true;
                } else if (aaVar == aa.RE_LAUNCH || aaVar == aa.AUTO_RE_LAUNCH) {
                    z = this.iuk.isT.iPG.qV(str);
                } else {
                    int size = (this.jIM.size() + 1) - (aaVar == aa.REDIRECT_TO ? 1 : 0);
                    if (this.iuk.isT.iPG.qV(str) && size == 1) {
                        z = true;
                    }
                }
                if (z) {
                    bVar = new s(getContext(), this);
                } else {
                    bVar = new e(getContext(), this);
                }
            }
            z = false;
            if (z) {
                bVar = new s(getContext(), this);
            } else {
                bVar = new e(getContext(), this);
            }
        }
        this.jIN.push(bVar);
        addView(bVar, 0);
        final boolean[] zArr = new boolean[]{false};
        final Runnable anonymousClass2 = new Runnable() {
            public final void run() {
                p pVar = null;
                zArr[0] = true;
                if (n.this.getPageCount() != 0) {
                    l lVar;
                    if (n.this.jIM.isEmpty()) {
                        lVar = null;
                    } else {
                        lVar = (l) n.this.jIM.getFirst();
                    }
                    if (aaVar == aa.SWITCH_TAB || aaVar == aa.RE_LAUNCH || aaVar == aa.AUTO_RE_LAUNCH) {
                        n.this.a(lVar, null);
                    }
                    boolean b = n.b(aaVar);
                    n.a(n.this, lVar, b, n.c(aaVar));
                    n.this.a(bVar, b);
                    com.tencent.mm.plugin.appbrand.report.a.a b2 = n.this.jIP;
                    p aeO = bVar.aeO();
                    if (lVar != null) {
                        pVar = lVar.aeO();
                    }
                    b2.a(aeO, pVar, aaVar);
                }
            }
        };
        if (this.jIM.size() == 0) {
            postDelayed(anonymousClass2, 5000);
        } else {
            postDelayed(anonymousClass2, 500);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final aa aaVar2 = aaVar;
        bVar.aeO().a(new g() {
            public final void onReady() {
                int i;
                int i2 = 2;
                bVar.aeO().b((g) this);
                if (!zArr[0]) {
                    n.this.removeCallbacks(anonymousClass2);
                    n.this.post(anonymousClass2);
                }
                n.c(n.this);
                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                com.tencent.mm.plugin.appbrand.report.a.a b = n.this.jIP;
                switch (aaVar2) {
                    case APP_LAUNCH:
                        i = 1;
                        break;
                    case REDIRECT_TO:
                    case RE_LAUNCH:
                    case AUTO_RE_LAUNCH:
                        i = 3;
                        break;
                    default:
                        i = 2;
                        break;
                }
                b.h(currentTimeMillis, i);
                com.tencent.mm.plugin.report.service.g.pWK.a(390, 0, 1, false);
                switch (((int) currentTimeMillis) / 250) {
                    case 0:
                        i2 = 1;
                        break;
                    case 1:
                        break;
                    case 2:
                        i2 = 3;
                        break;
                    case 3:
                        i2 = 4;
                        break;
                    case 4:
                    case 5:
                        i2 = 5;
                        break;
                    case 6:
                    case 7:
                        i2 = 6;
                        break;
                    default:
                        i2 = 7;
                        break;
                }
                com.tencent.mm.plugin.report.service.g.pWK.a(390, (long) i2, 1, false);
                x.i("MicroMsg.AppBrandPageContainer", "onReady received, time: %d", Long.valueOf(currentTimeMillis));
            }
        });
        bVar.loadUrl(str);
        bVar.a(aaVar);
    }

    private void ul(String str) {
        p aeO = ajy().aeO();
        l um = um(str);
        if (um != null) {
            um.loadUrl(str);
            um.a(aa.SWITCH_TAB);
            um.ajw();
        } else {
            l un = un(str);
            if (un != null) {
                un.loadUrl(str);
                um = (l) this.jIM.getFirst();
                a(um, un);
                a(un, um, aa.SWITCH_TAB);
            }
            um = un;
        }
        if (um != null) {
            this.jIP.a(um.aeO(), aeO, aa.SWITCH_TAB);
        }
    }

    private void a(l lVar, l lVar2) {
        Iterator it = this.jIM.iterator();
        Object obj = null;
        while (it.hasNext()) {
            l lVar3 = (l) it.next();
            if (lVar3 == lVar) {
                obj = 1;
            } else if (lVar3 == lVar2) {
                return;
            } else {
                if (obj != null) {
                    a(lVar3);
                    it.remove();
                }
            }
        }
    }

    private void a(final l lVar, final l lVar2, aa aaVar) {
        Runnable anonymousClass4;
        Animator ofFloat;
        this.jIM.remove(lVar2);
        if (lVar2.mSwiping) {
            a(lVar2);
        } else {
            anonymousClass4 = new Runnable() {
                public final void run() {
                    n.this.a(lVar2);
                }
            };
            ofFloat = ObjectAnimator.ofFloat(lVar2, "translationX", new float[]{0.0f, (float) lVar2.getWidth()});
            ofFloat.setDuration(250);
            a(ofFloat, anonymousClass4);
        }
        x.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", lVar.aeH(), lVar2.aeH());
        lVar.a(aaVar);
        lVar.aeJ();
        if (lVar2.mSwiping) {
            lVar.ajw();
            return;
        }
        anonymousClass4 = new Runnable() {
            public final void run() {
                lVar.ajw();
            }
        };
        ofFloat = ObjectAnimator.ofFloat(lVar, "translationX", new float[]{-(((float) lVar.getWidth()) * 0.25f), 0.0f});
        ofFloat.setDuration(250);
        a(ofFloat, anonymousClass4);
    }

    private synchronized void a(final l lVar, boolean z) {
        if (lVar != null) {
            this.jIM.remove(lVar);
            this.jIM.push(lVar);
            this.jIN.remove(lVar);
            lVar.bringToFront();
            requestLayout();
            invalidate();
            lVar.aeJ();
            Runnable anonymousClass7 = new Runnable() {
                public final void run() {
                    n.this.ajA();
                    lVar.ajw();
                }
            };
            if (z) {
                Animator ofFloat = ObjectAnimator.ofFloat(lVar, "translationX", new float[]{(float) lVar.getWidth(), 0.0f});
                ofFloat.setDuration(250);
                a(ofFloat, anonymousClass7);
            } else {
                anonymousClass7.run();
            }
        }
    }

    private l um(String str) {
        if (this.jIM.size() == 0) {
            return null;
        }
        return ((this.jIM.getFirst() instanceof e) && ((l) this.jIM.getFirst()).sk(str)) ? (l) this.jIM.getFirst() : null;
    }

    private l un(String str) {
        if (this.jIM.size() < 2) {
            return null;
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.jIM.size()) {
                return null;
            }
            if ((this.jIM.get(i2) instanceof e) && ((l) this.jIM.get(i2)).sk(str)) {
                return (l) this.jIM.get(i2);
            }
            i = i2 + 1;
        }
    }

    private void a(l lVar) {
        lVar.setVisibility(8);
        lVar.aeI();
        removeView(lVar);
        lVar.cleanup();
    }

    public final void c(final String str, final String str2, final int[] iArr) {
        runOnUiThread(new Runnable() {
            public final void run() {
                n.a(n.this, str, str2, iArr);
            }
        });
    }

    public final synchronized l ajy() {
        l lVar;
        if (this.jIN.isEmpty()) {
            try {
                lVar = (l) this.jIM.getFirst();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandPageContainer", e.getMessage());
                lVar = null;
            }
        } else {
            lVar = (l) this.jIN.getFirst();
        }
        return lVar;
    }

    public final synchronized String aeH() {
        String aeH;
        l ajy = ajy();
        if (ajy != null) {
            aeH = ajy.aeH();
        } else {
            aeH = null;
        }
        return aeH;
    }

    public final void cleanup() {
        l lVar;
        if (!bi.cC(this.jIM)) {
            com.tencent.mm.plugin.appbrand.report.a.a aVar = this.jIP;
            p aeO = ajy().aeO();
            if (!(aeO == null || aVar.jII)) {
                aVar.d(aeO);
            }
        }
        Iterator it = this.jIM.iterator();
        while (it.hasNext()) {
            lVar = (l) it.next();
            lVar.aeI();
            lVar.cleanup();
        }
        it = this.jIN.iterator();
        while (it.hasNext()) {
            lVar = (l) it.next();
            lVar.aeI();
            lVar.cleanup();
        }
        if (this.jIO != null) {
            this.jIO.cleanup();
        }
        this.jIM.clear();
        this.jIN.clear();
    }

    public final p ajz() {
        p pVar = null;
        if (this.iuk.YI()) {
            return null;
        }
        if (this.jIO == null) {
            if (this.iuk.isT.iPJ || !com.tencent.mm.plugin.appbrand.task.c.akV()) {
                pVar = com.tencent.mm.plugin.appbrand.task.c.uN(this.iuk.mAppId);
            }
            if (pVar == null) {
                pVar = new p();
            }
            pVar.a(getContext(), this.iuk);
            return pVar;
        }
        p pVar2 = this.jIO;
        this.jIO = null;
        pVar2.show();
        removeView(pVar2.getContentView());
        return pVar2;
    }

    public final void ajA() {
        if (!this.iuk.YI()) {
            postDelayed(new Runnable() {
                public final void run() {
                    if (n.this.jIO == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        p pVar = new p();
                        pVar.a(n.this.getContext(), n.this.iuk);
                        pVar.hide();
                        n.this.addView(pVar.getContentView(), 0);
                        n.this.jIO = pVar;
                        x.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            }, 200);
        }
    }

    private void a(Animator animator, final Runnable runnable) {
        animator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        animator.start();
    }
}
