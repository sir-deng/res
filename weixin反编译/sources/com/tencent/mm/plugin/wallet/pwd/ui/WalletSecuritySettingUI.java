package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import org.json.JSONObject;

public class WalletSecuritySettingUI extends MMPreference implements e {
    private f inW;
    private boolean sNL = true;
    private WalletSecuritySettingHeaderPref sNM;
    private IconPreference sNN;
    private IconPreference sNO;
    private IconPreference sNP;
    private IconPreference sNQ;
    private Preference sNR;
    private a sNS;
    private d sNT;
    private c sNU;
    private b sNV;
    private ProgressDialog sNW;

    private class b {
        String desc;
        String oVl;
        String sNZ;
        String sOc;
        String sOd;
        String sOe;
        int status;
        String title;

        b(Context context) {
            if (!p.m(context, "com.tencent.qqpimsecure")) {
                this.status = 0;
            } else if (bi.bi(context, "com.tencent.server.back.BackEngine")) {
                this.status = 2;
            } else {
                this.status = 1;
            }
        }

        public final String getUrl() {
            if (this.status == 0) {
                return eI("qqpimsecurestatus", "not_installed");
            }
            if (this.status == 1) {
                return eI("qqpimsecurestatus", "not_run");
            }
            return eI("qqpimsecurestatus", "runing");
        }

        private String eI(String str, String str2) {
            return Uri.parse(this.sNZ).buildUpon().appendQueryParameter(str, str2).build().toString();
        }
    }

    private class d {
        String desc;
        String oVl;
        String sOh;
        boolean sOi;
        int status;
        String title;

        private d() {
        }

        /* synthetic */ d(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    private class a {
        String desc;
        int jumpType;
        String oVl;
        String sNZ;
        String sOa;
        String sOb;
        String title;

        private a() {
        }

        /* synthetic */ a(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    private class c {
        String desc;
        int jumpType;
        String oVl;
        String sNZ;
        String sOa;
        String sOf;
        String sOg;
        int status;
        String title;

        private c() {
        }

        /* synthetic */ c(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletSecuritySettingUI.this.finish();
                return false;
            }
        });
    }

    public final int XK() {
        return -1;
    }

    protected final void initView() {
        super.initView();
        this.inW = this.yrJ;
        if (this.inW != null) {
            this.inW.addPreferencesFromResource(l.vhc);
        }
        g.Dr();
        String str = (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_CURRENT_JSON_TYPE_STRING_SYNC, (Object) "");
        if (!bi.oN(str)) {
            try {
                U(new JSONObject(str));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e, "", new Object[0]);
            }
        }
    }

    protected void onResume() {
        String string;
        String str = null;
        super.onResume();
        this.sNM = (WalletSecuritySettingHeaderPref) this.inW.Zu("wallet_security_basic_info");
        if (this.sNM != null) {
            boolean z;
            WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.sNM;
            OnClickListener anonymousClass2 = new OnClickListener() {
                public final void onClick(View view) {
                    if (WalletSecuritySettingUI.this.sNS != null && bi.oN(WalletSecuritySettingUI.this.sNS.sNZ)) {
                        x.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
                    } else if (WalletSecuritySettingUI.this.sNS != null && WalletSecuritySettingUI.this.sNS.jumpType == 1 && !bi.oN(WalletSecuritySettingUI.this.sNS.sNZ)) {
                        Intent intent = new Intent();
                        x.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", WalletSecuritySettingUI.this.sNS.sNZ);
                        intent.putExtra("rawUrl", WalletSecuritySettingUI.this.sNS.sNZ);
                        com.tencent.mm.bl.d.b(WalletSecuritySettingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    } else if (WalletSecuritySettingUI.this.sNS != null && WalletSecuritySettingUI.this.sNS.jumpType == 2) {
                        bi.oN(WalletSecuritySettingUI.this.sNS.sOa);
                    }
                }
            };
            String str2 = "MicroMsg.WalletSecuritySettingHeaderPref";
            String str3 = "alvinluo details == null: %b";
            Object[] objArr = new Object[1];
            if (walletSecuritySettingHeaderPref.sNG == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.v(str2, str3, objArr);
            walletSecuritySettingHeaderPref.sNJ = anonymousClass2;
            if (walletSecuritySettingHeaderPref.sNG != null) {
                walletSecuritySettingHeaderPref.sNG.setOnClickListener(anonymousClass2);
            }
            walletSecuritySettingHeaderPref = this.sNM;
            anonymousClass2 = new OnClickListener() {
                public final void onClick(View view) {
                    x.v("MicroMsg.WalletSecuritySettingUI", "alvinluo click close");
                    WalletSecuritySettingUI.this.finish();
                }
            };
            str2 = "MicroMsg.WalletSecuritySettingHeaderPref";
            str3 = "alvinluo closeBtn == null: %b";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(walletSecuritySettingHeaderPref.kso == null);
            x.v(str2, str3, objArr);
            walletSecuritySettingHeaderPref.sNK = anonymousClass2;
            if (walletSecuritySettingHeaderPref.kso != null) {
                walletSecuritySettingHeaderPref.kso.setOnClickListener(anonymousClass2);
            }
        }
        g.Dr();
        g.Dp().gRu.a(385, (e) this);
        if (this.sNL) {
            this.sNW = h.a((Context) this, getString(i.dHn), false, null);
            this.sNL = false;
        }
        boolean aKD = ((com.tencent.mm.pluginsdk.l) g.h(com.tencent.mm.pluginsdk.l.class)).aKD();
        SharedPreferences cgg = ad.cgg();
        if (cgg != null) {
            String string2 = cgg.getString("cpu_id", null);
            string = cgg.getString("uid", null);
            str = string2;
        } else {
            string = null;
        }
        x.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", Boolean.valueOf(aKD));
        g.CN().a(new com.tencent.mm.plugin.wallet.pwd.a.d(aKD, str, string), 0);
    }

    protected void onPause() {
        super.onPause();
        g.Dr();
        g.Dp().gRu.b(385, (e) this);
    }

    public final boolean a(f fVar, Preference preference) {
        if ("wallet_security_digital_certificate".equals(preference.idX)) {
            com.tencent.mm.bl.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
            return true;
        } else if ("wallet_security_pay_guard".equals(preference.idX)) {
            if (this.sNV == null) {
                return true;
            }
            x.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", this.sNV.getUrl());
            com.tencent.mm.wallet_core.ui.e.bz(this, this.sNV.getUrl());
            return true;
        } else if ("wallet_security_wallet_lock".equals(preference.idX)) {
            ((com.tencent.mm.plugin.walletlock.a.b) g.h(com.tencent.mm.plugin.walletlock.a.b.class)).c(this, new Intent());
            return true;
        } else if (!"wallet_security_safety_insurance".equals(preference.idX)) {
            return false;
        } else {
            if (this.sNU == null) {
                return true;
            }
            if (this.sNU.jumpType == 2) {
                com.tencent.mm.sdk.b.b qrVar = new qr();
                qrVar.fJd.fJh = 0;
                qrVar.fJd.userName = this.sNU.sOg;
                qrVar.fJd.fJf = this.sNU.sOa;
                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.sNU.sNZ);
                x.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", intent.getStringExtra("rawUrl"));
                com.tencent.mm.bl.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.d) {
            x.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", ((com.tencent.mm.plugin.wallet.pwd.a.d) kVar).sMJ);
            U(r0);
        }
    }

    private void onError(String str) {
        if (this.sNW != null && this.sNW.isShowing()) {
            this.sNW.dismiss();
        }
        h.a((Context) this, str, "", false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                WalletSecuritySettingUI.this.finish();
            }
        });
    }

    private void U(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
            onError(getString(i.vcQ));
            return;
        }
        try {
            JSONObject jSONObject2;
            this.inW = this.yrJ;
            CharSequence string = jSONObject.getString("more_security_title");
            this.sNR = this.inW.Zu("wallet_security_more_title");
            this.sNR.setTitle(string);
            if (jSONObject.has("basic_security_item")) {
                jSONObject2 = jSONObject.getJSONObject("basic_security_item");
                this.sNS = new a();
                this.sNS.title = jSONObject2.optString("title");
                this.sNS.desc = jSONObject2.optString("desc");
                this.sNS.oVl = jSONObject2.optString("logo_url");
            }
            if (jSONObject.has("wallet_lock_info")) {
                jSONObject2 = jSONObject.getJSONObject("wallet_lock_info");
                this.sNT = new d();
                this.sNT.title = jSONObject2.optString("wallet_lock_title");
                this.sNT.desc = jSONObject2.optString("wallet_lock_desc");
                this.sNT.oVl = jSONObject2.getString("wallet_lock_logo_url");
                this.sNT.status = jSONObject2.optInt("wallet_lock_status");
                this.sNT.sOh = jSONObject2.optString("wallet_lock_status_name");
                this.sNT.sOi = jSONObject2.optBoolean("is_open_touch_pay", false);
            }
            if (jSONObject.has("property_security_info")) {
                jSONObject2 = jSONObject.getJSONObject("property_security_info");
                this.sNU = new c();
                this.sNU.title = jSONObject2.optString("title", "");
                this.sNU.desc = jSONObject2.optString("desc", "");
                this.sNU.oVl = jSONObject2.optString("logo_url", "");
                this.sNU.status = jSONObject2.optInt(DownloadInfo.STATUS, 0);
                this.sNU.sOf = jSONObject2.optString("status_name");
                this.sNU.jumpType = jSONObject2.optInt("jump_type");
                this.sNU.sNZ = jSONObject2.optString("jump_h5_url");
                this.sNU.sOg = jSONObject2.optString("tinyapp_username");
                this.sNU.sOa = jSONObject2.optString("tinyapp_path");
            }
            if (jSONObject.has("safe_manager_info")) {
                jSONObject2 = jSONObject.getJSONObject("safe_manager_info");
                this.sNV = new b(this);
                this.sNV.title = jSONObject2.optString("title", "");
                this.sNV.desc = jSONObject2.optString("desc", "");
                this.sNV.oVl = jSONObject2.optString("logo_url", "");
                this.sNV.sOd = jSONObject2.optString("installed_status_name");
                this.sNV.sOc = jSONObject2.optString("uninstall_status_name");
                this.sNV.sOe = jSONObject2.optString("protected_mode_name");
                this.sNV.sNZ = jSONObject2.optString("jump_h5_url");
            }
            r.cCq().ak(jSONObject);
            g.Dr();
            g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_CURRENT_JSON_TYPE_STRING_SYNC, jSONObject.toString());
            this.sNM = (WalletSecuritySettingHeaderPref) this.inW.Zu("wallet_security_basic_info");
            if (this.sNS != null) {
                WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.sNM;
                String str = this.sNS.title;
                String str2 = this.sNS.desc;
                String str3 = this.sNS.sOb;
                walletSecuritySettingHeaderPref.mqp = str;
                walletSecuritySettingHeaderPref.sNH = str2;
                walletSecuritySettingHeaderPref.sNI = str3;
                walletSecuritySettingHeaderPref.av();
                if (bi.oN(this.sNS.sOb)) {
                    walletSecuritySettingHeaderPref = this.sNM;
                    if (walletSecuritySettingHeaderPref.sNG != null) {
                        walletSecuritySettingHeaderPref.sNG.setVisibility(8);
                    }
                }
            }
            if (this.sNT == null) {
                this.inW.bl("wallet_security_wallet_lock", true);
            } else {
                this.inW.bl("wallet_security_wallet_lock", false);
                this.sNP = (IconPreference) this.inW.Zu("wallet_security_wallet_lock");
                a(this.sNT.oVl, this.sNP);
                this.sNP.setTitle(this.sNT.title);
                this.sNP.setSummary(this.sNT.sOh);
                this.sNP.Zx(this.sNT.desc);
                this.sNP.crb();
            }
            this.inW.bl("wallet_security_digital_certificate", false);
            this.sNN = (IconPreference) this.inW.Zu("wallet_security_digital_certificate");
            r.cCq();
            g.Dr();
            if ((((Integer) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLETDIGITAL_CERT_SHOW_INT_SYNC, Integer.valueOf(0))).intValue() > 0 ? 1 : 0) == 0) {
                this.inW.bl("wallet_security_digital_certificate", true);
            } else {
                if (r.cCq().cCr()) {
                    if (this.sNN != null) {
                        this.sNN.setSummary(i.vcR);
                    }
                } else if (this.sNN != null) {
                    this.sNN.setSummary(i.vcS);
                }
                a(r.cCq().zQW, this.sNN);
                this.sNN.setTitle(r.cCq().zQU);
                this.sNN.setSummary(r.cCq().zQV);
                this.sNN.Zx(r.cCq().zQT);
                this.sNN.crb();
            }
            this.inW.bl("wallet_security_pay_guard", false);
            this.sNO = (IconPreference) this.inW.Zu("wallet_security_pay_guard");
            if (this.sNO != null) {
                this.sNO.setSummary(i.vcS);
            }
            if (this.sNV == null) {
                this.inW.bl("wallet_security_pay_guard", true);
            } else {
                a(this.sNV.oVl, this.sNO);
                this.sNO.setTitle(this.sNV.title);
                IconPreference iconPreference = this.sNO;
                b bVar = this.sNV;
                string = bVar.status == 0 ? bVar.sOc : bVar.status == 1 ? bVar.sOd : bVar.sOe;
                iconPreference.setSummary(string);
                this.sNO.Zx(this.sNV.desc);
                this.sNO.crb();
            }
            this.inW = this.yrJ;
            this.inW.bl("wallet_security_safety_insurance", false);
            this.sNQ = (IconPreference) this.inW.Zu("wallet_security_safety_insurance");
            if (this.sNQ != null) {
                this.sNQ.setSummary(i.vcT);
            }
            if (this.sNU == null) {
                this.inW.bl("wallet_security_safety_insurance", true);
            } else {
                a(this.sNU.oVl, this.sNQ);
                this.sNQ.setTitle(this.sNU.title);
                this.sNQ.setSummary(this.sNU.sOf);
                this.sNQ.Zx(this.sNU.desc);
                this.sNQ.crb();
            }
            this.inW.notifyDataSetChanged();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e, "", new Object[0]);
            onError(getString(i.vcQ));
        }
        if (this.sNW != null && this.sNW.isShowing()) {
            this.sNW.dismiss();
        }
    }

    private void a(String str, final IconPreference iconPreference) {
        if (iconPreference != null) {
            o.PB();
            Bitmap iJ = com.tencent.mm.ap.c.iJ(str);
            if (iJ != null) {
                iconPreference.drawable = new BitmapDrawable(this.mController.xRr.getResources(), iJ);
            } else if (!bi.oN(str)) {
                o.PF().a(str, new com.tencent.mm.ap.p.a() {
                    public final void h(String str, Bitmap bitmap) {
                        x.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", str);
                        iconPreference.drawable = new BitmapDrawable(WalletSecuritySettingUI.this.mController.xRr.getResources(), bitmap);
                    }
                });
            }
        }
    }
}
