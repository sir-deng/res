package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.mm.ad.b;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.bhn;
import com.tencent.mm.protocal.c.bho;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.protocal.c.bnr;
import com.tencent.mm.protocal.c.bns;
import com.tencent.mm.protocal.c.btx;
import com.tencent.mm.protocal.c.bty;
import com.tencent.mm.protocal.c.eg;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppBrandIDCardUI extends DrawStatusBarActivity {
    public static final int jQv = g.iwo;
    private String appId;
    private r jCh;
    private String jTA;
    private a jTe = new a() {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1$2 */
        class AnonymousClass2 implements OnClickListener {
            final /* synthetic */ int fmv;
            final /* synthetic */ String hoT;

            AnonymousClass2(int i, String str) {
                this.fmv = i;
                this.hoT = str;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("intent_err_code", bi.p(Integer.valueOf(this.fmv), 0));
                intent.putExtra("intent_err_msg", bi.oM(this.hoT));
                AppBrandIDCardUI.this.setResult(1, intent);
                AppBrandIDCardUI.this.finish();
            }
        }

        public final void alE() {
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnT = new bjt();
            aVar.hnU = new bju();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
            aVar.hnS = 1774;
            aVar.hnV = 0;
            aVar.hnW = 0;
            b Kf = aVar.Kf();
            bjt bjt = (bjt) Kf.hnQ.hnY;
            bjt.fGh = AppBrandIDCardUI.this.appId;
            bjt.wSC = AppBrandIDCardUI.this.jTy;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, b bVar) {
                    if (AppBrandIDCardUI.this.jCh != null && AppBrandIDCardUI.this.jCh.isShowing()) {
                        AppBrandIDCardUI.this.jCh.dismiss();
                    }
                    Intent intent;
                    if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                        bju bju = (bju) bVar.hnR.hnY;
                        if (bju.wSE == null) {
                            x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                            intent = new Intent();
                            intent.putExtra("intent_err_code", 40000);
                            intent.putExtra("intent_err_msg", "network err");
                            AppBrandIDCardUI.this.setResult(1, intent);
                            AppBrandIDCardUI.this.finish();
                            return;
                        }
                        x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", Integer.valueOf(bju.wSE.fyF));
                        x.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", Integer.valueOf(bju.wTF));
                        switch (bju.wTF) {
                            case 0:
                                if (bju.wSE.fyF != 0) {
                                    x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                                    intent = new Intent();
                                    intent.putExtra("intent_err_code", bju.wSE.fyF);
                                    intent.putExtra("intent_err_msg", bju.wSE.fyG);
                                    AppBrandIDCardUI.this.setResult(1, intent);
                                    AppBrandIDCardUI.this.finish();
                                    return;
                                }
                                AppBrandIDCardUI.this.jTw = bju;
                                AppBrandIDCardUI.d(AppBrandIDCardUI.this);
                                return;
                            case 1:
                                x.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", Integer.valueOf(bju.wSE.fyF), bju.wSE.fyG);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                h.a(AppBrandIDCardUI.this, false, bju.wTG.desc, bju.wTG.title, AppBrandIDCardUI.this.getString(j.iBU), "", new AnonymousClass2(bju.wSE.fyF, bju.wSE.fyG), new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                return;
                            default:
                                x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
                                return;
                        }
                    }
                    x.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                    intent = new Intent();
                    intent.putExtra("intent_err_code", 40000);
                    intent.putExtra("intent_err_msg", "network err");
                    AppBrandIDCardUI.this.setResult(1, intent);
                    AppBrandIDCardUI.this.finish();
                }
            });
        }

        public final void onSwipeBack() {
            AppBrandIDCardUI.this.onSwipeBack();
        }

        public final void back() {
            AppBrandIDCardUI.this.back();
        }

        public final void uX(String str) {
            x.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
            va(str);
        }

        public final void uY(String str) {
            x.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
            va(str);
        }

        public final void uZ(String str) {
            x.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
            va(str);
        }

        private void va(String str) {
            if (bi.oN(str)) {
                x.e("MicroMsg.AppBrandIDCardUI", "url is null");
                return;
            }
            x.v("MicroMsg.AppBrandIDCardUI", "goToWebview url: " + str);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("forceHideShare", true);
            d.b(AppBrandIDCardUI.this, "webview", ".ui.tools.WebViewUI", intent);
        }

        public final void alF() {
            x.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
            com.tencent.mm.plugin.report.service.g.pWK.h(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(2), AppBrandIDCardUI.this.jTw.fsK);
            if (AppBrandIDCardUI.this.jTw.wTN == null) {
                x.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", AppBrandIDCardUI.this.jTw.wTN.fGh);
                jSONObject.put("timeStamp", AppBrandIDCardUI.this.jTw.wTN.fry);
                jSONObject.put("nonceStr", AppBrandIDCardUI.this.jTw.wTN.wzR);
                jSONObject.put("package", AppBrandIDCardUI.this.jTw.wTN.xbQ);
                jSONObject.put("signType", AppBrandIDCardUI.this.jTw.wTN.kZO);
                jSONObject.put("paySign", AppBrandIDCardUI.this.jTw.wTN.wzA);
                com.tencent.mm.plugin.report.service.g.pWK.h(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(3), AppBrandIDCardUI.this.jTw.fsK);
                com.tencent.mm.plugin.appbrand.jsapi.g.a.jsn.a(AppBrandIDCardUI.this, jSONObject, new com.tencent.mm.plugin.appbrand.jsapi.g.b.b() {
                    public final void d(boolean z, final String str) {
                        if (z) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(4), AppBrandIDCardUI.this.jTw.fsK);
                            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                            aVar.hnT = new bnr();
                            aVar.hnU = new bns();
                            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                            aVar.hnS = 1721;
                            aVar.hnV = 0;
                            aVar.hnW = 0;
                            b Kf = aVar.Kf();
                            bnr bnr = (bnr) Kf.hnQ.hnY;
                            bnr.fGh = AppBrandIDCardUI.this.appId;
                            bnr.wSC = AppBrandIDCardUI.this.jTy;
                            bnr.wSD = str;
                            bnr.fsK = AppBrandIDCardUI.this.jTw.fsK;
                            AppBrandIDCardUI.this.jCh.show();
                            com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                                public final void a(int i, int i2, String str, b bVar) {
                                    if (AppBrandIDCardUI.this.jCh != null && AppBrandIDCardUI.this.jCh.isShowing()) {
                                        AppBrandIDCardUI.this.jCh.dismiss();
                                    }
                                    if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                                        bns bns = (bns) bVar.hnR.hnY;
                                        if (bns.wSE == null) {
                                            x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                                            Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(j.iBT), 0).show();
                                            return;
                                        }
                                        x.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", Integer.valueOf(bns.vQj));
                                        switch (bns.vQj) {
                                            case 0:
                                                x.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", bns.wXF);
                                                com.tencent.mm.plugin.report.service.g.pWK.h(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(9), AppBrandIDCardUI.this.jTw.fsK);
                                                Intent intent = new Intent();
                                                intent.putExtra("intent_err_code", bns.wSE.fyF);
                                                intent.putExtra("intent_auth_token", bns.wXF);
                                                AppBrandIDCardUI.this.setResult(-1, intent);
                                                AppBrandIDCardUI.this.finish();
                                                return;
                                            case 1:
                                                com.tencent.mm.plugin.report.service.g.pWK.h(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(5), AppBrandIDCardUI.this.jTw.fsK);
                                                AppBrandIDCardUI.this.jTz = str;
                                                AppBrandIDCardUI.this.jTx = bns.wXE;
                                                AppBrandIDCardUI.g(AppBrandIDCardUI.this);
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                    x.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                                }
                            });
                        }
                        x.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", Boolean.valueOf(z));
                    }
                });
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e, "", new Object[0]);
            }
        }

        public final void alG() {
            com.tencent.mm.plugin.report.service.g.pWK.h(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(6), AppBrandIDCardUI.this.jTw.fsK);
        }

        public final void a(eg egVar) {
            com.tencent.mm.plugin.report.service.g.pWK.h(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(7), AppBrandIDCardUI.this.jTw.fsK);
            x.i("MicroMsg.AppBrandIDCardUI", "sendSms");
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnT = new bhn();
            aVar.hnU = new bho();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
            aVar.hnS = 1762;
            aVar.hnV = 0;
            aVar.hnW = 0;
            b Kf = aVar.Kf();
            bhn bhn = (bhn) Kf.hnQ.hnY;
            bhn.fGh = AppBrandIDCardUI.this.appId;
            bhn.wSC = AppBrandIDCardUI.this.jTy;
            bhn.wSD = AppBrandIDCardUI.this.jTz;
            bhn.vQk = egVar.vQk;
            bhn.pff = egVar.pff;
            bhn.fsK = AppBrandIDCardUI.this.jTw.fsK;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, b bVar) {
                    if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                        bho bho = (bho) bVar.hnR.hnY;
                        if (bho.wSE != null) {
                            x.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", Integer.valueOf(bho.wSE.fyF));
                            if (bho.wSE.fyF == 0) {
                                AppBrandIDCardUI.this.jTA = bho.wSF;
                                x.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", bho.wSF);
                                return;
                            }
                            h.a(AppBrandIDCardUI.this, false, AppBrandIDCardUI.this.getString(j.iBZ), "", AppBrandIDCardUI.this.getString(j.iBf), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    x.i("MicroMsg.AppBrandIDCardUI", "[showVerifySmsAlert] btn click");
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        }
                        x.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
                        h.a(AppBrandIDCardUI.this, false, AppBrandIDCardUI.this.getString(j.iBZ), "", AppBrandIDCardUI.this.getString(j.iBf), "", /* anonymous class already generated */, /* anonymous class already generated */);
                        return;
                    }
                    x.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                    Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(j.iBT), 0).show();
                }
            });
        }

        public final void a(String str, eg egVar) {
            if (bi.oN(str)) {
                x.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
            } else if (bi.oN(egVar.vQk)) {
                x.e("MicroMsg.AppBrandIDCardUI", "phoneId is null, err, return");
            } else {
                x.i("MicroMsg.AppBrandIDCardUI", "verifySms");
                com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                aVar.hnT = new btx();
                aVar.hnU = new bty();
                aVar.uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
                aVar.hnS = 1721;
                aVar.hnV = 0;
                aVar.hnW = 0;
                b Kf = aVar.Kf();
                btx btx = (btx) Kf.hnQ.hnY;
                btx.fGh = AppBrandIDCardUI.this.appId;
                btx.wSC = AppBrandIDCardUI.this.jTy;
                btx.wSD = AppBrandIDCardUI.this.jTz;
                btx.vQk = egVar.vQk;
                btx.fsK = AppBrandIDCardUI.this.jTw.fsK;
                btx.sVt = str;
                btx.wSF = AppBrandIDCardUI.this.jTA;
                btx.pff = egVar.pff;
                com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                    public final void a(int i, int i2, String str, b bVar) {
                        if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                            bty bty = (bty) bVar.hnR.hnY;
                            if (bty.wSE != null) {
                                x.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", Integer.valueOf(bty.wSE.fyF), bi.oM(bty.wSE.fyG));
                                com.tencent.mm.plugin.report.service.g.pWK.h(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(8), AppBrandIDCardUI.this.jTw.fsK);
                                if (bty.wSE.fyF == 0) {
                                    com.tencent.mm.plugin.report.service.g.pWK.h(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(9), AppBrandIDCardUI.this.jTw.fsK);
                                    x.i("MicroMsg.AppBrandIDCardUI", "verify success");
                                    x.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", bty.wXF);
                                    Intent intent = new Intent();
                                    intent.putExtra("intent_err_code", bty.wSE.fyF);
                                    intent.putExtra("intent_auth_token", bty.wXF);
                                    AppBrandIDCardUI.this.setResult(-1, intent);
                                    AppBrandIDCardUI.this.finish();
                                    return;
                                } else if (bty.wSE.fyF == 40013) {
                                    h.a(AppBrandIDCardUI.this, false, AppBrandIDCardUI.this.getString(j.iBY), "", AppBrandIDCardUI.this.getString(j.iBf), "", /* anonymous class already generated */, /* anonymous class already generated */);
                                    return;
                                } else {
                                    h.a(AppBrandIDCardUI.this, false, AppBrandIDCardUI.this.getString(j.iBX), "", AppBrandIDCardUI.this.getString(j.iBf), "", /* anonymous class already generated */, /* anonymous class already generated */);
                                    return;
                                }
                            }
                            x.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
                            return;
                        }
                        x.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                        Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(j.iBT), 0).show();
                    }
                });
            }
        }

        public final bju alH() {
            return AppBrandIDCardUI.this.jTw;
        }

        public final eh alI() {
            return AppBrandIDCardUI.this.jTx;
        }
    };
    public Fragment jTu;
    public Fragment jTv;
    private bju jTw;
    private eh jTx;
    private LinkedList<Integer> jTy;
    private String jTz;

    public interface a {
        void a(eg egVar);

        void a(String str, eg egVar);

        void alE();

        void alF();

        void alG();

        bju alH();

        eh alI();

        void back();

        void onSwipeBack();

        void uX(String str);

        void uY(String str);

        void uZ(String str);
    }

    static /* synthetic */ void d(AppBrandIDCardUI appBrandIDCardUI) {
        x.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
        appBrandIDCardUI.jTu = new a();
        ((a) appBrandIDCardUI.jTu).jTe = appBrandIDCardUI.jTe;
        appBrandIDCardUI.getSupportFragmentManager().aT().a(jQv, appBrandIDCardUI.jTu, appBrandIDCardUI.jTu.getClass().getSimpleName()).m(appBrandIDCardUI.jTu.getClass().getSimpleName()).commit();
    }

    static /* synthetic */ void g(AppBrandIDCardUI appBrandIDCardUI) {
        x.i("MicroMsg.AppBrandIDCardUI", "switchToVerifyFragment");
        appBrandIDCardUI.jTv = new b();
        ((b) appBrandIDCardUI.jTv).jTe = appBrandIDCardUI.jTe;
        appBrandIDCardUI.getSupportFragmentManager().aT().a(jQv, appBrandIDCardUI.jTv, appBrandIDCardUI.jTv.getClass().getSimpleName()).m(appBrandIDCardUI.jTv.getClass().getSimpleName()).commit();
        if (appBrandIDCardUI.isSupportNavigationSwipeBack()) {
            appBrandIDCardUI.getSwipeBackLayout().mEnable = false;
        }
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            x.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
            finish();
            return;
        }
        this.appId = extras.getString("intent_appid", "");
        if (bi.oN(this.appId)) {
            x.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
            finish();
            return;
        }
        this.jTy = y(extras);
        if (bi.cC(this.jTy) || this.jTy.size() <= 0) {
            x.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
            Intent intent = new Intent();
            intent.putExtra("intent_err_code", 40003);
            intent.putExtra("intent_err_msg", "category_id is null");
            setResult(1, intent);
            finish();
            return;
        }
        this.mController.contentView.setBackgroundColor(-1052684);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        View frameLayout = new FrameLayout(this);
        frameLayout.setId(jQv);
        ((ViewGroup) this.mController.contentView).addView(frameLayout, layoutParams);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppBrandIDCardUI.this.back();
                return true;
            }
        });
        getString(j.dGZ);
        this.jCh = h.a((Context) this, getString(j.ctG), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppBrandIDCardUI.this.setResult(0);
                AppBrandIDCardUI.this.finish();
            }
        });
        this.jCh.show();
        this.jTe.alE();
    }

    public void onBackPressed() {
        back();
    }

    private void back() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
            return;
        }
        super.onBackPressed();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().mEnable = true;
        }
    }

    public void onSwipeBack() {
        back();
    }

    private static LinkedList<Integer> y(Bundle bundle) {
        LinkedList<Integer> linkedList = new LinkedList();
        try {
            x.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", bundle.getString("intent_category_id"));
            JSONArray jSONArray = new JSONArray(r1);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(Integer.valueOf(jSONArray.optInt(i)));
            }
            return linkedList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e, "", new Object[0]);
            return null;
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
