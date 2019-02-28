package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.aj.b;
import com.tencent.mm.plugin.aj.c;
import com.tencent.mm.plugin.aj.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public abstract class PreLoadWebViewUI extends WebViewUI {
    protected String frp;
    boolean tKB;
    CountDownLatch tKC = new CountDownLatch(bUw() + 2);
    private b tKD;
    protected String tpV;
    private int tqe = -1;

    protected class a extends h {
        protected a() {
            super();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.frp)) {
            this.frp = getIntent().getStringExtra("sessionId");
            this.tpV = getIntent().getStringExtra("subSessionId");
            if (TextUtils.isEmpty(this.tpV)) {
                this.tpV = this.frp;
            }
        }
    }

    protected final b bTz() {
        return this.tKD;
    }

    protected final MMWebView bTr() {
        c cVar;
        Intent intent = getIntent();
        if (intent != null) {
            this.tqe = intent.getIntExtra("key_preload_biz", -1);
            x.i("PreLoadWebViewUI", "getting preloaded  webview, biz %d", Integer.valueOf(this.tqe));
            cVar = (c) d.bPz().zX(this.tqe).dM(this);
        } else {
            cVar = null;
        }
        MMWebView mMWebView = cVar == null ? null : (MMWebView) cVar.tpU;
        this.tKD = cVar == null ? null : cVar.tpW;
        if (mMWebView == null) {
            x.i("PreLoadWebViewUI", "no available preloaded webview");
            this.tKB = false;
            Object bTy = bTy();
            boolean z = !TextUtils.isEmpty(bTy) ? bi.Wo(Uri.parse(bTy).getQueryParameter("isOpenPreload")) == 1 : false;
            if (z) {
                g.pWK.h(15005, Integer.valueOf(this.tqe), Integer.valueOf(4), Integer.valueOf(0));
            }
            return super.bTr();
        }
        x.i("PreLoadWebViewUI", "use preloaded webview ,%s ", mMWebView.toString());
        this.tKB = true;
        g.pWK.h(15005, Integer.valueOf(this.tqe), Integer.valueOf(3), Integer.valueOf(0));
        return mMWebView;
    }

    public void alu() {
        super.alu();
        this.tKC.countDown();
        if (this.tsa == null || this.tsa.tNo) {
            bUG();
        } else {
            this.tsa.a(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.a() {
                public final void onReady() {
                    PreLoadWebViewUI.this.bUG();
                }
            });
        }
        if (!com.tencent.mm.sdk.a.b.cfx()) {
            return;
        }
        if (this.tKB) {
            u.makeText(ad.getContext(), "use preloaded webview(安装coolassist时弹出)", 1).show();
        } else {
            u.makeText(ad.getContext(), "no preloaded webview(安装coolassist时弹出)", 1).show();
        }
    }

    private void bUG() {
        if (this.tKB) {
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        PreLoadWebViewUI.this.tKC.await();
                    } catch (Throwable e) {
                        x.printErrStackTrace("PreLoadWebViewUI", e, "", new Object[0]);
                    }
                    if (PreLoadWebViewUI.this.tKB) {
                        x.i("PreLoadWebViewUI", "send onUiInit to webview");
                        PreLoadWebViewUI.this.bUu();
                        PreLoadWebViewUI.this.tsa.al(PreLoadWebViewUI.this.bUH());
                    }
                }
            }).start();
        }
    }

    protected void onResume() {
        super.onResume();
        this.tKC.countDown();
    }

    protected final boolean bTA() {
        return this.tKB;
    }

    protected final void bTB() {
        this.tKB = false;
    }

    public final Map<String, Object> bUH() {
        Map<String, Object> emptyMap;
        Object bTy = bTy();
        if (TextUtils.isEmpty(bTy)) {
            emptyMap = Collections.emptyMap();
        } else {
            Map<String, Object> hashMap = new HashMap();
            Uri parse = Uri.parse(bTy);
            for (String str : parse.getQueryParameterNames()) {
                hashMap.put(str, parse.getQueryParameter(str));
            }
            emptyMap = hashMap;
        }
        Map bUx = bUx();
        if (bUx != null) {
            emptyMap.putAll(bUx);
        }
        x.i("PreLoadWebViewUI", "buildOnUiInitParams %s", emptyMap.toString());
        return emptyMap;
    }

    protected Map<String, Object> bUx() {
        return null;
    }

    public int bUw() {
        return 0;
    }

    protected void bUu() {
    }

    protected final void bTQ() {
        g.pWK.h(15005, Integer.valueOf(this.tqe), Integer.valueOf(5), Integer.valueOf(0));
    }
}
