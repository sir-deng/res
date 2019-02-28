package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TimePicker;
import com.tencent.mm.R;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.aq;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI extends MMPreference {
    private boolean fob = false;
    private f inW;
    private Preference kvR;
    private Preference kvS;
    private int qoK;
    private int qoL;
    private int qoM;
    private int qoN;
    private boolean qoO = false;
    private final OnTimeSetListener qoP = new OnTimeSetListener() {
        public final void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (SettingsActiveTimeUI.this.qoO) {
                SettingsActiveTimeUI.this.qoK = i;
                SettingsActiveTimeUI.this.qoL = i2;
                com.tencent.mm.j.f.aP(SettingsActiveTimeUI.this.qoK, SettingsActiveTimeUI.this.qoL);
            } else {
                SettingsActiveTimeUI.this.qoM = i;
                SettingsActiveTimeUI.this.qoN = i2;
                com.tencent.mm.j.f.aO(SettingsActiveTimeUI.this.qoM, SettingsActiveTimeUI.this.qoN);
            }
            SettingsActiveTimeUI.this.initView();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eLf);
        this.inW = this.yrJ;
        initView();
    }

    protected final void initView() {
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fcA);
        this.kvS = this.inW.Zu("settings_active_begin_time");
        this.qoK = a.zD();
        this.qoL = a.zF();
        this.kvS.setSummary(e(this, this.qoK, this.qoL));
        this.kvR = this.inW.Zu("settings_active_end_time");
        this.qoM = a.zC();
        this.qoN = a.zE();
        this.kvR.setSummary(e(this, this.qoM, this.qoN));
        this.fob = !a.zB();
        ((CheckBoxPreference) this.inW.Zu("settings_active_silence_time")).tYU = this.fob;
        if (this.fob) {
            this.kvS.setEnabled(true);
            this.kvR.setEnabled(true);
        } else {
            this.kvS.setEnabled(false);
            this.kvR.setEnabled(false);
        }
        if (!this.fob) {
            this.inW.c(this.kvS);
            this.inW.c(this.kvR);
        }
        this.inW.bl("settings_active_time_full", true);
        this.inW.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsActiveTimeUI.this.aWY();
                SettingsActiveTimeUI.this.finish();
                return true;
            }
        });
    }

    public final int XK() {
        return R.o.fcA;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.idX.equals("settings_active_begin_time")) {
            this.qoO = true;
            showDialog(1);
            return true;
        } else if (preference.idX.equals("settings_active_end_time")) {
            this.qoO = false;
            showDialog(1);
            return true;
        } else if (!preference.idX.equals("settings_active_silence_time")) {
            return false;
        } else {
            boolean z;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_active_silence_time");
            if (checkBoxPreference.isChecked()) {
                z = false;
            } else {
                z = true;
            }
            com.tencent.mm.j.f.br(z);
            g gVar = g.pWK;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(checkBoxPreference.isChecked() ? 1 : 2);
            gVar.h(11351, objArr);
            initView();
            return true;
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                if (this.qoO) {
                    return new TimePickerDialog(this.mController.xRr, this.qoP, this.qoK, this.qoL, false);
                }
                return new TimePickerDialog(this.mController.xRr, this.qoP, this.qoM, this.qoN, false);
            default:
                return null;
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 1:
                if (this.qoO) {
                    ((TimePickerDialog) dialog).updateTime(this.qoK, this.qoL);
                    return;
                } else {
                    ((TimePickerDialog) dialog).updateTime(this.qoM, this.qoN);
                    return;
                }
            default:
                return;
        }
    }

    private static String e(Context context, int i, int i2) {
        String e = w.e(context.getSharedPreferences(ad.cgf(), 0));
        String cfV = w.cfV();
        if (!e.equalsIgnoreCase("zh_CN") && (!e.equalsIgnoreCase("language_default") || !"zh_CN".equalsIgnoreCase(cfV))) {
            return DateFormat.getTimeInstance(3, w.VC(e)).format(new Time(i, i2, 0));
        }
        int i3;
        if (i > 12) {
            i3 = i - 12;
        } else {
            i3 = i;
        }
        return n.p(context, (((long) i) * 3600000) + (((long) i2) * 60000)) + String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }

    protected void onDestroy() {
        super.onDestroy();
        aq.gS(2);
    }
}
