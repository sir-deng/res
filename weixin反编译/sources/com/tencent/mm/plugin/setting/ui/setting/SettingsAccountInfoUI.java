package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.ay;
import com.tencent.mm.f.a.np;
import com.tencent.mm.j.g;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class SettingsAccountInfoUI extends MMPreference implements e, b {
    private ProgressDialog inI;
    private f inW;
    private View qoA;
    private TextView qoB;
    private EditText qoC;
    private i qoD;
    private boolean qoE;
    private SparseIntArray qoF = new SparseIntArray();

    public SettingsAccountInfoUI() {
        this.qoF.put(0, R.l.eLt);
        this.qoF.put(-82, R.l.eKO);
        this.qoF.put(-83, R.l.eKL);
        this.qoF.put(-84, R.l.eKM);
        this.qoF.put(-85, R.l.eKH);
        this.qoF.put(-86, R.l.eKP);
    }

    public final int XK() {
        return R.o.fcz;
    }

    public final boolean XJ() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        as.Hm();
        c.Db().a(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        as.Hm();
        c.Db().b(this);
    }

    protected final void initView() {
        setMMTitle(R.l.eLe);
        this.inW = this.yrJ;
        this.qoA = View.inflate(this, R.i.drZ, null);
        this.qoB = (TextView) this.qoA.findViewById(R.h.cLI);
        this.qoB.setText(getString(R.l.eLL));
        this.qoC = (EditText) this.qoA.findViewById(R.h.cLH);
        this.qoC.setInputType(129);
        if (bi.getInt(g.Af().getValue("VoiceprintEntry"), 0) != 1) {
            this.inW.bl("settings_voiceprint_title", true);
        } else if (as.Hp()) {
            IconPreference iconPreference = (IconPreference) this.inW.Zu("settings_voiceprint_title");
            as.Hm();
            if (((Boolean) c.Db().get(a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.valueOf(true))).booleanValue()) {
                as.Hm();
                if ((c.Db().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    iconPreference.dk(getString(R.l.dGa), R.g.bEg);
                    iconPreference.Fq(0);
                    x.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
                    this.inW.notifyDataSetChanged();
                }
            }
        } else {
            x.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
            return;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsAccountInfoUI.this.aWY();
                SettingsAccountInfoUI.this.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        as.CN().a(255, (e) this);
        as.CN().a(384, (e) this);
        as.CN().a(281, (e) this);
        as.CN().a(282, (e) this);
        brm();
        bro();
        this.qoE = false;
        IconPreference iconPreference = (IconPreference) this.inW.Zu("settings_more_safe");
        if (com.tencent.mm.r.c.Bx().b(a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, a.NEW_BANDAGE_WATCHER_SETTINGS_MORE_SAFE_STRING_SYNC)) {
            iconPreference.Fs(0);
        } else {
            iconPreference.Fs(8);
        }
        brn();
        brp();
        this.inW.bl("settings_facedect_title", true);
        PluginTextPreference pluginTextPreference = (PluginTextPreference) this.inW.Zu("settings_about_vusertitle");
        SelfVuserPreference selfVuserPreference = (SelfVuserPreference) this.inW.Zu("settings_about_vuserinfo");
        Preference Zu = this.inW.Zu("settings_about_vuser_about");
        as.Hm();
        int e = bi.e((Integer) c.Db().get(66049, null));
        if (e != 0) {
            Bitmap b;
            pluginTextPreference.visibility = 8;
            pluginTextPreference.Fz(R.l.dXs);
            if (ak.a.hhx != null) {
                b = BackwardSupportUtil.b.b(ak.a.hhx.gP(e), 2.0f);
            } else {
                b = null;
            }
            selfVuserPreference.drawable = new BitmapDrawable(getResources(), b);
            as.Hm();
            selfVuserPreference.text = (String) c.Db().get(66050, null);
        } else {
            this.inW.c(pluginTextPreference);
            this.inW.c(selfVuserPreference);
            this.inW.c(Zu);
        }
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        as.CN().b(255, (e) this);
        as.CN().b(384, (e) this);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        x.i("MicroMsg.SettingsAccountInfoUI", str + " item has been clicked!");
        q.FY();
        if (bi.oN(str)) {
            return false;
        }
        if (str.equals("settings_username") && bi.oN(q.FZ()) && com.tencent.mm.storage.x.Xj(q.FY())) {
            G(SettingsAliasUI.class);
        }
        Intent intent;
        if (str.equals("settings_mobile")) {
            intent = new Intent(this, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 4);
            MMWizardActivity.A(this, intent);
            return true;
        }
        if (str.equals("settings_about_vuser_about")) {
            bi.F(this.mController.xRr, String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[]{w.cfV()}));
        } else if (str.equals("settings_independent_password")) {
            if (this.qoE) {
                hS(true);
            } else {
                final k xVar = new com.tencent.mm.modelsimple.x(1);
                as.CN().a(xVar, 0);
                getString(R.l.dGZ);
                this.inI = h.a((Context) this, getString(R.l.eLT), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(xVar);
                    }
                });
            }
        } else if (str.equals("settings_safe_device")) {
            as.Hm();
            str = (String) c.Db().get(6, (Object) "");
            as.Hm();
            String str2 = (String) c.Db().get(4097, (Object) "");
            if (!bi.oN(str)) {
                d.y(this, "safedevice", ".ui.MySafeDeviceListUI");
            } else if (bi.oN(str2)) {
                d.a((Context) this, "safedevice", ".ui.BindSafeDeviceUI", new Intent());
            } else {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("is_bind_for_safe_device", true);
                MMWizardActivity.A(this, intent);
            }
        } else if (str.equals("settings_security_center")) {
            str = getString(R.l.eXS) + w.cfV();
            Context context = this.mController.xRr;
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("showShare", false);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("needRedirect", false);
            intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
            intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
            d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
        } else if (str.equals("settings_voiceprint_title")) {
            if (bi.getInt(g.Af().getValue("VoiceprintEntry"), 0) == 1) {
                as.Hm();
                if ((c.Db().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    as.Hm();
                    c.Db().a(a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.valueOf(false));
                    ((IconPreference) this.inW.Zu("settings_voiceprint_title")).Fq(8);
                    this.inW.notifyDataSetChanged();
                    x.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
                }
            }
            d.y(this.mController.xRr, "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
        } else if (str.equals("settings_facedect_title")) {
            com.tencent.mm.sdk.b.b npVar = new np();
            npVar.fGz.context = this;
            com.tencent.mm.sdk.b.a.xmy.m(npVar);
            x.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", Boolean.valueOf(npVar.fGA.fGy));
            if (!npVar.fGA.fGy) {
                u.makeText(this.mController.xRr, getString(R.l.een), 0).show();
            }
        } else if (str.equals("settings_trust_friend")) {
            G(SettingsTrustFriendUI.class);
        } else if (str.equals("settings_more_safe")) {
            com.tencent.mm.r.c.Bx().c(a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, a.NEW_BANDAGE_WATCHER_SETTINGS_MORE_SAFE_STRING_SYNC);
            G(SettingsMoreSafeUI.class);
        }
        return false;
    }

    public final void a(int i, m mVar, Object obj) {
        brm();
        bro();
        brn();
        brp();
    }

    private void brm() {
        Preference Zu = this.inW.Zu("settings_username");
        CharSequence FZ = q.FZ();
        if (bi.oN(FZ)) {
            FZ = q.FY();
            if (com.tencent.mm.storage.x.Xi(FZ)) {
                Zu.setSummary(getString(R.l.eMv));
                return;
            } else {
                Zu.setSummary(FZ);
                return;
            }
        }
        Zu.setSummary(FZ);
    }

    private void brn() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.inW.Zu("settings_safe_device");
        if (iconSwitchKeyValuePreference == null) {
            x.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
            return;
        }
        as.Hm();
        if (((Integer) c.Db().get(9, Integer.valueOf(0))).intValue() == 0) {
            x.d("MicroMsg.SettingsAccountInfoUI", "not bind uin");
            this.inW.bl("settings_safe_device", true);
            return;
        }
        this.inW.bl("settings_safe_device", false);
        if (q.Gg()) {
            iconSwitchKeyValuePreference.setSummary(R.l.eGO);
            iconSwitchKeyValuePreference.Fx(1);
            return;
        }
        iconSwitchKeyValuePreference.setSummary(R.l.eGP);
        iconSwitchKeyValuePreference.Fx(2);
    }

    private void bro() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.inW.Zu("settings_mobile");
        if (iconSwitchKeyValuePreference == null) {
            x.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
            return;
        }
        as.Hm();
        String str = (String) c.Db().get(6, null);
        x.d("MicroMsg.SettingsAccountInfoUI", "mobile :" + str);
        if (str == null || str.length() <= 0) {
            iconSwitchKeyValuePreference.setSummary(getString(R.l.eLm));
            iconSwitchKeyValuePreference.Fx(0);
            return;
        }
        iconSwitchKeyValuePreference.setSummary((CharSequence) str);
        iconSwitchKeyValuePreference.Fx(1);
    }

    private void brp() {
        boolean z;
        boolean z2 = true;
        com.tencent.mm.sdk.b.b ayVar = new ay();
        com.tencent.mm.sdk.b.a.xmy.m(ayVar);
        if (ayVar.fpX.fpY && ayVar.fpX.fpZ && ayVar.fpX.fqa) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", Boolean.valueOf(ayVar.fpX.fpY), Boolean.valueOf(ayVar.fpX.fpZ), Boolean.valueOf(ayVar.fpX.fqa));
        f fVar = this.inW;
        String str = "settings_fingerprint_title";
        if (z) {
            z2 = false;
        }
        fVar.bl(str, z2);
    }

    private void hS(boolean z) {
        x.d("MicroMsg.SettingsAccountInfoUI", "handlePassword " + z);
        if (!z) {
            Intent intent = new Intent();
            intent.putExtra("kintent_hint", getString(R.l.eMi));
            d.b(this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
        } else if (this.qoD != null) {
            this.qoD.show();
        } else {
            this.qoD = h.a((Context) this, null, this.qoA, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    String obj = SettingsAccountInfoUI.this.qoC.getText().toString();
                    SettingsAccountInfoUI.this.qoC.setText("");
                    SettingsAccountInfoUI.this.qoC.clearFocus();
                    SettingsAccountInfoUI.this.df(SettingsAccountInfoUI.this.qoC);
                    if (obj == null || obj.equals("")) {
                        h.a(SettingsAccountInfoUI.this, R.l.eTc, R.l.dGZ, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    final k alVar = new al(obj, "", "", "");
                    as.CN().a(alVar, 0);
                    SettingsAccountInfoUI settingsAccountInfoUI = SettingsAccountInfoUI.this;
                    Context context = SettingsAccountInfoUI.this;
                    SettingsAccountInfoUI.this.getString(R.l.dGZ);
                    settingsAccountInfoUI.inI = h.a(context, SettingsAccountInfoUI.this.getString(R.l.eLT), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(alVar);
                        }
                    });
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsAccountInfoUI.this.qoC.setText("");
                    SettingsAccountInfoUI.this.qoD.dismiss();
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.SettingsAccountInfoUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (kVar.getType() == 255) {
            if (((com.tencent.mm.modelsimple.x) kVar).hPA != 1) {
                return;
            }
            if (i == 0 && i2 == 0) {
                hS(true);
            } else if (!com.tencent.mm.plugin.setting.a.ihO.a((Context) this, i, i2, str)) {
                hS(false);
            }
        } else if (kVar.getType() != 384) {
        } else {
            if (i == 0 && i2 == 0) {
                as.Hm();
                c.Db().set(77830, ((al) kVar).Oc());
                Intent intent = new Intent();
                intent.putExtra("kintent_hint", getString(R.l.eMi));
                d.b(this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
                return;
            }
            this.qoE = true;
            h.a((Context) this, R.l.eMw, R.l.dGZ, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
