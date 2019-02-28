package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ax.n;
import com.tencent.mm.f.a.ph;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ipcall.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.pluginsdk.q.k;
import com.tencent.mm.pluginsdk.q.z;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONObject;

public class SettingsManageFindMoreUI extends MMPreference {
    private HashMap<Integer, Integer> kHY = new HashMap();
    private long lrE;
    private HashMap<Integer, Integer> qpL = new HashMap();
    private HashMap<Integer, Integer> qpM = new HashMap();
    private int qpN;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lrE = q.Gd();
        this.qpN = q.Gj();
        x.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", Long.valueOf(this.lrE), Integer.valueOf(this.qpN));
        initView();
    }

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int XK() {
        return R.o.fcD;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 0;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
        String str = preference.idX;
        x.i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", str);
        int i2 = -1;
        if (str.equals("settings_sns_switch")) {
            s(checkBoxPreference.isChecked(), WXMediaMessage.THUMB_LENGTH_LIMIT);
            SharedPreferences sharedPreferences = getSharedPreferences(ad.cgf(), 0);
            String string = sharedPreferences.getString(q.FY() + "_sns_entrance_disappear", "");
            if (!bi.oN(string) && string.startsWith("on")) {
                if (checkBoxPreference.isChecked() && string.equals("on_close")) {
                    string = "on";
                }
                if (!checkBoxPreference.isChecked() && r1.equals("on")) {
                    string = "on_close";
                }
                sharedPreferences.edit().putString(q.FY() + "_sns_entrance_disappear", string).commit();
            }
            i2 = 0;
        } else if (str.equals("settings_scan_switch")) {
            b(checkBoxPreference.isChecked(), 1048576, 49);
            i2 = 1;
        } else if (str.equals("settings_search_switch")) {
            i2 = 3;
            b(checkBoxPreference.isChecked(), 2097152, 50);
        } else if (str.equals("settings_shopping_switch")) {
            i2 = 6;
            b(checkBoxPreference.isChecked(), 4194304, 51);
        } else if (str.equals("settings_game_switch")) {
            i2 = 7;
            b(checkBoxPreference.isChecked(), 8388608, 52);
        } else if (str.equals("settings_miniprogram_switch")) {
            i2 = 8;
            b(checkBoxPreference.isChecked(), 16777216, 53);
        } else if (str.equals("settings_wechatout_switch")) {
            i2 = 9;
            b(checkBoxPreference.isChecked(), 33554432, 54);
        } else if (str.equals("settings_shake_switch")) {
            i2 = 2;
            s(checkBoxPreference.isChecked(), 256);
        } else if (str.equals("settings_nearby_switch")) {
            i2 = 4;
            s(checkBoxPreference.isChecked(), WXMediaMessage.TITLE_LENGTH_LIMIT);
        } else if (str.equals("settings_bottle_switch")) {
            i2 = 5;
            s(checkBoxPreference.isChecked(), 64);
        } else if (str.equals("settings_look_switch")) {
            ((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).aV("labs_browse", checkBoxPreference.isChecked());
            i2 = 10;
        }
        if (checkBoxPreference.isChecked()) {
            i = 1;
        }
        if (i2 >= 0) {
            this.qpM.put(Integer.valueOf(i2), Integer.valueOf(i));
        }
        return true;
    }

    protected final void initView() {
        boolean z;
        String value;
        setMMTitle(R.l.eLX);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsManageFindMoreUI.this.finish();
                return true;
            }
        });
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_sns_switch");
        checkBoxPreference.ysp = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", Boolean.valueOf(wn(WXMediaMessage.THUMB_LENGTH_LIMIT)));
        if (wn(WXMediaMessage.THUMB_LENGTH_LIMIT)) {
            checkBoxPreference.tYU = true;
            this.qpL.put(Integer.valueOf(0), Integer.valueOf(1));
        } else {
            checkBoxPreference.tYU = false;
            this.qpL.put(Integer.valueOf(0), Integer.valueOf(0));
        }
        checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_scan_switch");
        checkBoxPreference.ysp = false;
        if (wm(1048576)) {
            checkBoxPreference.tYU = false;
            this.qpL.put(Integer.valueOf(1), Integer.valueOf(0));
        } else {
            checkBoxPreference.tYU = true;
            this.qpL.put(Integer.valueOf(1), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_shake_switch");
        checkBoxPreference.ysp = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", Boolean.valueOf(wn(256)));
        if (wn(256)) {
            checkBoxPreference.tYU = true;
            this.qpL.put(Integer.valueOf(2), Integer.valueOf(1));
        } else {
            checkBoxPreference.tYU = false;
            this.qpL.put(Integer.valueOf(2), Integer.valueOf(0));
        }
        checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_look_switch");
        checkBoxPreference.ysp = false;
        JSONObject Oy = com.tencent.mm.plugin.aj.a.h.Oy("discoverRecommendEntry");
        boolean Rh = ((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).Rh("labs_browse");
        if (Rh) {
            if (((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).Rf("labs_browse")) {
                z = true;
            }
            z = false;
        } else {
            if (Oy.optInt("entrySwitch") == 1) {
                z = true;
            }
            z = false;
        }
        x.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s", Boolean.valueOf(Rh), Boolean.valueOf(z));
        if (z) {
            checkBoxPreference.tYU = true;
            this.qpL.put(Integer.valueOf(10), Integer.valueOf(1));
        } else if (Rh) {
            this.yrJ.bl("settings_look_switch", false);
            checkBoxPreference.tYU = false;
            this.qpL.put(Integer.valueOf(10), Integer.valueOf(0));
        } else {
            this.yrJ.bl("settings_look_switch", true);
        }
        checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_search_switch");
        checkBoxPreference.ysp = false;
        if (wm(2097152)) {
            checkBoxPreference.tYU = false;
            this.qpL.put(Integer.valueOf(3), Integer.valueOf(0));
        } else {
            checkBoxPreference.tYU = true;
            this.qpL.put(Integer.valueOf(3), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_nearby_switch");
        checkBoxPreference.ysp = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", Boolean.valueOf(wn(WXMediaMessage.TITLE_LENGTH_LIMIT)));
        if (wn(WXMediaMessage.TITLE_LENGTH_LIMIT)) {
            checkBoxPreference.tYU = true;
            this.qpL.put(Integer.valueOf(4), Integer.valueOf(1));
        } else {
            checkBoxPreference.tYU = false;
            this.qpL.put(Integer.valueOf(4), Integer.valueOf(0));
        }
        checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_bottle_switch");
        checkBoxPreference.ysp = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openFloatBottle %s", Boolean.valueOf(wn(64)));
        if (wn(64)) {
            checkBoxPreference.tYU = true;
            this.qpL.put(Integer.valueOf(5), Integer.valueOf(1));
        } else {
            checkBoxPreference.tYU = false;
            this.qpL.put(Integer.valueOf(5), Integer.valueOf(0));
        }
        if (w.cfS()) {
            value = com.tencent.mm.j.g.Af().getValue("JDEntranceConfigName");
        } else if (w.cfT()) {
            value = com.tencent.mm.j.g.Af().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.j.g.Af().getValue("JDEntranceConfigNameEN");
        }
        String value2 = com.tencent.mm.j.g.Af().getValue("JDEntranceConfigIconUrl");
        String str = null;
        k kVar = z.vjl;
        if (kVar != null) {
            str = kVar.bEH();
        }
        if (bi.G(value, value2, str)) {
            z = false;
        } else {
            z = true;
        }
        x.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", Boolean.valueOf(z));
        checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_shopping_switch");
        checkBoxPreference.ysp = false;
        if (z) {
            this.yrJ.bl("settings_shopping_switch", false);
        } else {
            this.yrJ.bl("settings_shopping_switch", true);
        }
        if (wm(4194304)) {
            checkBoxPreference.tYU = false;
            this.qpL.put(Integer.valueOf(6), Integer.valueOf(0));
        } else {
            checkBoxPreference.tYU = true;
            this.qpL.put(Integer.valueOf(6), Integer.valueOf(1));
        }
        j jVar = com.tencent.mm.pluginsdk.q.a.vjc;
        checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_game_switch");
        checkBoxPreference.ysp = false;
        if (jVar == null || !jVar.aRR()) {
            this.yrJ.bl("settings_game_switch", true);
        } else if (wm(8388608)) {
            checkBoxPreference.tYU = false;
            this.qpL.put(Integer.valueOf(7), Integer.valueOf(0));
        } else {
            checkBoxPreference.tYU = true;
            this.qpL.put(Integer.valueOf(7), Integer.valueOf(1));
        }
        b phVar = new ph();
        phVar.fHU.fHW = true;
        com.tencent.mm.sdk.b.a.xmy.m(phVar);
        x.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s", Boolean.valueOf(phVar.fHV.fHX));
        checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_miniprogram_switch");
        checkBoxPreference.ysp = false;
        if (!phVar.fHV.fHX) {
            this.yrJ.bl("settings_miniprogram_switch", true);
        } else if (wm(16777216)) {
            checkBoxPreference.tYU = false;
            this.qpL.put(Integer.valueOf(8), Integer.valueOf(0));
        } else {
            checkBoxPreference.tYU = true;
            this.qpL.put(Integer.valueOf(8), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.yrJ.Zu("settings_wechatout_switch");
        x.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", Boolean.valueOf(d.aTK()));
        if (d.aTK()) {
            checkBoxPreference.ysp = false;
            if (wm(33554432)) {
                checkBoxPreference.tYU = false;
                this.qpL.put(Integer.valueOf(9), Integer.valueOf(0));
            } else {
                checkBoxPreference.tYU = true;
                this.qpL.put(Integer.valueOf(9), Integer.valueOf(1));
            }
        } else {
            this.yrJ.bl("settings_wechatout_switch", true);
        }
        this.yrJ.notifyDataSetChanged();
    }

    private void b(boolean z, int i, int i2) {
        x.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.lrE &= (long) (i ^ -1);
        } else {
            this.lrE |= (long) i;
        }
        this.kHY.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    public void finish() {
        super.finish();
        x.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.lrE + ",pluginFlag:" + this.qpN);
        as.Hm();
        c.Db().set(147457, Long.valueOf(this.lrE));
        as.Hm();
        c.Db().set(34, Integer.valueOf(this.qpN));
        for (Entry entry : this.kHY.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            com.tencent.mm.bp.a wuVar = new wu();
            wuVar.wnP = intValue;
            wuVar.wnQ = intValue2;
            as.Hm();
            c.Fe().b(new e.a(23, wuVar));
            x.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + intValue + " " + intValue2);
        }
        this.kHY.clear();
        as.Hm();
        c.Fe().b(new n("", "", "", "", "", "", "", "", this.qpN, "", ""));
        aUI();
    }

    private boolean wm(int i) {
        return (this.lrE & ((long) i)) != 0;
    }

    private boolean wn(int i) {
        return (this.qpN & i) == 0;
    }

    private void s(boolean z, int i) {
        x.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            this.qpN &= i ^ -1;
        } else {
            this.qpN |= i;
        }
    }

    private void aUI() {
        for (Integer intValue : this.qpM.keySet()) {
            int intValue2 = intValue.intValue();
            if (this.qpL.containsKey(Integer.valueOf(intValue2)) && this.qpL.get(Integer.valueOf(intValue2)) != this.qpM.get(Integer.valueOf(intValue2))) {
                com.tencent.mm.plugin.report.service.g.pWK.h(15185, Integer.valueOf(intValue2), this.qpM.get(Integer.valueOf(intValue2)));
            }
        }
    }
}
