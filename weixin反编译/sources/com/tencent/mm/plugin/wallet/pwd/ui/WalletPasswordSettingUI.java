package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.bp;
import com.tencent.mm.f.a.su;
import com.tencent.mm.f.a.sw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.q;

@a(19)
public class WalletPasswordSettingUI extends MMPreference implements e {
    private boolean gNI;
    private ag handler = new ag(new ag.a() {
        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    h.a((Context) WalletPasswordSettingUI.this, false, WalletPasswordSettingUI.this.getResources().getString(i.uPJ), "", WalletPasswordSettingUI.this.getResources().getString(i.dGf), WalletPasswordSettingUI.this.getResources().getString(i.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            final b bpVar = new bp();
                            bpVar.frD = new Runnable() {
                                public final void run() {
                                    if (bpVar.fqD == null) {
                                        return;
                                    }
                                    if (bpVar.fqD.retCode == 0) {
                                        WalletPasswordSettingUI.this.jL(false);
                                        g.Dr();
                                        g.Dp().gRu.a(new y(null, 19), 0);
                                        return;
                                    }
                                    WalletPasswordSettingUI.e(WalletPasswordSettingUI.this);
                                    h.b(WalletPasswordSettingUI.this, WalletPasswordSettingUI.this.getResources().getString(i.uPK), "", true);
                                }
                            };
                            com.tencent.mm.sdk.b.a.xmy.a(bpVar, WalletPasswordSettingUI.this.getMainLooper());
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletPasswordSettingUI.e(WalletPasswordSettingUI.this);
                        }
                    });
                    break;
                case 2:
                    WalletPasswordSettingUI.b(WalletPasswordSettingUI.this);
                    break;
            }
            return false;
        }
    });
    private f inW;
    private Dialog ion;
    c sIU = new c<su>() {
        {
            this.xmG = su.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            WalletPasswordSettingUI.this.jM(true);
            WalletPasswordSettingUI.this.bLp();
            return false;
        }
    };
    CheckBoxPreference sNr;
    private IconPreference sNs;
    private Preference sNt;
    private String sNu;
    private String sNv;
    private String sNw;
    private z sNx;
    private boolean sNy = false;
    private int sNz = 0;

    static /* synthetic */ void b(WalletPasswordSettingUI walletPasswordSettingUI) {
        walletPasswordSettingUI.jL(false);
        final l lVar = (l) g.h(l.class);
        h.a((Context) walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(i.vaQ), "", walletPasswordSettingUI.getResources().getString(lVar.aKO() ? i.vaP : i.dGf), walletPasswordSettingUI.getString(i.dEy), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.WalletPasswordSettingUI", "user click the button to set system fingerprint");
                lVar.cD(WalletPasswordSettingUI.this);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void e(WalletPasswordSettingUI walletPasswordSettingUI) {
        l lVar = (l) g.h(l.class);
        if (walletPasswordSettingUI.sNr.isChecked() != lVar.aKD()) {
            walletPasswordSettingUI.jL(lVar.aKD());
        }
    }

    public final int XK() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Dr();
        g.Dp().gRu.a(385, (e) this);
        com.tencent.mm.sdk.b.a.xmy.b(this.sIU);
        this.gNI = getIntent().getBooleanExtra("key_is_from_system", false);
        if (this.gNI) {
            x.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
            ((com.tencent.mm.plugin.walletlock.a.b) g.h(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        }
        initView();
        if (com.tencent.mm.plugin.wallet.pwd.a.c.bEr()) {
            jM(false);
        } else {
            z zVar;
            g.Dr();
            this.sNv = (String) g.Dq().Db().get(w.a.USERINFO_WALLET_REALNAME_URL_STRING_SYNC, (Object) "");
            com.tencent.mm.plugin.wallet_core.d.h bMb = o.bMb();
            if (!bi.oN("wallet_open_auto_pay")) {
                Cursor a = bMb.gLA.a("select * from WalletPrefInfo where pref_key=?", new String[]{r2}, 2);
                if (a != null) {
                    if (a.moveToFirst()) {
                        zVar = new z();
                        zVar.b(a);
                    } else {
                        zVar = null;
                    }
                    a.close();
                    this.sNx = zVar;
                    if (this.sNx == null && this.sNx.field_is_show == 1 && !bi.oN(this.sNx.field_pref_url)) {
                        x.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
                        this.sNu = this.sNx.field_pref_url;
                        eH(this.sNx.field_pref_title, this.sNx.field_pref_url);
                    } else if (this.sNx != null) {
                        x.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
                    } else {
                        x.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.sNx.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bi.oN(this.sNx.field_pref_url));
                    }
                }
            }
            zVar = null;
            this.sNx = zVar;
            if (this.sNx == null) {
            }
            if (this.sNx != null) {
                x.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.sNx.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bi.oN(this.sNx.field_pref_url));
            } else {
                x.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
            }
        }
        g.Dr();
        this.sNz = ((Integer) g.Dq().Db().get(w.a.USERINFO_DELAY_TRANSFER_SHOW_SWITCH_FLAG_INT, Integer.valueOf(0))).intValue();
        g.Dr();
        this.sNw = (String) g.Dq().Db().get(w.a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, (Object) "");
        if (bi.oN(this.sNw)) {
            ae.a(true, null);
        } else {
            this.sNt.setTitle(this.sNw);
            ae.a(false, null);
        }
        if (this.sNz == 0) {
            this.inW.bl("wallet_delay_transfer_date", true);
        }
    }

    private void eH(String str, String str2) {
        this.sNs.setTitle((CharSequence) str);
        if (bi.oN(str2)) {
            this.inW.bl("wallet_open_auto_pay", true);
            x.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null");
            return;
        }
        this.inW.bl("wallet_open_auto_pay", false);
    }

    private void bLl() {
        g.Dr();
        String str = (String) g.Dq().Db().get(w.a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, (Object) "");
        g.Dr();
        x.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", str, (String) g.Dq().Db().get(w.a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, (Object) ""));
        if (bi.oN(str) || bi.oN(r1)) {
            this.inW.bl("wallet_password_setting_un_reg", true);
        } else {
            this.inW.bl("wallet_password_setting_un_reg", false);
        }
    }

    protected void onResume() {
        super.onResume();
        if (((com.tencent.mm.plugin.walletlock.a.b) g.h(com.tencent.mm.plugin.walletlock.a.b.class)).bOo()) {
            finish();
        } else {
            bLp();
        }
    }

    protected final void initView() {
        setMMTitle(q.Gl() ? getString(i.vaS) : getString(i.vaR));
        com.tencent.mm.wallet_core.ui.e.cCW();
        this.inW = this.yrJ;
        this.inW.addPreferencesFromResource(bLm());
        this.sNs = (IconPreference) this.inW.Zu("wallet_open_auto_pay");
        this.sNt = this.inW.Zu("wallet_delay_transfer_date");
        g.Dr();
        if (!((Boolean) g.Dq().Db().get(w.a.USERINFO_WALLET_PAY_DEDUCT_IS_NEW_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue()) {
            this.sNs.dl("new", com.tencent.mm.plugin.wxpay.a.e.bHe);
            this.sNs.Fr(0);
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_PAY_DEDUCT_IS_NEW_BOOLEAN_SYNC, Boolean.valueOf(true));
        }
        this.sNr = (CheckBoxPreference) this.inW.Zu("wallet_fingerprint_switch");
        bLp();
        this.inW.bl("nfc_idpay", true);
        this.inW.bl("wallet_open_auto_pay", true);
        bLl();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletPasswordSettingUI.this.finish();
                return true;
            }
        });
    }

    public int bLm() {
        return com.tencent.mm.plugin.wxpay.a.l.vha;
    }

    public void bLn() {
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    }

    public void bLo() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_paymanager", true);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.pwd.a.class, bundle, null);
    }

    private void jL(boolean z) {
        this.hbz.edit().putBoolean("wallet_fingerprint_switch", z).commit();
        this.sNr.tYU = z;
        this.inW.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        Bundle bundle;
        Intent intent;
        if ("wallet_modify_password".equals(preference.idX)) {
            bLn();
            com.tencent.mm.wallet_core.ui.e.HX(24);
            return true;
        } else if ("wallet_forget_password".equals(preference.idX)) {
            bLo();
            com.tencent.mm.wallet_core.ui.e.HX(25);
            return true;
        } else if ("wallet_realname_verify".equals(preference.idX)) {
            if (!o.bMc().bMy()) {
                x.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
                bundle = new Bundle();
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                bundle.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
                com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle, new com.tencent.mm.wallet_core.c.a() {
                    public final Intent l(int i, Bundle bundle) {
                        x.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
                        b swVar = new sw();
                        if (i == -1) {
                            swVar.fLz.scene = 17;
                        } else if (i == 0) {
                            swVar.fLz.scene = 18;
                        } else {
                            swVar.fLz.scene = 0;
                        }
                        swVar.fLA.fLu = new Runnable() {
                            public final void run() {
                                WalletPasswordSettingUI.this.bLp();
                            }
                        };
                        com.tencent.mm.sdk.b.a.xmy.m(swVar);
                        return null;
                    }
                });
            } else if (bi.oN(this.sNv)) {
                x.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
            } else {
                x.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
                intent = new Intent();
                intent.putExtra("rawUrl", this.sNv);
                intent.putExtra("showShare", false);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        } else if ("wallet_fingerprint_switch".equals(preference.idX)) {
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_FINGERPRINT_SWITCH_IS_NOT_NEW_BOOLEAN_SYNC, Boolean.valueOf(true));
            if (this.sNr.isChecked()) {
                if (this.gNI) {
                    com.tencent.mm.plugin.soter.c.a.yr(2);
                } else {
                    com.tencent.mm.plugin.soter.c.a.yr(1);
                }
                l lVar = (l) g.h(l.class);
                if (lVar == null || !lVar.aKE()) {
                    this.handler.obtainMessage(2).sendToTarget();
                } else {
                    bundle = new Bundle();
                    bundle.putInt("open_scene", 1);
                    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", bundle);
                }
            } else {
                this.handler.obtainMessage(1).sendToTarget();
            }
            return true;
        } else {
            if ("wallet_open_auto_pay".equals(preference.idX)) {
                if (bi.oN(this.sNu)) {
                    x.e("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is null");
                } else {
                    x.i("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is not null,jump!");
                    intent = new Intent();
                    intent.putExtra("rawUrl", this.sNu);
                    intent.putExtra("showShare", false);
                    d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                    this.sNs.Fr(8);
                    return true;
                }
            }
            if ("wallet_digitalcert".equals(preference.idX)) {
                if (!this.sNy) {
                    k cVar = new com.tencent.mm.plugin.wallet.pwd.a.c();
                    g.Dr();
                    g.Dp().gRu.a(cVar, 0);
                }
                d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
                return true;
            } else if ("wallet_delay_transfer_date".equals(preference.idX)) {
                startActivity(new Intent(this, WalletDelayTransferSettingUI.class));
                return true;
            } else {
                if ("wallet_password_setting_un_reg".equals(preference.idX)) {
                    g.Dr();
                    String str = (String) g.Dq().Db().get(w.a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, (Object) "");
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("showShare", false);
                    d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                }
                return false;
            }
        }
    }

    public void bLp() {
        if (o.bMc().bMv() || o.bMc().bMz()) {
            this.inW.bl("wallet_modify_password", true);
            this.inW.bl("wallet_forget_password", true);
            this.inW.bl("wallet_fingerprint_switch", true);
            this.inW.bl("wallet_realname_verify", false);
            this.inW.Zu("wallet_realname_verify").setSummary(i.vaM);
        } else if (o.bMc().bMy()) {
            this.inW.bl("wallet_modify_password", false);
            this.inW.bl("wallet_forget_password", false);
            this.inW.bl("wallet_fingerprint_switch", false);
            this.inW.bl("wallet_realname_verify", false);
            this.inW.Zu("wallet_realname_verify").setSummary(i.vaO);
        } else {
            x.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
        }
        this.inW.bl("wallet_digitalcert", true);
        if (!d.Pu("fingerprint")) {
            x.e("MicroMsg.WalletPasswordSettingUI", "plugin fingerprinthad not been installed");
            this.inW.bl("wallet_fingerprint_switch", true);
        } else if (com.tencent.mm.plugin.wallet.b.a.bLq()) {
            boolean booleanValue;
            x.i("MicroMsg.WalletPasswordSettingUI", "isSupportFingeprint is true");
            p.bKx();
            if (p.bKy() == null || !((l) g.h(l.class)).aKD()) {
                this.sNr.tYU = false;
                this.sNr.ysp = false;
            } else {
                this.sNr.tYU = true;
                this.sNr.ysp = false;
            }
            this.sNr.setSummary(i.vaK);
            this.inW.bl("wallet_fingerprint_switch", false);
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_BOOLEAN_SYNC, Boolean.valueOf(true));
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_HWFPMANAGER_BOOLEAN_SYNC, Boolean.valueOf(true));
            g.Dr();
            Object obj = g.Dq().Db().get(w.a.USERINFO_WALLET_FINGERPRINT_SWITCH_IS_NOT_NEW_BOOLEAN_SYNC, Boolean.valueOf(false));
            if (obj != null) {
                booleanValue = ((Boolean) obj).booleanValue();
            } else {
                booleanValue = false;
            }
            if (booleanValue) {
                this.sNr.zx(8);
            } else {
                this.sNr.ct(getString(i.dGa), com.tencent.mm.plugin.wxpay.a.e.bHe);
                this.sNr.zx(0);
            }
        } else {
            this.inW.bl("wallet_fingerprint_switch", true);
        }
        g.Dr();
        long longValue = ((Long) g.Dq().Db().get(147457, Long.valueOf(0))).longValue();
        int i = i.uXS;
        if ((16 & longValue) != 0) {
            i = i.uXR;
        } else if ((longValue & 32) != 0) {
            i = i.uXQ;
        }
        this.inW.Zu("wallet_delay_transfer_date").setSummary(i);
        this.inW.notifyDataSetChanged();
    }

    private void jM(boolean z) {
        k cVar = new com.tencent.mm.plugin.wallet.pwd.a.c();
        g.Dr();
        g.Dp().gRu.a(cVar, 0);
        this.sNy = true;
        if (z) {
            this.ion = com.tencent.mm.wallet_core.ui.g.a(this, false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (WalletPasswordSettingUI.this.ion != null) {
                        WalletPasswordSettingUI.this.ion.dismiss();
                    }
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.c) {
                bLp();
                com.tencent.mm.plugin.wallet.pwd.a.c cVar = (com.tencent.mm.plugin.wallet.pwd.a.c) kVar;
                x.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + cVar.sME);
                this.sNv = cVar.sMI;
                if (cVar.sME == 1) {
                    this.sNu = cVar.sMF;
                    eH(bi.aD(cVar.sMH, getString(i.vbo)), cVar.sMF);
                } else {
                    this.inW.bl("wallet_open_auto_pay", true);
                }
                bLl();
                if (this.ion != null) {
                    this.ion.dismiss();
                }
            } else if (kVar instanceof ae) {
                this.sNw = ((ae) kVar).sPd;
                this.sNz = ((ae) kVar).sPi;
                if (this.sNz == 0) {
                    this.inW.bl("wallet_delay_transfer_date", true);
                    return;
                }
                if (bi.oN(this.sNw)) {
                    x.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
                } else {
                    this.sNt.setTitle(this.sNw);
                }
                this.inW.bl("wallet_delay_transfer_date", false);
            }
        } else if (kVar instanceof ae) {
            x.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.sIU);
        g.Dr();
        g.Dp().gRu.b(385, (e) this);
    }
}
