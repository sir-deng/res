package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.qa;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting extends WalletPreferenceUI {
    protected f jPY;
    protected CheckBoxPreference okS;

    private static void st(int i) {
        b qaVar = new qa();
        qaVar.fIA.key = i;
        qaVar.fIA.value = 1;
        qaVar.fIA.fIB = true;
        a.xmy.m(qaVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        st(116);
    }

    protected final void initView() {
        this.jPY = this.yrJ;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsLuckyMoneyFreePwdSetting.this.finish();
                return false;
            }
        });
        setMMTitle(i.uQI);
        this.okS = (CheckBoxPreference) this.jPY.Zu("open_sns_pay_pref");
        aXV();
    }

    protected void onResume() {
        aXV();
        super.onResume();
    }

    private void aXV() {
        boolean z = true;
        if (com.tencent.mm.plugin.luckymoney.sns.b.a.aXY() != 1) {
            z = false;
        }
        this.okS.tYU = z;
        this.hbz.edit().putBoolean("open_sns_pay_pref", z).commit();
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.aXZ())) {
            x.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle is empty");
            this.okS.setTitle(i.uQH);
        } else {
            x.i("MicroMsg.mmui.MMPreference", "SetSnsPayTitle:" + com.tencent.mm.plugin.luckymoney.sns.b.a.aXZ());
            this.okS.setTitle(com.tencent.mm.plugin.luckymoney.sns.b.a.aXZ());
        }
        if (TextUtils.isEmpty(com.tencent.mm.plugin.luckymoney.sns.b.a.aYa())) {
            x.i("MicroMsg.mmui.MMPreference", "getSetSnsPayWording is empty");
            this.okS.setSummary(i.uQG);
        } else {
            x.i("MicroMsg.mmui.MMPreference", "SetSnsPayWording:" + com.tencent.mm.plugin.luckymoney.sns.b.a.aYa());
            this.okS.setSummary(com.tencent.mm.plugin.luckymoney.sns.b.a.aYa());
        }
        this.jPY.notifyDataSetChanged();
    }

    private void gx(boolean z) {
        this.hbz.edit().putBoolean("open_sns_pay_pref", z).commit();
        this.okS.tYU = z;
        this.jPY.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final boolean g(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.luckymoney.sns.a.a) {
            x.i("MicroMsg.mmui.MMPreference", "free pwd setting onWalletSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
            if (i != 0 || i2 != 0) {
                st(119);
                x.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
                aXV();
            } else if (((com.tencent.mm.plugin.luckymoney.sns.a.a) kVar).ols == 1) {
                x.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
                st(119);
                gx(true);
            } else {
                gx(false);
                st(118);
                x.i("MicroMsg.mmui.MMPreference", "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
            }
        }
        return false;
    }

    public final int XK() {
        return l.vgY;
    }

    public final boolean a(f fVar, Preference preference) {
        if ("open_sns_pay_pref".equals(preference.idX)) {
            if (this.okS.isChecked() || com.tencent.mm.plugin.luckymoney.sns.b.a.aXY() != 1) {
                st(120);
                com.tencent.mm.wallet_core.a.a((Activity) this, a.class, null, null);
            } else {
                cCY().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
                st(117);
            }
        }
        return false;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
