package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.av.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.i.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.l;
import java.util.List;

public class SettingsAboutSystemUI extends MMPreference {
    private f inW;
    private boolean isDeleteCancel = false;
    private ProgressDialog qob = null;
    private boolean qoj = false;
    private int qok = -1;
    private int qol = -1;
    private boolean qom = false;

    public final int XK() {
        return R.o.fcK;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qoj = false;
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.eLd);
        this.inW = this.yrJ;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsAboutSystemUI.this.aWY();
                SettingsAboutSystemUI.this.finish();
                return true;
            }
        });
        this.inW.bl("settings_swipeback_mode", !d.fN(19));
        if (!com.tencent.mm.bl.d.Pu("backup")) {
            this.inW.bl("settings_bak_chat", true);
        }
        bri();
        this.inW.bl("settings_traffic_statistic", com.tencent.mm.bl.d.cdJ());
        if (r.igH) {
            this.inW.bl("settings_take_photo", true);
        }
    }

    protected void onResume() {
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            as.Hm();
            checkBoxPreference.tYU = ((Boolean) c.Db().get(26, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.ysp = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_enter_button_send");
        if (checkBoxPreference != null) {
            as.Hm();
            checkBoxPreference.tYU = ((Boolean) c.Db().get(66832, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.ysp = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_swipeback_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.tYU = a.zj();
            checkBoxPreference.ysp = false;
        }
        Preference Zu = this.inW.Zu("settings_language");
        if (Zu != null) {
            Zu.setSummary(w.g(this.mController.xRr, R.c.bqS, R.l.dFG));
        }
        bri();
        brl();
        brl();
        brk();
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_nfc_switch");
        if (defaultAdapter == null) {
            this.inW.bl("settings_nfc_switch", true);
            return;
        }
        this.inW.bl("settings_nfc_switch", false);
        as.Hm();
        checkBoxPreference.setSummary(bi.oM((String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, null)));
        if (this.qoj) {
            x.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
            if (defaultAdapter.isEnabled()) {
                he(true);
                hR(true);
                return;
            }
        }
        as.Hm();
        int intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            as.Hm();
            if (((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
                hR(true);
            } else {
                hR(false);
            }
        } else if (intValue == 1) {
            hR(true);
        } else {
            hR(false);
        }
        this.inW.notifyDataSetChanged();
    }

    protected void onDestroy() {
        boolean z = true;
        super.onDestroy();
        if (this.qom) {
            boolean z2;
            String str = "MicroMsg.SettingsAboutSystemUI";
            String str2 = "kvstat, autodownload sight change: %d, %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.qol);
            if (this.qok == this.qol) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            x.i(str, str2, objArr);
            g gVar = g.pWK;
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(1);
            objArr2[1] = Integer.valueOf(this.qol);
            if (this.qok != this.qol) {
                z = false;
            }
            objArr2[2] = Boolean.valueOf(z);
            gVar.h(11437, objArr2);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.idX;
        int intValue;
        boolean booleanValue;
        i.a aVar;
        final LinearLayout linearLayout;
        OnClickListener anonymousClass2;
        Dialog ale;
        if (str.equals("settings_landscape_mode")) {
            if (this.hbz.getBoolean("settings_landscape_mode", false)) {
                setRequestedOrientation(-1);
                return true;
            }
            setRequestedOrientation(1);
            return true;
        } else if (str.equals("settings_voicerecorder_mode")) {
            if (this.hbz.getBoolean("settings_voicerecorder_mode", q.gHG.gEz != 1)) {
                return true;
            }
            h.a(this.mController.xRr, R.l.eOh, R.l.dGZ, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsAboutSystemUI.this.hbz.edit().putBoolean("settings_voicerecorder_mode", true).commit();
                    ((CheckBoxPreference) SettingsAboutSystemUI.this.inW.Zu("settings_voicerecorder_mode")).tYU = true;
                    SettingsAboutSystemUI.this.inW.notifyDataSetChanged();
                }
            });
            return true;
        } else if (str.equals("settings_nfc_switch")) {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
            if (defaultAdapter == null) {
                x.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
                return true;
            }
            as.Hm();
            intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
            as.Hm();
            int intValue2 = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
            if ((intValue == 2 || (intValue == 0 && intValue2 != 1)) && !defaultAdapter.isEnabled() && this.hbz.getBoolean("settings_nfc_switch", false)) {
                hR(false);
                h.a(this.mController.xRr, getString(R.l.eye), "", getString(R.l.eyf), getString(R.l.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user go set system nfc switch");
                        SettingsAboutSystemUI.this.qoj = true;
                        SettingsAboutSystemUI.this.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user cancel go set system nfc switch");
                    }
                });
                return true;
            }
            he(this.hbz.getBoolean("settings_nfc_switch", false));
            return true;
        } else if (str.equals("settings_voice_play_mode")) {
            as.Hm();
            booleanValue = ((Boolean) c.Db().get(26, Boolean.valueOf(false))).booleanValue();
            String str2 = "MicroMsg.SettingsAboutSystemUI";
            String str3 = "set voice mode from %B to %B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(booleanValue);
            objArr[1] = Boolean.valueOf(!booleanValue);
            x.d(str2, str3, objArr);
            as.Hm();
            t Db = c.Db();
            if (!booleanValue) {
                z = true;
            }
            Db.set(26, Boolean.valueOf(z));
            return true;
        } else if (str.equals("settings_enter_button_send")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_enter_button_send");
            if (checkBoxPreference == null) {
                return true;
            }
            x.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", Boolean.valueOf(checkBoxPreference.isChecked()));
            as.Hm();
            c.Db().set(66832, Boolean.valueOf(r0));
            return true;
        } else if (str.equals("settings_sns_sight_auto_download")) {
            aVar = new i.a(this.mController.xRr);
            aVar.EW(R.l.dEy);
            aVar.ES(R.l.eNt);
            View inflate = View.inflate(this.mController.xRr, R.i.dnu, null);
            linearLayout = (LinearLayout) inflate.findViewById(R.h.cQd);
            intValue = bi.getInt(com.tencent.mm.j.g.Af().getValue("SIGHTAutoLoadNetwork"), 1);
            as.Hm();
            final int a = bi.a((Integer) c.Db().get(327686, null), intValue);
            anonymousClass2 = new OnClickListener() {
                public final void onClick(View view) {
                    for (int i = 0; i < linearLayout.getChildCount(); i++) {
                        TextView textView = (TextView) linearLayout.getChildAt(i);
                        if (R.h.cSl != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dAB, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.k.dAC, 0, 0, 0);
                    final int intValue = ((Integer) view.getTag()).intValue();
                    x.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", Integer.valueOf(a), Integer.valueOf(intValue));
                    if (a != intValue) {
                        view.post(new Runnable() {
                            public final void run() {
                                ((Dialog) linearLayout.getTag()).dismiss();
                                as.Hm();
                                c.Db().set(327686, Integer.valueOf(intValue));
                                as.Hm();
                                c.Db().lO(true);
                                SettingsAboutSystemUI.this.brl();
                            }
                        });
                    }
                }
            };
            a(linearLayout, R.l.eNr, 1, 1 == a, anonymousClass2);
            a(linearLayout, R.l.eNu, 2, 2 == a, anonymousClass2);
            a(linearLayout, R.l.eNs, 3, 3 == a, anonymousClass2);
            aVar.dk(inflate);
            ale = aVar.ale();
            linearLayout.setTag(ale);
            ale.show();
            addDialog(ale);
            this.qom = true;
            return true;
        } else if (str.equals("settings_silence_update_mode")) {
            aVar = new i.a(this.mController.xRr);
            aVar.EW(R.l.dEy);
            aVar.ES(R.l.eNo);
            View inflate2 = View.inflate(this.mController.xRr, R.i.dnu, null);
            linearLayout = (LinearLayout) inflate2.findViewById(R.h.cQd);
            anonymousClass2 = new OnClickListener() {
                public final void onClick(View view) {
                    int i;
                    int i2;
                    int i3 = 0;
                    for (i = 0; i < linearLayout.getChildCount(); i++) {
                        TextView textView = (TextView) linearLayout.getChildAt(i);
                        if (R.h.cSl != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dAB, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.k.dAC, 0, 0, 0);
                    as.Hm();
                    int intValue = ((Integer) c.Db().get(7, Integer.valueOf(0))).intValue();
                    int intValue2 = ((Integer) view.getTag()).intValue();
                    x.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", Integer.valueOf(intValue2));
                    if (intValue2 == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((intValue & 16777216) == 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i != i2) {
                        if (intValue2 == 0) {
                            i3 = 1;
                        }
                        if (i3 != 0) {
                            i = -16777217 & intValue;
                        } else {
                            i = intValue | 16777216;
                        }
                        i2 = i3 == 0 ? 1 : 2;
                        as.Hm();
                        c.Db().set(7, Integer.valueOf(i));
                        com.tencent.mm.bp.a wuVar = new wu();
                        wuVar.wnP = 35;
                        wuVar.wnQ = i2;
                        as.Hm();
                        c.Fe().b(new e.a(23, wuVar));
                        com.tencent.mm.plugin.setting.a.ihO.un();
                        view.post(new Runnable() {
                            public final void run() {
                                ((Dialog) linearLayout.getTag()).dismiss();
                                SettingsAboutSystemUI.this.brk();
                            }
                        });
                    }
                }
            };
            as.Hm();
            boolean z2 = (((Integer) c.Db().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
            a(linearLayout, R.l.eNq, 0, z2, anonymousClass2);
            a(linearLayout, R.l.eNp, 1, !z2, anonymousClass2);
            aVar.dk(inflate2);
            ale = aVar.ale();
            linearLayout.setTag(ale);
            ale.show();
            addDialog(ale);
            return true;
        } else if (str.equals("settings_language")) {
            startActivity(new Intent(this.mController.xRr, SettingsLanguageUI.class));
            return true;
        } else if (str.equals("settings_text_size")) {
            return brj();
        } else {
            Intent intent;
            if (str.equals("settings_chatting_bg")) {
                intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                this.mController.xRr.startActivity(intent);
                return true;
            } else if (str.equals("settings_manage_findmoreui")) {
                intent = new Intent();
                intent.setClass(this, SettingsManageFindMoreUI.class);
                startActivity(intent);
                return true;
            } else if (str.equals("settings_plugins")) {
                as.Hm();
                c.Db().set(-2046825377, Boolean.valueOf(false));
                intent = new Intent();
                intent.setClass(this, SettingsPluginsUI.class);
                startActivity(intent);
                com.tencent.mm.r.c.Bx().aS(262158, 266266);
                return true;
            } else if (str.equals("settings_reset")) {
                h.a(this.mController.xRr, getResources().getString(R.l.eNd), "", getString(R.l.dEz), getString(R.l.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        boolean z = false;
                        SettingsAboutSystemUI.this.isDeleteCancel = false;
                        SettingsAboutSystemUI settingsAboutSystemUI = SettingsAboutSystemUI.this;
                        Context context = SettingsAboutSystemUI.this;
                        SettingsAboutSystemUI.this.getString(R.l.dGZ);
                        settingsAboutSystemUI.qob = h.a(context, SettingsAboutSystemUI.this.getString(R.l.dHn), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                SettingsAboutSystemUI.this.isDeleteCancel = true;
                            }
                        });
                        as.Hm();
                        List cju = c.Fk().cju();
                        if (cju.size() > 0) {
                            List A = l.A(cju);
                            if (A != null) {
                                while (true) {
                                    boolean z2 = z;
                                    if (z2 >= A.size()) {
                                        break;
                                    }
                                    if (((Boolean) A.get(z2)).booleanValue()) {
                                        com.tencent.mm.plugin.setting.a.ihO.cB((String) cju.get(z2));
                                    }
                                    z = z2 + 1;
                                }
                            }
                        }
                        bb.a(new bb.a() {
                            public final boolean HH() {
                                return SettingsAboutSystemUI.this.isDeleteCancel;
                            }

                            public final void HG() {
                                if (SettingsAboutSystemUI.this.qob != null) {
                                    SettingsAboutSystemUI.this.qob.dismiss();
                                    SettingsAboutSystemUI.this.qob = null;
                                }
                            }
                        });
                    }
                }, null);
                return true;
            } else if (str.equals("settings_emoji_manager")) {
                intent = new Intent();
                intent.putExtra("10931", 2);
                com.tencent.mm.bl.d.b(this.mController.xRr, "emoji", ".ui.EmojiMineUI", intent);
                return true;
            } else if (str.equals("settngs_clean")) {
                as.Hm();
                if (c.isSDCardAvailable()) {
                    com.tencent.mm.bl.d.b(this.mController.xRr, "clean", ".ui.CleanUI", new Intent());
                    return true;
                }
                u.fJ(this.mController.xRr);
                return true;
            } else if (str.equals("settings_traffic_statistic")) {
                startActivity(new Intent(this, SettingsNetStatUI.class));
                return true;
            } else if (str.equals("settings_text_size")) {
                return brj();
            } else {
                if (str.equals("settings_swipeback_mode")) {
                    final CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preference;
                    booleanValue = a.zj();
                    h.a(this.mController.xRr, getString(!booleanValue ? R.l.eNw : R.l.eNv), null, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.bk(!a.zj());
                            com.tencent.mm.kernel.g.Dr().releaseAll();
                            ah.y(new Runnable() {
                                public final void run() {
                                    Process.killProcess(Process.myPid());
                                }
                            });
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            checkBoxPreference2.tYU = booleanValue;
                            SettingsAboutSystemUI.this.inW.notifyDataSetChanged();
                        }
                    });
                    return true;
                }
                if (str.equals("settings_take_photo")) {
                    startActivity(new Intent(this, SettingsAboutCamera.class));
                }
                return false;
            }
        }
    }

    private void bri() {
        int i;
        int i2 = 0;
        IconPreference iconPreference = (IconPreference) this.inW.Zu("settings_plugins");
        as.Hm();
        if (bi.a((Boolean) c.Db().get(-2046825377, null), false)) {
            iconPreference.Fq(0);
            iconPreference.dk(getString(R.l.dGa), R.g.bEg);
        } else {
            iconPreference.Fq(8);
            iconPreference.dk("", -1);
        }
        if (com.tencent.mm.r.c.Bx().aR(262158, 266266)) {
            i = 0;
        } else {
            i = 8;
        }
        iconPreference.Fs(i);
        if (!com.tencent.mm.plugin.x.a.bfU().ij(b.hJR)) {
            i2 = 8;
        }
        iconPreference.Fs(i2);
        this.inW.notifyDataSetChanged();
    }

    private boolean brj() {
        startActivity(new Intent(this, SettingsFontUI.class));
        return true;
    }

    private void he(boolean z) {
        if (z) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(1));
            return;
        }
        getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        as.Hm();
        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(2));
    }

    private void hR(boolean z) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_nfc_switch");
        ad.getContext().getSharedPreferences(ad.cgf(), 0).edit().putBoolean("settings_nfc_switch", z).commit();
        checkBoxPreference.tYU = z;
        this.inW.notifyDataSetChanged();
    }

    private void brk() {
        boolean z = true;
        boolean z2 = bi.Wo(com.tencent.mm.j.g.Af().getValue("SilentDownloadApkAtWiFi")) != 0;
        if ((com.tencent.mm.sdk.platformtools.f.fek & 1) != 0) {
            x.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
            z2 = true;
        }
        if (z2) {
            this.inW.bl("settings_silence_update_mode", true);
            return;
        }
        this.inW.bl("settings_silence_update_mode", false);
        as.Hm();
        if ((((Integer) c.Db().get(7, Integer.valueOf(0))).intValue() & 16777216) != 0) {
            z = false;
        }
        this.inW.Zu("settings_silence_update_mode").setSummary(getString(z ? R.l.eNq : R.l.eNp));
        this.inW.notifyDataSetChanged();
    }

    private void a(LinearLayout linearLayout, int i, int i2, boolean z, OnClickListener onClickListener) {
        TextView textView = (TextView) View.inflate(this.mController.xRr, R.i.dqg, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dAC, 0, 0, 0);
        }
    }

    private void brl() {
        int i = bi.getInt(com.tencent.mm.j.g.Af().getValue("SIGHTAutoLoadNetwork"), 1);
        as.Hm();
        int a = bi.a((Integer) c.Db().get(327686, null), i);
        x.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", Integer.valueOf(i), Integer.valueOf(a));
        if (this.qok == -1) {
            this.qok = a;
        }
        this.qol = a;
        if (3 == a) {
            a = R.l.eNs;
        } else if (2 == a) {
            a = R.l.eNu;
        } else {
            a = R.l.eNr;
        }
        Preference Zu = this.inW.Zu("settings_sns_sight_auto_download");
        if (!(Zu == null || a == 0)) {
            Zu.setSummary(getString(a));
        }
        this.inW.notifyDataSetChanged();
    }
}
