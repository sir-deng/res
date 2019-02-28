package com.tencent.mm.plugin.webview.wepkg.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.f.a.kk;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgProcessPreloadService;
import com.tencent.mm.plugin.webview.wepkg.utils.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public class d extends c<kk> {
    private static volatile String fJB;
    private static volatile long tTd;
    private static volatile long tTe;
    private static Set<String> tTf = new HashSet();

    private static class a implements Runnable {
        private final kk tTi;

        public a(kk kkVar) {
            this.tTi = kkVar;
        }

        public final void run() {
            d.b(this.tTi);
        }
    }

    public d() {
        this.xmG = kk.class.getName().hashCode();
    }

    private boolean a(kk kkVar) {
        switch (kkVar.fCB.type) {
            case 0:
            case 1:
                String str = "MicroMsg.Wepkg.NotifyGameWebviewOperationListener";
                String str2 = "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s";
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(kkVar.fCB.type);
                objArr[1] = Integer.valueOf(hashCode());
                objArr[2] = Integer.valueOf(kkVar.hashCode());
                objArr[3] = Long.valueOf(Thread.currentThread().getId());
                objArr[4] = Boolean.valueOf(Thread.currentThread() == Looper.getMainLooper().getThread());
                x.i(str, str2, objArr);
                String str3 = "";
                try {
                    str3 = kkVar.fCB.intent.getStringExtra("rawUrl");
                } catch (Exception e) {
                }
                synchronized (d.class) {
                    if (!bi.oM(fJB).equalsIgnoreCase(str3)) {
                        fJB = str3;
                        tTd = System.currentTimeMillis();
                        tTe = System.currentTimeMillis();
                        if (ad.cgj()) {
                            b.tUu = g.Ag().zR();
                        }
                        if (!com.tencent.mm.plugin.webview.wepkg.utils.d.QY(str3)) {
                            x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + b.tUu);
                            b(kkVar);
                            break;
                        }
                        x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", com.tencent.mm.plugin.webview.wepkg.utils.d.QV(str3));
                        kkVar.fCB.group = com.tencent.mm.a.g.s(bi.oM(str3).getBytes()) + "_" + System.currentTimeMillis();
                        ah.h(new a(kkVar), 500);
                        c anonymousClass1 = new c(kkVar) {
                            public final void r(Message message) {
                                x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload complete. total time:%d", Long.valueOf(System.currentTimeMillis() - d.tTe));
                                if (this.tTc != null) {
                                    Object obj = this.tTc.get();
                                    if (obj instanceof kk) {
                                        kk kkVar = (kk) obj;
                                        if (kkVar != null) {
                                            d.b(kkVar);
                                        }
                                    }
                                }
                            }
                        };
                        Bundle bundle = new Bundle(1);
                        bundle.putInt("call_cmd_type", 0);
                        bundle.putString("call_raw_url", str3);
                        WepkgProcessPreloadService.a(anonymousClass1, bundle);
                        break;
                    }
                    x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
                }
        }
        return false;
    }

    private static synchronized void b(final kk kkVar) {
        synchronized (d.class) {
            ah.h(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", Integer.valueOf(1000), d.fJB);
                    d.fJB = "";
                }
            }, 1000);
            if (kkVar != null) {
                String str;
                if (!bi.oN(kkVar.fCB.group)) {
                    if (tTf.contains(kkVar.fCB.group)) {
                        tTf.remove(kkVar.fCB.group);
                    } else {
                        tTf.add(kkVar.fCB.group);
                    }
                }
                final Context context = kkVar.fCB.context != null ? kkVar.fCB.context : ad.getContext();
                if (kkVar.fCB.intent == null) {
                    kkVar.fCB.intent = new Intent();
                }
                kkVar.fCB.intent.putExtra("disable_wepkg", b.tUu);
                switch (kkVar.fCB.type) {
                    case 0:
                        com.tencent.mm.plugin.webview.ui.tools.d.a(kkVar.fCB.intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", kkVar.fCB.fCC, new Runnable() {
                            public final void run() {
                                com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.game.GameWebViewUI", kkVar.fCB.intent);
                            }
                        });
                        break;
                    case 1:
                        com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.TransparentWebViewUI", kkVar.fCB.intent);
                        break;
                }
                x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", Long.valueOf(System.currentTimeMillis() - tTd));
                String str2 = "";
                try {
                    str2 = kkVar.fCB.intent.getStringExtra("rawUrl");
                    kkVar.fCB.context = null;
                    str = str2;
                } catch (Exception e) {
                    str = str2;
                }
                com.tencent.mm.plugin.webview.wepkg.utils.a.b("preloadWebTime", str, com.tencent.mm.plugin.webview.wepkg.utils.d.QV(str), null, -1, r6, null);
            }
        }
    }
}
