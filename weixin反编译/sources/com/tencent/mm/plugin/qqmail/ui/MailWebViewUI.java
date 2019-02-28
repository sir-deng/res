package com.tencent.mm.plugin.qqmail.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.p;
import java.util.HashMap;
import java.util.Map;

public class MailWebViewUI extends MMActivity {
    private String fex;
    private ag handler;
    private d mlo = new d(this);
    private long pvI;
    private MMWebView pzt;
    private View pzu;
    private a pzv = new a() {
        public final void onSuccess(final String str, Map map) {
            MailWebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    MailWebViewUI.a(MailWebViewUI.this, str);
                }
            });
        }

        public final void onError(int i, final String str) {
            MailWebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    Toast.makeText(MailWebViewUI.this, str, 0).show();
                }
            });
        }
    };

    static /* synthetic */ void a(MailWebViewUI mailWebViewUI, String str) {
        if (mailWebViewUI.pzt != null && str != null) {
            if (mailWebViewUI.fex == null) {
                mailWebViewUI.pzt.loadData(str, "text/html", ProtocolPackage.ServerEncoding);
                return;
            }
            mailWebViewUI.pzt.loadDataWithBaseURL(mailWebViewUI.fex, str, "text/html", ProtocolPackage.ServerEncoding, null);
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI) {
        String stringExtra = mailWebViewUI.getIntent().getStringExtra("uri");
        String[] stringArrayExtra = mailWebViewUI.getIntent().getStringArrayExtra("params");
        Map hashMap = new HashMap();
        for (int i = 0; i < stringArrayExtra.length; i++) {
            int indexOf = stringArrayExtra[i].indexOf("=");
            hashMap.put(stringArrayExtra[i].substring(0, indexOf), stringArrayExtra[i].substring(indexOf + 1));
        }
        mailWebViewUI.fex = mailWebViewUI.getIntent().getStringExtra("baseurl");
        String aD = bi.aD(mailWebViewUI.getIntent().getStringExtra("method"), "get");
        if (aD == null || aD.length() == 0 || stringExtra == null || stringExtra.length() == 0) {
            x.e("MicroMsg.QQMail.WebViewUI", "doSend invalid argument.");
            return;
        }
        c cVar = new c();
        cVar.puU = false;
        cVar.toBundle(new Bundle());
        try {
            if (aD.equals("get")) {
                mailWebViewUI.pvI = ((Long) new ReadMailProxy(mailWebViewUI.mlo, mailWebViewUI.pzv).REMOTE_CALL("get", stringExtra, hashMap, r5)).longValue();
                return;
            }
            mailWebViewUI.pvI = ((Long) new ReadMailProxy(mailWebViewUI.mlo, mailWebViewUI.pzv).REMOTE_CALL("post", stringExtra, hashMap, r5)).longValue();
        } catch (Exception e) {
            x.w("MicroMsg.QQMail.WebViewUI", "get/post, method = %s, ex = %s", aD, e.getMessage());
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI, String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.QQMail.WebViewUI", "dealGetContentWidthScheme fail, url is null");
            return;
        }
        String substring = str.substring(33);
        final int i = bi.getInt(substring, 480);
        x.d("MicroMsg.QQMail.WebViewUI", "getContentWidth:" + substring);
        mailWebViewUI.pzt.post(new Runnable() {
            public final void run() {
                View view = (View) MailWebViewUI.this.pzt.getParent();
                if (view != null) {
                    int width = view.getWidth();
                    if (i > width) {
                        int i = 10;
                        float f = ((float) width) / ((float) i);
                        while (f < MailWebViewUI.this.pzt.getScale()) {
                            i--;
                            if (i > 0) {
                                MailWebViewUI.this.pzt.zoomOut();
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
        WebView.enablePlatformNotifications();
    }

    protected void onPause() {
        super.onPause();
        WebView.disablePlatformNotifications();
    }

    protected final int getLayoutId() {
        return R.i.dqf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new ag();
        initView();
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            setMMTitle(stringExtra);
        }
        this.mlo.I(new Runnable() {
            public final void run() {
                MailWebViewUI.b(MailWebViewUI.this);
            }
        });
    }

    protected void onStop() {
        this.pzt.stopLoading();
        super.onStop();
    }

    protected void onDestroy() {
        this.pzt.setVisibility(8);
        this.pzt.destroy();
        this.pzt = null;
        this.mlo.release();
        super.onDestroy();
    }

    protected final void initView() {
        this.pzu = findViewById(R.h.cYK);
        if (this.pzu != null) {
            this.pzu.setVisibility(8);
        }
        Boolean valueOf = Boolean.valueOf(getIntent().getBooleanExtra("singleColumn", false));
        this.pzt = MMWebView.a.co(this.mController.xRr);
        this.pzt.setBackgroundDrawable(com.tencent.mm.bu.a.b(this, R.e.btq));
        ((FrameLayout) findViewById(R.h.bYH)).addView(this.pzt);
        this.pzt.getSettings().setJavaScriptEnabled(true);
        if (valueOf.booleanValue()) {
            MMWebView mMWebView = this.pzt;
            if (VERSION.SDK_INT >= 8) {
                mMWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
            }
        }
        this.pzt.getSettings().cJl();
        this.pzt.getSettings().setSupportZoom(true);
        this.pzt.getSettings().setBuiltInZoomControls(true);
        this.pzt.setWebViewClient(new p() {
            public final void blM() {
                MailWebViewUI.this.pzt.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
            }

            public final boolean b(WebView webView, String str) {
                if (str.startsWith("weixin://private/getcontentwidth/")) {
                    x.d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = " + str);
                    MailWebViewUI.b(MailWebViewUI.this, str);
                } else {
                    webView.loadUrl(str);
                }
                return true;
            }

            public final void a(WebView webView, String str) {
                super.a(webView, str);
                s.a(webView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
            }
        });
        this.pzt.setWebChromeClient(new j() {
            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String Tz = s.Tz(consoleMessage != null ? consoleMessage.message() : null);
                if (!Tz.startsWith("weixin://private/getcontentwidth/")) {
                    return super.onConsoleMessage(consoleMessage);
                }
                x.d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = " + Tz);
                MailWebViewUI.b(MailWebViewUI.this, Tz);
                return true;
            }
        });
        this.pzt.czN();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MailWebViewUI.this.finish();
                return true;
            }
        });
    }
}
