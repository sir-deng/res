package com.tencent.mm.plugin.webview.stub;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.sh;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.e;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

@a(7)
public class WebViewStubProxyUI extends MMActivity {
    private e fCC = null;
    private al fia = new al(new al.a() {
        public final boolean uG() {
            if (WebViewStubProxyUI.this.getWindow() != null && WebViewStubProxyUI.this.getWindow().getDecorView() != null && WebViewStubProxyUI.this.getWindow().getDecorView().getWindowToken() != null) {
                WebViewStubProxyUI.e(WebViewStubProxyUI.this);
                WebViewStubProxyUI.this.tBK = true;
                return false;
            } else if (WebViewStubProxyUI.this.myp < 10) {
                WebViewStubProxyUI.d(WebViewStubProxyUI.this);
                return true;
            } else {
                x.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
                WebViewStubProxyUI.this.finish();
                return false;
            }
        }
    }, true);
    private int myp = 0;
    public boolean tBJ = false;
    private boolean tBK = false;
    private int tBL;
    private final e tBM = new e() {
        public final IBinder asBinder() {
            return null;
        }

        public final boolean AJ(int i) {
            WebViewStubProxyUI.this.fCC.AJ(i);
            return false;
        }

        public final boolean n(int i, Bundle bundle) {
            WebViewStubProxyUI.this.fCC.n(i, bundle);
            return false;
        }

        public final boolean a(c cVar) {
            WebViewStubProxyUI.this.fCC.a(cVar);
            return false;
        }

        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            x.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
            WebViewStubProxyUI.this.tBJ = WebViewStubProxyUI.Pn(str2);
            final String str3 = str;
            final String str4 = str2;
            final Bundle bundle2 = bundle;
            final boolean z2 = z;
            WebViewStubProxyUI.this.runOnUiThread(new Runnable() {
                public final void run() {
                    h.Bw(WebViewStubProxyUI.this.tBL).a(null, null, null);
                    WebViewStubProxyUI.this.finish();
                    try {
                        WebViewStubProxyUI.this.fCC.a(str3, str4, bundle2, z2);
                    } catch (Exception e) {
                        x.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + e.getMessage());
                    }
                }
            });
            return false;
        }

        public final String bSz() {
            return WebViewStubProxyUI.this.fCC.bSz();
        }

        public final String aeH() {
            return WebViewStubProxyUI.this.fCC.aeH();
        }

        public final String bSA() {
            return WebViewStubProxyUI.this.fCC.bSA();
        }

        public final void kv(boolean z) {
            WebViewStubProxyUI.this.fCC.kv(z);
        }

        public final void kw(boolean z) {
            WebViewStubProxyUI.this.fCC.kw(z);
        }

        public final void p(int i, Bundle bundle) {
            WebViewStubProxyUI.this.fCC.p(i, bundle);
        }

        public final void bSB() {
            WebViewStubProxyUI.this.fCC.bSB();
        }

        public final void O(Bundle bundle) {
            WebViewStubProxyUI.this.fCC.O(bundle);
        }

        public final void Po(String str) {
            WebViewStubProxyUI.this.fCC.Po(str);
        }

        public final void bSC() {
            if (WebViewStubProxyUI.this.fCC != null) {
                WebViewStubProxyUI.this.fCC.bSC();
            }
        }

        public final void f(String str, String str2, int i, int i2) {
        }

        public final void eT(String str, String str2) {
            WebViewStubProxyUI.this.fCC.eT(str, str2);
        }

        public final Bundle e(int i, Bundle bundle) {
            return WebViewStubProxyUI.this.fCC.e(i, bundle);
        }

        public final void P(Bundle bundle) {
            WebViewStubProxyUI.this.fCC.P(bundle);
        }

        public final void kx(boolean z) {
            WebViewStubProxyUI.this.fCC.kx(z);
        }

        public final void eU(String str, String str2) {
            WebViewStubProxyUI.this.fCC.eU(str, str2);
        }
    };
    private OnDismissListener tBN = new OnDismissListener() {
        public final void onDismiss(DialogInterface dialogInterface) {
            if (!WebViewStubProxyUI.this.isFinishing()) {
                WebViewStubProxyUI.this.finish();
            }
        }
    };
    private al tBO = new al(new al.a() {
        public final boolean uG() {
            if (!WebViewStubProxyUI.this.isFinishing()) {
                WebViewStubProxyUI.this.finish();
            }
            return false;
        }
    }, true);

    static /* synthetic */ boolean Pn(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(":");
        return split.length > 0 && split[0].equals("startMonitoringBeacons");
    }

    static /* synthetic */ int d(WebViewStubProxyUI webViewStubProxyUI) {
        int i = webViewStubProxyUI.myp + 1;
        webViewStubProxyUI.myp = i;
        return i;
    }

    static /* synthetic */ void e(WebViewStubProxyUI webViewStubProxyUI) {
        Intent intent = webViewStubProxyUI.getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        x.i("MicroMsg.WebViewStubProxyUI", "onCreate, dealAfterWindowTokenInited = " + intExtra);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        switch (intExtra) {
            case 1:
                i iVar = new i();
                iVar.type = intent.getStringExtra("proxyui_type_key");
                iVar.tQg = intent.getStringExtra("proxyui_function_key");
                iVar.tQe = intent.getStringExtra("proxyui_callback_key");
                iVar.pug = i.aa(intent.getExtras());
                jsapiPermissionWrapper = (JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key");
                if (jsapiPermissionWrapper == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                h.Bw(webViewStubProxyUI.tBL).a((Context) webViewStubProxyUI, webViewStubProxyUI.tBM, webViewStubProxyUI.fCC);
                if (!h.Bw(webViewStubProxyUI.tBL).a(iVar, jsapiPermissionWrapper)) {
                    try {
                        webViewStubProxyUI.tBM.a(null, null, null, true);
                        return;
                    } catch (Exception e) {
                        x.w("MicroMsg.WebViewStubProxyUI", "onHandleEnd, ex = " + e.getMessage());
                        return;
                    }
                }
                return;
            case 4:
                if (((JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key")) == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                h.Bw(webViewStubProxyUI.tBL).a((Context) webViewStubProxyUI, webViewStubProxyUI.tBM);
                if (!h.Bw(webViewStubProxyUI.tBL).Qp(intent.getStringExtra("proxyui_username_key"))) {
                    x.w("MicroMsg.WebViewStubProxyUI", "doProfile fail, finish");
                    webViewStubProxyUI.finish();
                    return;
                }
                return;
            default:
                x.e("MicroMsg.WebViewStubProxyUI", "dealAfterWindowTokenInited unknown actionCode = " + intExtra);
                webViewStubProxyUI.finish();
                return;
        }
    }

    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.fN(21)) {
            getWindow().setStatusBarColor(0);
        }
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = (WebViewStubCallbackWrapper) getIntent().getParcelableExtra("webview_stub_callbacker_key");
        if (webViewStubCallbackWrapper != null) {
            this.fCC = webViewStubCallbackWrapper.tEI;
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        this.tBL = intent.getIntExtra("webview_binder_id", 0);
        x.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d", Integer.valueOf(intExtra), Integer.valueOf(this.tBL));
        if ("startMonitoringBeacons".equals(intent.getStringExtra("proxyui_function_key"))) {
            this.tBJ = true;
        }
        String stringExtra;
        switch (intExtra) {
            case 1:
                if (!this.tBK) {
                    this.fia.K(100, 100);
                }
                if (this.tBJ) {
                    this.tBO.K(5000, 5000);
                    return;
                }
                return;
            case 2:
                final b shVar = new sh();
                shVar.frD = new Runnable() {
                    public final void run() {
                        if (shVar.fKQ.fKR) {
                            if (WebViewStubProxyUI.this.fCC != null) {
                                try {
                                    WebViewStubProxyUI.this.fCC.n(1001, null);
                                } catch (RemoteException e) {
                                    x.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + e.getMessage());
                                }
                            }
                            WebViewStubProxyUI.this.finish();
                            e eVar = q.a.viZ;
                            if (eVar != null) {
                                eVar.ar(WebViewStubProxyUI.this);
                                return;
                            }
                            return;
                        }
                        WebViewStubProxyUI.this.finish();
                    }
                };
                shVar.fKP.context = this;
                shVar.fKP.type = intent.getIntExtra("update_type_key", 0);
                if (shVar.fKP.type <= 0) {
                    x.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + shVar.fKP.type);
                    finish();
                    return;
                }
                com.tencent.mm.sdk.b.a.xmy.a(shVar, Looper.myLooper());
                return;
            case 3:
                Dialog a;
                as.Hm();
                bc FE = c.Fn().FE("@t.qq.com");
                if (!com.tencent.mm.y.q.GF()) {
                    a = com.tencent.mm.ui.base.h.a((Context) this, R.l.dVO, R.l.dGZ, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.webview.a.a.ihN.h(new Intent(), WebViewStubProxyUI.this);
                        }
                    }, null);
                } else if (FE == null || bi.oN(FE.name)) {
                    a = com.tencent.mm.ui.base.h.h(this, R.l.eNR, R.l.dGZ);
                } else {
                    as.CN().a(new ad(getIntent().getIntExtra(Columns.TYPE, 0), bi.oM(getIntent().getStringExtra("shortUrl"))), 0);
                    try {
                        this.fCC.AJ(0);
                        a = null;
                    } catch (Exception e) {
                        x.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + e.getMessage());
                        a = null;
                    }
                }
                if (a == null) {
                    finish();
                    return;
                } else {
                    a.setOnDismissListener(this.tBN);
                    return;
                }
            case 4:
                this.fia.K(100, 100);
                return;
            case 5:
                if (q.a.vjh != null) {
                    q.a.vjh.a(this, intent.getStringExtra("proxyui_handle_event_url"), this.tBN);
                    return;
                }
                return;
            case 6:
                int intExtra2 = getIntent().getIntExtra("proxyui_expired_errtype", 0);
                int intExtra3 = getIntent().getIntExtra("proxyui_expired_errcode", 0);
                if (intExtra2 == 0 && intExtra3 == 0) {
                    x.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
                    return;
                }
                b cVar = new com.tencent.mm.f.a.c();
                cVar.fnE.fnF = this;
                cVar.fnE.errType = intExtra2;
                cVar.fnE.errCode = intExtra3;
                com.tencent.mm.sdk.b.a.xmy.m(cVar);
                return;
            case 8:
                stringExtra = getIntent().getStringExtra("proxyui_phone");
                if (bi.oN(stringExtra)) {
                    x.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
                    finish();
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fromScene", 3);
                k.a((Context) this, stringExtra, this.tBN, bundle2);
                return;
            case 9:
                intent = (Intent) getIntent().getExtras().getParcelable("proxyui_next_intent_key");
                intent.setFlags(603979776);
                com.tencent.mm.bl.d.a((Context) this, "accountsync", "com.tencent.mm.ui.account.SimpleLoginUI", null, intent);
                finish();
                return;
            case 10:
                stringExtra = getIntent().getStringExtra("KAppId");
                String stringExtra2 = getIntent().getStringExtra("shortcut_user_name");
                if (!bi.oN(stringExtra) && !bi.oN(stringExtra2)) {
                    getString(R.l.dGZ);
                    final r a2 = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            x.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                            WebViewStubProxyUI.this.finish();
                        }
                    });
                    a2.show();
                    com.tencent.mm.plugin.base.model.d.a(com.tencent.mm.sdk.platformtools.ad.getContext(), stringExtra2, stringExtra, new com.tencent.mm.plugin.base.model.d.a() {
                        public final void dS(boolean z) {
                            if (a2 != null) {
                                a2.dismiss();
                            }
                            Bundle bundle;
                            if (z) {
                                if (WebViewStubProxyUI.this.fCC != null) {
                                    bundle = new Bundle();
                                    bundle.putBoolean("add_shortcut_status", true);
                                    try {
                                        WebViewStubProxyUI.this.fCC.e(54, bundle);
                                    } catch (Exception e) {
                                        x.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e.getMessage());
                                    }
                                }
                                com.tencent.mm.ui.base.h.a(WebViewStubProxyUI.this, R.l.eYi, R.l.dGZ, false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        WebViewStubProxyUI.this.finish();
                                    }
                                });
                                return;
                            }
                            Toast.makeText(WebViewStubProxyUI.this.mController.xRr, WebViewStubProxyUI.this.mController.xRr.getString(R.l.eYh), 0).show();
                            if (WebViewStubProxyUI.this.fCC != null) {
                                bundle = new Bundle();
                                bundle.putBoolean("add_shortcut_status", false);
                                try {
                                    WebViewStubProxyUI.this.fCC.e(54, bundle);
                                } catch (Exception e2) {
                                    x.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e2.getMessage());
                                }
                            }
                            WebViewStubProxyUI.this.finish();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getForceOrientation() {
        return getIntent().getIntExtra("screen_orientation", -1);
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.tBJ) {
            this.fCC = null;
        }
        x.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 113:
            case 115:
            case 116:
            case 117:
            case 118:
                if (iArr[0] == 0) {
                    h.Bw(this.tBL).b(i, -1, null);
                    return;
                } else {
                    h.Bw(this.tBL).b(i, 0, null);
                    return;
                }
            default:
                return;
        }
    }
}
