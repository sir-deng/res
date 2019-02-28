package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ap.a.a.c.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;

public class OAuthUI extends WebViewUI {
    private String appId;
    private boolean olR = false;
    private boolean tDg = true;
    private Req tDh;
    private c tDi;
    private al tDj;

    static /* synthetic */ void a(OAuthUI oAuthUI, String str) {
        Uri parse;
        String Pt;
        String bSF;
        Exception e;
        Resp resp;
        Bundle bundle;
        Args args;
        String str2 = null;
        x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, url = " + str);
        if (!bi.oN(str)) {
            parse = Uri.parse(str);
            if (parse == null) {
                oAuthUI.pzt.loadUrl(str);
                return;
            }
            x.i("MicroMsg.OAuthUI", "check schema as appId:" + oAuthUI.appId);
            try {
                Pt = oAuthUI.jAm.Pt(oAuthUI.appId);
                try {
                    bSF = oAuthUI.jAm.bSF();
                    try {
                        str2 = oAuthUI.jAm.aT(274436, null);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bSF = str2;
                }
            } catch (Exception e32) {
                e = e32;
                Pt = str2;
                bSF = str2;
            }
            if (bi.oN(Pt)) {
                x.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                oAuthUI.pzt.loadUrl(str);
            } else if (str.toLowerCase().startsWith("http")) {
                x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                oAuthUI.pzt.loadUrl(str);
            } else if (oAuthUI.olR) {
                oAuthUI.olR = true;
                resp = new Resp();
                resp.transaction = oAuthUI.tDh.transaction;
                resp.lang = bSF;
                resp.country = str2;
                str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                if (bi.oN(str2)) {
                    resp.errCode = -1;
                } else if (str2.toLowerCase().equals("authdeny")) {
                    resp.errCode = 0;
                    resp.code = str2;
                } else {
                    resp.errCode = -4;
                }
                resp.state = parse.getQueryParameter("state");
                resp.errStr = parse.getQueryParameter("reason");
                resp.url = str;
                x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                bundle = new Bundle();
                resp.toBundle(bundle);
                p.ae(bundle);
                args = new Args();
                args.targetPkgName = Pt;
                args.bundle = bundle;
                MMessageActV2.send(oAuthUI, args);
                oAuthUI.finish();
            } else {
                x.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
            }
        }
        return;
        x.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
        if (bi.oN(Pt)) {
            x.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
            oAuthUI.pzt.loadUrl(str);
        } else if (str.toLowerCase().startsWith("http")) {
            x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
            oAuthUI.pzt.loadUrl(str);
        } else if (oAuthUI.olR) {
            oAuthUI.olR = true;
            resp = new Resp();
            resp.transaction = oAuthUI.tDh.transaction;
            resp.lang = bSF;
            resp.country = str2;
            str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
            if (bi.oN(str2)) {
                resp.errCode = -1;
            } else if (str2.toLowerCase().equals("authdeny")) {
                resp.errCode = 0;
                resp.code = str2;
            } else {
                resp.errCode = -4;
            }
            resp.state = parse.getQueryParameter("state");
            resp.errStr = parse.getQueryParameter("reason");
            resp.url = str;
            x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
            bundle = new Bundle();
            resp.toBundle(bundle);
            p.ae(bundle);
            args = new Args();
            args.targetPkgName = Pt;
            args.bundle = bundle;
            MMessageActV2.send(oAuthUI, args);
            oAuthUI.finish();
        } else {
            x.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
        }
    }

    static /* synthetic */ void a(OAuthUI oAuthUI, String str, String str2, final String str3) {
        final View inflate = ((ViewStub) oAuthUI.findViewById(R.h.cyH)).inflate();
        oAuthUI.setMMTitle(oAuthUI.getString(R.l.eXQ));
        oAuthUI.setMMSubTitle(oAuthUI.getString(R.l.eIG));
        oAuthUI.removeOptionMenu(1);
        ImageView imageView = (ImageView) oAuthUI.findViewById(R.h.cok);
        TextView textView = (TextView) oAuthUI.findViewById(R.h.cZO);
        final ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) oAuthUI.findViewById(R.h.cty);
        threeDotsLoadingView.czW();
        a aVar = new a();
        aVar.hFK = 10.0f;
        aVar.hFA = R.k.dzq;
        com.tencent.mm.ap.a.a.PN().a(str, imageView, aVar.PQ());
        if (bi.oN(str2)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str2);
        }
        oAuthUI.tDj = new al(new al.a() {
            public final boolean uG() {
                OAuthUI.a(OAuthUI.this, str3);
                inflate.setVisibility(8);
                threeDotsLoadingView.ajR();
                return false;
            }
        }, false);
        oAuthUI.tDj.K(1000, 1000);
    }

    static /* synthetic */ void b(OAuthUI oAuthUI, String str) {
        ((ViewStub) oAuthUI.findViewById(R.h.cyI)).inflate();
        oAuthUI.setMMTitle(oAuthUI.getString(R.l.eXQ));
        oAuthUI.setMMSubTitle(oAuthUI.getString(R.l.eIG));
        oAuthUI.removeOptionMenu(1);
        TextView textView = (TextView) oAuthUI.findViewById(R.h.cZO);
        if (bi.oN(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
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
        return R.i.duo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.tyl != null) {
            this.tyl.bRN().fJB = "weixin://mark/oauth";
        }
    }

    protected final void alu() {
        boolean aPk;
        super.alu();
        try {
            aPk = this.jAm.aPk();
        } catch (Exception e) {
            x.w("MicroMsg.OAuthUI", "hasSetUin, ex = " + e.getMessage());
            aPk = false;
        }
        if (aPk) {
            this.pzt.setWebChromeClient(new j() {
                public final void d(WebView webView, String str) {
                    super.d(webView, str);
                    OAuthUI.this.setMMTitle(str);
                }
            });
            this.pzt.setWebViewClient(new h() {
                public final boolean PD(String str) {
                    x.i("MicroMsg.OAuthUI", "mmShouldOverrideUrlLoading, url = " + str);
                    if (!(str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe"))) {
                        OAuthUI.a(OAuthUI.this, str);
                    }
                    return true;
                }
            });
            this.pzt.setDownloadListener(new DownloadListener() {
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    OAuthUI.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            });
            this.pzt.czN();
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    OAuthUI.this.bSV();
                    OAuthUI.this.finish();
                    return true;
                }
            });
            addTextOptionMenu(1, getString(R.l.dGH), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (OAuthUI.this.tDi != null) {
                        OAuthUI.this.tDi;
                    }
                    OAuthUI.this.pzt.stopLoading();
                    OAuthUI.this.J(false, false);
                    OAuthUI.this.bSX();
                    return false;
                }
            });
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(ConstantsAPI.CONTENT);
            if (bi.oN(string)) {
                x.f("MicroMsg.OAuthUI", "content is null");
                return;
            }
            this.appId = Uri.parse(string).getQueryParameter("appid");
            x.i("MicroMsg.OAuthUI", "initView, appId = " + this.appId);
            try {
                this.jAm.Ps(this.appId);
            } catch (Exception e2) {
                x.w("MicroMsg.OAuthUI", "checkGetAppSetting, ex = " + e2.getMessage());
            }
            this.tDh = new Req(extras);
            try {
                this.tFC.bTY();
            } catch (Exception e22) {
                x.w("MicroMsg.OAuthUI", "AC_ADD_SCENE_END, ex = " + e22.getMessage());
            }
            bSX();
            return;
        }
        x.e("MicroMsg.OAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, R.l.dCs, 1).show();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                OAuthUI.this.finish();
                return true;
            }
        });
        enableOptionMenu(false);
    }

    protected void onStop() {
        this.pzt.stopLoading();
        super.onStop();
    }

    protected void onDestroy() {
        try {
            this.tFC.bTZ();
        } catch (Exception e) {
            x.w("MicroMsg.OAuthUI", "AC_REMOVE_SCENE_END, ex = " + e.getMessage());
        }
        if (this.tDj != null) {
            this.tDj.TN();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.tDg && i == 4 && this.pzt.canGoBack()) {
            this.pzt.goBack();
            return true;
        } else if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        } else {
            bSV();
            finish();
            return true;
        }
    }

    private void bSV() {
        String Pt;
        String bSF;
        Exception e;
        Resp resp;
        Bundle bundle;
        Args args;
        String str = null;
        x.i("MicroMsg.OAuthUI", "callbackResultCancel, appId = " + this.appId);
        if (this.olR) {
            x.e("MicroMsg.OAuthUI", "has callback, ignore this callback");
            return;
        }
        this.olR = true;
        try {
            Pt = this.jAm.Pt(this.appId);
            try {
                bSF = this.jAm.bSF();
                try {
                    str = this.jAm.aT(274436, null);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                bSF = str;
            }
        } catch (Exception e32) {
            e = e32;
            Pt = str;
            bSF = str;
        }
        if (bi.oN(Pt)) {
            resp = new Resp();
            resp.transaction = this.tDh.transaction;
            resp.errCode = -2;
            resp.lang = bSF;
            resp.country = str;
            bundle = new Bundle();
            resp.toBundle(bundle);
            p.ae(bundle);
            args = new Args();
            args.targetPkgName = Pt;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
            return;
        }
        x.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
        x.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
        if (bi.oN(Pt)) {
            resp = new Resp();
            resp.transaction = this.tDh.transaction;
            resp.errCode = -2;
            resp.lang = bSF;
            resp.country = str;
            bundle = new Bundle();
            resp.toBundle(bundle);
            p.ae(bundle);
            args = new Args();
            args.targetPkgName = Pt;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
            return;
        }
        x.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
    }

    protected final boolean bSW() {
        return true;
    }

    protected final void initView() {
        super.initView();
        this.pzt.getSettings().setJavaScriptEnabled(true);
        this.pzt.setVerticalScrollBarEnabled(false);
    }

    private void bSX() {
        w.d(getSharedPreferences(ad.cgf(), 0));
        this.tDi = c.a(this, this.appId, this.tDh, new c.a() {
            public final void a(c cVar, String str, boolean z) {
                x.i("MicroMsg.OAuthUI", "onResult, url = " + str + ", isShowLocalErrorPage = " + z);
                if (cVar != null) {
                    cVar.tDb = false;
                }
                if (z) {
                    String string;
                    try {
                        string = OAuthUI.this.getString(R.l.ezT);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.OAuthUI", e, "", new Object[0]);
                        string = null;
                    }
                    x.i("MicroMsg.OAuthUI", "onResult, html = " + string);
                    if (OAuthUI.this.pzt != null) {
                        OAuthUI.this.pzt.loadUrl(string);
                        if (OAuthUI.this.tyl != null) {
                            OAuthUI.this.tyl.bRN().fJB = string;
                        }
                    }
                } else if (!bi.oN(str) && OAuthUI.this.pzt != null) {
                    OAuthUI.this.pzt.loadUrl(str);
                    if (OAuthUI.this.tyl != null) {
                        OAuthUI.this.tyl.bRN().fJB = str;
                    }
                }
            }

            public final void c(boolean z, String str, String str2, String str3) {
                if (z) {
                    OAuthUI.a(OAuthUI.this, str2, str3, str);
                } else {
                    OAuthUI.b(OAuthUI.this, str3);
                }
            }
        }, this.jAm);
    }

    public final void b(c cVar) {
        c cVar2;
        int i;
        int i2;
        String str;
        int i3;
        Exception e;
        Object obj;
        boolean z;
        c.a aVar;
        c cVar3;
        c.a aVar2;
        if (this.tDi != null) {
            cVar2 = this.tDi;
            if (cVar2.tDb) {
                String string;
                i = -1;
                i2 = -1;
                str = null;
                String str2 = null;
                i3 = -1;
                try {
                    i = cVar.bSx();
                    i2 = cVar.bSy();
                    cVar.KS();
                    str = cVar.getData().getString("geta8key_result_full_url");
                    str2 = cVar.getData().getString("geta8key_result_head_img");
                    string = cVar.getData().getString("geta8key_result_wording");
                    try {
                        i3 = cVar.getData().getInt("geta8key_result_action_code", -1);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    Exception exception = e3;
                    string = null;
                    e = exception;
                }
                x.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + i + ", errCode = " + i2 + " , actionCode=" + i3);
                if (cVar2.mNX != null) {
                    cVar2.mNX.dismiss();
                }
                cVar2.tDa = false;
                cVar2.hmy.TN();
                if ((i2 == 0 || i != 0) && i2 != -2033) {
                    if (i == 4 || i2 != -100) {
                        if (i != 1 || i == 2 || i == 7 || i == 8) {
                            x.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + i);
                            obj = null;
                        } else if (ao.isConnected(cVar2.tDd)) {
                            obj = 1;
                        } else {
                            x.e("MicroMsg.OAuthSession", "isNetworkAvailable false, not connected");
                            obj = null;
                        }
                        if (obj != null) {
                            str = null;
                            z = true;
                            aVar = cVar2.tDc;
                            cVar3 = cVar2;
                        } else {
                            aVar2 = cVar2.tDc;
                            if (i2 != -1) {
                                z = true;
                                aVar = aVar2;
                                cVar3 = cVar2;
                            } else {
                                z = false;
                                aVar = aVar2;
                                cVar3 = cVar2;
                            }
                        }
                        aVar.a(cVar3, str, z);
                    }
                    cVar2.tDd.J(true, true);
                    try {
                        cVar2.jAm.ab(i, i2, cVar2.hashCode());
                        return;
                    } catch (Exception e4) {
                        x.w("MicroMsg.OAuthSession", "accountExpired, ex = " + e4.getMessage());
                        return;
                    }
                } else if (i3 == 27) {
                    cVar2.tDb = false;
                    cVar2.tDc.c(i2 == 0, str, str2, string);
                    return;
                } else {
                    cVar2.tDc.a(cVar2, str, false);
                    return;
                }
            }
            x.w("MicroMsg.OAuthSession", "onScenEnd, not listening");
            return;
        }
        return;
        x.e("MicroMsg.OAuthSession", "onSceneEnd, ex = " + e.getMessage());
        x.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + i + ", errCode = " + i2 + " , actionCode=" + i3);
        if (cVar2.mNX != null) {
            cVar2.mNX.dismiss();
        }
        cVar2.tDa = false;
        cVar2.hmy.TN();
        if (i2 == 0) {
        }
        if (i == 4) {
        }
        if (i != 1) {
        }
        x.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + i);
        obj = null;
        if (obj != null) {
            aVar2 = cVar2.tDc;
            if (i2 != -1) {
                z = false;
                aVar = aVar2;
                cVar3 = cVar2;
            } else {
                z = true;
                aVar = aVar2;
                cVar3 = cVar2;
            }
        } else {
            str = null;
            z = true;
            aVar = cVar2.tDc;
            cVar3 = cVar2;
        }
        aVar.a(cVar3, str, z);
    }
}
