package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ax.l;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.aq;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class SettingsNotificationUI extends MMPreference {
    private f inW;
    private HashMap<Integer, Integer> kHY = new HashMap();
    private int status;

    static /* synthetic */ void wo(int i) {
        if (i == 1 || i == 0) {
            as.Hm();
            c.Db().set(8200, Boolean.valueOf(true));
            if (i == 1) {
                as.Hm();
                c.Db().set(8201, Integer.valueOf(22));
                as.Hm();
                c.Db().set(8208, Integer.valueOf(8));
                as.Hm();
                c.Fe().b(new l(true, 22, 8));
                return;
            }
            as.Hm();
            c.Db().set(8201, Integer.valueOf(0));
            as.Hm();
            c.Db().set(8208, Integer.valueOf(0));
            as.Hm();
            c.Fe().b(new l(true, 0, 0));
            return;
        }
        as.Hm();
        c.Db().set(8200, Boolean.valueOf(false));
        as.Hm();
        c.Fe().b(new l());
    }

    public final int XK() {
        return R.o.fcG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.status = q.Gc();
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.eMs);
        this.inW = this.yrJ;
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fcG);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_new_msg_notification");
        if (a.zv()) {
            checkBoxPreference.tYU = true;
        }
        hU(checkBoxPreference.isChecked());
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.inW.Zu("settings_new_voip_msg_notification");
        if (a.zw()) {
            checkBoxPreference2.tYU = true;
        }
        if (checkBoxPreference.isChecked()) {
            checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_sound");
            if (a.zy()) {
                checkBoxPreference.tYU = true;
                brA();
            } else {
                this.inW.Zv("settings_notification_ringtone");
            }
            checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_shake");
            if (a.zA()) {
                checkBoxPreference.tYU = true;
            }
            checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_show_detail");
            if (a.zx()) {
                checkBoxPreference.tYU = true;
            }
        } else {
            this.inW.Zv("settings_show_detail");
            this.inW.Zv("settings_sound");
            this.inW.Zv("settings_notification_ringtone");
            this.inW.Zv("settings_shake");
            this.inW.Zv("settings_active_time");
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsNotificationUI.this.aWY();
                SettingsNotificationUI.this.finish();
                return true;
            }
        });
    }

    protected void onPause() {
        super.onPause();
        as.Hm();
        c.Db().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.kHY.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            com.tencent.mm.bp.a wuVar = new wu();
            wuVar.wnP = intValue;
            wuVar.wnQ = intValue2;
            as.Hm();
            c.Fe().b(new e.a(23, wuVar));
            x.d("MicroMsg.SettingsNotificationUI", "switch  " + intValue + " " + intValue2);
        }
        this.kHY.clear();
    }

    public void onResume() {
        super.onResume();
        brA();
    }

    private void brA() {
        Preference Zu = this.inW.Zu("settings_notification_ringtone");
        if (Zu != null) {
            Zu.setSummary(this.hbz.getString("settings.ringtone.name", getString(R.l.eMt)));
        }
        this.inW.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        boolean isChecked;
        if (str.equals("settings_new_msg_notification")) {
            com.tencent.mm.j.f.bl(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                g.pWK.a(500, 0, 1, false);
            } else {
                g.pWK.a(500, 1, 1, false);
            }
            return hU(((CheckBoxPreference) preference).isChecked());
        } else if (str.equals("settings_new_voip_msg_notification")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.j.f.bm(true);
                g.pWK.a(500, 2, 1, false);
            } else {
                h.a(this.mController.xRr, false, this.mController.xRr.getString(R.l.eMq), "", this.mController.xRr.getString(R.l.eMp), this.mController.xRr.getString(R.l.eLV), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.j.f.bm(false);
                        au auVar = new au();
                        auVar.eS(2);
                        auVar.aq(System.currentTimeMillis());
                        auVar.setType(1);
                        auVar.dU("weixin");
                        auVar.setContent(SettingsNotificationUI.this.mController.xRr.getString(R.l.eMr, new Object[]{Build.MODEL}));
                        bb.i(auVar);
                        as.Hm();
                        ae XF = c.Fk().XF("weixin");
                        if (XF != null) {
                            XF.setContent(SettingsNotificationUI.this.mController.xRr.getString(R.l.eMr, new Object[]{Build.MODEL}));
                            XF.eP(XF.field_unReadCount + 1);
                            as.Hm();
                            c.Fk().a(XF, "weixin");
                        } else {
                            XF = new ae();
                            XF.setContent(SettingsNotificationUI.this.mController.xRr.getString(R.l.eMr, new Object[]{Build.MODEL}));
                            XF.setUsername("weixin");
                            XF.eP(1);
                            as.Hm();
                            c.Fk().d(XF);
                        }
                        g.pWK.a(500, 3, 1, false);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.j.f.bm(true);
                        ((CheckBoxPreference) SettingsNotificationUI.this.inW.Zu("settings_new_voip_msg_notification")).tYU = true;
                        SettingsNotificationUI.this.initView();
                    }
                }, R.e.brm, 0);
            }
            initView();
            return true;
        } else if (str.equals("settings_voip_notification_sound")) {
            isChecked = ((CheckBoxPreference) preference).isChecked();
            as.Hm();
            c.Db().set(73217, Boolean.valueOf(isChecked));
            as.Hm();
            c.Db().set(73218, Boolean.valueOf(isChecked));
            g.pWK.a(500, isChecked ? 8 : 9, 1, false);
            x.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", Boolean.valueOf(isChecked));
            return true;
        } else if (str.equals("settings_sound")) {
            com.tencent.mm.j.f.bp(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                g.pWK.a(500, 10, 1, false);
            } else {
                g.pWK.a(500, 11, 1, false);
            }
            return true;
        } else if (str.equals("settings_shake")) {
            com.tencent.mm.j.f.bq(((CheckBoxPreference) preference).isChecked());
            if (((CheckBoxPreference) preference).isChecked()) {
                g.pWK.a(500, 16, 1, false);
            } else {
                g.pWK.a(500, 17, 1, false);
            }
            bi.m(this, ((CheckBoxPreference) preference).isChecked());
            return true;
        } else if (str.equals("settings_show_detail")) {
            isChecked = ((CheckBoxPreference) preference).isChecked();
            com.tencent.mm.j.f.bn(isChecked);
            isChecked = !isChecked;
            x.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + isChecked + " item value = 2048 functionId = 10");
            if (isChecked) {
                this.status |= 2048;
            } else {
                this.status &= -2049;
            }
            this.kHY.put(Integer.valueOf(10), Integer.valueOf(isChecked ? 1 : 2));
            return true;
        } else if (str.equals("settings_notification_ringtone")) {
            startActivity(new Intent(this.mController.xRr, SettingsRingtoneUI.class));
            return true;
        } else if (str.equals("settings_active_time")) {
            startActivity(new Intent(this, SettingsActiveTimeUI.class));
            return true;
        } else {
            if (str.equals("settings_plugings_notify")) {
                List linkedList = new LinkedList();
                linkedList.add(getString(R.l.eMC));
                linkedList.add(getString(R.l.eMD));
                linkedList.add(getString(R.l.eMB));
                Boolean valueOf = Boolean.valueOf(q.Gu());
                int GC = q.GC();
                int GD = q.GD();
                int i = valueOf.booleanValue() ? GC == GD ? 0 : 1 : 2;
                x.d("MicroMsg.SettingsNotificationUI", valueOf + "st " + GC + " ed " + GD + "  state " + i);
                Context context = this.mController.xRr;
                String string = getString(R.l.eMF);
                getString(R.l.eME);
                h.a(context, string, linkedList, i, new h.a() {
                    public final void vE(int i) {
                        if (i != i) {
                            SettingsNotificationUI.wo(i);
                        }
                    }
                });
            }
            return false;
        }
    }

    private boolean hU(boolean z) {
        Preference Zu = this.inW.Zu("settings_sound");
        Preference Zu2 = this.inW.Zu("settings_shake");
        Preference Zu3 = this.inW.Zu("settings_show_detail");
        if (Zu != null) {
            Zu.setEnabled(z);
        }
        if (Zu2 != null) {
            Zu2.setEnabled(z);
        }
        if (Zu3 != null) {
            Zu3.setEnabled(z);
        }
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        aq.gS(3);
    }
}
