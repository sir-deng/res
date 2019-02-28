package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.content.res.Resources;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.q;
import com.tencent.xweb.r;
import com.tencent.xweb.util.b;
import com.tencent.xweb.x5.sdk.d;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;

public final class c {
    private static volatile boolean gQM;
    private static final List<a> iXm = new LinkedList();

    public interface a {
        void Zk();
    }

    public static void initialize() {
        if (!gQM) {
            r.a(ad.getContext(), new b() {
                public final void i(String str, String str2) {
                    x.i(str, str2);
                }

                public final void e(String str, String str2) {
                    x.e(str, str2);
                }

                public final void w(String str, String str2) {
                    x.w(str, str2);
                }

                public final void d(String str, String str2) {
                    x.d(str, str2);
                }

                public final void v(String str, String str2) {
                    x.v(str, str2);
                }
            }, new q() {
                public final void h(long j, long j2) {
                    x.v("MicroMsg.JSEngineInitializer", "callback: idkeyStat:577" + ", " + j + ", 1");
                    g.pWK.a(577, j, 1, true);
                }

                public final void w(int i, int i2, int i3) {
                    x.v("MicroMsg.JSEngineInitializer", "callback: idkeyForPair:577" + ", " + i + ", 1, 577" + ", " + i2 + ", " + i3);
                    g.pWK.a(577, 577, i, i2, 1, i3, true);
                }

                public final void k(int i, String str) {
                    x.v("MicroMsg.JSEngineInitializer", "callback: kvStat:" + i + ", " + str);
                    g.pWK.k(i, str);
                }

                public final void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7) {
                    x.v("MicroMsg.JSEngineInitializer", "callback: kvStat:15003" + ", 17," + i + ",0," + str + "," + i3 + ",-1," + i4 + "," + i5 + "," + i6);
                    g.pWK.h(15003, Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), str, Integer.valueOf(ao.getNetType(ad.getContext())), Integer.valueOf(i3), Integer.valueOf(-1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
                }
            }, new WebViewExtensionListener() {
                public final Object onMiscCallBack(String str, Object... objArr) {
                    if (WebViewExtension.EXTENSION_ADD_FILTER_RESOURCES.equals(str)) {
                        e.a((Resources) objArr[0], (Map) objArr[1]);
                    }
                    return null;
                }
            });
            if (bi.chp()) {
                d.forceSysWebView();
            }
            WebView.initWebviewCore(ad.getContext(), MMWebView.zEH, "support", new WebView.b() {
                public final void tI() {
                    x.i("MicroMsg.JSEngineInitializer", "onCoreInitFinished");
                    c.gQM = true;
                    for (a Zk : c.iXm) {
                        Zk.Zk();
                    }
                }

                public final void tJ() {
                    x.i("MicroMsg.JSEngineInitializer", "onCoreInitFailed");
                }
            });
        }
    }

    public static boolean a(a aVar) {
        if (iXm.contains(aVar)) {
            return false;
        }
        if (!gQM) {
            return iXm.add(aVar);
        }
        aVar.Zk();
        return true;
    }
}
