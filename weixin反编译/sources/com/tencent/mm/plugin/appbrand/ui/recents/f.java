package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.e;
import com.tencent.mm.plugin.appbrand.appusage.e.b;
import com.tencent.mm.plugin.appbrand.appusage.e.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.ajg;
import com.tencent.mm.protocal.c.cdb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class f extends h implements b, b {
    Activity iTL;
    private a jWo = new a();
    d jWp;
    private boolean jWq = false;
    private OnClickListener jWr = null;
    volatile boolean mFinished = false;

    private static class a {
        String jWv;
        Integer jWw;
        List<String> jWx;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static /* synthetic */ void a(f fVar) {
        boolean z = false;
        ajg ajg = e.aaZ().iMa;
        if (ajg == null) {
            d dVar = fVar.jWp;
            x.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingFailed");
            dVar.jVE = c.jVS;
            dVar.jVF.jVr.ajR();
            dVar.bL(dVar.jVF.jVr);
            dVar.bL(dVar.jVF.jVV);
            d.bM(dVar.jVF.jVY);
            return;
        }
        if (ajg != null && (ajg.wxv == 1 || ajg.wxv == 2)) {
            c jG = c.jG(ajg.wxv);
            String str = "MicroMsg.AppBrandListRecentsListWAGameHeader";
            String str2 = "Use Game Entry %s";
            Object[] objArr = new Object[1];
            objArr[0] = jG == null ? "null" : jG.name();
            x.i(str, str2, objArr);
            if (jG == c.H5) {
                final String str3 = ajg.wxu;
                if (bi.oN(str3)) {
                    String str4 = "MicroMsg.AppBrandListRecentsListWAGameHeader";
                    str = "makeH5ClickListener failed. link_wxagame = [%s]";
                    Object[] objArr2 = new Object[1];
                    if (str3 == null) {
                        str3 = "null";
                    }
                    objArr2[0] = str3;
                    x.e(str4, str, objArr2);
                } else {
                    x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "H5 link is [%s]", str3);
                    if (bi.oN(str3)) {
                        fVar.jWr = null;
                    } else {
                        fVar.jWr = new OnClickListener() {
                            public final void onClick(View view) {
                                x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke H5 click listener, invoke h5");
                                ((com.tencent.mm.plugin.appbrand.compat.a.a) g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).K(f.this.iTL, str3);
                            }
                        };
                    }
                }
            } else if (jG == c.WXAPP) {
                final cdb cdb = ajg.wxt;
                if (cdb == null) {
                    x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "makeWxAppClickListener failed. wxaInfo = null.");
                } else {
                    str = "MicroMsg.AppBrandListRecentsListWAGameHeader";
                    str2 = "WxApp link is [%s]";
                    objArr = new Object[1];
                    objArr[0] = cdb.path == null ? "null" : cdb.path;
                    x.i(str, str2, objArr);
                    new AppBrandStatObject().scene = 1001;
                    fVar.jWr = new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke WxApp click listener, invoke wxapp");
                            AppBrandLaunchProxyUI.a(f.this.iTL, cdb.username, cdb.path, 0, cdb.vVm, new AppBrandStatObject(), null);
                        }
                    };
                }
            }
        } else if (ajg == null) {
            x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processClickListenerInfo resp is null");
        } else {
            x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processClickListenerInfo resp is not null, but action_code is %d", Integer.valueOf(ajg.wxv));
        }
        if (ajg == null) {
            x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processRenderInfo GetWxaGameResponse");
        } else {
            x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "processRenderInfo entry = [%s] ec = [%s] new = [%s] nc = [%s]", ajg.wxx, ajg.wxy, ajg.wxw, ajg.wxz);
            fVar.jWo.jWv = bi.aD(ajg.wxw, "");
            fVar.jWo.jWw = vd(ajg.wxz);
            fVar.jWo.jWx = new ArrayList(Math.max(ajg.wxs == null ? 0 : ajg.wxs.size(), 0));
            if (ajg.wxs != null && ajg.wxs.size() > 0) {
                Iterator it = ajg.wxs.iterator();
                while (it.hasNext()) {
                    cdb cdb2 = (cdb) it.next();
                    if (cdb2 != null) {
                        fVar.jWo.jWx.add(cdb2.wHQ);
                    }
                }
            }
        }
        if (ajg.wxm == 1) {
            z = true;
        }
        fVar.jWq = z;
        fVar.jWp.a(fVar.jWo.jWx, fVar.jWo.jWv, fVar.jWo.jWw);
    }

    f(Activity activity, ViewGroup viewGroup) {
        this.jWp = new d(viewGroup, j.dEg);
        this.jWp.jVD = this;
        this.iTL = activity;
    }

    final void amb() {
        e aaZ = e.aaZ();
        dn(e.enabled());
        if (e.enabled()) {
            if (this != null) {
                synchronized (aaZ.mLock) {
                    aaZ.iLZ.add(this);
                }
            }
            aaZ.refresh();
            this.jWp.amd();
            this.mFinished = false;
        }
    }

    final void onDetached() {
        this.mFinished = true;
        e aaZ = e.aaZ();
        if (this != null) {
            synchronized (aaZ.mLock) {
                aaZ.iLZ.remove(this);
            }
        }
    }

    final void onResume() {
    }

    public final void aba() {
        x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "AppBrandListRecentsListWAGameHeader.onWAGameDataUpdate");
        e.aaZ();
        if (e.enabled() && !this.mFinished) {
            View view = this.jWp.jVF.VU;
            if (view != null) {
                view.post(new Runnable() {
                    public final void run() {
                        if (!f.this.mFinished && f.this.jWp.jVF.VU != null) {
                            f.a(f.this);
                        }
                    }
                });
            }
        }
    }

    private static Integer vd(String str) {
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception e) {
            return null;
        }
    }

    final View amc() {
        return this.jWp.jVF.VU;
    }

    public final void b(int i, View view) {
        if (i == 0 || i == c.jVQ || i == c.jVP) {
            x.v("MicroMsg.AppBrandListRecentsListWAGameHeader", "onClick ");
        } else if (i == c.jVS) {
            this.jWp.amd();
            e.aaZ().refresh();
        } else if (i == c.jVR && this.jWr != null) {
            this.jWr.onClick(view);
            if (this.jWq) {
                d dVar = this.jWp;
                if (dVar.jVF.jVX != null) {
                    dVar.jVF.jVX.animate().alpha(0.0f).setDuration(200).start();
                }
            }
        }
    }
}
