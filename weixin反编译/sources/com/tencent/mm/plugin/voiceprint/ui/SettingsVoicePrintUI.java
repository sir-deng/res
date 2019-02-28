package com.tencent.mm.plugin.voiceprint.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class SettingsVoicePrintUI extends MMPreference implements e {
    private ProgressDialog inI = null;
    private f inW;
    private View lHV;
    private boolean mqz = false;
    private VoiceHeaderPreference snP;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eOe);
        as.CN().a(615, (e) this);
        this.lHV = findViewById(R.h.cws);
        initView();
        this.lHV.setBackgroundResource(R.e.white);
        as.Hm();
        c.Db().a(a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.valueOf(false));
        as.Hm();
        c.Db().a(a.USERFINO_VOICEPRINT_SETTING_DOT_SHOW_BOOLEAN, Boolean.valueOf(false));
        as.Hm();
        c.Db().a(a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN, Boolean.valueOf(false));
        as.Hm();
        c.Db().a(a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.valueOf(false));
        x.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    }

    public void onResume() {
        super.onResume();
        if (this.mqz) {
            this.mqz = false;
            if (this.inI != null && this.inI.isShowing()) {
                this.inI.dismiss();
            }
            Context context = this.mController.xRr;
            getString(R.l.dGZ);
            this.inI = h.a(context, getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            x.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
            as.CN().a(new i(1), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        as.CN().b(615, (e) this);
        if (this.inI != null) {
            this.inI.dismiss();
        }
    }

    public final void initView() {
        as.Hm();
        int p = bi.p(c.Db().get(40, Integer.valueOf(0)), 0);
        x.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + p + " " + (p & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        this.inW = this.yrJ;
        this.snP = (VoiceHeaderPreference) this.inW.Zu("settings_voiceprint_header");
        ((CheckBoxPreference) this.inW.Zu("settings_voiceprint_title")).mC(true);
        this.inW.notifyDataSetChanged();
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
        }
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.inI = h.a(context, getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        as.CN().a(new i(0), 0);
        this.inW.bl("settings_voiceprint_unlock", true);
        this.inW.bl("settings_voiceprint_reset", true);
        this.inW.bl("settings_voiceprint_create", true);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsVoicePrintUI.this.finish();
                return true;
            }
        });
    }

    public final int XK() {
        return R.o.fcM;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        Intent intent = new Intent();
        if (str.equals("settings_voiceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.Zu("settings_voiceprint_title");
            x.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.inI != null && this.inI.isShowing()) {
                this.inI.dismiss();
            }
            Context context = this.mController.xRr;
            getString(R.l.dGZ);
            this.inI = h.a(context, getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            if (checkBoxPreference.isChecked()) {
                as.CN().a(new i(1), 0);
            } else {
                as.CN().a(new i(2), 0);
            }
            return true;
        } else if (str.equals("settings_voiceprint_unlock")) {
            intent.setClass(this, VoiceUnLockUI.class);
            intent.putExtra("kscene_type", 73);
            startActivity(intent);
            return true;
        } else if (!str.equals("settings_voiceprint_reset")) {
            return false;
        } else {
            intent.setClass(this, VoiceCreateUI.class);
            intent.putExtra("KvoicePrintReset", true);
            intent.putExtra("kscene_type", 73);
            startActivityForResult(intent, 1);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType()));
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 615) {
                i iVar = (i) kVar;
                if (iVar.mStatus == 1) {
                    int i3;
                    x.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
                    this.inW.bl("settings_voiceprint_unlock", false);
                    this.inW.notifyDataSetChanged();
                    int Ge = q.Ge();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_voiceprint_title");
                    x.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", Integer.valueOf(iVar.smY));
                    if (iVar.smY > 0) {
                        x.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
                        checkBoxPreference.mC(true);
                        this.inW.bl("settings_voiceprint_reset", false);
                        this.inW.bl("settings_voiceprint_unlock", false);
                        i3 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT | Ge;
                        this.snP.cC(getString(R.l.eUj), "");
                    } else {
                        x.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
                        checkBoxPreference.mC(false);
                        this.inW.bl("settings_voiceprint_reset", true);
                        this.inW.bl("settings_voiceprint_unlock", true);
                        i3 = -131073 & Ge;
                        this.snP.cC(getString(R.l.eUi), "");
                    }
                    x.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", Integer.valueOf(i3));
                    ar.hhz.S("last_login_use_voice", String.valueOf(i3));
                    as.Hm();
                    c.Db().set(40, Integer.valueOf(i3));
                    this.inW.bl("settings_voiceprint_create", true);
                    this.inW.bl("settings_voiceprint_title", false);
                    this.snP.e(null);
                    this.inW.notifyDataSetChanged();
                } else {
                    x.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
                    g.pWK.h(11390, Integer.valueOf(2));
                    this.inW.bl("settings_voiceprint_unlock", true);
                    this.inW.bl("settings_voiceprint_reset", true);
                    this.inW.bl("settings_voiceprint_create", true);
                    this.inW.bl("settings_voiceprint_title", true);
                    this.snP.cC(getString(R.l.eUl), getString(R.l.eUk));
                    this.snP.e(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(SettingsVoicePrintUI.this, "android.permission.RECORD_AUDIO", 80, "", "")), bi.chl(), SettingsVoicePrintUI.this);
                            if (com.tencent.mm.pluginsdk.g.a.a(SettingsVoicePrintUI.this, "android.permission.RECORD_AUDIO", 80, "", "")) {
                                SettingsVoicePrintUI.this.bGB();
                            }
                        }
                    });
                    this.inW.notifyDataSetChanged();
                }
            }
            if (this.inI != null) {
                this.inI.dismiss();
                return;
            }
            return;
        }
        this.inW.bl("settings_voiceprint_unlock", true);
        this.inW.bl("settings_voiceprint_reset", true);
        this.inW.bl("settings_voiceprint_create", true);
        ((CheckBoxPreference) this.inW.Zu("settings_voiceprint_title")).mC(false);
        this.snP.cC(getString(R.l.eUi), "");
        this.inW.notifyDataSetChanged();
        if (this.inI != null) {
            this.inI.dismiss();
        }
    }

    private void bGB() {
        g.pWK.h(11390, Integer.valueOf(3));
        Intent intent = new Intent();
        intent.setClass(this, VoiceCreateUI.class);
        intent.putExtra("kscene_type", 71);
        intent.putExtra("createVoicePrint", true);
        startActivityForResult(intent, 1);
        this.mqz = false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && intent != null) {
            this.mqz = intent.getBooleanExtra("KIsCreateSuccess", false);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.VoiceSettingsUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    bGB();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            SettingsVoicePrintUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
