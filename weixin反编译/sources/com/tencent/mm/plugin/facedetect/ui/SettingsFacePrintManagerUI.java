package com.tencent.mm.plugin.facedetect.ui;

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
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.facedetect.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.q;

public class SettingsFacePrintManagerUI extends MMPreference implements e {
    private ProgressDialog inI = null;
    private f inW;
    private View lHV;
    private FaceHeaderPreference mqy;
    private boolean mqz = false;

    static /* synthetic */ void a(SettingsFacePrintManagerUI settingsFacePrintManagerUI) {
        g.pWK.h(11390, Integer.valueOf(3));
        Intent intent = new Intent();
        intent.setClass(settingsFacePrintManagerUI, FaceDetectUI.class);
        intent.putExtra("k_need_signature", true);
        intent.putExtra("k_user_name", q.Gb());
        intent.putExtra("k_purpose", 1);
        settingsFacePrintManagerUI.startActivityForResult(intent, 1);
        settingsFacePrintManagerUI.mqz = false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(h.mjO);
        com.tencent.mm.kernel.g.CN().a(938, (e) this);
        this.lHV = findViewById(a.e.cws);
        initView();
        this.lHV.setBackgroundResource(b.white);
        o.o(this);
    }

    public void onResume() {
        super.onResume();
        if (this.mqz) {
            this.mqz = false;
            if (this.inI != null && this.inI.isShowing()) {
                this.inI.dismiss();
            }
            Context context = this.mController.xRr;
            getString(h.dGZ);
            this.inI = com.tencent.mm.ui.base.h.a(context, getString(h.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            x.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
            com.tencent.mm.kernel.g.CN().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.kernel.g.CN().b(938, (e) this);
        if (this.inI != null) {
            this.inI.dismiss();
        }
    }

    public final void initView() {
        int p = bi.p(com.tencent.mm.kernel.g.Dq().Db().get(40, Integer.valueOf(0)), 0);
        x.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + p + " " + (p & 4194304));
        this.inW = this.yrJ;
        this.mqy = (FaceHeaderPreference) this.inW.Zu("settings_faceprint_header");
        ((CheckBoxPreference) this.inW.Zu("settings_faceprint_title")).mC(true);
        this.inW.notifyDataSetChanged();
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
        }
        Context context = this.mController.xRr;
        getString(h.dGZ);
        this.inI = com.tencent.mm.ui.base.h.a(context, getString(h.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        com.tencent.mm.kernel.g.CN().a(new com.tencent.mm.plugin.facedetect.b.q(3), 0);
        this.inW.bl("settings_faceprint_create", true);
        this.inW.bl("settings_faceeprint_reset", true);
        this.inW.bl("settings_faceprint_unlock", true);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsFacePrintManagerUI.this.finish();
                return true;
            }
        });
    }

    public final int XK() {
        return i.mkr;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        Intent intent = new Intent();
        if (str.equals("settings_faceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.Zu("settings_faceprint_title");
            x.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.inI != null && this.inI.isShowing()) {
                this.inI.dismiss();
            }
            Context context = this.mController.xRr;
            getString(h.dGZ);
            this.inI = com.tencent.mm.ui.base.h.a(context, getString(h.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            if (checkBoxPreference.isChecked()) {
                com.tencent.mm.kernel.g.CN().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
            } else {
                com.tencent.mm.kernel.g.CN().a(new com.tencent.mm.plugin.facedetect.b.q(2), 0);
            }
            return true;
        } else if (str.equals("settings_faceprint_unlock")) {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", q.Gb());
            intent.putExtra("k_purpose", 2);
            startActivity(intent);
            return true;
        } else if (!str.equals("settings_faceeprint_reset")) {
            return false;
        } else {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", q.Gb());
            intent.putExtra("k_purpose", 1);
            startActivityForResult(intent, 1);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType()));
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 938) {
                com.tencent.mm.plugin.facedetect.b.q qVar = (com.tencent.mm.plugin.facedetect.b.q) kVar;
                if (qVar.mlh) {
                    int i3;
                    x.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
                    this.inW.bl("settings_faceprint_unlock", false);
                    this.inW.notifyDataSetChanged();
                    int Ge = q.Ge();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_faceprint_title");
                    x.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", Boolean.valueOf(qVar.mli));
                    if (qVar.mli) {
                        x.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
                        checkBoxPreference.mC(true);
                        this.inW.bl("settings_faceeprint_reset", false);
                        this.inW.bl("settings_faceprint_unlock", false);
                        i3 = 4194304 | Ge;
                        this.mqy.cC(getString(h.mkc), "");
                    } else {
                        x.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
                        checkBoxPreference.mC(false);
                        this.inW.bl("settings_faceeprint_reset", true);
                        this.inW.bl("settings_faceprint_unlock", true);
                        i3 = -4194305 & Ge;
                        this.mqy.cC(getString(h.mkb), "");
                    }
                    x.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", Integer.valueOf(i3));
                    ar.hhz.S("last_login_use_voice", String.valueOf(i3));
                    com.tencent.mm.kernel.g.Dq().Db().set(40, Integer.valueOf(i3));
                    this.inW.bl("settings_faceprint_create", true);
                    this.inW.bl("settings_faceprint_title", false);
                    this.mqy.e(null);
                    this.inW.notifyDataSetChanged();
                } else {
                    x.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
                    g.pWK.h(11390, Integer.valueOf(2));
                    this.inW.bl("settings_faceprint_create", true);
                    this.inW.bl("settings_faceprint_title", true);
                    this.inW.bl("settings_faceprint_unlock", true);
                    this.inW.bl("settings_faceeprint_reset", true);
                    this.mqy.setTitle(getString(h.mka));
                    this.mqy.e(new OnClickListener() {
                        public final void onClick(View view) {
                            SettingsFacePrintManagerUI.a(SettingsFacePrintManagerUI.this);
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
        this.inW.bl("settings_faceprint_create", true);
        this.inW.bl("settings_faceprint_unlock", true);
        this.inW.bl("settings_faceeprint_reset", true);
        ((CheckBoxPreference) this.inW.Zu("settings_faceprint_title")).mC(false);
        this.mqy.setTitle(getString(h.mkb));
        this.inW.notifyDataSetChanged();
        if (this.inI != null) {
            this.inI.dismiss();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (intent != null && intent.getIntExtra("err_code", 10) == 0) {
                this.mqz = true;
            }
            x.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", Boolean.valueOf(this.mqz));
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr != null && iArr.length > 1) {
            x.d("MicroMsg.FaceSettingsManagerUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults0[%d] grantResults1[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Long.valueOf(Thread.currentThread().getId()));
            switch (i) {
                case 23:
                    if (iArr[0] != 0 || iArr[1] != 0) {
                        x.w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
