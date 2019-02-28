package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.j.g;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.account.LanguagePreference;
import com.tencent.mm.ui.account.LanguagePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SettingsLanguageUI extends MMPreference {
    private static final String[] qpv = v.qpv;
    private f inW;
    private List<a> qpw;
    private String qpx;
    private boolean qpy = false;

    static /* synthetic */ void a(SettingsLanguageUI settingsLanguageUI, String str, boolean z) {
        Locale VC = w.VC(str);
        if ("language_default".equalsIgnoreCase(str)) {
            if (VERSION.SDK_INT >= 24) {
                VC = w.xnv;
                Locale.setDefault(VC);
            } else {
                VC = Locale.getDefault();
            }
        }
        w.a(settingsLanguageUI.getSharedPreferences(ad.cgf(), 0), str);
        w.a((Context) settingsLanguageUI, VC);
        be.setProperty("system_property_key_locale", str);
        ad.a(com.tencent.mm.bv.a.a(settingsLanguageUI.getApplication().getResources(), settingsLanguageUI.getApplication()));
        if (z) {
            com.tencent.mm.plugin.setting.a.ihN.s(new Intent().putExtra("Intro_Need_Clear_Top ", true), settingsLanguageUI);
            return;
        }
        as.CN().a(new com.tencent.mm.y.be(new com.tencent.mm.y.be.a() {
            public final void a(e eVar) {
                if (eVar != null) {
                    c KD = eVar.KD();
                    byte[] bArr = new byte[0];
                    as.Hm();
                    KD.v(bArr, com.tencent.mm.y.c.Cn());
                }
            }
        }), 0);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        ad.getContext().sendBroadcast(intent);
        intent = new Intent();
        intent.setComponent(new ComponentName(b.xMM, "com.tencent.mm.booter.MMReceivers$ExdeviceProcessReceiver"));
        intent.putExtra("exdevice_process_action_code_key", "action_reload_resources");
        intent.putExtra("exdevice_language", str);
        ad.getContext().sendBroadcast(intent);
        FontSelectorView.brU();
        g.Ag().gJN.clear();
        intent = new Intent();
        intent.putExtra("Intro_Need_Clear_Top ", true);
        com.tencent.mm.plugin.setting.a.ihN.s(intent, settingsLanguageUI);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.inW = this.yrJ;
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int XK() {
        return -1;
    }

    protected final void initView() {
        int i = 0;
        setMMTitle(R.l.eLP);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsLanguageUI.this.aWY();
                SettingsLanguageUI.this.finish();
                return true;
            }
        });
        a(0, getString(R.l.eLO), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsLanguageUI.this.finish();
                SettingsLanguageUI.a(SettingsLanguageUI.this, SettingsLanguageUI.this.qpx, SettingsLanguageUI.this.qpy);
                return true;
            }
        }, p.b.xSe);
        this.qpy = getIntent().getBooleanExtra("not_auth_setting", false);
        this.inW.removeAll();
        String[] stringArray = getResources().getStringArray(R.c.bqS);
        this.qpx = w.e(getSharedPreferences(ad.cgf(), 0));
        this.qpw = new ArrayList();
        while (i < qpv.length) {
            String str = qpv[i];
            this.qpw.add(new a(stringArray[i], "", str, this.qpx.equalsIgnoreCase(str)));
            i++;
        }
        for (a aVar : this.qpw) {
            Preference languagePreference = new LanguagePreference(this);
            languagePreference.a(aVar);
            this.inW.a(languagePreference);
        }
        this.inW.a(new PreferenceCategory(this));
        this.inW.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof LanguagePreference)) {
            return false;
        }
        a aVar = ((LanguagePreference) preference).xWP;
        if (aVar == null) {
            return false;
        }
        this.qpx = aVar.xWS;
        for (a aVar2 : this.qpw) {
            aVar2.nAl = false;
        }
        aVar.nAl = true;
        fVar.notifyDataSetChanged();
        return true;
    }
}
