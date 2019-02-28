package com.tencent.mm.plugin.appbrand;

import android.widget.FrameLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.plugin.appbrand.ui.m;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f<_ActivityContext extends MMActivity & m> implements o {
    private _ActivityContext isO;
    FrameLayout isY;
    public LinkedList<e> itK = new LinkedList();
    HashMap<String, e> itL = new HashMap();
    private c itM;

    /* renamed from: com.tencent.mm.plugin.appbrand.f$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ e itN;

        AnonymousClass3(e eVar) {
            this.itN = eVar;
        }

        public final void run() {
            if (this.itN.YH()) {
                f.this.d(this.itN);
            }
        }
    }

    public f(_ActivityContext _activitycontext, c cVar, FrameLayout frameLayout) {
        this.isO = _activitycontext;
        this.isY = frameLayout;
        this.itM = cVar;
    }

    public final void a(final e eVar, final AppBrandInitConfig appBrandInitConfig, final AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig != null && appBrandStatObject != null) {
            if (eVar == null) {
                Iterator it = this.itK.iterator();
                while (it.hasNext()) {
                    e eVar2 = (e) it.next();
                    eVar2.isY.setVisibility(8);
                    this.itL.put(eVar2.mAppId, eVar2);
                    eVar2.itj.iKb.jC(12);
                }
                this.itK.clear();
            }
            if (pz(appBrandInitConfig.appId) == null) {
                b(eVar, appBrandInitConfig, appBrandStatObject);
            } else {
                this.isO.runOnUiThread(new Runnable() {
                    public final void run() {
                        boolean z = false;
                        f fVar = f.this;
                        e eVar = eVar;
                        AppBrandInitConfig appBrandInitConfig = appBrandInitConfig;
                        AppBrandStatObject appBrandStatObject = appBrandStatObject;
                        e pz = fVar.pz(appBrandInitConfig.appId);
                        int indexOf = fVar.itK.indexOf(pz) - 1;
                        if (indexOf >= 0) {
                            LinkedList linkedList = new LinkedList();
                            int i = indexOf;
                            while (i >= 0 && ((e) fVar.itK.get(i)).YH()) {
                                linkedList.add(fVar.itK.get(i));
                                i--;
                            }
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                e eVar2 = (e) it.next();
                                if (eVar2 != eVar) {
                                    fVar.d(eVar2);
                                }
                            }
                        }
                        if (!fVar.itK.contains(pz)) {
                            fVar.itK.push(pz);
                            if (fVar.isY.indexOfChild(pz.isY) == -1) {
                                fVar.isY.addView(pz.isY);
                            }
                            fVar.itL.remove(pz.mAppId);
                        }
                        fVar.itK.remove(pz);
                        fVar.itK.push(pz);
                        pz.isY.setVisibility(0);
                        fVar.isY.bringChildToFront(pz.isY);
                        pz.isQ = eVar;
                        if (pz.gUI) {
                            boolean z2;
                            String str;
                            if (appBrandInitConfig != null) {
                                if (pz.itp) {
                                    pz.itp = false;
                                    z2 = true;
                                } else if (appBrandInitConfig.iIZ != pz.isR.iIZ) {
                                    z2 = true;
                                }
                                pz.itn = z2;
                                if (!(appBrandInitConfig == null || appBrandStatObject == null || appBrandStatObject.scene == 1022 || appBrandStatObject.scene == 1001 || appBrandStatObject.scene == 1089 || appBrandStatObject.scene == 1090 || (bi.oN(appBrandInitConfig.iRi) && bi.oN(appBrandInitConfig.hlk) && bi.oN(pz.isR.iRi) && bi.oN(pz.isR.hlk)))) {
                                    z = true;
                                }
                                pz.ito = z;
                                pz.isR = appBrandInitConfig;
                                str = appBrandInitConfig.iRi;
                                pz.a(appBrandStatObject);
                            }
                            z2 = false;
                            pz.itn = z2;
                            z = true;
                            pz.ito = z;
                            pz.isR = appBrandInitConfig;
                            str = appBrandInitConfig.iRi;
                            pz.a(appBrandStatObject);
                        }
                        if (eVar != null) {
                            eVar.onPause();
                            com.tencent.mm.plugin.appbrand.ui.f.a(pz, eVar, new AnonymousClass3(eVar));
                            pz.onResume();
                        }
                    }
                });
            }
        }
    }

    final void b(final e eVar, final AppBrandInitConfig appBrandInitConfig, final AppBrandStatObject appBrandStatObject) {
        if (ah.isMainThread()) {
            e eVar2;
            if (appBrandInitConfig.YI()) {
                x.i("MicroMsg.AppBrandRuntimeContainer", "cleanup by game, ugly");
                cleanup();
            } else {
                Iterator it = this.itK.iterator();
                while (it.hasNext()) {
                    eVar2 = (e) it.next();
                    if (eVar2.YI()) {
                        break;
                    }
                }
                for (e eVar22 : this.itL.values()) {
                    if (eVar22.YI()) {
                        break;
                    }
                }
                eVar22 = null;
                d(eVar22);
            }
            if (eVar != null) {
                eVar.onPause();
            }
            eVar22 = new e(this.isO, this);
            eVar22.a(appBrandInitConfig, appBrandStatObject);
            eVar22.isQ = eVar;
            eVar22.YC();
            this.itK.push(eVar22);
            this.isY.addView(eVar22.isY);
            if (eVar != null) {
                com.tencent.mm.plugin.appbrand.ui.f.a(eVar22, eVar, null);
                return;
            }
            return;
        }
        this.isO.runOnUiThread(new Runnable() {
            public final void run() {
                f.this.b(eVar, appBrandInitConfig, appBrandStatObject);
            }
        });
    }

    public final void close() {
        if (!(YR() == null || YR().YF() == 1060 || YR().isS == null || !YR().isS.iRw || !YR().gUI)) {
            ((d) g.h(d.class)).ck(this.isO);
            YR().isS.iRw = false;
        }
        if (((m) this.isO).aly()) {
            this.isO.moveTaskToBack(true);
        } else {
            this.isO.finish();
        }
    }

    public final void finish() {
        this.isO.finish();
    }

    public final e YR() {
        return (e) this.itK.peek();
    }

    public final e b(e eVar) {
        int indexOf = this.itK.indexOf(eVar);
        int size = this.itK.size() - 1;
        if (indexOf == -1 || indexOf >= size) {
            return null;
        }
        return (e) this.itK.get(indexOf + 1);
    }

    public final int YS() {
        return this.itK.size();
    }

    public final boolean c(e eVar) {
        return this.itK.contains(eVar);
    }

    final e pz(String str) {
        Iterator it = this.itK.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.mAppId.equals(str)) {
                return eVar;
            }
        }
        return (e) this.itL.get(str);
    }

    public final void d(final e eVar) {
        this.isO.runOnUiThread(new Runnable() {
            public final void run() {
                f fVar = f.this;
                e eVar = eVar;
                if (eVar != null) {
                    eVar.cleanup();
                    fVar.isY.removeView(eVar.isY);
                    fVar.itL.remove(eVar.mAppId);
                    fVar.itK.remove(eVar);
                }
            }
        });
    }

    public final void cleanup() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.itK);
        linkedList.addAll(this.itL.values());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            d((e) it.next());
        }
        x.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    }

    public final c YT() {
        return this.itM;
    }
}
